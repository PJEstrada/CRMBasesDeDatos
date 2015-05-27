/*
CRM Bases De Datos
Alberto Suriano 12281
Ernesto Solís 12286
Pablo Estrada 12121
 */

package bd;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author pablo
 */
public class Tweet {
    
    
    String texto;
    int idCliente;
    String nombreCliente;
    String userName;
    LocalDate fecha;
    ArrayList<String> hashtags;
    int numHashtags;
    ArrayList<String> mentions;
    
    public Tweet(String t, int id, String user, ArrayList<String> hashtags, LocalDate fecha){
        this.texto = t;
        this.idCliente = id;
        this.userName = user;
        this.hashtags = hashtags;
        this.fecha = fecha;
    
    
    }
    public Tweet(){
        
    
    }
    
    public ArrayList<String> toStringArrayList(){
        ArrayList<String> result = new ArrayList<String>();
        result.add(texto);
        
        result.add(Integer.toString(idCliente));
        result.add(nombreCliente);
        result.add(userName);
        result.add(fecha.toString());
        int i =0;
        String hs = "";
        for(String s: this.hashtags){
            if(i==this.hashtags.size()-1){
               hs += s;          
            }
            else{
                hs += s+", "; 
            }

             i++;
        }
        result.add(hs);
        result.add(Integer.toString(this.numHashtags));
        String men = "";
        for(String s: this.mentions){
            if(i< this.hashtags.size()-1){
               men += s;          
            }
            else{
                men += s+", "; 
            }

             i++;
        }    
        result.add(men);
        return result;
    }
}
