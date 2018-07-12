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
public class HistoriquesLivres {
    private String idLivre;
    private StatusHls statusHL;
    private Date dateStatus;
    
    
    private enum StatusHls {archive_mort,renovation,perdu;}
   
}
