/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import java.util.Date;

/**
 *
 * @author eleves
 */
public class RendezVous {
    private int idRendezVous; 
    private String idLivre, idUtilisateur;
    private String datePrevue;
    private String type;        
    private String statusRV;
    
    //Types {journee, matin, apresmidi}
    //StatusRVs {conclu, annule, attente}

    public RendezVous() {
    }

    public RendezVous(int idRendezVous, String idLivre, String idUtilisateur, String datePrevue, String type, String statusRV) {
        this.idRendezVous = idRendezVous;
        this.idLivre = idLivre;
        this.idUtilisateur = idUtilisateur;
        this.datePrevue = datePrevue;
        this.type = type;
        this.statusRV = statusRV;
    }

    public int getIdRendezVous() {
        return idRendezVous;
    }

    public void setIdRendezVous(int idRendezVous) {
        this.idRendezVous = idRendezVous;
    }

    public String getLivre() {
        return idLivre;
    }

    public void setLivre(String Livre) {
        this.idLivre = Livre;
    }

    public String getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(String idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getDatePrevue() {
        return datePrevue;
    }

    public void setDatePrevue(String datePrevue) {
        this.datePrevue = datePrevue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatusRV() {
        return statusRV;
    }

    public void setStatusRV(String statusRV) {
        this.statusRV = statusRV;
    }

    @Override
    public String toString() {
        return "RendezVous{" + "idRendezVous=" + idRendezVous + ", Livre=" + 
                idLivre + ", idUtilisateur=" + idUtilisateur + ", datePrevue=" + 
                datePrevue + ", type=" + type + ", statusRV=" + statusRV + '}';
    }
    
    
    
}
