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
    private String idLivre, cdu, titre;
    private int isbn;
    private Date dateRegistre;
    private TypeLivres typeLivre;
    
    public enum TypeLivres {regulier,rare}
                            
}
