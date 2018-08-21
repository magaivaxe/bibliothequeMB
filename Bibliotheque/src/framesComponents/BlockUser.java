
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
public final class BlockUser extends JPanel implements DefineComponents {
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

    public static BlockUser courant;

    // Constructor
    public BlockUser(){
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
        final String B_MJOURUSER = "Mise a jour";
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

        // Panel
        setLayout(null);
        // Components

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
