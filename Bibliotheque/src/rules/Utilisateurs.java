/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rules;
/**
 *
 * @author eleves
 */
public class Utilisateurs {
//Attibuts----------------------------------------------------------------------
    private String idUtilisateur, nom, preNom,
            adresse, telephone, courriel, role, statusUT,dateNe,dateRegistre;
 
//Constructeurs-----------------------------------------------------------------
    
    public Utilisateurs(String idUtilisateur, String nom, String preNom, 
            String adresse, String telephone, String courriel, String dateNe, 
            String dateRegistre, String role, String statusUT) {
        this.idUtilisateur = idUtilisateur;
        this.nom = nom;
        this.preNom = preNom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.courriel = courriel;
        this.dateNe = dateNe;
        this.dateRegistre = dateRegistre;
        this.role = role;
        this.statusUT = statusUT;
    }
    
    public Utilisateurs() {
    }

//getters et setters------------------------------------------------------------

    public String getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(String idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPreNom() {
        return preNom;
    }

    public void setPreNom(String preNom) {
        this.preNom = preNom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public String getDateNe() {
        return dateNe;
    }

    public void setDateNe(String dateNe) {
        this.dateNe = dateNe;
    }

    public String getDateRegistre() {
        return dateRegistre;
    }

    public void setDateRegistre(String dateRegistre) {
        this.dateRegistre = dateRegistre;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatusUT() {
        return statusUT;
    }

    public void setStatusUT(String statusUT) {
        this.statusUT = statusUT;
    }

    @Override
    public String toString() {
        return "Utilisateurs{" + "idUtilisateur=" + this.idUtilisateur + 
                ", nom=" + this.nom + ", preNom=" + preNom + ", adresse=" 
                + adresse + ", telephone=" + telephone + ", courriel=" 
                + courriel + ", role=" + role + ", statusUT=" + statusUT +
                ", dateNe=" + dateNe + ", dateRegistre=" + dateRegistre + '}';
    }


  
}
