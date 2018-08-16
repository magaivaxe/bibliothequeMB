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
    private final String TITRE = "Acceuil";
    private final String M_BIBLIOTHEQUE = "Bibliothèque";
    private final String A_PROPOS = "À propos...";
    private final String MI_DECONNEXION = "Déconnexion";
    private final String TP_RECHERCHE = "Recherche";
    private final String TP_HISTORIQUE = "Historique";
    private final String TP_LIVRES = "Livres";
    private final String TP_AJOUTER = "Ajouter";
    private final String TP_LIVRE_MISEJOUR = "Mise à jour";
    private final String TP_LIVRE_ARCH_MORT = "Archive Mort";
    private final String TP_UTILISATEUR = "Utilisateur";
    private final String TP_USER_BLOQUER = "Bloquer/Débloquer";
    private final String TP_EMPRUNTS = "Emprunts/Réservations";
    private final String CB_TITRE = "Titre";
    private final String CB_AUTEUR = "Auteur";
    private final String CB_ISBN = "ISBN";
    private final String CB_SUJET = "Sujet";
    private final String B_RECHERCHER = "Rechercher";
    private final String B_RESERVER = "Réserver livre";
    // Main bounds
    private final int W_FRAME = 1200;
    private final int H_FRAME = 800;
    private final int Y_ORIGIN = 30; 
    private final int SPACE = 5;
    // Recherche bounds
    private final int W_CBOX = 100;
    private final int H_CBOX = 30;
    private final int Y_CBOX = Y_ORIGIN;
    private final int X_CBOX_AUTEUR = (W_FRAME - 4*(W_CBOX + SPACE)) / 2;
    private final int X_CBOX_TITRE = X_CBOX_AUTEUR + W_CBOX + SPACE;
    private final int X_CBOX_ISBN = X_CBOX_TITRE + W_CBOX + SPACE;
    private final int X_CBOX_SUJET = X_CBOX_ISBN + W_CBOX + SPACE;
    
    private final int W_B_RECHERCHE = 120;
    private final int H_BUTTON = H_CBOX;
    private final int H_TF_RECHERCHE = H_CBOX;
    private final int W_TF_RECHERCHE = W_FRAME - 2*W_CBOX - W_B_RECHERCHE;
    private final int X_TF_RECHERCHE = 
        (W_FRAME - W_TF_RECHERCHE - W_B_RECHERCHE) / 2 - 2*SPACE;
    private final int X_B_RECHERCHE = X_TF_RECHERCHE + W_TF_RECHERCHE + SPACE;
    private final int Y_TF_RECHERCHE = Y_ORIGIN + H_CBOX;
    private final int Y_B_RECHERCHE = Y_TF_RECHERCHE;
    
    private final int W_SCROLLPANE = 
        W_TF_RECHERCHE + W_B_RECHERCHE + X_TF_RECHERCHE;
    private final int X_SCROLLPANE = (W_FRAME - W_SCROLLPANE) / 2 - 2*SPACE;
    private final int Y_SCROLLPANE = Y_TF_RECHERCHE + H_TF_RECHERCHE + SPACE;
    private final int H_SCROLLPANE = H_FRAME - 2*Y_SCROLLPANE - 2*Y_ORIGIN;
    
    private final int W_B_RESERVE = 150;
    private final int Y_B_RESERVE = Y_SCROLLPANE + H_SCROLLPANE + 3*SPACE;
    private final int X_B_RESERVE = X_SCROLLPANE + W_SCROLLPANE - W_B_RESERVE;
    
    // Objects
    private JCheckBox cb_titre, cb_auteur, cb_isbn, cb_sujet;
    private JTextField tf_recherche;
    private JButton b_recherche, b_reserver;
    private JScrollPane scrollPane;
    private JTable jta_recherche;
    private TMRechercher tm_recherche;
    private JPanel recherchePanel,historiquePanel,livresPanel,usersPanel,
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
        courant = this;
    }
    
    @Override
    public void initialiserMenuBar() {
        // Menus
        m_biblio = new JMenu(M_BIBLIOTHEQUE);
        // Menu items
        mi_aPropos = new JMenuItem(A_PROPOS);
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
        // Frame
        setTitle(TITRE);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setJMenuBar(menuBar);
        // Recherche components
        initTPRecherche();
        // Panels
        historiquePanel = new JPanel();
        livresPanel = new JPanel(); usersPanel = new JPanel();
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
