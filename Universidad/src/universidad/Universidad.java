
package universidad;
import java.sql.Connection;
import java.time.LocalDate;
import universidad.acceso_a_datos.AlumnoData;
import universidad.acceso_a_datos.Conexion;
import universidad.entidades.Alumno;


public class Universidad {

    
    public static void main(String[] args) {
        
        Connection con = (Connection) Conexion.getConexion();
        Alumno juan=new Alumno(12121212,"Luna","juan Pedro",LocalDate.of(1980,4,25),true);
        //AlumnoData alu=new AlumnoData();
        //alu.guardarAlumno(juan);
        //alu.modificarAlumno(juan);
        //alu.eliminarAlumno(1);
        //Alumno alumnoEncontrado=alu.buscarAlumno(1);
        //if(alumnoEncontrado!=null){
        //System.out.println("dni "+alumnoEncontrado.getDni());
        //System.out.println("apellido"+alumnoEncontrado.getApellido());
                
        AlumnoData alu=new AlumnoData();
        
       
        for(Alumno alumno:alu.listarAlumnos()){
            System.out.println(alumno.getDni());
            System.out.println(alumno.getApellido());
            System.out.println(alumno.getNombre());
        }
    }
    
    
}
