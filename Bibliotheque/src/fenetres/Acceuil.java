/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenetres;

import com.sun.glass.events.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import tables.TMRechercher;

/**
 *
 * @author sire_marcos
 */
public class Acceuil extends JFrame implements InterfaceFenetres{
    // Champs
     
     
    
    // Objects
    private JCheckBox cb_titre, cb_auteur, cb_isbn, cb_sujet;
    private JTextField tf_recherche;
    private JButton b_recherche, b_reserver;
    private JScrollPane scrollPane;
    private JTable jta_recherche;
    private TMRechercher tm_recherche;
    private JPanel recherchePanel,historiquePanel,
            empruntsPanel,livreAjouterPanel,livreMJPanel,livreAMPanel,
            userAjouterPanel,userBloquerPanel;
    private JTabbedPane tp_main,tp_livre,tp_user;
    private JMenuBar menuBar;
    private JMenu m_biblio;
    private JMenuItem mi_aPropos, mi_deconnexion;
    
    public static Acceuil courant;
    
    // Constructeur
    public Acceuil() {
        initialiserMenuBar();
        initialiserComposants();
        layouts();
        styles();
        polices();
        courant = this;
    }
    
    @Override
    public void initialiserMenuBar() {
        // Locals
        final String M_BIBLIOTHEQUE = "Bibliothèque";
        final String MI_A_PROPOS = "À propos...";
        final String MI_DECONNEXION = "Déconnexion";
        // Menus
        m_biblio = new JMenu(M_BIBLIOTHEQUE);
        // Menu items
        mi_aPropos = new JMenuItem(MI_A_PROPOS);
        mi_deconnexion = new JMenuItem(MI_DECONNEXION);
        mi_deconnexion.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        
        m_biblio.add(mi_aPropos); m_biblio.add(new JSeparator());
        m_biblio.add(mi_deconnexion);
        // MenuBar
        menuBar = new JMenuBar();
        menuBar.add(m_biblio);
    }
    
    // Initialise recherche tabbedPane components
    private void initTPRecherche(){
        // Locals
        final String CB_TITRE = "Titre";
        final String CB_AUTEUR = "Auteur";
        final String CB_ISBN = "ISBN";
        final String CB_SUJET = "Sujet";
        final String B_RECHERCHER = "Rechercher";
        final String B_RESERVER = "Réserver livre";
        //
        cb_titre = new JCheckBox(CB_TITRE);
        cb_isbn = new JCheckBox(CB_ISBN);
        cb_auteur = new JCheckBox(CB_AUTEUR);
        cb_sujet = new JCheckBox(CB_SUJET);
        
        tf_recherche = new JTextField();
        b_recherche = new JButton(B_RECHERCHER);
        b_reserver = new JButton(B_RESERVER);
        tm_recherche = new TMRechercher();
        jta_recherche = new JTable(tm_recherche);
        scrollPane = new JScrollPane(jta_recherche);
        
        recherchePanel = new JPanel();
        
        recherchePanel.add(cb_titre);recherchePanel.add(cb_isbn);
        recherchePanel.add(cb_auteur);recherchePanel.add(cb_sujet);
        recherchePanel.add(tf_recherche);recherchePanel.add(b_recherche);
        recherchePanel.add(scrollPane); recherchePanel.add(b_reserver);
    }
    
    @Override
    public void initialiserComposants() {
        // Locals
        final String TITRE = "Acceuil";
        final String TP_RECHERCHE = "Recherche";
        final String TP_HISTORIQUE = "Historique";
        final String TP_LIVRES = "Livres";
        final String TP_AJOUTER = "Ajouter";
        final String TP_LIVRE_MISEJOUR = "Mise à jour";
        final String TP_LIVRE_ARCH_MORT = "Archive Mort";
        final String TP_UTILISATEUR = "Utilisateur";
        final String TP_USER_BLOQUER = "Bloquer/Débloquer";
        final String TP_EMPRUNTS = "Emprunts/Réservations";
        // Frame
        setTitle(TITRE);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setJMenuBar(menuBar);
        // Recherche components
        initTPRecherche();
        // Panels
        historiquePanel = new JPanel();
        empruntsPanel = new JPanel();
        livreAjouterPanel = new JPanel(); livreMJPanel = new JPanel();
        livreAMPanel = new JPanel();
        userAjouterPanel = new JPanel(); userBloquerPanel = new JPanel();
        // TabbedPanes
        tp_livre = new JTabbedPane();
        tp_livre.add(TP_AJOUTER, livreAjouterPanel);
        tp_livre.add(TP_LIVRE_MISEJOUR, livreMJPanel);
        tp_livre.add(TP_LIVRE_ARCH_MORT, livreAMPanel);
        
        tp_user = new JTabbedPane();
        tp_user.add(TP_AJOUTER, userAjouterPanel);
        tp_user.add(TP_USER_BLOQUER, userBloquerPanel);
        
        tp_main = new JTabbedPane();
        tp_main.add(TP_RECHERCHE, recherchePanel);
        tp_main.add(TP_HISTORIQUE, historiquePanel);
        tp_main.add(TP_LIVRES, tp_livre);
        tp_main.add(TP_UTILISATEUR, tp_user);
        tp_main.add(TP_EMPRUNTS, empruntsPanel);
        
        add(tp_main);
    }

