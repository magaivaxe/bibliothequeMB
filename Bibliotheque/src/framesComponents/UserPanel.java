
package framesComponents;

import com.toedter.calendar.JDateChooser;
import framesInterfaces.DefineComponents;
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
        final String L_BDATE = "Date de naissance:";
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
        final int W_CBOX = 110;
        final int W_TF = 400;
        final int W_BUTTON = 180;

        final int W_L_LNAME = 55;
        final int X_L_LNAME = 3*ORIGIN + 13*SPACE;
        final int Y_LINE1 = 3*ORIGIN;
        final int X_TF_LNAME = X_L_LNAME + W_L_LNAME + SPACE;
        final int X_CBOX_EMPLOYEE = X_TF_LNAME + W_TF + ORIGIN;

        final int W_L_FNAME = 35;
        final int X_L_FNAME = 3*ORIGIN + 17*SPACE;
        final int Y_LINE2 = Y_LINE1 + H_COMP + LINE;
        final int X_TF_FNAME = X_L_FNAME + W_L_FNAME + SPACE;

        final int W_L_BIRTHDATE = 120;
        final int X_L_BIRTHDATE = 3*ORIGIN;
        final int Y_LINE3 = Y_LINE2 + H_COMP + LINE;
        final int W_DC_BIRTHDATE = 200;
        final int X_DC_BIRTHDATE = X_L_BIRTHDATE + W_L_BIRTHDATE + SPACE;

        final int W_L_ADDRESS = 55;
        final int X_L_ADDRESS = 3*ORIGIN + 13*SPACE;
        final int Y_LINE4 = Y_LINE3 + H_COMP + LINE;
        final int X_TF_ADDRESS = X_L_ADDRESS + W_L_ADDRESS + SPACE;

        final int W_L_PHONE = 70;
        final int X_L_PHONE = 3*ORIGIN + 10*SPACE;
        final int Y_LINE5 = Y_LINE4 + H_COMP + LINE;
        final int X_TF_PHONE = X_L_PHONE + W_L_PHONE + SPACE;

        final int W_L_MAIL = 55;
        final int X_L_MAIL = 3*ORIGIN + 13*SPACE;
        final int Y_LINE6 = Y_LINE5 + H_COMP + LINE;
        final int X_TF_MAIL = X_L_MAIL + W_L_MAIL + SPACE;

        final int W_L_ID = 20;
        final int X_L_ID = 3*ORIGIN + 20*SPACE;
        final int Y_LINE7 = Y_LINE6 + H_COMP + LINE;
        final int X_TF_ID = X_L_ID + W_L_ID + SPACE;

        final int W_SEPARATOR = WL_FRAME - 6*ORIGIN;
        final int X_SEPARATOR = (WL_FRAME - W_SEPARATOR) / 2 - 4*SPACE;
        final int Y_LINE8 = Y_LINE7 + H_COMP + ORIGIN;

        final int W_L_TPASSWORD = 160;
        final int Y_LINE9 = Y_LINE8 + H_COMP + LINE;
        final int X_L_TPASSWORD = 
            (WL_FRAME - W_L_TPASSWORD - W_BUTTON - W_TF - 2*SPACE)/2 - 2*SPACE;
        final int X_TF_TPASSWORD = X_L_TPASSWORD + W_L_TPASSWORD + SPACE;
        final int X_B_TPASSWORD = X_TF_TPASSWORD + W_TF + SPACE;
        
        final int X_B_SAVE = (WL_FRAME - W_BUTTON)/2 - 2*SPACE;
        final int Y_LINE10 = Y_LINE9 + H_COMP + 2*ORIGIN - 2*SPACE;

        // Panel
        setLayout(null);
        // Components
        l_lastName.setBounds(X_L_LNAME, Y_LINE1, W_L_LNAME, H_COMP);
        tf_lastName.setBounds(X_TF_LNAME, Y_LINE1, W_TF, H_COMP);
        cb_employee.setBounds(X_CBOX_EMPLOYEE, Y_LINE1, W_CBOX, H_COMP);
        
        l_firstName.setBounds(X_L_FNAME, Y_LINE2, W_L_FNAME, H_COMP);
        tf_firstName.setBounds(X_TF_FNAME, Y_LINE2, W_TF, H_COMP);
        
        l_birthdate.setBounds(X_L_BIRTHDATE, Y_LINE3, W_L_BIRTHDATE, H_COMP);
        dc_birthdate.setBounds(X_DC_BIRTHDATE, Y_LINE3, W_DC_BIRTHDATE, H_COMP);
        
        l_address.setBounds(X_L_ADDRESS, Y_LINE4, W_L_ADDRESS, H_COMP);
        tf_address.setBounds(X_TF_ADDRESS, Y_LINE4, W_TF, H_COMP);
        
        l_phone.setBounds(X_L_PHONE, Y_LINE5, W_L_PHONE, H_COMP);
        tf_phone.setBounds(X_TF_PHONE, Y_LINE5, W_TF, H_COMP);
        
        l_mail.setBounds(X_L_MAIL, Y_LINE6, W_TF, H_COMP);
        tf_mail.setBounds(X_TF_MAIL, Y_LINE6, W_TF, H_COMP);
        
        l_id.setBounds(X_L_ID, Y_LINE7, W_TF, H_COMP);
        tf_id.setBounds(X_TF_ID, Y_LINE7, W_TF, H_COMP);
        
        separator.setBounds(X_SEPARATOR, Y_LINE8, W_SEPARATOR, H_COMP);
        
        l_tempPassword.setBounds(X_L_TPASSWORD, Y_LINE9, W_L_TPASSWORD, H_COMP);
        tf_tempPassword.setBounds(X_TF_TPASSWORD, Y_LINE9, W_TF, H_COMP);
        b_temPassword.setBounds(X_B_TPASSWORD, Y_LINE9, W_BUTTON, H_COMP);
        
        b_saveUser.setBounds(X_B_SAVE, Y_LINE10, W_BUTTON, 2*H_COMP);
    }

    @Override
    public void styles(){
    }

    @Override
    public void polices(){
    }
  
    // Add setters and getters
  
}
