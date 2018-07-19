/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

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
    private String msg;
    private String msg_titre;
    private JFrame frame;
    // Constructeur
    public QuiterListener(JFrame frame, String msg, String msg_titre) {
        this.frame = frame;
        this.msg = msg;
        this.msg_titre = msg_titre;
    }
    
    //
    @Override
    public void actionPerformed(ActionEvent e) {
        int r = JOptionPane.showConfirmDialog(
                null, msg, msg_titre, JOptionPane.YES_OPTION,
                JOptionPane.WARNING_MESSAGE);
            if (r == 0) {
                frame.dispose();
            }
    }
    
}
