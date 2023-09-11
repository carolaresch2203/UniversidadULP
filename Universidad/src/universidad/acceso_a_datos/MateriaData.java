/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package universidad.acceso_a_datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidad.entidades.Materia;

/**
 *
 * @author carol
 */
public class MateriaData {
    private Connection con;

    public MateriaData() {
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
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
               Materia mat = new Materia();
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
        
    }
    
   public void eliminarMateria(int id){
       
   } 
   
   public List<Materia>listarMaterias(){
       
       return null;
       
   }
}
