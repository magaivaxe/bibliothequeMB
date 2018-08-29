
package framesComponents;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import tableModels.TMSearchBook;
import framesInterfaces.DefineComponents;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

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
    private JTable ta_recherche;
    private TMSearchBook tm_recherche;
        // Hide to users and visible to employee
        private JLabel l_startDate, l_finalDate;
        private JDateChooser dc_start, dc_final;
        private JCheckBox cb_deadArchive;
        private JSeparator sep_vertical;
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
        final String CB_DEADARCHIVE = "Archive mort";
        final String B_RECHERCHER = "Rechercher";
        final String B_RESERVER = "Réserver livre";
        final String B_UPDATE = "Mise à jour";
        final String L_STARTDATE = "Date de début:";
        final String L_FINALDATE = "Date finale:";
        // Components
        cb_titre = new JCheckBox(CB_TITRE);
        cb_isbn = new JCheckBox(CB_ISBN);
        cb_auteur = new JCheckBox(CB_AUTEUR);
        cb_sujet = new JCheckBox(CB_SUJET);
        cb_deadArchive = new JCheckBox(CB_DEADARCHIVE);
        
        sep_vertical = new JSeparator(SwingConstants.VERTICAL);
        tf_recherche = new JTextField();
        dc_start = new JDateChooser();
        dc_final = new JDateChooser();
        l_startDate = new JLabel(L_STARTDATE);
        l_finalDate = new JLabel(L_FINALDATE);
        
        b_recherche = new JButton(B_RECHERCHER);
        b_reserver = new JButton(B_RESERVER);
        b_update = new JButton(B_UPDATE);
        
        tm_recherche = new TMSearchBook();
        ta_recherche = new JTable(tm_recherche);
        scrollPane = new JScrollPane(ta_recherche);
        // Panel
        add(cb_titre);add(cb_isbn);add(cb_auteur);add(cb_sujet);
        add(cb_deadArchive);add(tf_recherche);add(sep_vertical);
        add(dc_final); add(dc_start);add(l_startDate);add(l_finalDate);
        add(scrollPane);add(b_reserver);add(b_recherche);add(b_update);
    }

    @Override
    public void layouts() {
        // Components bounds
        final int W_CB = 93;
        final int Y_CB = ORIGIN;
        final int X_CB_AUTEUR = W_CB - 3*SPACE;
        final int X_CB_TITRE = X_CB_AUTEUR + W_CB + SPACE;
        final int X_CB_ISBN = X_CB_TITRE + W_CB + SPACE;
        final int X_CB_SUJET = X_CB_ISBN + W_CB + SPACE;
        final int W_SEPVERT = 2*SPACE;
        final int H_SEPVERT = H_COMP;
        final int X_SEPVERT = X_CB_SUJET + W_CB + SPACE;
        final int W_CB_DEAD = 120;
        final int X_CB_DEAD = X_SEPVERT + W_SEPVERT + SPACE;
        final int W_L_START = 95;
        final int X_L_START = X_CB_DEAD + W_CB_DEAD + 6*SPACE;
        final int W_DC = 130;
        final int X_DC_START = X_L_START + W_L_START + SPACE;
        final int W_L_FINAL = 75;
        final int X_L_FINAL = X_DC_START + W_DC + 5*SPACE;
        final int X_DC_FINAL = X_L_FINAL + W_L_FINAL + SPACE;

        final int W_B_RECHERCHE = 120;
        final int W_TF_RECHERCHE = WL_FRAME - 2*W_CB - W_B_RECHERCHE;
        final int X_TF_RECHERCHE = 
           (WL_FRAME - W_TF_RECHERCHE - W_B_RECHERCHE) / 2 - 2*SPACE;
        final int X_B_RECHERCHE = X_TF_RECHERCHE + W_TF_RECHERCHE + SPACE;
        final int Y_TF_RECHERCHE = ORIGIN + H_COMP + 2*SPACE;
        final int Y_B_RECHERCHE = Y_TF_RECHERCHE;

        final int W_SCROLLPANE = 
           W_TF_RECHERCHE + W_B_RECHERCHE + X_TF_RECHERCHE;
        final int H_SCROLLPANE = HL_FRAME - 9*ORIGIN;
        final int X_SCROLLPANE = (WL_FRAME - W_SCROLLPANE) / 2 - 2*SPACE;
        final int Y_SCROLLPANE = Y_TF_RECHERCHE + H_COMP + 4*SPACE;
        
        final int W_B_RESERVE = 150;
        final int Y_B_RESERVE = Y_SCROLLPANE + H_SCROLLPANE + 3*SPACE;
        final int X_B_RESERVE = X_SCROLLPANE + W_SCROLLPANE - W_B_RESERVE;
        
        final int W_B_UPDATE = W_B_RESERVE;
        final int Y_B_UPDATE = Y_B_RESERVE;
        final int X_B_UPDATE = X_SCROLLPANE;
        // Panel layout
        setLayout(null);
        // Components layout
        cb_auteur.setBounds(X_CB_AUTEUR, Y_CB, W_CB, H_COMP);
        cb_titre.setBounds(X_CB_TITRE, Y_CB, W_CB, H_COMP);
        cb_isbn.setBounds(X_CB_ISBN, Y_CB, W_CB, H_COMP);
        cb_sujet.setBounds(X_CB_SUJET, Y_CB, W_CB, H_COMP);
        sep_vertical.setBounds(X_SEPVERT, Y_CB, W_SEPVERT, H_SEPVERT);
        cb_deadArchive.setBounds(X_CB_DEAD, Y_CB, W_CB_DEAD, H_COMP);
        l_startDate.setBounds(X_L_START, Y_CB, W_L_START, H_COMP);
        dc_start.setBounds(X_DC_START, Y_CB, W_DC, H_COMP);
        l_finalDate.setBounds(X_L_FINAL, Y_CB, W_L_FINAL, H_COMP);
        dc_final.setBounds(X_DC_FINAL, Y_CB, W_DC, H_COMP);
        
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
        // Locals valiables
        final int W_TM = scrollPane.getWidth();
        final int C = (int) W_TM / 12;
        final int W_CDU = C;
        final int W_TYPE = C;
        final int W_AUTHOR = 4*C;
        final int W_TITLE = 6*C;
        // Locals objects
        TableColumn tc_cdu = ta_recherche.getColumnModel().getColumn(0);
        TableColumn tc_author = ta_recherche.getColumnModel().getColumn(1);
        TableColumn tc_title = ta_recherche.getColumnModel().getColumn(2);
        TableColumn tc_type = ta_recherche.getColumnModel().getColumn(3);
        // Table
        tc_cdu.setPreferredWidth(W_CDU);
        tc_author.setPreferredWidth(W_AUTHOR);
        tc_title.setPreferredWidth(W_TITLE);
        tc_type.setPreferredWidth(W_TYPE);
    }

    @Override
    public void polices() {
        // Table header
        JTableHeader tableHeader = ta_recherche.getTableHeader();
        tableHeader.setFont(Font.getFont(FONT_HEADER));
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

    public TMSearchBook getTm_recherche() {return tm_recherche;}

    public JTable getTa_recherche() {return ta_recherche;}
    
    public JDateChooser getDc_start() {return dc_start;}

    public JDateChooser getDc_final() {return dc_final;}

    public JCheckBox getCb_deadArchive() {return cb_deadArchive;}

    public JLabel getL_startDate() {return l_startDate;}

    public JLabel getL_finalDate() {return l_finalDate;}

    public JSeparator getSep_vertical() {return sep_vertical;}
    
}
