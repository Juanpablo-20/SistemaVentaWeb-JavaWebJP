package Modelo;

//import com.sun.jdi.connect.spi.Connection;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {

    Conexion cn = new Conexion();

    Connection con;

    PreparedStatement ps;

    ResultSet rs;

    int r;

    public Empleado Validar(String user, String cedula) {

        Empleado em = new Empleado();

        String sql = "Select * from empleado where User=? and Cedula=?";

        try {
            con = (Connection) cn.conexion();

            ps = con.prepareStatement(sql);

            ps.setString(1, user);

            ps.setString(2, cedula);
            rs = ps.executeQuery();

            while (rs.next()) {

                em.setId(rs.getInt("IdEmpleado"));

                em.setUser(rs.getString("User"));

                em.setCedula(rs.getString("Cedula"));

                em.setNombre(rs.getString("Nombre"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return em;
    }

    //Operar con Crud
    public List listar() {

        String sql = "select * from empleado";

        List<Empleado> lista = new ArrayList<>();

        try {
            con = cn.conexion();

            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                Empleado em = new Empleado();

                em.setId(rs.getInt(1));

                em.setCedula(rs.getString(2));

                em.setNombre(rs.getString(3));

                em.setTelefono(rs.getString(4));

                em.setEstado(rs.getString(5));

                em.setUser(rs.getString(6));

                lista.add(em);
            }

        } catch (Exception e) {

        }

        return lista;

    }

    public int agregar(Empleado em) {

        String sql = "insert into empleado(Cedula, Nombre, Telefono, Estado, User)values(?,?,?,?,?)";

        try {

            con = cn.conexion();

            ps = con.prepareStatement(sql);

            ps.setString(1, em.getCedula());

            ps.setString(2, em.getNombre());

            ps.setString(3, em.getTelefono());

            ps.setString(4, em.getEstado());

            ps.setString(5, em.getUser());

            ps.executeUpdate();

        } catch (Exception e) {

        }

        return r;

    }
    
    public Empleado listarId(int id){
        Empleado emp = new Empleado();
        
        String sql = "select * from empleado where IdEmpleado=" + id;
        
        try{
            
            con = cn.conexion();

            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();
            
            while(rs.next()){
                emp.setCedula(rs.getString(2));
                emp.setNombre(rs.getString(3));
                emp.setTelefono(rs.getString(4));
                emp.setEstado(rs.getString(5));
                emp.setUser(rs.getString(6));
            }
            
        }catch(Exception e){
            
        }
        
        return emp;
    }

    public int actualizar(Empleado em) {
        String sql = "update empleado set Cedula=?, Nombre=?, Telefono=?, Estado=?, User=? where IdEmpleado=?";

        try {

            con = cn.conexion();

            ps = con.prepareStatement(sql);

            ps.setString(1, em.getCedula());

            ps.setString(2, em.getNombre());

            ps.setString(3, em.getTelefono());

            ps.setString(4, em.getEstado());

            ps.setString(5, em.getUser());
            
            ps.setInt(6, em.getId());

            ps.executeUpdate();

        } catch (Exception e) {

        }

        return r;

    }

    public void delete(int id) throws SQLException {
        
        String sql = "delete from empleado where IdEmpleado=" + id;
        
        try{
            con = cn.conexion();

            ps = con.prepareStatement(sql);

            ps.executeUpdate();
            
        }catch(Exception e){
            
        }
    }
}
