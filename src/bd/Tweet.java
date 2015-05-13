/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    String userName;
    LocalDate fecha;
    ArrayList<String> hashtags;
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
}
