/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



/**
 *
 * @author Al
 */
public class ClientLoader {

    ArrayList<Integer> numerosTotal = new ArrayList();
    ArrayList<PairTypeNumber> tiposNuevoCliente = new ArrayList(); //estos son para poder realizar el checkeo que las datos esten acorde
    ArrayList<String> nombresColumnas = new ArrayList(); //estos son para poder lanzar bien los errores
    ArrayList<String> nombresColumnasNativas = new ArrayList(); //esta es para las que pertenecen al area de cliente como tal
    
    //esto es solo para no hacerme bolas
    ArrayList<PairTypeNumber> tiposActualizarCliente = new ArrayList(); //estos son para poder realizar el checkeo que las datos esten acorde
    ArrayList<String> nombresColumnasActualizar = new ArrayList(); //estos son para poder lanzar bien los errores
    ArrayList<String> nombresColumnasNativasActualizar = new ArrayList(); //esta es para las que pertenecen al area de cliente como tal
    public ClientLoader(int numberCamps){
        numerosTotal.add(numberCamps);
        numerosTotal.add(5);
        numerosTotal.add(4);
        numerosTotal.add(2);
        numerosTotal.add(5);
    }
    
    /*----------------------------------TODOS estos metodos son para actualizar o eliminar un cliente----------------------------------*/
    public ArrayList<JPanel> componentesEditarCliente(ArrayList<classForUsers> columnas, boolean canEdit){
        /*
        Cliente: 6
        Contacto: 5
        Empresa: 4
        Industria: 2
        SocialData: 5
        */
        tiposActualizarCliente = new ArrayList();
        nombresColumnasActualizar = new ArrayList();
        nombresColumnasNativasActualizar = new ArrayList();
        int i =0;
        int index =0;
        int indexActual = numerosTotal.get(index);
        ArrayList<JPanel> filasLlenar = new ArrayList();
        JPanel panelito = new JPanel();
        JLabel titulo1 = new JLabel("Datos Cliente");
        panelito.add(titulo1);
        filasLlenar.add(panelito);
        //dummy
        ArrayList<JPanel> titulosPanel = new ArrayList();
        titulosPanel.add(panelito);
        
        JPanel panelito2 = new JPanel();
        JLabel titulo2 = new JLabel("Datos Contacto: ");
        panelito2.add(titulo2);
        titulosPanel.add(panelito2);
        
        JPanel panelito3 = new JPanel();
        JLabel titulo3 = new JLabel("Datos Empresa: ");
        panelito3.add(titulo3);
        titulosPanel.add(panelito3);
        
        JPanel panelito4 = new JPanel();
        JLabel titulo4 = new JLabel("Datos Industria: ");
        panelito4.add(titulo4);
        titulosPanel.add(panelito4);
        
        JPanel panelito5 = new JPanel();
        JLabel titulo5 = new JLabel("Datos de Social Data: ");
        panelito5.add(titulo5);
        titulosPanel.add(panelito5);
       
        for(classForUsers par: columnas){
            String nombreColumna = par.nombreColumna;
            if(nombreColumna.contains("id") && !nombreColumna.equals("apellido")){
                continue;
            }
            else if(nombreColumna.contains("foto")){
                continue;
            }
            if(index == 0){
                nombresColumnasNativasActualizar.add(nombreColumna);
            }
            
            nombreColumna = nombreColumna.replace("_", " ");
            nombreColumna = nombreColumna.substring(0, 1).toUpperCase() + nombreColumna.substring(1);
            nombresColumnasActualizar.add(nombreColumna);
            String tipoColumna = par.tipoColumna;
            tipoColumna = tipoColumna.toUpperCase();
            int numberTipo =0;
            if(tipoColumna.contains("TEXT") || tipoColumna.contains("VARCHAR")){
                numberTipo = 1;
            }
            else if(tipoColumna.contains("INT")){
                numberTipo = 2;
            }
            else if(tipoColumna.contains("FLOAT")){
                numberTipo = 3;
            }
            else if(tipoColumna.contains("DATE")){
                numberTipo = 4;
            }
            PairTypeNumber nuevoHere = new PairTypeNumber(numberTipo,tipoColumna,nombreColumna);
            
            
            tiposActualizarCliente.add(nuevoHere);
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(1, 2));
            JLabel label = new JLabel(nombreColumna);
            JTextField textField = new JTextField();
            String poner = par.datosEnColumna;
            if(poner.equals("NULL")){
                poner = "";
            }
            textField.setText(poner);
            textField.setEditable(canEdit);
            
            textField.setPreferredSize(new Dimension(200,24));
            panel.add(label);
            panel.add(textField);
            i++;
            if(i==indexActual){
                index++;
                if(index<numerosTotal.size()){
                    filasLlenar.add(panel);
                    filasLlenar.add(titulosPanel.get(index));
                     i = 0;
                     indexActual = numerosTotal.get(index);
                     continue;
                }
            }
            filasLlenar.add(panel);
        }
        return filasLlenar;
    }
    
    /*----------------------------------TODOS estos metodos son para agregar un nuevo cliente-----------------------------------------*/
    //Metodo que ira validando cada campo al hacerse clic en el boton de listo
    //Devolvera un arraylist con el numero de los campos que tienen error y los vaciara probablemente ????? not sure actually
    public ArrayList<Integer> checkCampos(ArrayList<PairTypeField> columnas, ArrayList<String> dataIngresada){
        ArrayList<Integer> camposArreglar = new ArrayList();
        for(int i = 0; i< dataIngresada.size(); i++){
            String probar = dataIngresada.get(i);
            int useToTest = -1;
            String tipoColumna = columnas.get(i).typeField;
            if(tipoColumna.equals("String")){ //este tipo fijo no va a ser pero para mientras
                useToTest = 1;
            }
            else if(tipoColumna.equals("Integer")){
                useToTest = 2;
            }
            else if(tipoColumna.equals("Float")){
                useToTest = 3;
            }
            else if(tipoColumna.equals("Date")){
                useToTest = 4;
            }
            boolean isCorrect = validateField(probar,useToTest);
            if(!isCorrect){
                camposArreglar.add(i);
            }
        }
        return camposArreglar;
    }
    
    //Metodo que se va a encargar de verificar campos a travez de un numero y un string
    //Hmmmmm creo que voy a usar mi clase PairTypeNumber donde Type sera el mensaje y number el numero logicamente hahahaha
    //Si me hago bolas no ps que le voy a hacer xD
    public ArrayList<PairTypeNumber> checkCamposNuevo(ArrayList<PairTypeNumber> campos, ArrayList<String> dataIngresada){
        ArrayList<PairTypeNumber> camposArreglar = new ArrayList();
        for(int i = 0; i< dataIngresada.size(); i++){
            String probar = dataIngresada.get(i);
            int numberToTest = campos.get(i).numberType;
            boolean isCorrect = validateField(probar, numberToTest);
            if(!isCorrect){
                String mensaje = "El campo "+campos.get(i).nameColumn +" tiene ingresado un dato no valido";
                int number = i;
                PairTypeNumber error = new PairTypeNumber(number,mensaje);
                camposArreglar.add(error);
            }
        }
        return camposArreglar;
    }
    
    //Metodo para crear paneles con los componentes debidos para cuando se debe editar
    public ArrayList<JPanel> componentes(ArrayList<PairNameData> columnas){
        ArrayList<JPanel> filasLlenar = new ArrayList();
        for(PairNameData par: columnas){
            String nombreColumna = par.nombreColumna;
            if(nombreColumna.contains("id")){
                continue;
            }
            String datosEn = par.datosFilaEnColumna;
            JPanel panel = new JPanel();
            JLabel label = new JLabel(nombreColumna);
            JTextField textField = new JTextField(datosEn);
            panel.add(label);
            panel.add(textField);
            filasLlenar.add(panel);
        }
        return filasLlenar;
    }
    //Metodo para crear paneles para cuando es un nuevo usuario 
    public ArrayList<JPanel> componentesNuevoCliente(ArrayList<PairTypeField> columnas){
        /*
        Cliente: 6
        Contacto: 5
        Empresa: 4
        Industria: 2
        SocialData: 5
        */
        tiposNuevoCliente = new ArrayList();
        nombresColumnas = new ArrayList();
        nombresColumnasNativas = new ArrayList();
        int i =0;
        int index =0;
        int indexActual = numerosTotal.get(index);
        ArrayList<JPanel> filasLlenar = new ArrayList();
        JPanel panelito = new JPanel();
        JLabel titulo1 = new JLabel("Datos Cliente");
        panelito.add(titulo1);
        filasLlenar.add(panelito);
        //dummy
        ArrayList<JPanel> titulosPanel = new ArrayList();
        titulosPanel.add(panelito);
        
        JPanel panelito2 = new JPanel();
        JLabel titulo2 = new JLabel("Datos Contacto: ");
        panelito2.add(titulo2);
        titulosPanel.add(panelito2);
        
        JPanel panelito3 = new JPanel();
        JLabel titulo3 = new JLabel("Datos Empresa: ");
        panelito3.add(titulo3);
        titulosPanel.add(panelito3);
        
        JPanel panelito4 = new JPanel();
        JLabel titulo4 = new JLabel("Datos Industria: ");
        panelito4.add(titulo4);
        titulosPanel.add(panelito4);
        
        JPanel panelito5 = new JPanel();
        JLabel titulo5 = new JLabel("Datos de Social Data: ");
        panelito5.add(titulo5);
        titulosPanel.add(panelito5);
       
        for(PairTypeField par: columnas){
            String nombreColumna = par.namefield;
            if(nombreColumna.contains("id") && !nombreColumna.equals("apellido")){
                continue;
            }
            else if(nombreColumna.contains("foto")){
                continue;
            }
            if(index == 0){
                nombresColumnasNativas.add(nombreColumna);
            }
            
            nombreColumna = nombreColumna.replace("_", " ");
            nombreColumna = nombreColumna.substring(0, 1).toUpperCase() + nombreColumna.substring(1);
            nombresColumnas.add(nombreColumna);
            String tipoColumna = par.typeField;
            tipoColumna = tipoColumna.toUpperCase();
            int numberTipo =0;
            if(tipoColumna.contains("TEXT") || tipoColumna.contains("VARCHAR")){
                numberTipo = 1;
            }
            else if(tipoColumna.contains("INT")){
                numberTipo = 2;
            }
            else if(tipoColumna.contains("FLOAT")){
                numberTipo = 3;
            }
            else if(tipoColumna.contains("DATE")){
                numberTipo = 4;
            }
            PairTypeNumber nuevoHere = new PairTypeNumber(numberTipo,tipoColumna,nombreColumna);
            
            
            tiposNuevoCliente.add(nuevoHere);
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(1, 2));
            JLabel label = new JLabel(nombreColumna);
            JTextField textField = new JTextField();
            textField.setPreferredSize(new Dimension(200,24));
            panel.add(label);
            panel.add(textField);
            i++;
            if(i==indexActual){
                index++;
                if(index<numerosTotal.size()){
                    filasLlenar.add(panel);
                    filasLlenar.add(titulosPanel.get(index));
                     i = 0;
                     indexActual = numerosTotal.get(index);
                     continue;
                }
            }
            filasLlenar.add(panel);
        }
        return filasLlenar;
    }
    //Metodo que se encarga de realizar la defernsiva de un campo determinado
    //Recibe un identificador y un texto ingresado
    //Los identificadores seran:
    /*
        1 = String
        2 = Integer
        3 = Float
        4 = Date
    */
    public boolean validateField(String text, int type){

        switch(type){
            case(1):
                if(text.length()==0){
                    return false;
                }
                return true;
            case(2):
                try{
                    int he = Integer.parseInt(text);
                    return true;
                }catch(Exception e){
                    if(text.equals("NULL")){
                        return true;
                    }
                    return false;
                }
            case(3):
                try{
                    double he2 = Double.parseDouble(text);
                    return true;
                }catch(Exception e2){
                    if(text.equals("NULL")){
                        return true;
                    }
                    return false;
                }
            case(4):
                try{
                    LocalDate he3 = LocalDate.parse(text);
                    return true;
                }catch(Exception e3){
                    if(text.equals("NULL")){
                        return true;
                    }
                    return false;
                }
            default:
                break;
        }
        return false;
    }     
}
