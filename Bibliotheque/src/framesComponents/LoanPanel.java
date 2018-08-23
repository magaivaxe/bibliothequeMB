
package framesComponents;

import interfaces.DefineComponents;
import java.awt.Color;
import java.awt.ScrollPane;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import tableModels.TMSearchUser;

/**
 *
 * @author Marcos Gomes
 */
public class LoanPanel extends JPanel implements DefineComponents {
    // Fields
    
    // Objects
    private JCheckBox cb_phone, cb_mail, cb_id;
    private JTextField tf_identity,tf_idBook;
    private JLabel l_idBook,l_userPassword;
    private JPasswordField pf_userPassword;
    private JTextArea ta_books;
    private JButton b_addBook,b_loanBook, b_reserveBook;
    private JSeparator separator;
    
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
        final String B_ADDBOOKS = "Ajouter livre";
        final String B_LOAN = "Emprunter livres";
        final String B_RESERVE = "Réserver livres";
        // Components
        cb_phone = new JCheckBox(CB_PHONE);
        cb_mail = new JCheckBox(CB_MAIL);
        cb_id = new JCheckBox(CB_ID);
        l_idBook = new JLabel(L_IDBOOK);
        l_userPassword = new JLabel(L_PASSWORD);
        b_addBook = new JButton(B_ADDBOOKS);
        b_loanBook = new JButton(B_LOAN);
        b_reserveBook = new JButton(B_RESERVE);
        
        tf_idBook = new JTextField();
        tf_identity = new JTextField();
        pf_userPassword = new JPasswordField();
        ta_books = new JTextArea(null,0,0);
        separator = new JSeparator();
        // Panel
        add(cb_phone);add(cb_mail);add(cb_id);add(l_idBook);add(l_userPassword);
        add(ta_books);add(tf_idBook);add(tf_identity);add(pf_userPassword);
        add(b_addBook);add(b_loanBook);add(b_reserveBook);add(separator);
    }

    @Override
    public void layouts() {
        // Locals
        // Locals
        final int W_B = 140;
        
        final int Y_LINE1 = ORIGIN;
        final int W_CB_PHONE = 100;
        final int W_CB_MAIL = 85;
        final int W_CB_ID = 25;
        final int W_TF_IDENTITY = 400;
        final int X_CB_PHONE = (WL_FRAME - W_CB_PHONE - W_CB_MAIL - W_CB_ID -
            W_TF_IDENTITY- 3*ORIGIN) / 2 - 2*SPACE;
        final int X_CB_MAIL = X_CB_PHONE + W_CB_PHONE + ORIGIN;
        final int X_CB_ID = X_CB_MAIL + W_CB_MAIL +ORIGIN;
        final int X_TF_IDENTITY = X_CB_ID + W_CB_ID + ORIGIN;
        
        final int Y_LINE2 = Y_LINE1 + H_COMP + ORIGIN;
        final int W_L_IDBOOK = 50;
        final int W_TF_IDBOOK = 150;
        final int X_L_IDBOOK = (WL_FRAME - W_L_IDBOOK - W_TF_IDBOOK - W_B - 
            SPACE - ORIGIN) / 2 - 2*SPACE;
        final int X_TF_IDBOOK = X_L_IDBOOK + W_L_IDBOOK + SPACE;
        final int X_B_ADDBOOK = X_TF_IDBOOK + W_TF_IDBOOK + ORIGIN;
        
        final int Y_LINE3 = Y_LINE2 + H_COMP + LINE;
        final int X_TAREA = X_CB_PHONE;
        final int W_TAREA = W_CB_PHONE + W_CB_MAIL + W_CB_ID + W_TF_IDENTITY +
            3*ORIGIN;
        final int H_TAREA = 6*H_COMP;
        
        final int Y_LINE4 = Y_LINE3 + H_TAREA + ORIGIN;
        final int W_SEP = W_TAREA;
        final int X_SEP = X_TAREA;
        
        final int Y_LINE5 = Y_LINE4 + ORIGIN;
        final int W_L_USERPASS = 165;
        final int X_L_USERPASS = (WL_FRAME - W_L_USERPASS)/2 - 2*SPACE;
        
        final int Y_LINE6 = Y_LINE5 + H_COMP + SPACE;
        
        final int Y_LINE7 = Y_LINE6 + H_COMP + ORIGIN;
        final int X_B_RESERVER = (WL_FRAME - 2*W_B - 2*ORIGIN)/2 - 2*SPACE;
        final int X_B_LOAN = X_B_RESERVER + W_B + 2*ORIGIN;
        
        // Panel
        setLayout(null);
        // Components
        cb_phone.setBounds(X_CB_PHONE, Y_LINE1, W_CB_PHONE, H_COMP);
        cb_mail.setBounds(X_CB_MAIL, Y_LINE1, W_CB_MAIL, H_COMP);
        cb_id.setBounds(X_CB_ID, Y_LINE1, W_CB_MAIL, H_COMP);
        tf_identity.setBounds(X_TF_IDENTITY, Y_LINE1, W_TF_IDENTITY, H_COMP);
        
        l_idBook.setBounds(X_L_IDBOOK, Y_LINE2, W_L_IDBOOK, H_COMP);
        tf_idBook.setBounds(X_TF_IDBOOK, Y_LINE2, W_TF_IDBOOK, H_COMP);
        b_addBook.setBounds(X_B_ADDBOOK, Y_LINE2, W_B, H_COMP);
        
        ta_books.setBounds(X_TAREA, Y_LINE3, W_TAREA, H_TAREA);
        separator.setBounds(X_SEP, Y_LINE4, W_SEP, H_COMP);
        
        l_userPassword.setBounds(X_L_USERPASS, Y_LINE5, W_L_USERPASS, H_COMP);
        pf_userPassword.setBounds(X_L_USERPASS, Y_LINE6, W_L_USERPASS, H_COMP);
        
        b_reserveBook.setBounds(X_B_RESERVER, Y_LINE7, W_B, H_COMP);
        b_loanBook.setBounds(X_B_LOAN, Y_LINE7, W_B, H_COMP);
    }

    @Override
    public void styles() {
        // Text area border
        Border borderTA = BorderFactory.createLineBorder(BORDER_COLOR, 1);
        ta_books.setBorder(borderTA);
    }

    @Override
    public void polices() {
        
    }
    
}
