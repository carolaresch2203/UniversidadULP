
package universidad.entidades;


public class Materia {
    private int idMateria;
    private String nombre;
    private int anioMateria;
    private boolean active;

    public Materia() {
    }

    public Materia(int idMateria, String nombre, int anioMateria, boolean active) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.anioMateria = anioMateria;
        this.active = active;
    }

    public Materia(String nombre, int anioMateria, boolean active) {
        this.nombre = nombre;
        this.anioMateria = anioMateria;
        this.active = active;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnioMateria() {
        return anioMateria;
    }

    public void setAnioMateria(int anioMateria) {
        this.anioMateria = anioMateria;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Materia{" + "idMateria=" + idMateria + ", nombre=" + nombre + ", anioMateria=" + anioMateria + '}';
    }
    
    
}
