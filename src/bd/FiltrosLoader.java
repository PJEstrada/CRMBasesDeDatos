/*
CRM Bases De Datos
Alberto Suriano 12281
Ernesto Solís 12286
Pablo Estrada 12121
 */


package bd;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FiltrosLoader {
    
    ArrayList<Integer> numerosTotal = new ArrayList();
    //nombre de los textBox
    ArrayList<String> nombreTextBox = new ArrayList();
    //nombre de los checkBox
    ArrayList<String> nombreCheckBox = new ArrayList();
    
    
    //nombre de las tablas
    ArrayList<String> nombreTablas = new ArrayList();
    ArrayList<String> tablasRetorno = new ArrayList();
    public FiltrosLoader(int numberCamps){
        numerosTotal.add(numberCamps);
        numerosTotal.add(5);
        numerosTotal.add(4);
        numerosTotal.add(2);
        numerosTotal.add(5);
        nombreTablas.add("cliente");
        nombreTablas.add("contacto");
        nombreTablas.add("empresa");
        nombreTablas.add("industria");
        nombreTablas.add("socialdata");
    }
    //Metodo de validacion (copiado de ClientLoader)
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
    //Metodo para crear paneles con los componentes debidos para cuando se debe editar
    public ArrayList<JPanel> componentesFiltro(ArrayList<PairTypeField> columnas){
        int i =0;
        int index =0;
        int indexActual = numerosTotal.get(index);
        int contador = 0;
        String tablaActual = nombreTablas.get(index);
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
            //String tipoColumna = par.typeField;
            JPanel panel = new JPanel();
            panel.setName("subPanel_"+contador);
            contador++;
            panel.setLayout(new GridLayout(1, 2));
            JCheckBox checkBox = new JCheckBox();
            checkBox.setName("checkBox_"+contador);
            checkBox.setText(nombreColumna);
            JLabel label = new JLabel(nombreColumna);
            JTextField textField = new JTextField();
            textField.setPreferredSize(new Dimension(200,24));
            textField.setName("campo_"+contador);
            panel.add(checkBox);
            //panel.add(label);
            panel.add(textField);
            nombreTextBox.add(textField.getName());
            nombreCheckBox.add(checkBox.getName());
            tablasRetorno.add(tablaActual);
            i++;
            if(i==indexActual){
                index++;
                if(index<numerosTotal.size()){
                    filasLlenar.add(panel);
                    filasLlenar.add(titulosPanel.get(index));
                     i = 0;
                     indexActual = numerosTotal.get(index);
                     tablaActual = nombreTablas.get(index);
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
        if(text.length()==0){
            return false;
        }
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
                    return false;
                }
            case(3):
                try{
                    double he2 = Double.parseDouble(text);
                    return true;
                }catch(Exception e2){
                    return false;
                }
            case(4):
                try{
                    LocalDate he3 = LocalDate.parse(text);
                    return true;
                }catch(Exception e3){
                    return false;
                }
            default:
                break;
        }
        return false;
    }
}
