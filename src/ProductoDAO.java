package Modelo;

//import com.sun.jdi.connect.spi.Connection;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    Conexion cn = new Conexion();

    Connection con;

    PreparedStatement ps;

    ResultSet rs;

    int r;
    
    public Producto buscar(int IdProducto){
        
        Producto prod = new Producto();
        
        String sql = "select * from producto where IdProducto=" + IdProducto;
        
        try{
            
            con = cn.conexion();
            
            ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                prod.setIdProducto(rs.getInt(1));
                
                prod.setNombreProducto(rs.getString(2));
                
                prod.setPrecio(rs.getDouble(3));
                
                prod.setStock(rs.getInt(4));
                
                prod.setEstado(rs.getString(5));
            }
            
        }catch(Exception e){
        
        }
        
        return prod;
        
    } 
    
    public int ActualizarStock(int IdProducto, int Stock){
        
        String sql = "update producto set Stock=? where IdProducto=?";
        
        try{
            
            con = cn.conexion();
            
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, Stock);
            
            ps.setInt(2, IdProducto);
            
            ps.executeUpdate();
            
        }catch(Exception e){
        
        }
        
        return r;
    }

    //Operar con Crud
    public List listar() {

        String sql = "select * from producto";

        List<Producto> lista = new ArrayList<>();

        try {
            con = cn.conexion();

            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                Producto prod = new Producto();

                prod.setIdProducto(rs.getInt(1));

                prod.setNombreProducto(rs.getString(2));

                prod.setPrecio(rs.getDouble(3));

                prod.setStock(rs.getInt(4));

                prod.setEstado(rs.getString(5));

                lista.add(prod);
                System.out.println("Producto " + rs.getInt(1));
            }

        } catch (Exception e) {
            System.out.println("Tabla producto no existe");
        }

        return lista;

    }

    public int agregar(Producto prod) {

        String sql = "insert into producto(NombreProducto, Precio, Stock, Estado)values(?,?,?,?)";

        try {

            con = cn.conexion();

            ps = con.prepareStatement(sql);

            ps.setString(1, prod.getNombreProducto());

            ps.setDouble(2, prod.getPrecio());

            ps.setInt(3, prod.getStock());

            ps.setString(4, prod.getEstado());

            ps.executeUpdate();

        } catch (Exception e) {

        }

        return r;

    }

    public Producto listarId(int id) {

        Producto prod = new Producto();

        String sql = "select * from producto where IdProducto=" + id;

        try {

            con = cn.conexion();

            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {

                ps.setString(1, prod.getNombreProducto());

                ps.setDouble(2, prod.getPrecio());

                ps.setInt(3, prod.getStock());

                ps.setString(4, prod.getEstado());
            }

        } catch (Exception e) {

        }

        return prod;
    }

//    Producto nuevo para diferenciar el id
    public Producto listarId2(int id) {
        
        Producto prod = new Producto();

        String sql = "select * from producto where IdProducto=" + id + " ";

        try {
            con = cn.conexion();

            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                
                prod.setNombreProducto(rs.getString(2));
                
                prod.setPrecio(rs.getDouble(3));
                
                prod.setStock(rs.getInt(4));
                
                prod.setEstado(rs.getString(5));
                
                prod.setIdProducto(rs.getInt(1));
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
        return prod;
    }

    public int actualizar(Producto prod) {
        String sql = "update producto set NombreProducto=?, Precio=?, Stock=?, Estado=? where IdProducto=?";

        try {

            con = cn.conexion();

            ps = con.prepareStatement(sql);

            ps.setString(1, prod.getNombreProducto());

            ps.setDouble(2, prod.getPrecio());

            ps.setInt(3, prod.getStock());

            ps.setString(4, prod.getEstado());

            ps.setInt(5, prod.getIdProducto());

            ps.executeUpdate();

        } catch (Exception e) {

        }

        return r;

    }

    public void delete(int id) throws SQLException {

        String sql = "delete from producto where IdProducto=" + id;

        try {
            con = cn.conexion();

            ps = con.prepareStatement(sql);

            ps.executeUpdate();

        } catch (Exception e) {

        }
    }
}
