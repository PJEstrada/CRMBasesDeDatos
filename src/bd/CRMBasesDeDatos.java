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
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author pablo
 */
public class CRMBasesDeDatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        /* Pasos para conectarse a Postgre*/
        //1.Import
        //2.Load register and driver
        //3.Establish Connections
        //4.Create a Stmt object
        //5.Excute query
        //6.Process result
        //7.Close connection    
        
        Twitter twitter = new Twitter();
        ArrayList<Tweet> tweets = Twitter.obtener15TweetDelUsuario("NintendoAmerica");
        
        MongoDB mongo = new MongoDB();
        mongo.addTweets(tweets);
        
        try{
            String query = "SELECT * FROM asignacion";
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/First","postgres","root");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            
            while(rs.next()){
               String sname = "-"+rs.getString(1)+"-"+rs.getString(2)+"-"+rs.getString(3)+"-"+rs.getString(4)+"-"+rs.getString(5);
               
               //System.out.println(sname);
            
            }
            con.close();
            
            
            
        }
        catch(Exception e){
                e.printStackTrace();
        
            }

    
    
    }
    
}
