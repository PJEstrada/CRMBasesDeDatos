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
/*Esta clase lleva de forma conjunta dato de las llaves de la base de datos*/
public class PairNameIdClient {
    int id;
    int idContacto;
    int idEmpresa;
    int idIndustria;
    int idSocial;
    String name;

    public PairNameIdClient(int id, int idContacto, int idEmpresa, int idIndustria, int idSocial, String name) {
        this.id = id;
        this.idContacto = idContacto;
        this.idEmpresa = idEmpresa;
        this.idIndustria = idIndustria;
        this.idSocial = idSocial;
        this.name = name;
    }

    
    
    @Override
    public String toString(){
        return name;
    }
}
