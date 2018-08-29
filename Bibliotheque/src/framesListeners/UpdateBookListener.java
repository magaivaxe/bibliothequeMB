/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framesListeners;

import frames.Acceuil;
import framesComponents.SearchPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import methodes.Searches;
import rules.UpdateBook;
import tableData.SearchedBook;

/**
 *
 * @author sire_marcos
 */
public class UpdateBookListener implements ActionListener {
    // Fields
    final String MSG_1 = "Il faut sélectionner le livre à mettre à jour.";
    final String MSG_2 = "C'est impossible de mettre à jour plus"
            + " qu'un livre à la fois.";
    final String MSG_3 = "Livre à jour.";
    @Override
    public void actionPerformed(ActionEvent e) {
        //
        SearchPanel sp = SearchPanel.courant;
        Acceuil ac = Acceuil.courant;
        final int [] ROWS = sp.getTa_recherche().getSelectedRows();
        final ArrayList<SearchedBook> LIST = sp.getTm_recherche().getRow(ROWS);
        //
        if (ROWS.length == 0) {
            Messages.getInstance().showMessages(MSG_1);
        } else if (ROWS.length > 1) {
            Messages.getInstance().showMessages(MSG_2);
        } else {
            final String MSG_CONF = "Voulez-vous mettre à jour: " 
                    + LIST.get(0).getTitre();
            int r = Messages.getInstance().warningMessages(MSG_CONF);
            //
            if (r == 0) {
                try {
                    UpdateBook ub = Searches.getInstance().byID(MSG_1);
                } catch (SQLException ex) {
                }
                // Add message
                Messages.getInstance().showMessages(MSG_3);
            }
        }
    }
    
}
