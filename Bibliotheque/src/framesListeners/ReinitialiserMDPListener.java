/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framesListeners;

import frames.NewMotPasse;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mainPack.DateTime;
import methodes.Reinitialisation;

/**
 *
 * @author sire_marcos
 */
public class ReinitialiserMDPListener implements ActionListener{
    // Fields
    private final String MSG_1 = "Informations incorrectes.";
    private final String MSG_2 = "Utilisateur incorrect.";
    private final String MSG_3 = "Mot de passe à jour.";
    private final String MSG_4 = "Date invalide.";
    
    // Objects
    private String date;
    private Reinitialisation rei;
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Locals
        final NewMotPasse nmp = NewMotPasse.courant;
        
        final String USER = nmp.getTf_utilisateur().getText();
        final String pw = String.valueOf(nmp.getPf_motPasse().getPassword());
        final String pwc = String.valueOf(
            nmp.getPf_confirmation().getPassword());
        
        // Conditions to do the query
        if(!checkDatas(USER,pw,pwc)) {
            Messages.getInstance().showMessages(MSG_1);
        } else {
           rei = new Reinitialisation();
            if (!USER.equals(rei.chercherUtilisateur(USER, date))) {
                Messages.getInstance().showMessages(MSG_2);
            } else {
                rei.changerMotDePasse(USER, pw);
                Messages.getInstance().showMessages(MSG_3);
            }
        }
    }
    
    /**
     * 
     * @param nmp
     * @return 
     */
    private boolean checkDate(NewMotPasse nmp){
        //
        final String FORMAT = "yyyy-MM-dd";
        try {
            date = DateTime.getInstance().setDateFormat(
                nmp.getDataChooser().getDate(), FORMAT);
            return true;
        } catch (Exception e) {
            Messages.getInstance().showMessages(MSG_4);
            return false;
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
    private boolean checkDatas(String user,String pw,String pwc){
        //
        if(user.isEmpty() || user.length() > 8){
            return false;
        } else if (!checkDate(NewMotPasse.courant)) {
            return false;
        } else if (pw.isEmpty() || pwc.isEmpty()) {
            return false;
        } else return pw.equals(pwc);
    }
}
