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
import methodes.Reserve;
import tableData.SearchedBook;

/**
 *
 * @author sire_marcos
 */
public class ReserveListener implements ActionListener{
    // Fields
    final String MSG_1 = "Il faut sélectionner un livre pour"
                       + " faire une réservation.";
    final String MSG_2 = "C'est interdit de réserver plus que"
                       + " trois livres à la fois.";
    final String MSG_3 = "Livres reservés.";
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Locals
        SearchPanel sp = SearchPanel.courant;
        Acceuil ac = Acceuil.courant;
        final int [] ROWS = sp.getTa_recherche().getSelectedRows();
        final ArrayList<SearchedBook> LIST = sp.getTm_recherche().getRow(ROWS);
        //
        if (ROWS.length == 0) {
            Messages.getInstance().showMessages(MSG_1);
        } else if (ROWS.length > 3) {
            Messages.getInstance().showMessages(MSG_2);
        } else {
            final String MSG_CONF = "Voulez-vous réserver: " + booksString(LIST);
            int r = Messages.getInstance().warningMessages(MSG_CONF);
            //
            if (r == 0) {
                // loop to reserve
                for (int i = 0; i < LIST.size(); i++) {
                    //
                    try {
                        // Locals
                        Reserve.getInstance().insert(LIST.get(i).getIdLivre(),
                        ac.getIdUser());
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
                // Add message
                Messages.getInstance().showMessages(MSG_2);
            }
        }
    }
    
    /**
     * 
     * @param list book list to compose a string to show message
     * @return a concatenaded String of books
     */
    private String booksString(ArrayList<SearchedBook> list) {
        //Locals
        String books = "\n";
        for (int i = 0; i < list.size(); i++) {
            // Conditions to write text
            if (list.size() == 1) {
                books = books + list.get(i).getTitre() + ".";
            } else if (i == list.size() - 1) {
                books = books + "et " + list.get(i).getTitre() + ".";
            } else {
                books = books + list.get(i).getTitre() + ",\n";
            }
        }
        return books;
    }
}
