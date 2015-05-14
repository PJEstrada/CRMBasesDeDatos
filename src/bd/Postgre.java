/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
