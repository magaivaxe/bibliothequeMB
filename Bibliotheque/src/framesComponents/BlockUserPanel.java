
package framesComponents;

import framesInterfaces.DefineComponents;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;
import tableModels.TMSearchUser;

/**
 *
 * @author Marcos Gomes
 */
public final class BlockUserPanel extends JPanel implements DefineComponents {
    // Fields
  
    // Objects
    private JCheckBox cb_phone,cb_lastName,cb_id,cb_penaltyPayed,cb_reopen;
    private JButton b_search, b_unblockUser, b_miseJour,b_blockUser;
    private JLabel l_unblockBy;
    private JTextField tf_search;
    private JScrollPane scrollPane;
    private JTable tm_blockUser;
    private TMSearchUser tm_searchUser;
    private JSeparator separator1, separator2;

    public static BlockUserPanel courant;

    // Constructor
    public BlockUserPanel(){
        super();
        initialiserComposants();
        layouts();
        styles();
        polices();
        courant = this;
    }

    @Override
    public void initialiserComposants(){
        // Locals
        final String CB_PHONE = "Téléphone";
        final String CB_LNAME = "Nom";
        final String CB_ID = "ID";
        final String CB_PEN_PAYED = "Amende payée";
        final String CB_REOPEN = "Réouverture de compte";

        final String B_SEARCH = "Rechercher";
        final String B_UNBLOCKUSER = "Débloquer";
        final String B_BLOCKUSER = "Bloquer";
        final String B_MJOURUSER = "Mise à jour";
        final String L_UNLOCKBY = "Débloquer par:";

        // Components
        cb_phone = new JCheckBox(CB_PHONE);
        cb_lastName = new JCheckBox(CB_LNAME);
        cb_id = new JCheckBox(CB_ID);
        cb_penaltyPayed = new JCheckBox(CB_PEN_PAYED);
        cb_reopen = new JCheckBox(CB_REOPEN);

        b_search = new JButton(B_SEARCH);
        b_unblockUser = new JButton(B_UNBLOCKUSER);
        b_blockUser = new JButton(B_BLOCKUSER);
        b_miseJour = new JButton(B_MJOURUSER);

        l_unblockBy = new JLabel(L_UNLOCKBY);
        tf_search = new JTextField();
        tm_searchUser = new TMSearchUser();
        tm_blockUser = new JTable(tm_searchUser);
        scrollPane = new JScrollPane(tm_blockUser);
        
        separator1 = new JSeparator();
        separator2 = new JSeparator();
        // Panel
        add(cb_phone);add(cb_lastName);add(cb_id);add(cb_penaltyPayed);
        add(cb_reopen);add(b_search);add(b_unblockUser);add(b_blockUser);
        add(l_unblockBy);add(tf_search);add(scrollPane);add(b_miseJour);
        add(separator1);add(separator2);
    }  

    @Override
    public void layouts(){
        // Locals
        final int W_B = 110;
        
        final int Y_LINE1 = ORIGIN;
        final int W_CB_PHONE = 100;
        final int W_CB_LNAME = 65;
        final int W_CB_ID = 50;
        final int W_TF_SEARCH = 400;
        final int X_CB_PHONE = (WL_FRAME - W_CB_PHONE - W_CB_LNAME - W_CB_ID -
            W_TF_SEARCH - W_B - 3*ORIGIN) / 2 - 2*SPACE;
        final int X_CB_LNAME = X_CB_PHONE + W_CB_PHONE + ORIGIN;
        final int X_CB_ID = X_CB_LNAME + W_CB_LNAME +ORIGIN;
        final int X_TF_SEARCH = X_CB_ID + W_CB_ID + ORIGIN;
        final int X_B_SEARCH = X_TF_SEARCH + W_TF_SEARCH + SPACE;
        
        final int Y_LINE2 = Y_LINE1 + H_COMP + LINE;
        final int W_SP = 700;
        final int H_SP = 550;
        final int X_SP = 2*ORIGIN;
        
        final int X_COLUMN = X_SP + W_SP + ORIGIN;
        final int Y_LINE3 = Y_LINE2 + H_SP/4;
        final int W_L_UNBLOCK = 110;
        
        final int Y_LINE4 = Y_LINE3 + H_COMP + LINE;
        final int W_CB_PENALTY = 130;
        final int W_CB_REOPEN = 180;
        final int X_CB_REOPEN = X_COLUMN + W_CB_PENALTY + SPACE;
        
        final int Y_LINE5 = Y_LINE4 + H_COMP + LINE;
        final int X_B_UNBLOCK = X_COLUMN + 
            ((W_CB_PENALTY + W_CB_REOPEN + SPACE) - W_B)/2;
        
        final int Y_LINE6 = Y_LINE5 + H_COMP + LINE;
        final int W_SEP = W_CB_PENALTY + W_CB_REOPEN + SPACE;
        
        final int Y_LINE7 = Y_LINE6 + H_COMP + LINE;
        final int Y_LINE8 = Y_LINE7 + H_COMP + LINE;
        final int Y_LINE9 = Y_LINE8 + H_COMP + LINE;
        // Panel
        setLayout(null);
        // Components
        cb_phone.setBounds(X_CB_PHONE, Y_LINE1, W_CB_PHONE, H_COMP);
        cb_lastName.setBounds(X_CB_LNAME, Y_LINE1, W_CB_LNAME, H_COMP);
        cb_id.setBounds(X_CB_ID, Y_LINE1, W_CB_ID, H_COMP);
        tf_search.setBounds(X_TF_SEARCH, Y_LINE1, W_TF_SEARCH, H_COMP);
        b_search.setBounds(X_B_SEARCH, Y_LINE1, W_B, H_COMP);
        
        scrollPane.setBounds(X_SP, Y_LINE2, W_SP, H_SP);
        
        l_unblockBy.setBounds(X_COLUMN, Y_LINE3, W_L_UNBLOCK, H_COMP);
        cb_penaltyPayed.setBounds(X_COLUMN, Y_LINE4, W_CB_PENALTY, H_COMP);
        cb_reopen.setBounds(X_CB_REOPEN, Y_LINE4, W_CB_REOPEN, H_COMP);
        b_unblockUser.setBounds(X_B_UNBLOCK, Y_LINE5, W_B, H_COMP);
        separator1.setBounds(X_COLUMN, Y_LINE6, W_SEP, H_COMP);
        b_blockUser.setBounds(X_B_UNBLOCK, Y_LINE7 - SPACE, W_B, H_COMP);
        separator2.setBounds(X_COLUMN, Y_LINE8, W_SEP, H_COMP);
        b_miseJour.setBounds(X_B_UNBLOCK, Y_LINE9 - SPACE, W_B, H_COMP);
    }

    @Override
    public void styles(){
    }

    @Override
    public void polices(){
        // Locals
        JTableHeader tableHeader = tm_blockUser.getTableHeader();
        tableHeader.setFont(Font.getFont(FONT_HEADER));
    }

    // Add setters and getters
}
