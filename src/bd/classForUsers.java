/*
CRM Bases De Datos
Alberto Suriano 12281
Ernesto Solís 12286
Pablo Estrada 12121
 */

package bd;

/**
 *
 * @author usuario
 */
/*
Clase que se encarga de llevar de forma conjunta el nombre de la columna, los datos en la columna y el tipo del mismo. 
*/
public class classForUsers {
    String nombreColumna;
    String datosEnColumna;
    String tipoColumna;

    public classForUsers(String nombreColumna, String datosEnColumna, String tipoColumna) {
        this.nombreColumna = nombreColumna;
        this.datosEnColumna = datosEnColumna;
        this.tipoColumna = tipoColumna;
    }
    
}
