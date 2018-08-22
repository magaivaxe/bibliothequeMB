
package framesComponents;

import interfaces.DefineComponents;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import tableModels.TMSearchUser;

/**
 *
 * @author Marcos Gomes
 */
public final class BlockUserPanel extends JPanel implements DefineComponents {
    // Fields
  
    // Objects
    private JCheckBox cb_phone,cb_lastName,cb_id,cb_penaltyPayed,cb_reopen;
    private JButton b_search, b_unblockUser, b_miseJour;
    private JLabel l_unblockBy;
    private JTextField tf_search;
    private JScrollPane scrollPane;
    private JTable table;
    private TMSearchUser tm_searchUser;
        // to hide to employees
        private JButton b_blockUser;

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
        table = new JTable(tm_searchUser);
            scrollPane = new JScrollPane(table);
        // Panel
        add(cb_phone);add(cb_lastName);add(cb_id);add(cb_penaltyPayed);
        add(cb_reopen);add(b_search);add(b_unblockUser);add(b_blockUser);
        add(l_unblockBy);add(tf_search);add(scrollPane);add(b_miseJour);
    }  

    @Override
    public void layouts(){
        // Locals
        final int W_B = 110;
        
        final int Y_LINE1 = ORIGIN;
        final int W_CB_PHONE = 85;
        final int W_CB_LNAME = 55;
        final int W_CB_ID = 45;
        final int W_TF_SEARCH = 300;
        final int X_CB_PHONE = (WL_FRAME - W_CB_PHONE - W_CB_LNAME - W_CB_ID -
            W_TF_SEARCH - W_B - 3*ORIGIN) / 2 - 2*SPACE;
        final int X_CB_LNAME = X_CB_PHONE + W_CB_PHONE + ORIGIN;
        final int X_CB_ID = X_CB_LNAME + W_CB_LNAME +ORIGIN;
        final int X_TF_SEARCH = X_CB_ID + W_CB_ID + ORIGIN;
        final int X_B_SEARCH = X_TF_SEARCH + W_TF_SEARCH + SPACE;
        
        final int Y_LINE2 = Y_LINE1 + H_COMP + LINE;
        
        // Panel
        setLayout(null);
        // Components
        cb_phone.setBounds(X_CB_PHONE, Y_LINE1, W_CB_PHONE, H_COMP);
        cb_lastName.setBounds(X_CB_LNAME, Y_LINE1, W_CB_LNAME, H_COMP);
        cb_id.setBounds(X_CB_ID, Y_LINE1, W_CB_ID, H_COMP);
        tf_search.setBounds(X_TF_SEARCH, Y_LINE1, W_TF_SEARCH, H_COMP);
        b_search.setBounds(X_B_SEARCH, Y_LINE1, W_B, H_COMP);
        // set bounds to all components... :-p
    }

    @Override
    public void styles(){
    }

    @Override
    public void polices(){
    }

    // Add setters and getters
}
