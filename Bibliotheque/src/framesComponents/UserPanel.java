
package framesComponents;

import com.toedter.calendar.JDateChooser;
import interfaces.DefineComponents;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

/**
 *
 * @author Marcos Gomes
 */
public final class UserPanel extends JPanel implements DefineComponents {
    // Fields
  
    // Objects
    private JLabel l_firstName, l_lastName, l_birthdate, l_address,
        l_phone, l_mail, l_id, l_tempPassword;
    private  JDateChooser dc_birthdate;
    private JTextField tf_firstName, tf_lastName, tf_address,
        tf_phone, tf_mail, tf_id, tf_tempPassword;
    private JSeparator separator;
    private JButton b_temPassword, b_saveUser;
        // to hide to users
        private JCheckBox cb_employee;

    public static UserPanel courant;

    // Constructor
    public UserPanel(){
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
        final String CB_EMPLOYEE = "Employé(e):";
        final String L_FNAME = "Nom:";
        final String L_LNAME = "Prénom:";
        final String L_BDATE = "Date naissance:";
        final String L_ADDRESS = "Adresse:";
        final String L_PHONE = "Téléphone:";
        final String L_MAIL = "Courriel:";
        final String L_ID = "ID:";
        final String L_TPASSWORD = "Mot de passe temporaire:";
        final String B_TPASSWORD = "Créer mot de passe";
        final String B_SAVEUSER = "Enregistrer utilisateur";

        // Components
        l_firstName = new JLabel(L_FNAME);
        l_lastName = new JLabel(L_LNAME);
        l_birthdate = new JLabel(L_BDATE);
        l_address = new JLabel(L_ADDRESS);
        l_phone = new JLabel(L_PHONE);
        l_mail = new JLabel(L_MAIL);
        l_id = new JLabel(L_ID);
        l_tempPassword = new JLabel(L_TPASSWORD);

        tf_firstName = new JTextField();
        tf_lastName = new JTextField();
        tf_address = new JTextField();
        tf_phone = new JTextField();
        tf_mail = new JTextField();
        tf_id = new JTextField();
        tf_tempPassword = new JTextField();

        dc_birthdate = new JDateChooser();
        cb_employee = new JCheckBox(CB_EMPLOYEE);
        separator = new JSeparator();
        b_temPassword = new JButton(B_TPASSWORD);
        b_saveUser = new JButton(B_SAVEUSER);

        // Panel
        add(l_firstName);add(l_lastName);add(l_birthdate);
        add(l_address);add(l_phone);add(l_mail);add(l_id);
        add(l_tempPassword); add(dc_birthdate);
        add(tf_firstName);add(tf_lastName);add(tf_address);
        add(tf_phone);add(tf_mail);add(tf_id);add(tf_tempPassword);
        add(cb_employee);add(b_temPassword);
        add(b_saveUser);add(separator);
    }  

    @Override
    public void layouts(){
        // Locals
        final int W_CBOX = 100;
        final int W_TF = 400;
        final int W_BUTTON = 250;

        final int W_L_LNAME = 50;
        final int X_L_LNAME = ORIGIN;
        final int Y_L_LNAME = ORIGIN;
        final int X_TF_LNAME = X_L_LNAME + W_L_LNAME + SPACE;
        final int Y_TF_LNAME = Y_L_LNAME;
        final int X_CBOX_EMPLOYEE = X_TF_LNAME + W_TF + ORIGIN;
        final int Y_CBOX_EMPLOYEE = Y_TF_LNAME;

        final int W_L_FNAME = 80;
        final int X_L_FNAME = ORIGIN;
        final int Y_L_FNAME = Y_L_LNAME + H_COMP + LINE;
        final int X_TF_FNAME = X_L_FNAME + W_L_FNAME + SPACE;
        final int Y_TF_FNAME = Y_L_FNAME;

        final int W_L_BIRTHDATE = 160;
        final int X_L_BIRTHDATE = ORIGIN;
        final int Y_L_BIRTHDATE = Y_L_FNAME + H_COMP + LINE;
        final int W_DC_BIRTHDATE = 100;
        final int X_DC_BIRTHDATE = X_L_BIRTHDATE + W_L_BIRTHDATE + SPACE;
        final int Y_DC_BIRTHDATE = Y_L_BIRTHDATE;

        final int W_L_ADDRESS = 100;
        final int X_L_ADDRESS = ORIGIN;
        final int Y_L_ADDRESS = Y_L_BIRTHDATE + H_COMP + LINE;
        final int X_TF_ADDRESS = X_L_ADDRESS + W_L_ADDRESS + SPACE;
        final int Y_TF_ADDRESS = Y_L_ADDRESS;

        final int W_L_PHONE = 120;
        final int X_L_PHONE = ORIGIN;
        final int Y_L_PHONE = Y_L_ADDRESS + H_COMP + LINE;
        final int X_TF_PHONE = X_L_PHONE + W_L_PHONE + SPACE;
        final int Y_TF_PHONE = Y_L_PHONE;

        final int W_L_MAIL = 100;
        final int X_L_MAIL = ORIGIN;
        final int Y_L_MAIL = Y_L_PHONE + H_COMP + LINE;
        final int X_TF_MAIL = X_L_MAIL + W_L_MAIL + SPACE;
        final int Y_TF_MAIL = Y_L_MAIL;

        final int W_L_ID = 20;
        final int X_L_ID = ORIGIN;
        final int Y_L_ID = Y_L_MAIL + H_COMP + LINE;
        final int X_TF_ID = X_L_ID + W_L_ID + SPACE;
        final int Y_TF_ID = Y_L_ID;

        final int W_SEPARATOR = WL_FRAME - 2*ORIGIN;
        final int X_SEPARATOR = (WL_FRAME - W_SEPARATOR) / 2;
        final int Y_SEPARATOR = Y_L_ID + H_COMP + LINE;

        final int W_L_TPASSWORD = 220;
        final int X_L_TPASSWORD = ORIGIN;
        final int Y_L_TPASSWORD = Y_SEPARATOR + H_COMP + LINE;
        final int X_TF_TPASSWORD = X_L_TPASSWORD + W_L_TPASSWORD + SPACE;
        final int Y_TF_TPASSWORD = Y_L_TPASSWORD;
        final int X_B_TPASSWORD = X_TF_TPASSWORD + W_TF + SPACE;
        final int Y_B_TPASSWORD = Y_L_TPASSWORD;

        final int X_B_SAVE = ORIGIN;
        final int Y_B_SAVE = Y_L_TPASSWORD + H_COMP + LINE;

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
