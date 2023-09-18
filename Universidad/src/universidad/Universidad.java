package universidad;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.Iterator;
import universidad.acceso_a_datos.AlumnoData;
import universidad.acceso_a_datos.Conexion;
import universidad.acceso_a_datos.InscripcionData;
import universidad.acceso_a_datos.MateriaData;
import universidad.entidades.Alumno;
import universidad.entidades.Inscripcion;
import universidad.entidades.Materia;

public class Universidad {

    public static void main(String[] args) {

        Connection con = (Connection) Conexion.getConexion();

        AlumnoData alu = new AlumnoData();
        //       Alumno juan=new Alumno( 1, 12121212,"Luna","juan Pedro ",LocalDate.of(1980,4,25),true);
//       alu.guardarAlumno(juan);
//       alu.modificarAlumno(juan);
        //   alu.eliminarAlumno(2);
//       
//       Alumno belen = new Alumno(12345678, "Dimarco", "Belen", LocalDate.of(1996, 01, 06), true );
//       alu.guardarAlumno(belen);
//       
//       Alumno ricardo = new Alumno(34567891, "Arjona", "Ricardo", LocalDate.of(1964, 01, 19), true);
//       alu.guardarAlumno(ricardo);
//       
//       Alumno pedro = new Alumno(45678901, "Sosa", "Pedro", LocalDate.of(1964, 01, 19), true);
//       alu.guardarAlumno(pedro);
//       
//       Alumno javier = new Alumno(5678901, "Mercado", "Javier", LocalDate.of(1973, 11, 02), true);
//       alu.guardarAlumno(javier);
//       
//       Alumno ana = new Alumno(6789012, "Sartoris", "Ana Gabriela", LocalDate.of(1976, 05, 19), true);
//       alu.guardarAlumno(ana);
//       
//       Alumno pedroR = new Alumno(7890123, "Rogriguez", "Pedro", LocalDate.of(1980, 04, 25), true);
//       alu.guardarAlumno(pedroR);
//       
//       Alumno carolinaR = new Alumno(32518851, "Resch", "Carolina", LocalDate.of(1987, 06, 01), true);
//       alu.guardarAlumno(carolinaR);
//       
//       Alumno matiasC = new Alumno(344283, "Castro", "Matias", LocalDate.of(1989, 03, 30), true);
//       alu.guardarAlumno(matiasC);
//       Alumno alumnoEncontrado = alu.buscarAlumno(3);
//       if(alumnoEncontrado != null){
//        System.out.println("DNI: " + alumnoEncontrado.getDni());
//        System.out.println("Apellido: " + alumnoEncontrado.getApellido());
//        System.out.println("Nombre: " + alumnoEncontrado.getNombre());
//       }
//        
//        Alumno alumnoEncontrado = alu.buscarAlumnoXdni(344283);
//        System.out.println("DNI: " + alumnoEncontrado.getDni());
//        System.out.println("Apellido: " + alumnoEncontrado.getApellido());
//        System.out.println("Nombre: " + alumnoEncontrado.getNombre());
//        
//        for(Alumno alumno:alu.listarAlumno()){
//            System.out.println(alumno.getDni());
//            System.out.println(alumno.getApellido());
//            System.out.println(alumno.getNombre());
//            System.out.println("---------------------------");
//
//        }  
        MateriaData mat = new MateriaData();

//         Materia m1 = new Materia("Matematica", 20019, true);
//         mat.guardarMateria(m1);
//         
//         Materia m2 = new Materia("Tecnologia", 20023, true);
//         mat.guardarMateria(m2);
//         
//         Materia m3 = new Materia("Literatura", 20020, true);
//         mat.guardarMateria(m3);
//         
        //        Materia m4 = new Materia(4, "Geografia", 2014, true);
//         mat.guardarMateria(m4);
//         
//         Materia m5 = new Materia("Data Cience", 2024, true);
//         mat.guardarMateria(m5);
//          Materia materiaEncontrada = mat.buscarMateria(2);
//          if(materiaEncontrada!=null){
//              System.out.println("Nombre: " + materiaEncontrada.getNombre());
//              System.out.println("Año: " + materiaEncontrada.getAnioMateria());
//          }
//           mat.modificarMateria(m4);
//           mat.eliminarMateria(3);
//
//              for(Materia mats:mat.listarMaterias()){
//            System.out.println(mats.getNombre());
//            System.out.println(mats.getAnioMateria());
//            System.out.println(mats.isActive());
//            System.out.println("---------------------------");
//    }
//              
        InscripcionData id = new InscripcionData();
//        
//        Alumno pedro = alu.buscarAlumno(4);
//        Materia mate = mat.buscarMateria(1);
//        Inscripcion i1 = new Inscripcion(5.5, pedro, mate);
//        id.guardarInscripcion(i1);

//       Alumno caroR = alu.buscarAlumno(8);
//        Materia lit = mat.buscarMateria(3);
//        Inscripcion i2 = new Inscripcion(7.8, caroR, lit);
//        id.guardarInscripcion(i2);
//        
//        Alumno ricardo = alu.buscarAlumno(3);
//        Materia geo = mat.buscarMateria(4);
//        Inscripcion i3 = new Inscripcion(9.2, ricardo, geo);
//        id.guardarInscripcion(i3);
//        
//       Alumno jav = alu.buscarAlumno(5);
//        Materia tec = mat.buscarMateria(2);
//        Inscripcion i4 = new Inscripcion(8.5, jav, tec);
//        id.guardarInscripcion(i4);
//        
        Alumno ana = alu.buscarAlumno(6);
        Materia dc = mat.buscarMateria(5);
//        Inscripcion i5 = new Inscripcion(9, ana, dc);
//        id.guardarInscripcion(i5);
//        
//        Alumno pedroR = alu.buscarAlumno(7);
//        Alumno matias = alu.buscarAlumno(9);
//        
//        Inscripcion i6 = new Inscripcion(7.3, pedroR, mate);
//        id.guardarInscripcion(i6);
//        Inscripcion i7 = new Inscripcion(8.0, matias, lit);
//        id.guardarInscripcion(i7);
//        Inscripcion i8 = new Inscripcion(9.0, jav, geo);
//        id.guardarInscripcion(i8);
//        Inscripcion i9 = new Inscripcion(6.5, pedro, tec);
//        id.guardarInscripcion(i9);
//        Inscripcion i10 = new Inscripcion(8.0, caroR, dc);
//        id.guardarInscripcion(i10);
//        
//          id.actualizarNota(6, 5, 9);
//          id.borrarInscripcionMateriaAlumno(5, 2);

//           for (Inscripcion insc : id.obtenerInscripciones()) {
//               
//               System.out.println("id " + insc.getIdInscripcion());
//               System.out.println("Apellido: " + insc.getAlumno().getApellido());
//               System.out.println("Materia: " + insc.getMateria().getNombre());
//               System.out.println("________________________________");
//        }

//          for(Materia materias : id.obtenerMateriasCursadas(3)){
//              System.out.println("ID: " + materias.getIdMateria());
//              System.out.println("Nombre: " + materias.getNombre());
//              System.out.println("Año: " + materias.getAnioMateria());
//          }

//             for(Materia materia : id.obtenerMateriasNoCursadas(5)){
//                 System.out.println("Nombre "+ materia.getNombre());
//             }

//              for (Inscripcion ins : id.obtenerInscripcionesPorAlumno(4)) {
//                  System.out.println("Nombre: " + ins.getAlumno().getNombre());
//                  System.out.println("Apellido: " + ins.getAlumno().getApellido());
//                  System.out.println("Materia: " + ins.getMateria().getNombre());
//                  System.out.println("_________________________________________");
//        }
    }

}
