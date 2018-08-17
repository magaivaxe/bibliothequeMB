
package framesComponents;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import tableModels.TMSearchBook;
import interfaces.DefineComponents;

/**
 * @author Marcos Gomes
 */
public final class SearchPanel extends JPanel implements DefineComponents{
    // Fields
    
    // Objects
    private JCheckBox cb_titre, cb_auteur, cb_isbn, cb_sujet;
    private JTextField tf_recherche;
    private JButton b_recherche, b_reserver; 
    private JScrollPane scrollPane;
    private JTable jta_recherche;
    private TMSearchBook tm_recherche;
        // Hide to users
        private JDateChooser dc_start, dc_final;
        private JCheckBox cb_deadArchive;
        private JButton b_update;
    
    public static SearchPanel courant;
    
    // Constructor
    public SearchPanel() {
        super();
        initialiserComposants();
        layouts();
        styles();
        polices();
        courant = this;
    }
    
    @Override
    public void initialiserComposants() {
        // Locals
        final String CB_TITRE = "Titre";
        final String CB_AUTEUR = "Auteur";
        final String CB_ISBN = "ISBN";
        final String CB_SUJET = "Sujet";
        final String B_RECHERCHER = "Rechercher";
        final String B_RESERVER = "Réserver livre";
        final String B_UPDATE = "Mise à jour";
        //
        cb_titre = new JCheckBox(CB_TITRE);
        cb_isbn = new JCheckBox(CB_ISBN);
        cb_auteur = new JCheckBox(CB_AUTEUR);
        cb_sujet = new JCheckBox(CB_SUJET);
        
        tf_recherche = new JTextField();
        b_recherche = new JButton(B_RECHERCHER);
        b_reserver = new JButton(B_RESERVER);
        b_update = new JButton(B_UPDATE);
        tm_recherche = new TMSearchBook();
        jta_recherche = new JTable(tm_recherche);
        scrollPane = new JScrollPane(jta_recherche);
        
        add(cb_titre);add(cb_isbn);add(cb_auteur);add(cb_sujet);
        add(tf_recherche);add(b_recherche);add(scrollPane);add(b_reserver);
        add(b_update);
    }

    @Override
    public void layouts() {
        // Components bounds
        final int W_CBOX = 100;
        final int Y_CBOX = ORIGIN;
        final int X_CBOX_AUTEUR = (WL_FRAME - 4*(W_CBOX + SPACE)) / 2;
        final int X_CBOX_TITRE = X_CBOX_AUTEUR + W_CBOX + SPACE;
        final int X_CBOX_ISBN = X_CBOX_TITRE + W_CBOX + SPACE;
        final int X_CBOX_SUJET = X_CBOX_ISBN + W_CBOX + SPACE;

        final int W_B_RECHERCHE = 120;
        final int W_TF_RECHERCHE = WL_FRAME - 2*W_CBOX - W_B_RECHERCHE;
        final int X_TF_RECHERCHE = 
           (WL_FRAME - W_TF_RECHERCHE - W_B_RECHERCHE) / 2 - 2*SPACE;
        final int X_B_RECHERCHE = X_TF_RECHERCHE + W_TF_RECHERCHE + SPACE;
        final int Y_TF_RECHERCHE = ORIGIN + H_COMP;
        final int Y_B_RECHERCHE = Y_TF_RECHERCHE;

        final int W_SCROLLPANE = 
           W_TF_RECHERCHE + W_B_RECHERCHE + X_TF_RECHERCHE;
        final int X_SCROLLPANE = (WL_FRAME - W_SCROLLPANE) / 2 - 2*SPACE;
        final int Y_SCROLLPANE = Y_TF_RECHERCHE + H_COMP + SPACE;
        final int H_SCROLLPANE = HL_FRAME - 2*Y_SCROLLPANE - 2*ORIGIN;

        final int W_B_RESERVE = 150;
        final int Y_B_RESERVE = Y_SCROLLPANE + H_SCROLLPANE + 3*SPACE;
        final int X_B_RESERVE = X_SCROLLPANE + W_SCROLLPANE - W_B_RESERVE;
        
        final int W_B_UPDATE = W_B_RESERVE;
        final int Y_B_UPDATE = Y_B_RESERVE;
        final int X_B_UPDATE = X_SCROLLPANE;
        // Panel layout
        setLayout(null);
        // Components layout
        cb_auteur.setBounds(X_CBOX_AUTEUR, Y_CBOX, W_CBOX, H_COMP);
        cb_titre.setBounds(X_CBOX_TITRE, Y_CBOX, W_CBOX, H_COMP);
        cb_isbn.setBounds(X_CBOX_ISBN, Y_CBOX, W_CBOX, H_COMP);
        cb_sujet.setBounds(X_CBOX_SUJET, Y_CBOX, W_CBOX, H_COMP);
        tf_recherche.setBounds(
            X_TF_RECHERCHE, Y_TF_RECHERCHE, W_TF_RECHERCHE, H_COMP);
        b_recherche.setBounds(
            X_B_RECHERCHE, Y_B_RECHERCHE, W_B_RECHERCHE, H_COMP);
        scrollPane.setBounds(
            X_SCROLLPANE, Y_SCROLLPANE, W_SCROLLPANE, H_SCROLLPANE);
        b_reserver.setBounds(X_B_RESERVE, Y_B_RESERVE, W_B_RESERVE, H_COMP);
        b_update.setBounds(X_B_UPDATE, Y_B_UPDATE, W_B_UPDATE, H_COMP);
    }

    @Override
    public void styles() {
        
    }

    @Override
    public void polices() {
        
    }

    // Getters

    public JCheckBox getCb_titre() {return cb_titre;}

    public JCheckBox getCb_auteur() {return cb_auteur;}

    public JCheckBox getCb_isbn() {return cb_isbn;}

    public JCheckBox getCb_sujet() {return cb_sujet;}

    public JTextField getTf_recherche() {return tf_recherche;}

    public JButton getB_recherche() {return b_recherche;}

    public JButton getB_reserver() {return b_reserver;}

    public JButton getB_update() {return b_update;}
    
    
}
