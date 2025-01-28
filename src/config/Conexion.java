package config;

//import com.sun.jdi.connect.spi.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
        
public class Conexion {

    Connection conexion;
    
    String url = "jdbc:mysql://localhost:3306/bd_ventas";
    
    String user = "root";
    
    String password = "1234";

    public Connection conexion() {
        
        try {
            
            Class.forName("org.gjt.mm.mysql.Driver");
            
            conexion = (Connection) DriverManager.getConnection(url, user, null);
            
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conexion;
    }

    
}
