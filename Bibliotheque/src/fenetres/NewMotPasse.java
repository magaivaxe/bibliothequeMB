/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenetres;

import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import listeners.QuiterListener;
import listeners.ReinitialiserMDPListener;

/**
 *
 * @author sire_marcos
 */
public class NewMotPasse extends JFrame implements InterfaceFenetres{
    // Champs
    private final String TITRE = "Réinitialiser mot de passe";
    private final String UTILISATEUR = "Utilisateur: ";
    private final String MDP = "Mot de Passe: ";
    private final String CONFIRM_MDP = "Confirmation: ";
    private final String DATE_NAISSANCE = "Date de Naissance: ";
    private final String B_ENVOYER = "Envoyer";
    private final String B_ANNULER = "Annuler";
    private final String MSG_1 =
              "Voulez-vous annuler le nouveau mot de passe?\n"
            + "Si oui, les informations seront perdues!";
    private final String MSG_TITRE = "Attention!";
    private final int LARGEUR = 400;
    private final int HAUTEUR = 300;
    private final int H_PAD_TF = 50;
    private final int B_PAD_TF = 40;
    private final int GD_PAD_TF = 20;
    private final int B_PAD_L = 20;
    private final int B_PAD_B = 10;
            
    // Objets
    private JLabel l_utilisateur, l_motPasse, l_confirmation, l_date;
    private JTextField t_utilisateur, t_date;
    private JPasswordField pf_motPasse,pf_confirmation;
    private JButton b_envoyer, b_annuler;
    private JPanel labelPanel, tfPanel, horPanel, buttonPanel;
    private Container cont;
    
    public static NewMotPasse courant;
    
    // Constructeur
    public NewMotPasse() {
        initialiserComposants();
        layouts();
        polices();
        definirListeners();
        courant = this;
    }

    @Override
    public void initialiserComposants() {
        //
        setTitle(TITRE);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        //
        l_utilisateur = new JLabel(UTILISATEUR);
        l_date = new JLabel(DATE_NAISSANCE);
        l_motPasse = new JLabel(MDP);
        l_confirmation = new JLabel(CONFIRM_MDP);
        labelPanel = new JPanel();
        labelPanel.add(l_utilisateur); labelPanel.add(l_date);
        labelPanel.add(l_motPasse); labelPanel.add(l_confirmation);
        
        t_utilisateur = new JTextField();
        t_date = new JTextField();
        pf_motPasse = new JPasswordField();
        pf_confirmation = new JPasswordField();
        tfPanel = new JPanel();
        tfPanel.add(t_utilisateur); tfPanel.add(t_date);
        tfPanel.add(pf_motPasse); tfPanel.add(pf_confirmation);
        
        horPanel = new JPanel();
        horPanel.add(labelPanel); horPanel.add(tfPanel);
        
        b_annuler = new JButton(B_ANNULER);
        b_envoyer = new JButton(B_ENVOYER);
        buttonPanel = new JPanel();
        buttonPanel.add(b_annuler); buttonPanel.add(b_envoyer);
        
        cont = getContentPane();
        cont.add(horPanel); cont.add(buttonPanel);
    }

    @Override
    public void layouts() {
        //
        setResizable(false);
        setSize(LARGEUR, HAUTEUR);
        setLocationRelativeTo(null);
        cont.setLayout(new BoxLayout(cont, BoxLayout.Y_AXIS));
        //
        l_utilisateur.setAlignmentX(RIGHT_ALIGNMENT);
        l_date.setAlignmentX(RIGHT_ALIGNMENT);
        l_motPasse.setAlignmentX(RIGHT_ALIGNMENT);
        l_confirmation.setAlignmentX(RIGHT_ALIGNMENT);
        l_utilisateur.setBorder(new EmptyBorder(0, 0, B_PAD_L, 0));
        l_date.setBorder(new EmptyBorder(0, 0, B_PAD_L, 0));
        l_motPasse.setBorder(new EmptyBorder(0, 0, B_PAD_L, 0));
        b_envoyer.setAlignmentX(RIGHT_ALIGNMENT); 
        
        //
        horPanel.setLayout(new BoxLayout(horPanel, BoxLayout.X_AXIS));
        horPanel.setBorder(
                new EmptyBorder(H_PAD_TF, GD_PAD_TF,B_PAD_TF, GD_PAD_TF));
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
        tfPanel.setLayout(new BoxLayout(tfPanel, BoxLayout.Y_AXIS));
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.setBorder(new EmptyBorder(0, 0, B_PAD_B, 0));
    }

    @Override
    public void styles() {
        
    }
 
    @Override
    public void polices() {
        
    }

    @Override
    public void definirListeners() {
        //
        b_annuler.addActionListener(new QuiterListener(this, MSG_1, MSG_TITRE));
        b_envoyer.addActionListener(new ReinitialiserMDPListener());
    }

    @Override
    public void initialiserMenuBar(){
        
    }

}
