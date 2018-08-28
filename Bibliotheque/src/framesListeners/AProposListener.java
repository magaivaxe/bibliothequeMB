/*
 * 
 */
package framesListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author sire_marcos
 */
public class AProposListener implements ActionListener{
    //Fields
    final String TITLE = "Bibliothèque Marguerite Bourgeoys";
    final String PHONE = "514 999 9999";
    final String OPEN = "8h le matin";
    final String CLOSE = "17h l'après midi";
    final String MAIL = "margherite@mb.ca";
    final String MSG = "Heure d'ouverture: "+ OPEN +"\n"
                     + "Heure de fermeture: "+ CLOSE +"\n"
                     + "Téléphone: " + PHONE + "\n"
                     + "Courriel: " + MAIL;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //
        JOptionPane.showMessageDialog(
            null, MSG, TITLE, JOptionPane.INFORMATION_MESSAGE);
    }
}
