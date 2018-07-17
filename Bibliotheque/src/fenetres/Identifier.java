
package fenetres;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import listeners.BaseListeners;
import listeners.ConnecterListener;

/**
 *
 * @author sire_marcos
 */
public class Identifier extends JFrame implements InterfaceFenetres{
    // Champs
    private final String TITRE = "Identification";
    private final String TITRE_PANE = "Bibliothèque Marguerite Bourgeoys";
    private final String UTILISATEUR = "Utilisateur: ";
    private final String MOT_DE_PASSE = "Mot de Passe: ";
    private final int WITH_MAIN = 400;
    private final int HEIGHT_MAIN = 350;
    private final int BRD_H_B = 40;
    private final int BRD_G_D = 58;
    
    // Objects
    private MenuBarPrincipal menuBar;
    private JPanel mainPanel, labelPanel, textePanel,
            basPanel, hautPanel, buttonPanel;
    private JLabel labelUtilisateur, labelMotdePasse, labelMarguerite;
    private JTextField textUtilisateur;
    private JPasswordField textMotdePasse;
    private JButton buttonConecter, buttonMdPOublie;
    private BaseListeners connecterListener;
    /*
    Objet courant pour être possible d'accéder les objets de la fenêtre 
    pour les listeners
    */
    public static Identifier courant;
    
    // Constructeur
    public Identifier() {
        initialiser();
        definirLayout();
        definirListeners();
        Identifier.courant = this;
    }
    
    @Override
    public void initialiser() {
        // Préférences
        setTitle(TITRE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Fenêtre
        setResizable(false);
        setBounds(new Rectangle(WITH_MAIN, HEIGHT_MAIN));
        setLocationRelativeTo(null); /* Fonctionne près définir la taille */
        // Menus
        menuBar = new MenuBarPrincipal();
        this.setJMenuBar(menuBar);
        // Composants
        hautPanel = new JPanel();
        labelMarguerite = new JLabel(TITRE_PANE);
        hautPanel.add(labelMarguerite);
        
        labelMotdePasse = new JLabel(MOT_DE_PASSE);
        labelUtilisateur = new JLabel(UTILISATEUR);
        
        labelPanel = new JPanel();
        labelPanel.add(labelUtilisateur);
        labelPanel.add(labelMotdePasse);
        
        textePanel = new JPanel();
        textUtilisateur = new JTextField();
        textMotdePasse = new JPasswordField();
        textePanel.add(textUtilisateur);
        textePanel.add(textMotdePasse);
        
        basPanel = new JPanel();
        basPanel.add(labelPanel);
        basPanel.add(textePanel);
        
        buttonConecter = new JButton();
        buttonMdPOublie = new JButton();
        buttonMdPOublie.setText("Mot de passe oublié");
        buttonConecter.setText("Connection");
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(buttonMdPOublie);
        buttonPanel.add(buttonConecter);
        
        mainPanel = new JPanel();
        mainPanel.add(hautPanel);
        mainPanel.add(basPanel);
        mainPanel.add(buttonPanel);
        
        this.setContentPane(mainPanel);
    }

    @Override
    public void definirLayout() {
        //
        labelMarguerite.setAlignmentX(CENTER_ALIGNMENT);
        labelMarguerite.setBorder(new EmptyBorder(0, 0, 40, 0));
        labelUtilisateur.setAlignmentX(RIGHT_ALIGNMENT);
        labelUtilisateur.setBorder(new EmptyBorder(0, 0, 30, 0));
        labelMotdePasse.setAlignmentX(RIGHT_ALIGNMENT);
        //
        basPanel.setLayout(new BoxLayout(basPanel, BoxLayout.X_AXIS));
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
        textePanel.setLayout(new BoxLayout(textePanel, BoxLayout.Y_AXIS));
        //
        buttonPanel.setBorder(new EmptyBorder(40, 0, 0, 0));
        //
        mainPanel.setBorder(new EmptyBorder(BRD_H_B, BRD_G_D, BRD_H_B, BRD_G_D));
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.PAGE_AXIS));
    }

    @Override
    public void definirListeners(){
        connecterListener = new ConnecterListener();
        buttonConecter.addActionListener(connecterListener);
        // Listener local
        buttonMdPOublie.addActionListener((ActionEvent e) -> {
            
        });
    }

    public JTextField getTextUtilisateur(){return textUtilisateur;}
    
    public JPasswordField getTextMotDePasse(){return textMotdePasse;}
    
}
