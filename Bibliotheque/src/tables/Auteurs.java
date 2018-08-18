/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import java.time.Year;

/**
 *
 * @author eleves
 */
public class Auteurs {
    private int isbn;
    private String p_a_PreNom, p_a_Nom, s_a_PreNom, s_a_Nom, t_a_PreNom, t_a_Nom;
    private Year annisbneeNe, anneeMort;

    public Auteurs(int isbn, String p_a_PreNom, String p_a_Nom, String s_a_PreNom, String s_a_Nom, String t_a_PreNom, String t_a_Nom, Year annisbneeNe, Year anneeMort) {
        this.isbn = isbn;
        this.p_a_PreNom = p_a_PreNom;
        this.p_a_Nom = p_a_Nom;
        this.s_a_PreNom = s_a_PreNom;
        this.s_a_Nom = s_a_Nom;
        this.t_a_PreNom = t_a_PreNom;
        this.t_a_Nom = t_a_Nom;
        this.annisbneeNe = annisbneeNe;
        this.anneeMort = anneeMort;
    }

    public Auteurs() {
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getP_a_PreNom() {
        return p_a_PreNom;
    }

    public void setP_a_PreNom(String p_a_PreNom) {
        this.p_a_PreNom = p_a_PreNom;
    }

    public String getP_a_Nom() {
        return p_a_Nom;
    }

    public void setP_a_Nom(String p_a_Nom) {
        this.p_a_Nom = p_a_Nom;
    }

    public String getS_a_PreNom() {
        return s_a_PreNom;
    }

    public void setS_a_PreNom(String s_a_PreNom) {
        this.s_a_PreNom = s_a_PreNom;
    }

    public String getS_a_Nom() {
        return s_a_Nom;
    }

    public void setS_a_Nom(String s_a_Nom) {
        this.s_a_Nom = s_a_Nom;
    }

    public String getT_a_PreNom() {
        return t_a_PreNom;
    }

    public void setT_a_PreNom(String t_a_PreNom) {
        this.t_a_PreNom = t_a_PreNom;
    }

    public String getT_a_Nom() {
        return t_a_Nom;
    }

    public void setT_a_Nom(String t_a_Nom) {
        this.t_a_Nom = t_a_Nom;
    }

    public Year getAnnisbneeNe() {
        return annisbneeNe;
    }

    public void setAnnisbneeNe(Year annisbneeNe) {
        this.annisbneeNe = annisbneeNe;
    }

    public Year getAnneeMort() {
        return anneeMort;
    }

    public void setAnneeMort(Year anneeMort) {
        this.anneeMort = anneeMort;
    }

    @Override
    public String toString() {
        return "Auteurs{" + "isbn=" + isbn + ", p_a_PreNom=" + p_a_PreNom + ","
                + " p_a_Nom=" + p_a_Nom + ", s_a_PreNom=" + s_a_PreNom + ","
                + " s_a_Nom=" + s_a_Nom + ", t_a_PreNom=" + t_a_PreNom + ","
                + " t_a_Nom=" + t_a_Nom + ", annisbneeNe=" + annisbneeNe + ","
                + " anneeMort=" + anneeMort + '}';
    }
                    
    
}
