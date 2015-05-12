/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author pablo
 */
public class Tweet {
    
    
    String texto;
    int idCliente;
    String userName;
    ArrayList<String> hashtags;
    Date fecha;
    
    public Tweet(String t, int id, String user, ArrayList<String> hashtags, Date fecha){
        this.texto = t;
        this.idCliente = id;
        this.userName = user;
        this.hashtags = hashtags;
        this.fecha = fecha;
    
    
    }
    
}
