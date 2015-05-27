/*
CRM Bases De Datos
Alberto Suriano 12281
Ernesto Solís 12286
Pablo Estrada 12121
 */

package bd;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author pablo
 */
public class Postgre {
    
    public static Connection bdConnection;
    
    
    public Postgre() throws ClassNotFoundException{
        try {
            Class.forName("org.postgresql.Driver");
            bdConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/CRM","postgres","root");
            
        } catch (SQLException ex) {
            Logger.getLogger(Postgre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
