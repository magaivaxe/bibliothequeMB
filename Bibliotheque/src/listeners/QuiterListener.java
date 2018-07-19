/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import fenetres.Identifier;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcos
 */
public class QuiterListener implements ActionListener{
    // Champs
    private final String MSG_1 = "Voulez-vous quiter l'appication";
    private final String MSG_1_TITRE = "Message";
    private JFrame frame;
    // Constructeur
    public QuiterListener(JFrame frame) {
        this.frame = frame;
    }
    
    //
    @Override
    public void actionPerformed(ActionEvent e) {
        int r = JOptionPane.showConfirmDialog(
                null, MSG_1, MSG_1_TITRE, JOptionPane.YES_OPTION,
                JOptionPane.INFORMATION_MESSAGE);
            if (r == 0) {
                frame.dispose();
            }
    }
    
}
