package models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** * * @author Brayan */
public class ConnectionMySQL {
    private String database_name = "pharmacy";
    private String user = "root";
    private String password = "";
    private String url = "jdbc:mysql://localhost:3307/"+database_name;
    Connection conn = null;

    public Connection getConnection(){
        try{
            // Obtener valor del Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Obtener la conexión
            conn = DriverManager.getConnection(url, user, password);
        }catch(ClassNotFoundException e){
            System.err.println("Ha ocurrido un classNotFoundException " + e.getMessage());
        }catch(SQLException e){
            System.err.println("Ha ocurrido un SQLException " + e.getMessage());
        }
        return conn;
    }
}
