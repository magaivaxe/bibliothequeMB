/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framesComponents;

import interfaces.DefineComponents;
import java.awt.ScrollPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import tableModels.TMSearchUser;

/**
 *
 * @author Marcos Gomes
 */
public class LoanPanel extends JPanel implements DefineComponents {
    // Fields
    
    // Objects
    private JCheckBox cb_phone, cb_mail, cb_id;
    private JTextField tf_search,tf_idBook;
    private JLabel l_idBook,l_userPassword;
    private JPasswordField pf_userPassword;
    private JTextArea ta_books;
    private JButton b_search,b_addBook,loanBook;
    private JTable table;
    private TMSearchUser tm_searchUser;
    private ScrollPane scrollPane;
    
    public static LoanPanel courrant;
    
    // Constructor
    public LoanPanel() {
        super();
        initialiserComposants();
        layouts();
        styles();
        polices();
        courrant = this;
    }

    @Override
    public void initialiserComposants() {
        // Locals
        final String CB_PHONE = "Téléphone";
        final String CB_MAIL = "Courriel";
        final String CB_ID = "ID";
        final String L_IDBOOK = "ID livre:";
        final String L_PASSWORD = "Mot de passe d'utilisateur";
        final String B_SEARCH = "Rechercher";
        final String B_ADDBOOKS = "Ajouter livre";
        final String B_LOAN = "Emprunter livres";
        // Components
        //ADD THE COMPOPNENTS HERE
    }

    @Override
    public void layouts() {
        // Locals
        
        // Panel
        setLayout(null);
        // Components
        
    }

    @Override
    public void styles() {
        
    }

    @Override
    public void polices() {
        
    }
    
}
