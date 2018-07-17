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
    private final int LARGEUR = 600;
    private final int HAUTEUR = 500;
    
    // Objets
    private JLabel l_utilisateur, l_motPasse, l_confirmation, l_date;
    private JTextField t_utilisateur, t_date;
    private JPasswordField pf_motPasse,pf_confirmation;
    private JButton b_envoyer, b_annuler;
    private JPanel labelPanel, tfPanel, buttonPanel;
    private Container cont;
    
    public static NewMotPasse courant;
    
    // Constructeur
    public NewMotPasse() {
        initialiser();
        layouts();
        polices();
        definirListeners();
        courant = this;
    }

    @Override
    public void initialiser() {
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
        
        b_annuler = new JButton(B_ANNULER);
        b_envoyer = new JButton(B_ENVOYER);
        buttonPanel = new JPanel();
        buttonPanel.add(b_annuler); buttonPanel.add(b_envoyer);
        
        cont = getContentPane();
        cont.add(labelPanel); cont.add(tfPanel); cont.add(buttonPanel);
    }

    @Override
    public void layouts() {
        //
        setResizable(false);
        setSize(LARGEUR, HAUTEUR);
        setLocationRelativeTo(null);
        //
        
        //
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
        tfPanel.setLayout(new BoxLayout(tfPanel, BoxLayout.Y_AXIS));
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
    }

    @Override
    public void styles() {
        
    }

    @Override
    public void polices() {
        
    }

    @Override
    public void definirListeners() {
        
    }
    
}
