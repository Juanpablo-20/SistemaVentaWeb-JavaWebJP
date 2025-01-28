
package Modelo;

public class Cliente {
    
    private int IdCliente;
    
    private String Cedula;
    
    private String Nombre;
    
    private String Direccion;
    
    private String estado;

    public Cliente() {
    }

    public Cliente(int IdCliente, String Cedula, String Nombre, String Direccion, String estado) {
        this.IdCliente = IdCliente;
        this.Cedula = Cedula;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.estado = estado;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
