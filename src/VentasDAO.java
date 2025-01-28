package Modelo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import config.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VentasDAO {

    Connection con;

    Conexion cn = new Conexion();

    PreparedStatement ps;

    ResultSet rs;

    int r;

    public String GenerarSerie() {

        String NumeroSerie = " ";

        String sql = "select max(NumeroSerie) from ventas";

        try {
            con = (Connection) cn.conexion();

            ps = (PreparedStatement) con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                NumeroSerie = rs.getString(1);
            }

        } catch (Exception e) {

        }

        return NumeroSerie;
    }

    public String IdVentas() {

        String IdVentas = " ";

        String sql = "select max(IdVentas) from ventas";

        try {
            con = (Connection) cn.conexion();

            ps = (PreparedStatement) con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                IdVentas = rs.getString(1);
            }

        } catch (Exception e) {

        }
        return IdVentas;
    }

    public int GuardarVentas(Ventas ven) {

        String sql = "insert into ventas(IdCliente, IdEmpleado, NumeroSerie, FechaVentas, Monto, Estado)values(?,?,?,?,?,?)";

        try {
            con = (Connection) cn.conexion();

            ps = (PreparedStatement) con.prepareStatement(sql);

            ps.setInt(1, ven.getIdCliente());

            ps.setInt(2, ven.getIdEmpleado());

            ps.setString(3, ven.getNumeroSerie());

            ps.setString(4, ven.getFecha());

            ps.setDouble(5, ven.getMonto());

            ps.setString(6, ven.getEstado());

            ps.executeUpdate();

        } catch (Exception e) {

        }
        return r;
    }

    public int GuardarDetalleVentas(Ventas ven) {

        String sql = "insert into detalle_ventas(IdVentas, IdProducto, Cantidad, PrecioVenta)values(?,?,?,?)";

        try {

            con = (Connection) cn.conexion();

            ps = (PreparedStatement) con.prepareStatement(sql);

            ps.setInt(1, ven.getIdVentas());

            ps.setInt(2, ven.getIdProducto());

            ps.setInt(3, ven.getCantidad());

            ps.setDouble(4, ven.getPrecio());

            ps.executeUpdate();

        } catch (Exception e) {

        }
        return r;
    }

    //Operar con Crud
    public List listarNuevaVentas() {

        String sql = "select * from detalle_ventas";

        List<Ventas> listaNuevaVentas = new ArrayList<>();

        try {
            con = (Connection) cn.conexion();

            ps = (PreparedStatement) con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                Ventas vent = new Ventas();

                vent.setIdVentas(rs.getInt(1));

                vent.setIdProducto(rs.getInt(2));

                vent.setCantidad(rs.getInt(3));

                vent.setPrecio(rs.getInt(4));

                listaNuevaVentas.add(vent);

            }

        } catch (Exception e) {

        }

        return listaNuevaVentas;

    }

    public Ventas listarId(int id) {

        Ventas vent = new Ventas();

        String sql = "select * from detalle_ventas where IdDetalleVentas=" + id;

        try {

            con = (Connection) cn.conexion();

            ps = (PreparedStatement) con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {

                vent.setIdVentas(rs.getInt(1));

                vent.setIdProducto(rs.getInt(2));

                vent.setCantidad(rs.getInt(3));

                vent.setPrecio(rs.getInt(4));
            }

        } catch (Exception e) {

        }

        return vent;
    }
    
    public int actualizar(Ventas vent) {
        
        String sql = "update detalle_ventas set IdVentas=?, IdProducto=?, Cantidad=?, PrecioVenta=? where IdDetalleVentas=?";

        try {

            con = (Connection) cn.conexion();

            ps = (PreparedStatement) con.prepareStatement(sql);

            ps.setInt(1, vent.getIdVentas());

            ps.setInt(2, vent.getIdProducto());

            ps.setInt(3, vent.getCantidad());

            ps.setInt(4, (int) vent.getPrecio());

            ps.executeUpdate();

        } catch (Exception e) {

        }

        return r;
    }
    
    public void delete(int id) throws SQLException {

        String sql = "delete from detalle_ventas where IdDetalleVentas=" + id;

        try {
            con = (Connection) cn.conexion();

            ps = (PreparedStatement) con.prepareStatement(sql);

            ps.executeUpdate();

        } catch (Exception e) {

        }
    }
}
