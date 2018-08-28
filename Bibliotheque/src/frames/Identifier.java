
package frames;


import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import framesListeners.AProposListener;
import framesListeners.ConnecterListener;
import framesListeners.MPOListener;
import framesListeners.QuiterListener;
import framesComponents.GeneralMenuBar;
import framesInterfaces.DefineActions;
import framesInterfaces.DefineComponents;

/**
 *
 * @author Marcos Gomes
 */
public class Identifier
        extends JFrame implements DefineActions, DefineComponents {
    // Fields
    
    // Objects
    private JPanel mainPanel;
    private JLabel l_utilisateur, l_motPasse, l_titre;
    private JTextField tf_utilisateur;
    private JPasswordField pf_motPasse;
    private JButton b_connecter, b_mpOublie;
    private JMenuBar menuBar;
    
    public static Identifier courant;
    
    // Constructeur
    public Identifier() {
        initialiserComposants();
        layouts();
        polices();
        styles();
        definirListeners();
        courant = this;
    }
    
    @Override
    public final void initialiserComposants() {
        // Locals
        final String TITRE = "Identification";
        final String TITRE_PANEL = "Bibliothèque Marguerite Bourgeoys";
        final String L_UTILISATEUR = "Utilisateur:";
        final String L_MDP = "Mot de Passe:";
        final String B_CONNECTER = "Connection";
        final String B_OUBLIE = "Mot de passe oublié";
        // Frame
        setTitle(TITRE);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        menuBar = new GeneralMenuBar();
        setJMenuBar(menuBar);
        // Labels
        l_titre = new JLabel(TITRE_PANEL);
        l_motPasse = new JLabel(L_MDP);
        l_utilisateur = new JLabel(L_UTILISATEUR);
        // Text fields
        tf_utilisateur = new JTextField();
        pf_motPasse = new JPasswordField();
        // Buttons
        b_connecter = new JButton(B_CONNECTER);
        b_mpOublie = new JButton(B_OUBLIE);
        // Panel
        mainPanel = new JPanel();
        mainPanel.add(l_titre);mainPanel.add(l_motPasse);
        mainPanel.add(l_utilisateur);
        mainPanel.add(tf_utilisateur);mainPanel.add(pf_motPasse);
        mainPanel.add(b_connecter);mainPanel.add(b_mpOublie);
        
        add(mainPanel);
    }

    @Override
    public final void layouts() {
        // Components bounds
        final int W_L_TITRE = 280;
        final int X_L_TITRE = (WS_FRAME - W_L_TITRE) / 2;
        final int Y_L_TITRE = ORIGIN;

        final int W_L_USER = 70;
        final int X_L_USER = ORIGIN + 4*SPACE;
        final int Y_L_USER = Y_L_TITRE + H_COMP + ORIGIN;
        final int W_TF_USER = 200;
        final int X_TF_USER = X_L_USER + W_L_USER + SPACE;
        final int Y_TF_USER = Y_L_USER;

        final int W_L_MPASSE = 90;
        final int X_L_MPASSE = ORIGIN;
        final int Y_L_MPASSE = Y_L_USER + H_COMP + 3*SPACE;
        final int W_PF_MPASSE = W_TF_USER;
        final int X_PF_MPASSE = X_L_MPASSE + W_L_MPASSE + SPACE;
        final int Y_PF_MPASSE = Y_L_MPASSE;

        final int W_BUTTON = 160;
        final int X_B_MPO = (WS_FRAME - 2*W_BUTTON - SPACE) / 2;
        final int Y_B_MPO = Y_L_MPASSE + H_COMP + ORIGIN;
        final int X_B_CONEC = X_B_MPO + W_BUTTON + SPACE;
        final int Y_B_CONEC = Y_B_MPO;
        // Frame layout
        setResizable(false);
        setSize(WS_FRAME, HS_FRAME);
        setLocationRelativeTo(null); /* Fonctionne après définir la taille */
        // Panel layout
        mainPanel.setLayout(null);
        // Components layout
        l_titre.setBounds(X_L_TITRE, Y_L_TITRE, W_L_TITRE, H_COMP);
        l_utilisateur.setBounds(X_L_USER, Y_L_USER, W_L_USER, H_COMP);
        l_motPasse.setBounds(X_L_MPASSE, Y_L_MPASSE, W_L_MPASSE, H_COMP);
        tf_utilisateur.setBounds(X_TF_USER, Y_TF_USER, W_TF_USER, H_COMP);
        pf_motPasse.setBounds(X_PF_MPASSE, Y_PF_MPASSE, W_PF_MPASSE, H_COMP);
        b_mpOublie.setBounds(X_B_MPO, Y_B_MPO, W_BUTTON, H_COMP);
        b_connecter.setBounds(X_B_CONEC, Y_B_CONEC, W_BUTTON, H_COMP);
    }
    
    @Override
    public final void styles() {
    }
    
    @Override
    public final void polices() {
        // Locals
        l_titre.setFont(Font.getFont(FONT_TITLE));
    }
    
    @Override
    public final void definirListeners(){
        // Locals 
        final String MSG_1 = "Voulez-vous quiter l'appication?";
        final String MSG_1_TITRE = "Message";
        // Identifier listeners
        b_connecter.addActionListener(new ConnecterListener());
        b_mpOublie.addActionListener(new MPOListener());
        // Menubar listeners
        GeneralMenuBar.courant.getMi_quiter().addActionListener(
                new QuiterListener(this, MSG_1, MSG_1_TITRE));
        GeneralMenuBar.courant.getMi_aPropos().addActionListener(
            new AProposListener());
    }

    public JTextField getTf_utilisateur(){return tf_utilisateur;}
    
    public JPasswordField getTextMotDePasse(){return pf_motPasse;}

    @Override
    public void definirDefaults() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
}
