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
public class Amendes {
    private int idAmende, idEmprunts;
    private String idUtilisateur;
    private Date dateAmende, datePaye;
    private double valeur;
    private StatusAMs statusAM;
    
    private enum StatusAMs {ouverte,paye;}
    
}
