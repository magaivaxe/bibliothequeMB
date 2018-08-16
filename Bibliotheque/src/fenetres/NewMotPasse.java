/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenetres;

import com.toedter.calendar.JDateChooser;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import listeners.QuiterListener;
import listeners.ReinitialiserMDPListener;

/**
 * @author Marcos Gomes
 */
public class NewMotPasse extends JFrame implements InterfaceFenetres{
    // Fields
    
    // Objets
    private JLabel l_utilisateur, l_motPasse, l_confirmation, l_date;
    private JTextField tf_utilisateur;
    private JDateChooser dataChooser;
    private JPasswordField pf_motPasse,pf_confirmation;
    private JButton b_envoyer, b_annuler;
    private JPanel mainPanel;
    
    public static NewMotPasse courant;
    
    // Constructeur
    public NewMotPasse() {
        initialiserComposants();
        layouts();
        polices();
        styles();
        definirListeners();
        courant = this;
    }

    @Override
    public void initialiserComposants() {
        // Locals
        final String TITRE = "Réinitialiser mot de passe";
        final String L_USER = "Utilisateur:";
        final String L_MDP = "Mot de Passe:";
        final String L_CONFIRM_MDP = "Confirmation:";
        final String L_DATE = "Date de Naissance:";
        final String B_ENVOYER = "Envoyer";
        final String B_ANNULER = "Annuler";
        // Frame
        setTitle(TITRE);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        // Labels
        l_utilisateur = new JLabel(L_USER);
        l_date = new JLabel(L_DATE);
        l_motPasse = new JLabel(L_MDP);
        l_confirmation = new JLabel(L_CONFIRM_MDP);
        // Text fields
        tf_utilisateur = new JTextField();
        dataChooser = new JDateChooser();
        pf_motPasse = new JPasswordField();
        pf_confirmation = new JPasswordField();
        // Buttons
        b_annuler = new JButton(B_ANNULER);
        b_envoyer = new JButton(B_ENVOYER);
        // Panel
        mainPanel = new JPanel();
        mainPanel.add(l_utilisateur); mainPanel.add(l_date);
        mainPanel.add(l_motPasse); mainPanel.add(l_confirmation);
        mainPanel.add(tf_utilisateur);mainPanel.add(dataChooser);
        mainPanel.add(pf_motPasse);mainPanel.add(pf_confirmation);
        mainPanel.add(b_annuler);mainPanel.add(b_envoyer);
        
        add(mainPanel);
    }

    @Override
    public void layouts() {
        // Main bounds
        final int W_FRAME = 470;
        final int H_FRAME = 310;
        final int ORIGIN = 30;
        final int SPACE = 5;
        // Components bounds
        final int H_COMP = 30;
        final int W_TFIELD = 200;

        final int W_L_USER = 70;
        final int X_L_USER = ORIGIN + 10*SPACE;
        final int Y_L_USER = ORIGIN;
        final int X_TF_USER = X_L_USER + W_L_USER + SPACE;
        final int Y_TF_USER = Y_L_USER;

        final int W_L_DATE = 120;
        final int X_L_DATE = ORIGIN;
        final int Y_L_DATE = Y_L_USER + H_COMP + SPACE;
        final int X_TF_DATE = X_L_DATE + W_L_DATE + SPACE;
        final int Y_TF_DATE = Y_L_DATE;
        final int W_L_HINTDATE = 80;
        final int X_L_HINTDATE = X_TF_DATE + W_TFIELD + SPACE;
        final int Y_L_HINTDATE = Y_TF_DATE;
    
        final int W_L_MDP = 90;
        final int X_L_MDP = ORIGIN + 6*SPACE;
        final int Y_L_MDP = Y_L_DATE + H_COMP + ORIGIN;
        final int X_PF_MDP = X_L_MDP + W_L_MDP + SPACE;
        final int Y_PF_MDP = Y_L_MDP;

        final int W_L_CMDP = 90;
        final int X_L_CMDP = ORIGIN + 6*SPACE;
        final int Y_L_CMDP = Y_L_MDP + H_COMP + SPACE;
        final int X_PF_CMDP = X_L_CMDP + W_L_CMDP + SPACE;
        final int Y_PF_CMDP = Y_L_CMDP;

        final int W_BUTTON = 100;
        final int X_B_ANNULER = (W_FRAME - 2*W_BUTTON - 20*SPACE) / 2;
        final int Y_B_ANNULER = Y_L_CMDP + H_COMP + ORIGIN;
        final int X_B_ENVOYER = X_B_ANNULER + W_BUTTON + 20*SPACE;
        final int Y_B_ENVOYER = Y_B_ANNULER;
        // Frame layout
        setResizable(false);
        setSize(W_FRAME, H_FRAME);
        setLocationRelativeTo(null);
        // Panel layout
        mainPanel.setLayout(null);
        // Components layout
        l_utilisateur.setBounds(X_L_USER, Y_L_USER, W_L_USER, H_COMP);
        l_date.setBounds(X_L_DATE, Y_L_DATE, W_L_DATE, H_COMP);
        l_motPasse.setBounds(X_L_MDP, Y_L_MDP, W_L_MDP, H_COMP);
        l_confirmation.setBounds(X_L_CMDP, Y_L_CMDP, W_L_CMDP, H_COMP);
        
        tf_utilisateur.setBounds(X_TF_USER, Y_TF_USER, W_TFIELD, H_COMP);
        dataChooser.setBounds(X_TF_DATE, Y_TF_DATE, W_TFIELD, H_COMP);
        pf_motPasse.setBounds(X_PF_MDP, Y_PF_MDP, W_TFIELD, H_COMP);
        pf_confirmation.setBounds(X_PF_CMDP, Y_PF_CMDP, W_TFIELD, H_COMP);
        
        b_annuler.setBounds(X_B_ANNULER, Y_B_ANNULER, W_BUTTON, H_COMP);
        b_envoyer.setBounds(X_B_ENVOYER, Y_B_ENVOYER, W_BUTTON, H_COMP);
    }

    @Override
    public void styles() {
        
    }
 
    @Override
    public void polices() {
        Map<TextAttribute, Object> pol_hintDate = new HashMap<>();
        pol_hintDate.put(
            TextAttribute.POSTURE, TextAttribute.POSTURE_OBLIQUE);
//        l_hintDate.setFont(Font.getFont(pol_hintDate));
    }

    @Override
    public void definirListeners() {
        // Locals
        final String MSG_1 =
              "Voulez-vous annuler le nouveau mot de passe?\n"
            + "Si oui, les informations seront perdues!";
        final String MSG_1_TITRE = "Attention!";
        // Listeners
        b_annuler.addActionListener(
            new QuiterListener(this, MSG_1, MSG_1_TITRE));
        b_envoyer.addActionListener(new ReinitialiserMDPListener());
    }
    
    // Getters
    public JTextField getTf_utilisateur() {return tf_utilisateur;}

    public JDateChooser getDataChooser() {return dataChooser;}

    public JPasswordField getPf_motPasse() {return pf_motPasse;}

    public JPasswordField getPf_confirmation() {return pf_confirmation;}
    

}
