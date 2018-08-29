/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framesListeners;

import frames.Acceuil;
import frames.Identifier;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import methodes.Login;
import rules.UsersMotDePasse;
import rules.Utilisateurs;

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
    private final String MSG_3 = "Utilisateur inexistant";
    
    @Override
    public void actionPerformed(ActionEvent e){
        // Locals
        Identifier idt = Identifier.courant;
        UsersMotDePasse umdp;
        final String USER = idt.getTf_utilisateur().getText();
        final String PW = String.valueOf(
            idt.getTextMotDePasse().getPassword());
        // Connect conditions
        if (USER.isEmpty() || PW.isEmpty()){
            Messages.getInstance().showMessages(MSG_1);
        }
        else if(PW.length() > 8){
            Messages.getInstance().showMessages(MSG_2);
        }
        else {
            // Try find the user, if found open next framme
            Login l = new Login();
            umdp = l.trouverMotDePasse(USER, PW);
            System.out.println(umdp.toString());
            // Same passwords, new runnable
            if (PW.equals(l.decrypterMotDePasse(PW))) {
                //
                Utilisateurs user = l.findUserRole(USER);
                Thread tmp = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Acceuil acc;
                        acc = new Acceuil(user.getRole(),user.getIdUtilisateur());
                        acc.setVisible(true);
                    }
                });
                tmp.start();
                idt.dispose();
            }
        }
    }
}
