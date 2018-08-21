/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framesComponents;

import com.toedter.calendar.JYearChooser;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import interfaces.DefineComponents;
import java.awt.font.TextAttribute;
import java.text.AttributedString;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sire_marcos
 */
public class BookPanel extends JPanel implements DefineComponents{
    // Fields
    private AttributedString er = new AttributedString("er");
    private AttributedString e = new AttributedString("e");
    // Objects
    private JCheckBox cb_regularBook, cb_rareBook;
    private JYearChooser yc_birth, yc_death, yc_year;
    private JLabel l_titre,l_1autorFirstName,l_1authorLastName,l_birth,
        l_death,l_2authorFirstName,l_2authorLastName,l_3authorFirstName,
        l_3authorLastName,l_publisher,l_city,l_pages,l_price,l_isbn,l_cdu,
        l_year,l_edition,l_bookID,l_imageCover;
    private JTextField tf_titre,tf_1autorFirstName,tf_1authorLastName,
        tf_2authorFirstName,tf_2authorLastName,tf_3authorFirstName,
        tf_3authorLastName,tf_publisher,tf_city,tf_pages,tf_price,tf_isbn,
        tf_cdu,tf_edition,tf_bookID,tf_imageCover;
    private JButton b_autoID,b_choiceImage,b_saveBook;
            
    public static BookPanel courant;
            
    // Contructors
    public BookPanel() {
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
        final String CB_REG_BOOK = "Livre régulier";
        final String CB_RARE_BOOK = "Livre rare";
        final String L_TITRE = "Titre:";
        final String L_1AUTHOR2NAME = "Nom 1er auteur:";
        final String L_1AUTHOR1NAME = "Prénom 1er auteur:";
        final String L_2AUTHOR2NAME = "Nom 2e auteur:";
        final String L_2AUTHOR1NAME = "Prénom 2e auteur:";
        final String L_3AUTHOR2NAME = "Nom 3e auteur:";
        final String L_3AUTHOR1NAME = "Prénom 3e auteur:";
        final String L_BIRTH = "Naissance:";
        final String L_DEATH = "Décédé(e):";
        final String L_PUBLISHER = "Maison de publication:";
        final String L_CITY = "Ville:";
        final String L_PAGES = "Pages:";
        final String L_PRICE = "Prix:";
        final String L_ISBN = "ISBN:";
        final String L_CDU = "CDU:";
        final String L_YEAR = "Année:";
        final String L_EDITION = "Édition:";
        final String L_ID = "ID:";
        final String L_IMAGECOVER = "Image couverture";
        final String B_AUTOID = "Auto ID";
        final String B_CHOICEIMG = "Choisir image";
        final String B_SAVEBOOK = "Enregistrer livre";
        // Components
        cb_regularBook = new JCheckBox(CB_REG_BOOK);
        cb_rareBook = new JCheckBox(CB_RARE_BOOK);
        yc_birth = new JYearChooser();yc_death = new JYearChooser();
        yc_year = new JYearChooser();

        l_titre = new JLabel(L_TITRE);
        l_1authorLastName = new JLabel(L_1AUTHOR2NAME);
        l_1autorFirstName = new JLabel(L_1AUTHOR1NAME);
        l_2authorLastName = new JLabel(L_2AUTHOR2NAME);
        l_2authorFirstName = new JLabel(L_2AUTHOR1NAME);
        l_3authorLastName = new JLabel(L_3AUTHOR2NAME);
        l_3authorFirstName = new JLabel(L_3AUTHOR1NAME);
        l_birth = new JLabel(L_BIRTH); l_death = new JLabel(L_DEATH);
        l_publisher = new JLabel(L_PUBLISHER); l_city = new JLabel(L_CITY);
        l_pages = new JLabel(L_PAGES); l_price = new JLabel(L_PRICE);
        l_isbn = new JLabel(L_ISBN); l_cdu = new JLabel(L_CDU);
        l_year = new JLabel(L_YEAR); l_edition = new JLabel(L_EDITION);
        l_bookID = new JLabel(L_ID); l_imageCover = new JLabel(L_IMAGECOVER);
        
        tf_titre = new JTextField();tf_imageCover = new JTextField();
        tf_1authorLastName = new JTextField();tf_city = new JTextField();
        tf_1autorFirstName = new JTextField();tf_price = new JTextField();
        tf_2authorFirstName = new JTextField();tf_cdu = new JTextField();
        tf_2authorLastName = new JTextField();tf_bookID = new JTextField();
        tf_3authorFirstName = new JTextField();tf_edition = new JTextField();
        tf_3authorLastName = new JTextField();tf_isbn = new JTextField();
        tf_publisher = new JTextField();tf_pages = new JTextField();
         
        b_autoID = new JButton(B_AUTOID); b_saveBook = new JButton(B_SAVEBOOK);
        b_choiceImage = new JButton(B_CHOICEIMG);
        // Add to panel
        add(cb_rareBook);add(cb_regularBook);
        add(yc_birth);add(yc_death);add(yc_year);
        
        add(l_1authorLastName);add(l_1autorFirstName);add(l_pages);add(l_city);
        add(l_2authorFirstName);add(l_2authorLastName);add(l_edition);
        add(l_3authorFirstName);add(l_3authorLastName);add(l_publisher);
        add(l_birth);add(l_death);add(l_isbn);add(l_cdu);add(l_year);
        add(l_price);add(l_bookID);add(l_imageCover);add(l_titre);
        
        add(tf_1authorLastName);add(tf_1autorFirstName);add(tf_publisher);
        add(tf_2authorFirstName);add(tf_2authorLastName);add(tf_edition);
        add(tf_3authorFirstName);add(tf_3authorLastName);add(tf_isbn);
        add(tf_titre);add(tf_imageCover);add(tf_city);add(tf_price);
        add(tf_cdu);add(tf_bookID);add(tf_pages);
        
        add(b_autoID);add(b_saveBook);add(b_choiceImage);
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
        // Locals
        Map<TextAttribute, Object> font_super = new HashMap<>();
        font_super.put(TextAttribute.SUPERSCRIPT, TextAttribute.SUPERSCRIPT_SUPER);
        Map<TextAttribute, Object> font_sub = new HashMap<>();
        font_sub.put(TextAttribute.SUPERSCRIPT, TextAttribute.SUPERSCRIPT_SUB);
    }
    
