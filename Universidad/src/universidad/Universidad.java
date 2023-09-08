
package universidad;

import org.mariadb.jdbc.Connection;
import universidad.acceso_a_datos.Conexion;


public class Universidad {

    
    public static void main(String[] args) {
        
        Connection con = (Connection) Conexion.getConexion();
      
    }
    
}
