
package universidad;


import java.sql.Connection;
import java.time.LocalDate;
import universidad.acceso_a_datos.AlumnoData;
import universidad.acceso_a_datos.Conexion;
import universidad.entidades.Alumno;


public class Universidad {

    
    public static void main(String[] args) {
        
       Connection con = (Connection) Conexion.getConexion();

       //Alumno juan=new Alumno(12121212,"Luna","juan ",LocalDate.of(1980,4,25),true);
       AlumnoData alu=new AlumnoData();
//       alu.guardarAlumno(juan);
//       alu.modificarAlumno(juan);
//       alu.eliminarAlumno(1);
       
       Alumno belen = new Alumno(12345678, "Dimarco", "Belen", LocalDate.of(1996, 01, 06), true );
       alu.guardarAlumno(belen);
       
       //Alumno lopez = new Alumno(23456789,"Lopez","Juan", LocalDate.of(2000, 08, 19), true);
       //alu.guardarAlumno(lopez);
       
       Alumno ricardo = new Alumno(34567891, "Arjona", "Ricardo", LocalDate.of(1964, 01, 19), true);
       alu.guardarAlumno(ricardo);
       
       Alumno pedro = new Alumno(45678901, "Sosa", "Pedro", LocalDate.of(1964, 01, 19), true);
       alu.guardarAlumno(pedro);
       
       Alumno javier = new Alumno(5678901, "Mercado", "Javier", LocalDate.of(1973, 11, 02), true);
       alu.guardarAlumno(javier);
       
       Alumno ana = new Alumno(6789012, "Sartoris", "Ana Gabriela", LocalDate.of(1976, 05, 19), true);
       alu.guardarAlumno(ana);
       
       Alumno pedroR = new Alumno(7890123, "Rogriguez", "Pedro", LocalDate.of(1980, 04, 25), true);
       alu.guardarAlumno(pedroR);
       
//       Alumno alumnoEncontrado = alu.buscarAlumno(2);
//        System.out.println("DNI" + alumnoEncontrado.getDni());
//        System.out.println("Apellido" + alumnoEncontrado.getApellido());
//        System.out.println("Nombre" + alumnoEncontrado.getNombre());
//        
//        alu.buscarAlumnoXdni(45678901);
//        System.out.println("DNI" + alumnoEncontrado.getDni());
//        System.out.println("Apellido" + alumnoEncontrado.getApellido());
//        System.out.println("Nombre" + alumnoEncontrado.getNombre());
        
        for(Alumno alumno:alu.listarAlumno()){
            System.out.println(alumno.getDni());
            System.out.println(alumno.getApellido());
            System.out.println(alumno.getNombre());

        }  
         

    }
    
    

}
