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
public class Reservations {
    private int idReservation; 
    private String idLivre, idUtilisateur, statusRs;
    private Date datePrevue;
   
//StatusRSs {fini,annule,attente}

    public Reservations(int idReservation, String idLivre, String idUtilisateur, Date datePrevue, String statusRs) {
        this.idReservation = idReservation;
        this.idLivre = idLivre;
        this.idUtilisateur = idUtilisateur;
        this.datePrevue = datePrevue;
        this.statusRs = statusRs;
        
    }

    public Reservations() {
    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public String getIdLivre() {
        return idLivre;
    }

    public void setIdLivre(String idLivre) {
        this.idLivre = idLivre;
    }

    public String getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(String idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getStatusRs() {
        return statusRs;
    }

    public void setStatusRs(String statusRs) {
        this.statusRs = statusRs;
    }

    public Date getDatePrevue() {
        return datePrevue;
    }

    public void setDatePrevue(Date datePrevue) {
        this.datePrevue = datePrevue;
    }

    @Override
    public String toString() {
        return "Reservations{" + "idReservation=" + idReservation 
                + ", idLivre=" + idLivre + ", idUtilisateur=" + idUtilisateur 
                + ", datePrevue=" + datePrevue + ", statusRs=" + statusRs + '}';
    }
    
    
    
}
