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
import java.util.Arrays;
import org.bson.Document;


public class MongoDB {

    
   public static void main( String args[] ){
      try{   
		 // To connect to mongodb server
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
         // Now connect to your databases
        MongoDatabase database = mongoClient.getDatabase("mydb");
        MongoCollection<Document> collection = database.getCollection("tutorialspoint");
        
        
        
      }catch(Exception e){
	     System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	  }
   }    
    
   
   /*
   
   {
   
   cliente: "nombre_cliente",
   tweet: "",
   
   
   
   }
   
   
   
   
   
   */
    
}
