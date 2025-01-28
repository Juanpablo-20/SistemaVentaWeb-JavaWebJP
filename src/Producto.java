
package Modelo;

public class Producto {
    
    private int IdProducto;
    
    private String NombreProducto;
    
    private double Precio;
    
    private int Stock;
    
    private String Estado;

    public Producto() {
    }

    public Producto(int IdProducto, String NombreProducto, double Precio, int Stock, String Estado) {
        this.IdProducto = IdProducto;
        this.NombreProducto = NombreProducto;
        this.Precio = Precio;
        this.Stock = Stock;
        this.Estado = Estado;
    }

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
}
