

package bd;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FiltrosLoader {
    
    
    public FiltrosLoader(){}
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
    public ArrayList<JPanel> componentes(ArrayList<PairTypeField> columnas){
        ArrayList<JPanel> filasLlenar = new ArrayList();
        for(PairTypeField par: columnas){
            String nombreColumna = par.namefield;
            JPanel panel = new JPanel();
            JLabel label = new JLabel(nombreColumna);
            JTextField textField = new JTextField("");
            panel.add(label);
            panel.add(textField);
            filasLlenar.add(panel);
        }
        return filasLlenar;
    }
    //Metodo para crear paneles para cuando es un nuevo usuario 
    public ArrayList<JPanel> componentesFiltro(ArrayList<PairTypeField> columnas){
        ArrayList<JPanel> filasLlenar = new ArrayList();
        for(PairTypeField par: columnas){
            String nombreColumna = par.namefield;
            String tipoColumna = par.typeField;
            JPanel panel = new JPanel();
            JLabel label = new JLabel(nombreColumna);
            JTextField textField = new JTextField();
            panel.add(label);
            panel.add(textField);
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
