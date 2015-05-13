/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import org.bson.Document;


public class MongoDB {
    
    DBCollection collectionTweets;
    MongoClient client;
    DB database;
    
    public MongoDB(){
      try{   
        // To connect to mongodb server
        client = new MongoClient( "localhost" , 27017 );
         // Now connect to your databases
        database = client.getDB("social_media");
        System.out.println("Conectado a base de datos: social_media");
        System.out.println("Colecciones");
        Set colls = database.getCollectionNames();

        for (Object s : colls)
        {
            System.out.println(s.toString());
        }
        collectionTweets = database.getCollection("tweets");
        
        
        
      }catch(Exception e){
	     System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	  }    
    
    }
    
    public void addTweets(ArrayList<Tweet> tweets){
        for(Tweet tw: tweets){
            BasicDBObject doc = new BasicDBObject("text",tw.texto).append("idCliente", tw.idCliente).append("userName", tw.userName).append("fecha", tw.fecha.toString());
            ArrayList<BasicDBObject> hs = new ArrayList<BasicDBObject>();
            
            for(String hasht: tw.hashtags){
                hs.add(new BasicDBObject("text",hasht));
            
            }
            doc.append("hashtags", hs);
            
             ArrayList<BasicDBObject> mentions = new ArrayList<BasicDBObject>();
            
            for(String men: tw.hashtags){
                mentions.add(new BasicDBObject("text",men));
            
            }
            doc.append("mentions", mentions);       
            this.collectionTweets.insert(doc);
            
        }
        
        
    
    }
    
    public ArrayList<Tweet> buscarTweets(String nombreCliente, String texto, String userName, String hashtags){
        return null;
    
    
    }

    
   
   /*
   
   {
   
   cliente: "nombre_cliente",
   tweet: "",
   
   
   
   }
   
   
   
   
   
   */
    
}
