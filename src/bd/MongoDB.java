/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import com.mongodb.BasicDBList;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.regex.Pattern;
import org.bson.Document;


public class MongoDB {
    
    DBCollection collectionTweets;
    MongoClient client;
    DB database;
    
    public MongoDB() throws Exception{
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
	     throw new Exception();
	  }    
    
    }
    
    public void addTweets(ArrayList<Tweet> tweets){
        for(Tweet tw: tweets){
            BasicDBObject doc = new BasicDBObject("text",tw.texto).append("idCliente", tw.idCliente).append("nombreCliente", tw.nombreCliente).append("userName", tw.userName).append("fecha", tw.fecha.toString());
              BasicDBList hs = new BasicDBList();
            
            for(String hasht: tw.hashtags){
                hs.add(hasht);
            
            }
            doc.append("hashtags", hs);
            
            doc.append("numHashtags", tw.hashtags.size());
            BasicDBList mentions = new BasicDBList();
            
            for(String men: tw.mentions){
                mentions.add(men);
            
            }
            doc.append("mentions", mentions);       
            this.collectionTweets.insert(doc);
            
        }
        
        
    
    }
    
    public ArrayList<Tweet> obtenerTweetsCliente(int idCliente){
        BasicDBObject searchQuery = new BasicDBObject("idCliente",idCliente);
        DBCursor cursor = this.collectionTweets.find(searchQuery);
        ArrayList<Tweet> result = new ArrayList<Tweet>();
        while(cursor.hasNext()){
            Tweet tweet = new Tweet();
            DBObject current = cursor.next();
            System.out.println("Tweet: "+current.get("text"));
            tweet.texto = current.get("text").toString();
            System.out.println("idCliente: "+current.get("idCliente"));
            tweet.idCliente = Integer.parseInt(current.get("idCliente").toString());
            System.out.println("NombreCliente: "+current.get("nombreCliente"));
            tweet.nombreCliente = current.get("nombreCliente").toString();
            System.out.println("User: "+current.get("userName"));
            tweet.userName = current.get("userName").toString();
            System.out.println("Fecha: "+current.get("fecha"));
            tweet.fecha = LocalDate.parse(current.get("fecha").toString());
            System.out.println("Hashtags: "+current.get("hashtags"));
            BasicDBList asd = (BasicDBList)current.get("hashtags");
            tweet.hashtags = new ArrayList<String>();
            for(Object a: asd){
                String s = (String)a;
                tweet.hashtags.add(s);
            }
            System.out.println("Num Hashtags: "+current.get("numHashtags"));
            tweet.numHashtags = Integer.parseInt(current.get("numHashtags").toString());
            
            System.out.println("Mentions: "+current.get("mentions"));
            BasicDBList asd2 = (BasicDBList)current.get("mentions");
            tweet.mentions = new ArrayList<String>();
            for(Object a: asd2){
                String s = (String)a;
                tweet.mentions.add(s);
            } 
            result.add(tweet);
        
        }
        return result;
                
        
    }
    
    public void eliminarTweetsClientes(int idCliente){
        BasicDBObject query = new BasicDBObject("idCliente",idCliente);
        this.collectionTweets.remove(query);
        
        

    }
    
    public ArrayList<Tweet> buscarTweets(String texto, ArrayList<String>  nombreClientes,  ArrayList<String> userNames, ArrayList<String> hashtags, ArrayList<String> mentions, int numHashtags){
        BasicDBObject searchQuery = new BasicDBObject();
        //Construyendo query texto del tweets
        if(!texto.equals("")){
            Pattern regex = Pattern.compile(texto,Pattern.CASE_INSENSITIVE);
            searchQuery.put("text",regex);
        }
            
        //Construyendo query or de nombres de cliente
        if(!nombreClientes.isEmpty()){
            ArrayList<BasicDBObject> clausulas = new ArrayList<BasicDBObject>();
            for(String s: nombreClientes){
                clausulas.add(new BasicDBObject("nombreCliente",Pattern.compile(s , Pattern.CASE_INSENSITIVE)));

            }
            BasicDBList orclientes = new BasicDBList();
            orclientes.addAll(clausulas);
            searchQuery.put("$or",orclientes);       
        
        }
        // Query paara usuarios
        if(!userNames.isEmpty()){
            ArrayList<BasicDBObject> clausulas = new ArrayList<BasicDBObject>();
            for(String s: userNames){
                clausulas.add(new BasicDBObject("userName", Pattern.compile(s , Pattern.CASE_INSENSITIVE)));

            }
            BasicDBList orusers = new BasicDBList();
            orusers.addAll(clausulas);
            searchQuery.put("$or",orusers);            
        
        }
        // Query paara de hashtags
        if(!hashtags.isEmpty()){
            ArrayList<BasicDBObject> clausulas = new ArrayList<BasicDBObject>();
            for(String s: hashtags){
                clausulas.add(new BasicDBObject("hashtags",Pattern.compile(s , Pattern.CASE_INSENSITIVE)));

            }
            BasicDBList orusers = new BasicDBList();
            orusers.addAll(clausulas);
            searchQuery.put("$or",orusers);            
        
        }
        // Query paara de mentions
         if(!mentions.isEmpty()){
            ArrayList<BasicDBObject> clausulas = new ArrayList<BasicDBObject>();
            for(String s: mentions){
                clausulas.add(new BasicDBObject("mentions", Pattern.compile(s , Pattern.CASE_INSENSITIVE)));

            }
            BasicDBList ormentions = new BasicDBList();
            ormentions.addAll(clausulas);
            searchQuery.put("$or",ormentions);            
        
        }       
         //Query para numero de hashtags
        if(numHashtags!=-1){
            searchQuery.put("numHashtags", numHashtags);
            
        
        }
        
        
        DBCursor cursor = this.collectionTweets.find(searchQuery);
        
        ArrayList<Tweet> result = new ArrayList<Tweet>();
        while(cursor.hasNext()){
            Tweet tweet = new Tweet();
            DBObject current = cursor.next();
            System.out.println("Tweet: "+current.get("text"));
            tweet.texto = current.get("text").toString();
            System.out.println("idCliente: "+current.get("idCliente"));
            tweet.idCliente = Integer.parseInt(current.get("idCliente").toString());
            System.out.println("NombreCliente: "+current.get("nombreCliente"));
            tweet.nombreCliente = current.get("nombreCliente").toString();
            System.out.println("User: "+current.get("userName"));
            tweet.userName = current.get("userName").toString();
            System.out.println("Fecha: "+current.get("fecha"));
            tweet.fecha = LocalDate.parse(current.get("fecha").toString());
            System.out.println("Hashtags: "+current.get("hashtags"));
            BasicDBList asd = (BasicDBList)current.get("hashtags");
            tweet.hashtags = new ArrayList<String>();
            for(Object a: asd){
                String s = (String)a;
                tweet.hashtags.add(s);
            }
            System.out.println("Num Hashtags: "+current.get("numHashtags"));
            tweet.numHashtags = Integer.parseInt(current.get("numHashtags").toString());
            
            System.out.println("Mentions: "+current.get("mentions"));
            BasicDBList asd2 = (BasicDBList)current.get("mentions");
            tweet.mentions = new ArrayList<String>();
            for(Object a: asd2){
                String s = (String)a;
                tweet.mentions.add(s);
            } 
            result.add(tweet);
        
        }
        return result;
        
    
    }

    
   
   /*
   
   {
   
   cliente: "nombre_cliente",
   tweet: "",
   
   
   
   }
   
   
   
   
   
   */
    
}
