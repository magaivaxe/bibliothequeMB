
package fenetres;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import listeners.QuiterListener;
import setComponents.GeneralMenuBar;
import setComponents.HistoriquePanel;
import setComponents.RecherchePanel;

/**
 * @author Marcos Gomes
 */
public class Acceuil extends JFrame implements InterfaceFenetres{
    // Champs
    
    // Objects
    private JPanel recherchePanel, historiquePanel,
            empruntsPanel,livreAjouterPanel,livreMJPanel,livreAMPanel,
            userAjouterPanel,userBloquerPanel;
    private JTabbedPane tp_main,tp_livre,tp_user;
    
    public static Acceuil courant;
    
    // Constructeur
    public Acceuil() {
        initialiserComposants();
        layouts();
        styles();
        polices();
        definirListeners();
        courant = this;
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
        setJMenuBar(new GeneralMenuBar());
        // Panels
        recherchePanel = new RecherchePanel();
        historiquePanel = new HistoriquePanel();
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
        // Frame layout
        setResizable(false);
        setSize(W_FRAME, H_FRAME);
        setLocationRelativeTo(null);
        
    }

    @Override
    public void styles() {
        
    }

    @Override
    public void polices() {
        
    }

    @Override
    public void definirListeners() {
        // Locals
        final String MSG_1 = "Voulez-vous quiter l'appication?";
        final String MSG_1_TITRE = "Message";
        // Menubar listeners
        GeneralMenuBar.courant.getMi_quiter().addActionListener(
            new QuiterListener(this, MSG_1, MSG_1_TITRE));
    }
    
}
