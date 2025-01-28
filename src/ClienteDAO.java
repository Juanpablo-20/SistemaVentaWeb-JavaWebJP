package Modelo;

//import com.sun.jdi.connect.spi.Connection;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    Conexion cn = new Conexion();

    Connection con;

    PreparedStatement ps;

    ResultSet rs;

    int r;
    
    public Cliente buscar(String Cedula){
        Cliente c = new Cliente();
        
        String sql = "select * from cliente where Cedula= " + Cedula;
        
        try{
            
            con = cn.conexion();

            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();
            
            while(rs.next()){
                c.setIdCliente(rs.getInt(1));
                c.setCedula(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setDireccion(rs.getString(4));
                c.setEstado(rs.getString(5));
            }
            
        }catch(Exception e){
        
        }
        
        return c;
    }
    
    //Operar con Crud
    public List listar() {

        String sql = "select * from cliente";

        List<Cliente> lista = new ArrayList<>();

        try {
            con = cn.conexion();

            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                Cliente cli = new Cliente();

                cli.setIdCliente(rs.getInt(1));

                cli.setCedula(rs.getString(2));

                cli.setNombre(rs.getString(3));

                cli.setDireccion(rs.getString(4));

                cli.setEstado(rs.getString(5));

                lista.add(cli);
            }

        } catch (Exception e) {

        }

        return lista;

    }

    public int agregar(Cliente cli) {

        String sql = "insert into cliente(Cedula, Nombre, Direccion, Estado)values(?,?,?,?)";

        try {

            con = cn.conexion();

            ps = con.prepareStatement(sql);

            ps.setString(1, cli.getCedula());

            ps.setString(2, cli.getNombre());

            ps.setString(3, cli.getDireccion());

            ps.setString(4, cli.getEstado());

            ps.executeUpdate();

        } catch (Exception e) {

        }

        return r;

    }

    public Cliente listarId(int id) {
        Cliente cli = new Cliente();

        String sql = "select * from cliente where IdCliente=" + id;

        try {

            con = cn.conexion();

            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                
                cli.setCedula(rs.getString(2));
                
                cli.setNombre(rs.getString(3));
                
                cli.setDireccion(rs.getString(4));
                
                cli.setEstado(rs.getString(5));
            }

        } catch (Exception e) {

        }

        return cli;
    }

    public int actualizar(Cliente cli) {
        String sql = "update cliente set Cedula=?, Nombre=?, Direccion=?, Estado=? where IdCliente=?";

        try {

            con = cn.conexion();

            ps = con.prepareStatement(sql);

            ps.setString(1, cli.getCedula());

            ps.setString(2, cli.getNombre());

            ps.setString(3, cli.getDireccion());

            ps.setString(4, cli.getEstado());

            ps.executeUpdate();

        } catch (Exception e) {

        }

        return r;

    }

    public void delete(int id) throws SQLException {

        String sql = "delete from cliente where IdCliente=" + id;

        try {
            con = cn.conexion();

            ps = con.prepareStatement(sql);

            ps.executeUpdate();

        } catch (Exception e) {

        }
    }
}
