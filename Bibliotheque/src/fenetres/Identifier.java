
package fenetres;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author sire_marcos
 */
public class Identifier extends JFrame implements InterfaceFenetres{
    // Champs
    private final String TITRE = "Bibliothèque Marguerite Bourgeoys - "
            + "Identification";
    private final String TITRE_PANE = "Bibliothèque Marguerite Bourgeoys";
    private final String UTILISATEUR = "Utilisateur";
    private final String MOT_DE_PASSE = "Mot de Passe";
    private final int TX_WITH = 100;
    private final int TX_HEIGHT = 30;
    private final int WIDTH = 600;
    private final int HEIGHT = 400;
    
    private final int BDR = 5;
    
    // Objects
    private MenuBarPrincipal menuBar;
    private JPanel panel, userPanel, motPassePanel;
    private JLabel labelUtilisateur, labelMotdePasse, labelMarguerite;
    private JTextField textUtilisateur;
    private JPasswordField passwordField;
    
    /*
    Objet courant pour être possible d'accéder les objets de la fenêtre 
    pour les listeners
    */
    static Identifier courant;
    // Constructeur

    public Identifier() {
        initialiser();
        definirLayout();
    }
    
    @Override
    public void initialiser() {
        // Préférences
        Identifier.courant = this;
        setTitle(TITRE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Fenêtre
        setResizable(false);
        setBounds(new Rectangle(WIDTH, HEIGHT));
        setLocationRelativeTo(null); /* Fonctionne près définir la taille */
        //
        panel = new JPanel();
        panel.setBorder(new EmptyBorder(BDR, BDR, BDR, BDR));
        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        // Menus
        menuBar = new MenuBarPrincipal();
        this.setJMenuBar(menuBar);
        // Composants
        labelMarguerite = new JLabel(TITRE_PANE);
        labelMotdePasse = new JLabel(MOT_DE_PASSE);
        labelUtilisateur = new JLabel(UTILISATEUR);
        
        textUtilisateur = new JTextField();
        textUtilisateur.setColumns(15);
        textUtilisateur.setToolTipText(UTILISATEUR);
        
        passwordField = new JPasswordField();
        passwordField.setColumns(15);
        //passwordField.setToolTipText(MOT_DE_PASSE);
        
        panel.add(labelMarguerite);
        panel.add(labelUtilisateur);
        panel.add(textUtilisateur);
        panel.add(labelMotdePasse);
        panel.add(passwordField);
        
        this.setContentPane(panel);
    }

    @Override
    public void definirLayout() {
        
        
    }
    
    
}
