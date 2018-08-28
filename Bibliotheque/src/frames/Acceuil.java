
package frames;

import framesComponents.BlockUserPanel;
import framesComponents.BookPanel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import framesListeners.QuiterListener;
import framesComponents.GeneralMenuBar;
import framesComponents.HistoryPanel;
import framesComponents.LoanPanel;
import framesComponents.SearchPanel;
import framesComponents.UserPanel;
import framesInterfaces.DefineActions;
import framesInterfaces.DefineComponents;
import framesListeners.AProposListener;
import framesListeners.RechercheListener;

/**
 * @author Marcos Gomes
 */
public final class Acceuil
        extends JFrame implements DefineActions, DefineComponents {
    // Champs
    String role;
    // Objects
    private JPanel searchPanel, historyPanel,
            loanPanel,bookPanel,
            userPanel,blockUserPanel;
    private JTabbedPane tp_main,tp_user;
    
    public static Acceuil courant;
    
    // Constructeur
    private Acceuil(){}
    
    public Acceuil(String role) {
        this.role = role;
        
        initialiserComposants();
        layouts();
        styles();
        polices();
        definirListeners();
        definirDefaults();
        
        courant = this;
    }
    
    @Override
    public void initialiserComposants() {
        // Locals
        final String TITRE = "Acceuil";
        final String TP_RECHERCHE = "Recherche";
        final String TP_HISTORIQUE = "Historique";
        final String TP_LIVRES = "Ajouter livre";
        final String TP_AJOUTER = "Ajouter";
        final String TP_UTILISATEUR = "Utilisateur";
        final String TP_USER_BLOQUER = "Bloquer/Débloquer";
        final String TP_EMPRUNTS = "Emprunts/Réservations";
        // Frame
        setTitle(TITRE);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setJMenuBar(new GeneralMenuBar());
        // Panels
        searchPanel = new SearchPanel();
        historyPanel = new HistoryPanel();
        loanPanel = new LoanPanel();
        bookPanel = new BookPanel();
        userPanel = new UserPanel();
        blockUserPanel = new BlockUserPanel();
        // TabbedPanes
        tp_user = new JTabbedPane();
        tp_user.add(TP_AJOUTER, userPanel);
        tp_user.add(TP_USER_BLOQUER, blockUserPanel);
        
        tp_main = new JTabbedPane();
        tp_main.add(TP_RECHERCHE, searchPanel);
        tp_main.add(TP_HISTORIQUE, historyPanel);
        tp_main.add(TP_LIVRES, bookPanel);
        tp_main.add(TP_UTILISATEUR, tp_user);
        tp_main.add(TP_EMPRUNTS, loanPanel);
        
        add(tp_main);
    }

    @Override
    public void layouts() {
        // Frame layout
        setResizable(false);
        setSize(WL_FRAME, HL_FRAME);
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
        GeneralMenuBar gmb = GeneralMenuBar.courant;
        // Menubar
        gmb.getMi_quiter().addActionListener(
            new QuiterListener(this, MSG_1, MSG_1_TITRE)); 
        gmb.getMi_aPropos().addActionListener(
            new AProposListener());
        // Search Panel
        SearchPanel.courant.getB_recherche().addActionListener(
            new RechercheListener());
    }

    @Override
    public void definirDefaults() {
        // Locals
        SearchPanel sp = SearchPanel.courant;
        
        sp.getCb_auteur().setEnabled(false);
        sp.getCb_isbn().setEnabled(false);
        sp.getCb_sujet().setEnabled(false);
        sp.getCb_titre().setSelected(true);
        
        // hide components from users
        if (role.equals("role0")) {
            // Search panel
            sp.getL_startDate().setVisible(false);
            sp.getL_finalDate().setVisible(false);
            sp.getSep_vertical().setVisible(false);
            sp.getDc_start().setVisible(false);
            sp.getDc_final().setVisible(false);
            sp.getCb_deadArchive().setVisible(false);
            sp.getB_update().setVisible(false);
            // Others
            tp_main.setEnabledAt(2, false);
            tp_main.setEnabledAt(3, false);
            tp_main.setEnabledAt(4, false);
        }
    }
    
}
