
package fenetres;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import listeners.ConnecterListener;
import listeners.MPOListener;
import listeners.QuiterListener;
import listeners.RechercheListener;

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
    private final String B_CONNECTER = "Connection";
    private final String B_OUBLIE = "Mot de passe oublié";
    private final String BIBLIOTHEQUE = "Bibliothèque";
    private final String RECHERCHE = "Recherche des livres";
    private final String A_PROPOS = "À propos...";
    private final String QUITER_BIBLIOTHEQUE = "Quiter la bibliothèque";
    private final String AIDE = "Aide";
    
    private final int LARGEUR = 400;
    private final int HAUTEUR = 350;
    private final int BRD_H_B = 40;
    private final int BRD_G_D = 58;
    private final int HAUT_BAS = 60;
    private final int ENTRE_LB = 20;
    
    // Objects
    private JPanel mainPanel, labelPanel, textePanel,
            basPanel, hautPanel, buttonPanel;
    private JLabel l_utilisateur, l_motPasse, l_titre;
    private JTextField t_utilisateur;
    private JPasswordField pf_motPasse;
    private JButton b_connecter, b_mpOublie;
    private JMenuBar menuBar;
    private JMenu m_biblio, m_aide;
    private JMenuItem mi_aPropos, mi_recherche, mi_quiter;
    private JSeparator separator;
    
    public static Identifier courant;
    
    // Constructeur
    public Identifier() {
        initialiserMenuBar();
        initialiserComposants();
        layouts();
        polices();
        styles();
        definirListeners();
        courant = this;
    }
    
    @Override
    public final void initialiserMenuBar(){
        //
        menuBar = new JMenuBar();
        m_biblio = new JMenu(BIBLIOTHEQUE);
        m_aide = new JMenu(AIDE);
        
        mi_recherche = new JMenuItem(RECHERCHE);
        mi_recherche.setAccelerator(
            KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK)); 
        mi_aPropos = new JMenuItem(A_PROPOS);
        mi_quiter = new JMenuItem(QUITER_BIBLIOTHEQUE);
        mi_quiter.setAccelerator(
            KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        
        separator = new JSeparator();
        m_biblio.add(mi_recherche);
        m_biblio.add(separator); m_biblio.add(mi_quiter);
        m_aide.add(mi_aPropos);
        menuBar.add(m_biblio); menuBar.add(m_aide);
    }
    
    @Override
    public final void initialiserComposants() {
        
        //
        setTitle(TITRE);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setJMenuBar(menuBar);
        // 
        l_titre = new JLabel(TITRE_PANE);
        l_motPasse = new JLabel(MOT_DE_PASSE);
        l_utilisateur = new JLabel(UTILISATEUR);
        hautPanel = new JPanel();
        hautPanel.add(l_titre);
        labelPanel = new JPanel();
        labelPanel.add(l_utilisateur); labelPanel.add(l_motPasse);
        
        t_utilisateur = new JTextField();
        pf_motPasse = new JPasswordField();
        textePanel = new JPanel();
        textePanel.add(t_utilisateur); textePanel.add(pf_motPasse);
        
        basPanel = new JPanel();
        basPanel.add(labelPanel); basPanel.add(textePanel);
        
        b_connecter = new JButton(B_CONNECTER);
        b_mpOublie = new JButton(B_OUBLIE);
        buttonPanel = new JPanel();
        buttonPanel.add(b_mpOublie); buttonPanel.add(b_connecter);
        
        mainPanel = new JPanel();
        mainPanel.add(hautPanel); mainPanel.add(basPanel);
        mainPanel.add(buttonPanel);
        
        this.setContentPane(mainPanel);
    }

    @Override
    public final void layouts() {
        //
        setResizable(false);
        setSize(LARGEUR, HAUTEUR);
        setLocationRelativeTo(null); /* Fonctionne après définir la taille */
        //
        l_titre.setAlignmentX(RIGHT_ALIGNMENT);
        l_titre.setBorder(new EmptyBorder(0, 0, HAUT_BAS, 0));
        l_utilisateur.setAlignmentX(RIGHT_ALIGNMENT);
        l_utilisateur.setBorder(new EmptyBorder(0, 0, ENTRE_LB, 0));
        l_motPasse.setAlignmentX(RIGHT_ALIGNMENT);
        //
        basPanel.setLayout(new BoxLayout(basPanel, BoxLayout.X_AXIS));
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
        textePanel.setLayout(new BoxLayout(textePanel, BoxLayout.Y_AXIS));
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.setBorder(new EmptyBorder(HAUT_BAS, 0, 0, 0));
        //
        mainPanel.setBorder(new EmptyBorder(BRD_H_B, BRD_G_D, BRD_H_B, BRD_G_D));
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.PAGE_AXIS));
    }
    
    @Override
    public final void styles() {
    }
    
    @Override
    public final void polices() {
        // Locaux
        Map<TextAttribute, Object> pol_titre = new HashMap<>();
            pol_titre.put(TextAttribute.FAMILY, Font.DIALOG);
            pol_titre.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_SEMIBOLD);
            pol_titre.put(TextAttribute.SIZE, 16);
        l_titre.setFont(Font.getFont(pol_titre));
    }
    
    @Override
    public final void definirListeners(){
        //
        b_connecter.addActionListener(new ConnecterListener());
        b_mpOublie.addActionListener(new MPOListener());
        mi_recherche.addActionListener(new RechercheListener());
        mi_quiter.addActionListener(new QuiterListener(this));
        
    }

    public JTextField getT_utilisateur(){return t_utilisateur;}
    
    public JPasswordField getTextMotDePasse(){return pf_motPasse;}
 
}
