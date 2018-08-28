/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framesListeners;

import frames.NewMotPasse;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import methodes.Reinitialisation;

/**
 *
 * @author sire_marcos
 */
public class ReinitialiserMDPListener implements ActionListener{
    // Fields
    private final String TITLE_MSG = "ATTENTION!";
    private final String MSG_1 = "Quelques informations ne sont pas correctes.";
    private final String MSG_2 = "Utilisateur incorrect.";
    private Reinitialisation rei;
    @Override
    public void actionPerformed(ActionEvent e) {
        // Locals
        final NewMotPasse nmp = NewMotPasse.courant;
        final String user = nmp.getTf_utilisateur().getText();
        final String date = nmp.getDataChooser().getToolTipText();
        final char [] pw = nmp.getPf_motPasse().getPassword();
        final char [] pwc = nmp.getPf_confirmation().getPassword();
        System.out.println(date);
        // Cconditions to do the query
        if(!checkDatas(user,date,pw,pwc)) {
            JOptionPane.showMessageDialog(null, MSG_1, TITLE_MSG, 
                    JOptionPane.OK_OPTION);
        } else {
           rei = new Reinitialisation();
            if (!user.equals(rei.chercherUtilisateur(user, date))) {
                JOptionPane.showMessageDialog(null, MSG_2, TITLE_MSG,
                    JOptionPane.OK_OPTION);
            } else {
                String pwts = String.valueOf(pw);
                rei.changerMotDePasse(user, pwts);
            }
        }
    }
    
    /**
     * Method to check the entry values 
     * @param user User id
     * @param date birthdate
     * @param pw new password
     * @param pwc new password confirmation
     * @return false if the entries are wrongs else true
     */
    private boolean checkDatas(String user,String date,char[] pw,char[] pwc){
        //
        if(user.isEmpty() || user.length() > 8){
            return false;
        } else if (date.isEmpty()) {
            return false;
        } else if (pw.length == 0 || pwc.length == 0) {
            return false;
        } else if (!pw.equals(pwc)) {
            return false;
        } else {
            return true;
        }
    }
    
}
