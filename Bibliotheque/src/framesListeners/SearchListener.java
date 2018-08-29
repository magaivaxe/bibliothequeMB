/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framesListeners;

import framesComponents.SearchPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import methodes.Searches;
import tableData.SearchedBook;

/**
 *
 * @author Marcos
 */
public class SearchListener implements ActionListener{
    // Fields
    private final String MSG_1 = "Veuillez entrer un livre à rechercher.";
    private final String MSG_2 = "Aucun paramètres de recherche selectionné.";
    private final String MSG_3 = "Impossible connecter.";
    // Objects
    
    // Constructor
    public SearchListener() {}

    @Override
    public void actionPerformed(ActionEvent e) {
        // locals
        SearchPanel sp = SearchPanel.courant;
        final String INFO =  sp.getTf_recherche().getText();
        // Seach Conditions
        if (INFO.isEmpty()) {
            Messages.getInstance().showMessages(MSG_1);
        } else if(!sp.getCb_titre().isSelected()) {
            Messages.getInstance().showMessages(MSG_2);
        } else if (sp.getCb_deadArchive().isSelected()) {
            //TODO search by bead archive
        } else {
            // Search a book by title
            try {
                ArrayList<SearchedBook> list =
                        Searches.getInstance().byTitle(INFO);
                sp.getTm_recherche().setRows(list);
            } catch (SQLException ex) {
                Messages.getInstance().showMessages(MSG_3);
            }
        }
    }
}
