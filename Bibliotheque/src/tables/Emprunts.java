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
public class Emprunts {
    private int idEmprunt; 
    private String idLivre,idUtilisateur;
    private Date dateEmp, dateRen;
    private String statusEM;
    
    //StatusEMs {cours,fini,delai}

    public Emprunts() {
    }

    public Emprunts(int idEmprunt, String idLivre, String idUtilisateur, 
            Date dateEmp, Date dateRen, String statusEM) {
        this.idEmprunt = idEmprunt;
        this.idLivre = idLivre;
        this.idUtilisateur = idUtilisateur;
        this.dateEmp = dateEmp;
        this.dateRen = dateRen;
        this.statusEM = statusEM;
    }

    public int getIdEmprunt() {
        return idEmprunt;
    }

    public void setIdEmprunt(int idEmprunt) {
        this.idEmprunt = idEmprunt;
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

    public Date getDateEmp() {
        return dateEmp;
    }

    public void setDateEmp(Date dateEmp) {
        this.dateEmp = dateEmp;
    }

    public Date getDateRen() {
        return dateRen;
    }

    public void setDateRen(Date dateRen) {
        this.dateRen = dateRen;
    }

    public String getStatusEM() {
        return statusEM;
    }

    public void setStatusEM(String statusEM) {
        this.statusEM = statusEM;
    }

    @Override
    public String toString() {
        return "Emprunts{" + "idEmprunt=" + idEmprunt + ", idLivre=" + idLivre + 
                ", idUtilisateur=" + idUtilisateur + ", dateEmp=" + dateEmp + 
                ", dateRen=" + dateRen + ", statusEM=" + statusEM + '}';
    }
    
    
   
   
    
    
    
}
