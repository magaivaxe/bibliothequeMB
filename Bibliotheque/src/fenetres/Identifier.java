
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
import listeners.RechercheAvanceListener;

/**
 *
 * @author sire_marcos
 */
public class Identifier extends JFrame implements InterfaceFenetres{
    // Champs
    private final String TITRE = "Identification";
    private final String TITRE_PANE = "Bibliothèque Marguerite Bourgeoys";
    private final String L_UTILISATEUR = "Utilisateur: ";
    private final String L_MOT_DE_PASSE = "Mot de Passe: ";
    private final String B_CONNECTER = "Connection";
    private final String B_OUBLIE = "Mot de passe oublié";
    private final String M_BIBLIOTHEQUE = "Bibliothèque";
    private final String M_RECHERCHE = "Recherche";
    private final String MI_RECHERCHE_TITRE = "Par titre";
    private final String MI_RECHERCHE_AVANCE = "Avancée";
    private final String A_PROPOS = "À propos...";
    private final String QUITER_BIBLIOTHEQUE = "Quiter la bibliothèque";
    private final String MSG_1 = "Voulez-vous quiter l'appication?";
    private final String MSG_1_TITRE = "Message";
    private final int LARGEUR = 400;
    private final int HAUTEUR = 350;
    private final int BRD_H_B = 40;
    private final int BRD_G_D = 58;
    private final int HAUT_BAS = 50;
    private final int ENTRE_LB = 20;
    
    // Objects
    private JPanel mainPanel, labelPanel, textePanel,
            basPanel, hautPanel, buttonPanel;
    private JLabel l_utilisateur, l_motPasse, l_titre;
    private JTextField tf_utilisateur;
    private JPasswordField pf_motPasse;
    private JButton b_connecter, b_mpOublie;
    private JMenuBar menuBar;
    private JMenu m_biblio, m_recherche;
    private JMenuItem mi_aPropos,mi_quiter, mi_parTitre, mi_avancee;
    
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
        m_biblio = new JMenu(M_BIBLIOTHEQUE);
        m_recherche = new JMenu(M_RECHERCHE);
        
        mi_parTitre = new JMenuItem(MI_RECHERCHE_TITRE);
        mi_parTitre.setAccelerator(
            KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        mi_avancee = new JMenuItem(MI_RECHERCHE_AVANCE);
        mi_avancee.setAccelerator(
            KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        
        mi_aPropos = new JMenuItem(A_PROPOS);
        mi_quiter = new JMenuItem(QUITER_BIBLIOTHEQUE);
        mi_quiter.setAccelerator(
            KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        
        m_recherche.add(mi_parTitre); m_recherche.add(new JSeparator());
        m_recherche.add(mi_avancee);
        m_biblio.add(mi_aPropos); m_biblio.add(new JSeparator());
        m_biblio.add(mi_quiter);
        
        menuBar = new JMenuBar();
        menuBar.add(m_biblio); menuBar.add(m_recherche);
    }
    
    @Override
    public final void initialiserComposants() {
        // Frame
        setTitle(TITRE);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setJMenuBar(menuBar);
        // 
        l_titre = new JLabel(TITRE_PANE);
        l_motPasse = new JLabel(L_MOT_DE_PASSE);
        l_utilisateur = new JLabel(L_UTILISATEUR);
        hautPanel = new JPanel();
        hautPanel.add(l_titre);
        labelPanel = new JPanel();
        labelPanel.add(l_utilisateur); labelPanel.add(l_motPasse);
        
        tf_utilisateur = new JTextField();
        pf_motPasse = new JPasswordField();
        textePanel = new JPanel();
        textePanel.add(tf_utilisateur); textePanel.add(pf_motPasse);
        
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
        l_utilisateur.setAlignmentX(RIGHT_ALIGNMENT);
        l_motPasse.setAlignmentX(RIGHT_ALIGNMENT);
        //
        basPanel.setLayout(new BoxLayout(basPanel, BoxLayout.X_AXIS));
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
        textePanel.setLayout(new BoxLayout(textePanel, BoxLayout.Y_AXIS));
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.PAGE_AXIS));
        
        buttonPanel.setBorder(new EmptyBorder(HAUT_BAS, 0, 0, 0));
        l_utilisateur.setBorder(new EmptyBorder(0, 0, ENTRE_LB, 0));
        l_titre.setBorder(new EmptyBorder(0, 0, HAUT_BAS, 0));
        mainPanel.setBorder(
            new EmptyBorder(BRD_H_B, BRD_G_D, BRD_H_B, BRD_G_D));
    }
    
    @Override
    public final void styles() {
    }
    
    @Override
    public final void polices() {
        // Locaux
        Map<TextAttribute, Object> pol_titre = new HashMap<>();
            pol_titre.put(TextAttribute.FAMILY, Font.DIALOG);
            pol_titre.put(
                TextAttribute.WEIGHT, TextAttribute.WEIGHT_SEMIBOLD);
            pol_titre.put(TextAttribute.SIZE, 16);
        l_titre.setFont(Font.getFont(pol_titre));
    }
    
    @Override
    public final void definirListeners(){
        //
        b_connecter.addActionListener(new ConnecterListener());
        b_mpOublie.addActionListener(new MPOListener());
        mi_parTitre.addActionListener(new RechercheAvanceListener());
        mi_quiter.addActionListener(
                new QuiterListener(this, MSG_1, MSG_1_TITRE));
    }

    public JTextField getTf_utilisateur(){return tf_utilisateur;}
    
    public JPasswordField getTextMotDePasse(){return pf_motPasse;}

 
}
