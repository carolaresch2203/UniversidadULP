
package universidad.acceso_a_datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import universidad.entidades.Materia;

/**
 *
 * @author carol
 */
public class MateriaData {
    private Connection con;

    public MateriaData() {
        con = Conexion.getConexion();
    }
    
    public void guardarMateria(Materia materia){
        
        String sql = "INSERT INTO materia (nombre, anio, estado) VALUES (?,?,?) ";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnioMateria());
            ps.setBoolean(3, materia.isActive());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            
            if(rs.next()){
                materia.setIdMateria( rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Materia cargada correctamente");
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error a conectarse a la tabla");
        }
        
    }
    
    public Materia buscarMateria(int id){
        
        String sql = "SELECT nombre, anio, estado FROM materia WHERE idMateria = ? AND estado = 1";
        Materia mat = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                mat = new Materia();
                mat.setIdMateria(id);
                mat.setNombre(rs.getString("nombre"));
                mat.setAnioMateria(rs.getInt("anio"));
                mat.setActive(rs.getBoolean("estado"));
                
            }else{
                JOptionPane.showMessageDialog(null, "No existe esa materia");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error a conectarse a la tabla");
        }
       return mat; 
    }
    
    public void modificarMateria(Materia materia){
        String sql = "UPDATE materia SET nombre = ?, anio = ?, estado = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2,materia.getAnioMateria());
            ps.setBoolean(3, materia.isActive());
            
            int exito = ps.executeUpdate();
            
            if(exito == 1){
                JOptionPane.showMessageDialog(null, "Modificado exitosamente");
            }
            else{
                JOptionPane.showMessageDialog(null, "La materia es inexistente");
            }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia");
        }
        
    }
    
   public void eliminarMateria(int id){
       
       String sql = "UPDATE materia SET estado = 0 WHERE idMateria = ?";
       
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int fila = ps.executeUpdate();
            
            if(fila == 1){
                JOptionPane.showMessageDialog(null, "Se elimino correctamente la materia");
            }
            ps.close();
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia");
        }
       
       
   } 
   
   public List<Materia>listarMaterias(){
       
       List<Materia> materias = new ArrayList<>();
       
       String sql = "SELECT * FROM materia WHERE estado = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idAlumno"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("anio"));
                materia.setActive(rs.getBoolean("estado"));
                materias.add(materia);
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia");
        }
       
       return materias;
       
   }
}
