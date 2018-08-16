/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableData;

/**
 *
 * @author sire_marcos
 */
public class SearchedBook {
    // Fields
    private String cdu;
    private String auteur;
    private String titre;
    private String type;
    
    // Constructors
    public SearchedBook() {}
    public SearchedBook(String cdu, String auteur, String titre, String type) {
        this.cdu = cdu;
        this.auteur = auteur;
        this.titre = titre;
        this.type = type;
    }
    
    // Setters and getters
    public String getCdu() {return cdu;}

    public void setCdu(String cdu) { this.cdu = cdu;}

    public String getAuteur() {return auteur;}

    public void setAuteur(String auteur) {this.auteur = auteur;}

    public String getTitre() {return titre;}

    public void setTitre(String titre) { this.titre = titre;}

    public String getType() {return type;}

    public void setType(String type) {this.type = type;}
    
    // To String
    @Override
    public String toString() {
        return "SearchedBook{" + 
                "cdu=" + cdu + 
                ", auteur=" + auteur + 
                ", titre=" + titre + 
                ", type=" + type + '}';
    }
    
    
    
}
