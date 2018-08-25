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
public class RendezVous {
    private int idRendezVous; 
    private String Livre, idUtilisateur;
    private Date datePrevue;
    private Types type;        
    private StatusRVs statusRV;
    
    private enum Types {journee, matin, apresmidi}
    private enum StatusRVs {conclu, annule, attente}
    
}
