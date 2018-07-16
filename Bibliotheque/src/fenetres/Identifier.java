
package fenetres;

import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

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
    private final int X = 100;
    private final int Y = 100;
    private final int WIDTH = 700;
    private final int HEIGHT = 500;
    
    private final int BDR = 5;
    
    // Objects
    private MenuBarPrincipal menuBar;
    private JPanel panel;
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
    }
    
    @Override
    public void initialiser() {
        // Préférences
        Identifier.courant = this;
        setTitle(TITRE);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(new Rectangle(WIDTH, HEIGHT));
        // Fonctionne près définir la taille
        setLocationRelativeTo(null);
        // Menus
        menuBar = new MenuBarPrincipal();
        this.setJMenuBar(menuBar);
        // Composants
        labelMarguerite = new JLabel(TITRE_PANE);
        labelMotdePasse = new JLabel(MOT_DE_PASSE);
        labelUtilisateur = new JLabel(UTILISATEUR);
    }

    @Override
    public void definirLayout() {
        
    }
    
    
}
