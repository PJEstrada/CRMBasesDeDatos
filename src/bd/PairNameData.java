/*
CRM Bases De Datos
Alberto Suriano 12281
Ernesto Solís 12286
Pablo Estrada 12121
 */

package bd;

/**
 *
 * @author Al
 */
/*
Clase que se encargara de poder llevar datos apareados siendo el nombre de la columna y los datos en en la fila de columna
*/
public class PairNameData {
    String nombreColumna;
    String datosFilaEnColumna;

    public PairNameData(String nombreColumna, String datosFilaEnColumna) {
        this.nombreColumna = nombreColumna;
        this.datosFilaEnColumna = datosFilaEnColumna;
    }
}
