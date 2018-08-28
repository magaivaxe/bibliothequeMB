/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framesListeners;

import frames.Identifier;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author eleves
 */
public class ConnecterListener implements ActionListener
{
    // Champs
    private final String MSG_1 = "Entrez l'utilisateur et le mot de passe "
            + "s'il vous plaît...";
    private final String MSG_2 = "Mot de passe jusqu'au 8 charactères.";
    private final String TITLE_MSG = "ATTENTION!";
    
    @Override
    public void actionPerformed(ActionEvent e){
        // Locals
        final String textUtilisateur = Identifier.courant
                .getTf_utilisateur().getText();
        final char [] textMotDePasse = Identifier.courant
                .getTextMotDePasse().getPassword();
        //
        if (textUtilisateur.isEmpty() || textMotDePasse.length == 0){
            JOptionPane.showMessageDialog(null, MSG_1, TITLE_MSG,
                    JOptionPane.OK_OPTION);
        }
        else if(textMotDePasse.length > 8){
            JOptionPane.showMessageDialog(null, MSG_2, TITLE_MSG,
                    JOptionPane.OK_OPTION);
        }
        else {
            
        }
    }
    
}
