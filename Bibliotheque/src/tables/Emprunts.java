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
    private String idLivre;//permiere lettre d'auteur+nbsequence
    private Date dateEmp, dateRen;//dateRendre
    private StatusEMs statusEM;
    
    private enum StatusEMs {cours,fini,delai}
}
