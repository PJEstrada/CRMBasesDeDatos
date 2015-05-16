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
