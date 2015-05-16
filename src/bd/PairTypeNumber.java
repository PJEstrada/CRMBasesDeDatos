/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

/**
 *
 * @author usuario
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
