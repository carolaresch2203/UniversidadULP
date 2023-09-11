
package universidad;

import org.mariadb.jdbc.Connection;
import universidad.acceso_a_datos.AlumnoData;
import universidad.acceso_a_datos.Conexion;
import universidad.entidades.Alumno;


public class Universidad {

    
    public static void main(String[] args) {
        
        Connection con = (Connection) Conexion.getConexion();
        
        
        AlumnoData alu=new AlumnoData();
        
       // alu.guardarAlumno();
        
        
        for(Alumno alumno:alu.listarAlumno()){
            System.out.println(alumno.getDni());
            System.out.println(alumno.getApellido());
            System.out.println(alumno.getNombre());
      
    }
    
}
}
