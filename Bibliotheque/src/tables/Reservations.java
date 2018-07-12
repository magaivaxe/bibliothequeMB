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
    private String idLivre, idUtilisateur;//permiere lettre d'auteur+nbsequence
    private Date datePrevue;
    private StatusRSs statusRs;
    
    private enum StatusRSs {fini,annule,attente}
    
}
