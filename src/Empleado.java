
package Modelo;

public class Empleado {
    
    int id;
    
    String cedula;
    
    String nombre;
    
    String telefono;
    
    String estado;
    
    String user;

    public Empleado() {
    }

    public Empleado(int id, String cedula, String nombre, String telefono, String estado, String user) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.estado = estado;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    
}
