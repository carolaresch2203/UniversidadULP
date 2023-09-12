
package universidad.acceso_a_datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import universidad.entidades.Alumno;
import universidad.entidades.Inscripcion;
import universidad.entidades.Materia;


public class InscripcionData {
    private Connection con;
    private MateriaData matData;
    private AlumnoData aluData;

    public InscripcionData() {
        con = Conexion.getConexion();
    }
    
    public void guardarInscripcion(Inscripcion ins){
        
        String sql = "INSERT INTO inscripcion (nota, idAlumno, idMateria)"
                + " VALUES nota =?, idAlumno =?, idMateria =?";
        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public List<Inscripcion>obtenerInscripciones(){
        return null;
    }
    
    public List<Inscripcion>obtenerInscripcionesPorAlumno(){
        return null;
    }
    
    public List<Materia>obtenerMateriasCursadas(int id){
        return null;
    }
    
    public List<Materia>obtenerMateriasNosCursadas(int id){
        return null;
    }
    
    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria){
        
    }
    
    public void actualizarNota(int idAlumno, int idMateria, double nota){
        
    }
    
    public List<Alumno>obtenerAlumnosXmateria(int idMateria){
        return null;
    }
    
}
