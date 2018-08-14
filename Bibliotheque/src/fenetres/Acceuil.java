/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenetres;

import com.sun.glass.events.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;

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
    
    private final int LARGEUR = 1200;
    private final int HAUTEUR = 800;
    private final int TP_M_LARGEUR = 1100;
    private final int TP_M_HAUTEUR = 750;
    private final int TP_M_XY = 30;
    // Objets
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
        //
        m_biblio = new JMenu(M_BIBLIOTHEQUE);
        
        mi_aPropos = new JMenuItem(A_PROPOS);
        mi_deconnexion = new JMenuItem(MI_DECONNEXION);
        mi_deconnexion.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        
        m_biblio.add(mi_aPropos); m_biblio.add(new JSeparator());
        m_biblio.add(mi_deconnexion);
        
        menuBar = new JMenuBar();
        menuBar.add(m_biblio);
    }

    @Override
    public void initialiserComposants() {
        // Frame
        setTitle(TITRE);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setJMenuBar(menuBar);
        // TabbedPane
        recherchePanel = new JPanel(); historiquePanel = new JPanel();
        livresPanel = new JPanel(); usersPanel = new JPanel();
        empruntsPanel = new JPanel();
        livreAjouterPanel = new JPanel(); livreMJPanel = new JPanel();
        livreAMPanel = new JPanel();
        userAjouterPanel = new JPanel(); userBloquerPanel = new JPanel();
        
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
        //
        setResizable(false);
        setSize(LARGEUR, HAUTEUR);
        setLocationRelativeTo(null);
        
    }

    @Override
    public void styles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void polices() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void definirListeners() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
