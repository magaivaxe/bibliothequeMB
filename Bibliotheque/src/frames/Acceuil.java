
package frames;

import framesComponents.BlockUserPanel;
import framesComponents.BookPanel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import listeners.QuiterListener;
import framesComponents.GeneralMenuBar;
import framesComponents.HistoryPanel;
import framesComponents.LoanPanel;
import framesComponents.SearchPanel;
import framesComponents.UserPanel;
import interfaces.DefineActions;
import interfaces.DefineComponents;
import listeners.RechercheListener;

/**
 * @author Marcos Gomes
 */
public final class Acceuil
        extends JFrame implements DefineActions, DefineComponents {
    // Champs
    
    // Objects
    private JPanel searchPanel, historyPanel,
            loanPanel,bookPanel,
            userPanel,blockUserPanel;
    private JTabbedPane tp_main,tp_user;
    
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
        // Menubar
        GeneralMenuBar.courant.getMi_quiter().addActionListener(
            new QuiterListener(this, MSG_1, MSG_1_TITRE)); 
        // Search Panel
        SearchPanel.courant.getB_recherche().addActionListener(
            new RechercheListener());
    }
    
}
