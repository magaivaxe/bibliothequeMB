/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

/**
 *
 * @author eleves
 */
public class UsersMotDePasse {
//attributs---------------------------------------------------------------------
    private String idUtilisateur, mdpEncripte;

//constructeurs-----------------------------------------------------------------
    public UsersMotDePasse() {
    }

    public UsersMotDePasse(String idUser, String mdpEncripte) {
        this.idUtilisateur = idUser;
        this.mdpEncripte = mdpEncripte;
    }

//getters et setters------------------------------------------------------------
    public String getIdUser() {
        return idUtilisateur;
    }

    public void setIdUser(String idUser) {
        this.idUtilisateur = idUser;
    }

    public String getMdpEncripte() {
        return mdpEncripte;
    }

    public void setMdpEncripte(String mdpEncripte) {
        this.mdpEncripte = mdpEncripte;
    }
    
//methodes----------------------------------------------------------------------
    
}
