package universidad.acceso_a_datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import universidad.entidades.Alumno;
import universidad.entidades.Inscripcion;
import universidad.entidades.Materia;

public class InscripcionData {

    private Connection con;
    private MateriaData matData = new MateriaData();
    private AlumnoData aluData = new AlumnoData();

    public InscripcionData() {
        this.con = Conexion.getConexion();
    }

    public void guardarInscripcion(Inscripcion ins) {

        String sql = "INSERT INTO inscripcion ( idAlumno, idMateria, nota)"
                + " VALUES (?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, ins.getAlumno().getIdAlumno());
            ps.setInt(2, ins.getMateria().getIdMateria());
            ps.setDouble(3, ins.getNota());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {

                ins.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Inscripcion registrada correctamente");
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripcion");
        }

    }

    public List<Inscripcion> obtenerInscripciones() {

        List<Inscripcion> listaIns = new ArrayList<>();

        String sql = "SELECT * FROM inscripcion";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Inscripcion insc = new Inscripcion();
                insc.setIdInscripcion(rs.getInt("idInscripcion"));
                Alumno al = aluData.buscarAlumno(rs.getInt("idAlumno"));
                Materia mt = matData.buscarMateria(rs.getInt("idMateria"));
                insc.setAlumno(al);
                insc.setMateria(mt);
                insc.setNota(rs.getDouble("nota"));

                listaIns.add(insc);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a una de las tablas");
        }

        return listaIns;
    }

    public List<Inscripcion> obtenerInscripcionesPorAlumno(int idAlumno) {

        List<Inscripcion> inscripciones = new ArrayList<>();
        String sql = "SELECT* FROM inscripcion WHERE idAlumno=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Inscripcion ins = new Inscripcion();

                ins.setIdInscripcion(rs.getInt("idInscripcion"));
                Alumno alu = aluData.buscarAlumno(rs.getInt("idAlumno"));
                Materia mat = matData.buscarMateria(rs.getInt("idMateria"));
                ins.setAlumno(alu);
                ins.setMateria(mat);
                ins.setNota(rs.getDouble("nota"));
                inscripciones.add(ins);

            }
            rs.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripciones");
        }

        return inscripciones;

    }

    public List<Materia> obtenerMateriasCursadas(int idAlumno) {

        List<Materia> materias = new ArrayList<>();

        String sql = "SELECT inscripcion.idMateria, materia.nombre, materia.anio FROM inscripcion, materia"
                + "WHERE inscripcion.idMateria = materia.idMateria"
                + "AND inscripcion.idAlumno = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Materia mat = new Materia();

                mat.setIdMateria(rs.getInt("idMateria"));
                mat.setNombre(rs.getString("nombre"));
                mat.setAnioMateria(rs.getInt("anio"));

                materias.add(mat);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripcion");
        }

        return materias;
    }

    public List<Materia> obtenerMateriasNoCursadas(int idAlumno) {

        List<Materia> materias = new ArrayList<>();

        String sql = "SELECT * FROM materia WHERE estado = 1 "
                + "AND id.Materia NOT IN "
                + "(SELECT idMateria FROM inscripcion WHERE idAlumno = ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Materia mat = new Materia();
                mat.setIdMateria(rs.getInt("idMateria"));
                mat.setNombre(rs.getString("nombre"));
                mat.setAnioMateria(rs.getInt("anio"));

                materias.add(mat);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripcion");
        }
        return materias;
    }

    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria) {
        String sql = "DELETE FROM inscripcion WHERE idAlumno=? AND idMateria=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);

            int fila = ps.executeUpdate();

            if (fila > 0) {
                JOptionPane.showMessageDialog(null, "Inscripcion borrada exitosamente");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripcion");
        }

    }

    public void actualizarNota(int idAlumno, int idMateria, double nota) {

        String sql = "UPDATE inscripcion SET nota=? WHERE idAlumno=? AND idMateria=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Nota actualizada correctamente");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripcion");
        }

    }

    public List<Alumno> obtenerAlumnosXmateria(int idMateria) {

        List<Alumno> alumMat = new ArrayList<>();

        String sql = "SELECT alumno.idAlumno, dni, nombre, apellido, fechaNacimiento, estado"
                + "FROM inscripcion , alumno  WHERE inscripcion.idAlumno = alumno.idAlumno"
                + "AND idMateria = ? AND  alumno.estado = 1";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Alumno alum = new Alumno();
                alum.setIdAlumno(rs.getInt("idAlumno"));
                alum.setApellido(rs.getString("apellido"));
                alum.setNombre(rs.getString("nombre"));
                alum.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                alum.setActivo(rs.getBoolean("estado"));

                alumMat.add(alum);
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a una de las tablas");
        }

        return alumMat;
    }

}
