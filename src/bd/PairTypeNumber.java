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
Clase que lleva de forma conjunta el numero que es del tipo y el nombre del mismo
*/
public class PairTypeNumber {
    int numberType;
    String nameType;

    public PairTypeNumber(int numberType, String nameType) {
        this.numberType = numberType;
        this.nameType = nameType;
    }
    String nameColumn;

    public PairTypeNumber(int numberType, String nameType, String nameColumn) {
        this.numberType = numberType;
        this.nameType = nameType;
        this.nameColumn = nameColumn;
    }
    
    
}