    @Override
    public void layouts() {
        // Main bounds
        final int W_FRAME = 1200;
        final int H_FRAME = 800;
        final int Y_ORIGIN = 30; 
        final int SPACE = 5;
        // Recherche bounds
        final int W_CBOX = 100;
        final int H_CBOX = 30;
        final int Y_CBOX = Y_ORIGIN;
        final int X_CBOX_AUTEUR = (W_FRAME - 4*(W_CBOX + SPACE)) / 2;
        final int X_CBOX_TITRE = X_CBOX_AUTEUR + W_CBOX + SPACE;
        final int X_CBOX_ISBN = X_CBOX_TITRE + W_CBOX + SPACE;
        final int X_CBOX_SUJET = X_CBOX_ISBN + W_CBOX + SPACE;

        final int W_B_RECHERCHE = 120;
        final int H_BUTTON = H_CBOX;
        final int H_TF_RECHERCHE = H_CBOX;
        final int W_TF_RECHERCHE = W_FRAME - 2*W_CBOX - W_B_RECHERCHE;
        final int X_TF_RECHERCHE = 
           (W_FRAME - W_TF_RECHERCHE - W_B_RECHERCHE) / 2 - 2*SPACE;
        final int X_B_RECHERCHE = X_TF_RECHERCHE + W_TF_RECHERCHE + SPACE;
        final int Y_TF_RECHERCHE = Y_ORIGIN + H_CBOX;
        final int Y_B_RECHERCHE = Y_TF_RECHERCHE;

        final int W_SCROLLPANE = 
           W_TF_RECHERCHE + W_B_RECHERCHE + X_TF_RECHERCHE;
        final int X_SCROLLPANE = (W_FRAME - W_SCROLLPANE) / 2 - 2*SPACE;
        final int Y_SCROLLPANE = Y_TF_RECHERCHE + H_TF_RECHERCHE + SPACE;
        final int H_SCROLLPANE = H_FRAME - 2*Y_SCROLLPANE - 2*Y_ORIGIN;

        final int W_B_RESERVE = 150;
        final int Y_B_RESERVE = Y_SCROLLPANE + H_SCROLLPANE + 3*SPACE;
        final int X_B_RESERVE = X_SCROLLPANE + W_SCROLLPANE - W_B_RESERVE;
        // Frame layout
        setResizable(false);
        setSize(W_FRAME, H_FRAME);
        setLocationRelativeTo(null);
        // Recherche Pane layout 
        recherchePanel.setLayout(null);
        cb_auteur.setBounds(X_CBOX_AUTEUR, Y_CBOX, W_CBOX, H_CBOX);
        cb_titre.setBounds(X_CBOX_TITRE, Y_CBOX, W_CBOX, H_CBOX);
        cb_isbn.setBounds(X_CBOX_ISBN, Y_CBOX, W_CBOX, H_CBOX);
        cb_sujet.setBounds(X_CBOX_SUJET, Y_CBOX, W_CBOX, H_CBOX);
        tf_recherche.setBounds(
            X_TF_RECHERCHE, Y_TF_RECHERCHE, W_TF_RECHERCHE, H_TF_RECHERCHE);
        b_recherche.setBounds(
            X_B_RECHERCHE, Y_B_RECHERCHE, W_B_RECHERCHE, H_BUTTON);
        scrollPane.setBounds(
            X_SCROLLPANE, Y_SCROLLPANE, W_SCROLLPANE, H_SCROLLPANE);
        b_reserver.setBounds(X_B_RESERVE, Y_B_RESERVE, W_B_RESERVE, H_BUTTON);
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
