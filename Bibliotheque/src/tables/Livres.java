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
public class Livres {
    private String idLivre,cdu,typeLivre,titre;
    private Date dateRegistre;

    public Livres(String idLivre, String cdu, String titre, Date dateRegistre, String typeLivre) {
        this.idLivre = idLivre;
        this.cdu = cdu;
        this.titre = titre;
        this.dateRegistre = dateRegistre;        
        this.typeLivre = typeLivre;

    }

    public Livres() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getIdLivre() {
        return idLivre;
    }

    public void setIdLivre(String idLivre) {
        this.idLivre = idLivre;
    }

    public String getCdu() {
        return cdu;
    }

    public void setCdu(String cdu) {
        this.cdu = cdu;
    }

    public String getTypeLivre() {
        return typeLivre;
    }

    public void setTypeLivre(String typeLivre) {
        this.typeLivre = typeLivre;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getDateRegistre() {
        return dateRegistre;
    }

    public void setDateRegistre(Date dateRegistre) {
        this.dateRegistre = dateRegistre;
    }

    @Override
    public String toString() {
        return "Livres{" + "idLivre=" + idLivre + ", cdu=" + cdu + 
                ", typeLivre=" + typeLivre + ", titre=" + titre + 
                ", dateRegistre=" + dateRegistre + '}';
    }

   
    
    
                          
}