    // Setters and Getters
    public JCheckBox getCb_regularBook() {
        return cb_regularBook;
    }

    public JCheckBox getCb_rareBook() {
        return cb_rareBook;
    }

    public JYearChooser getYc_birth() {
        return yc_birth;
    }

    public JYearChooser getYc_death() {
        return yc_death;
    }

    public JYearChooser getYc_year() {
        return yc_year;
    }

    public JTextField getTf_titre() {
        return tf_titre;
    }

    public JTextField getTf_1autorFirstName() {
        return tf_1autorFirstName;
    }

    public JTextField getTf_1authorLastName() {
        return tf_1authorLastName;
    }

    public JTextField getTf_2authorFirstName() {
        return tf_2authorFirstName;
    }

    public JTextField getTf_2authorLastName() {
        return tf_2authorLastName;
    }

    public JTextField getTf_3authorFirstName() {
        return tf_3authorFirstName;
    }

    public JTextField getTf_3authorLastName() {
        return tf_3authorLastName;
    }

    public JTextField getTf_publisher() {
        return tf_publisher;
    }

    public JTextField getTf_city() {
        return tf_city;
    }

    public JTextField getTf_pages() {
        return tf_pages;
    }

    public JTextField getTf_price() {
        return tf_price;
    }

    public JTextField getTf_isbn() {
        return tf_isbn;
    }

    public JTextField getTf_cdu() {
        return tf_cdu;
    }

    public JTextField getTf_edition() {
        return tf_edition;
    }

    public JTextField getTf_bookID() {
        return tf_bookID;
    }

    public JTextField getTf_imageCover() {
        return tf_imageCover;
    }

    public JButton getB_autoID() {
        return b_autoID;
    }

    public JButton getB_choiceImage() {
        return b_choiceImage;
    }

    public JButton getB_saveBook() {
        return b_saveBook;
    }

    public void setCb_regularBook(JCheckBox cb_regularBook) {
        this.cb_regularBook = cb_regularBook;
    }

    public void setCb_rareBook(JCheckBox cb_rareBook) {
        this.cb_rareBook = cb_rareBook;
    }

    public void setYc_birth(JYearChooser yc_birth) {
        this.yc_birth = yc_birth;
    }

    public void setYc_death(JYearChooser yc_death) {
        this.yc_death = yc_death;
    }

    public void setYc_year(JYearChooser yc_year) {
        this.yc_year = yc_year;
    }

    public void setTf_titre(JTextField tf_titre) {
        this.tf_titre = tf_titre;
    }

    public void setTf_1autorFirstName(JTextField tf_1autorFirstName) {
        this.tf_1autorFirstName = tf_1autorFirstName;
    }

    public void setTf_1authorLastName(JTextField tf_1authorLastName) {
        this.tf_1authorLastName = tf_1authorLastName;
    }

    public void setTf_2authorFirstName(JTextField tf_2authorFirstName) {
        this.tf_2authorFirstName = tf_2authorFirstName;
    }

    public void setTf_2authorLastName(JTextField tf_2authorLastName) {
        this.tf_2authorLastName = tf_2authorLastName;
    }

    public void setTf_3authorFirstName(JTextField tf_3authorFirstName) {
        this.tf_3authorFirstName = tf_3authorFirstName;
    }

    public void setTf_3authorLastName(JTextField tf_3authorLastName) {
        this.tf_3authorLastName = tf_3authorLastName;
    }

    public void setTf_publisher(JTextField tf_publisher) {
        this.tf_publisher = tf_publisher;
    }

    public void setTf_city(JTextField tf_city) {
        this.tf_city = tf_city;
    }

    public void setTf_pages(JTextField tf_pages) {
        this.tf_pages = tf_pages;
    }

    public void setTf_price(JTextField tf_price) {
        this.tf_price = tf_price;
    }

    public void setTf_isbn(JTextField tf_isbn) {
        this.tf_isbn = tf_isbn;
    }

    public void setTf_cdu(JTextField tf_cdu) {
        this.tf_cdu = tf_cdu;
    }

    public void setTf_edition(JTextField tf_edition) {
        this.tf_edition = tf_edition;
    }

    public void setTf_bookID(JTextField tf_bookID) {
        this.tf_bookID = tf_bookID;
    }

    public void setTf_imageCover(JTextField tf_imageCover) {
        this.tf_imageCover = tf_imageCover;
    }
    
    
    
}
