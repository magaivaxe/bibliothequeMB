/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import fenetres.Identifier;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author eleves
 */
public class ConnecterListener extends BaseListeners
{
    // Champs
    private final String MSG = "Entrez l'utilisateur et le mot de passe "
            + "s'il vous plaît...";
    private final String TITRE = "ATTENTION!";
    
    @Override
    public void actionPerformed(ActionEvent e){
        //
        String textUtilisateur = Identifier.courant
                .getTextUtilisateur().getText();
        char [] textMotDePasse = Identifier.courant
                .getTextMotDePasse().getPassword();
        //
        if (textUtilisateur.isEmpty() || textMotDePasse.length == 0){
            JOptionPane.showMessageDialog(null, MSG, TITRE,
                    JOptionPane.OK_OPTION);
        }
        else{
            
        }
    }
    
}
