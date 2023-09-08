
package universidad.acceso_a_datos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Conexion {
    private static final String URL = "jdbc:mariadb://localhost/";
    private static final String BBDD = "universidad";
    private static String USUARIO = "root";
    private static String PASSWORD = "";
    private static Connection connection;
    
    private Conexion(){
        
    }
    
    public static Connection getConexion(){
        
        if(connection == null){
            
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                connection = DriverManager.getConnection(URL + BBDD, USUARIO, PASSWORD);
                
                JOptionPane.showMessageDialog(null, "Conectado");
                
            } catch (ClassNotFoundException ex) {
               JOptionPane.showMessageDialog(null, "Error al cargar el driver");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error de coneccion");
            }
        }
        return connection;
    } 
            
}
