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
import java.awt.Color;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 *
 * @author Marcos Gomes
 */
public class BookPanel extends JPanel implements DefineComponents{
    // Fields
    
    // Objects
    private JCheckBox cb_regularBook, cb_rareBook;
    private JYearChooser yc_birth, yc_death, yc_year;
    private JLabel l_title,l_1autorFirstName,l_1authorLastName,l_birth,
        l_death,l_2authorFirstName,l_2authorLastName,l_3authorFirstName,
        l_3authorLastName,l_publisher,l_city,l_pages,l_price,l_isbn,l_cdu,
        l_year,l_edition,l_bookID,l_imageCover, l_showImage;
    private JTextField tf_title,tf_1autorFirstName,tf_1authorLastName,
        tf_2authorFirstName,tf_2authorLastName,tf_3authorFirstName,
        tf_3authorLastName,tf_publisher,tf_city,tf_pages,tf_price,tf_isbn,
        tf_cdu,tf_edition,tf_bookID,tf_imageCover;
    private JButton b_autoID,b_choiceImage,b_saveBook;
    private JSeparator sep_author,sep_edition, sep_save;
            
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
        final String L_YEAR = "Année publication:";
        final String L_EDITION = "Édition:";
        final String L_ID = "ID:";
        final String L_IMAGECOVER = "Image couverture:";
        final String B_AUTOID = "Auto ID";
        final String B_CHOICEIMG = "Choisir image";
        final String B_SAVEBOOK = "Enregistrer livre";
        // Components
        cb_regularBook = new JCheckBox(CB_REG_BOOK);
        cb_rareBook = new JCheckBox(CB_RARE_BOOK);
        yc_birth = new JYearChooser();yc_death = new JYearChooser();
        yc_year = new JYearChooser();

        l_title = new JLabel(L_TITRE);
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
        l_showImage = new JLabel();
        
        tf_title = new JTextField();tf_imageCover = new JTextField();
        tf_1authorLastName = new JTextField();tf_city = new JTextField();
        tf_1autorFirstName = new JTextField();tf_price = new JTextField();
        tf_2authorFirstName = new JTextField();tf_cdu = new JTextField();
        tf_2authorLastName = new JTextField();tf_bookID = new JTextField();
        tf_3authorFirstName = new JTextField();tf_edition = new JTextField();
        tf_3authorLastName = new JTextField();tf_isbn = new JTextField();
        tf_publisher = new JTextField();tf_pages = new JTextField();
        
        sep_author = new JSeparator(SwingConstants.VERTICAL);
        sep_edition = new JSeparator(SwingConstants.HORIZONTAL);
        sep_save = new JSeparator(SwingConstants.HORIZONTAL);
        b_autoID = new JButton(B_AUTOID); b_saveBook = new JButton(B_SAVEBOOK);
        b_choiceImage = new JButton(B_CHOICEIMG);
        // Add to panel
        add(cb_rareBook);add(cb_regularBook);
        add(yc_birth);add(yc_death);add(yc_year);
        
        add(l_1authorLastName);add(l_1autorFirstName);add(l_pages);add(l_city);
        add(l_2authorFirstName);add(l_2authorLastName);add(l_edition);
        add(l_3authorFirstName);add(l_3authorLastName);add(l_publisher);
        add(l_birth);add(l_death);add(l_isbn);add(l_cdu);add(l_year);
        add(l_price);add(l_bookID);add(l_imageCover);add(l_title);
        add(l_showImage);
        
        add(tf_1authorLastName);add(tf_1autorFirstName);add(tf_publisher);
        add(tf_2authorFirstName);add(tf_2authorLastName);add(tf_edition);
        add(tf_3authorFirstName);add(tf_3authorLastName);add(tf_isbn);
        add(tf_title);add(tf_imageCover);add(tf_city);add(tf_price);
        add(tf_cdu);add(tf_bookID);add(tf_pages);
        add(sep_author);add(sep_edition);add(sep_save);
        
        add(b_autoID);add(b_saveBook);add(b_choiceImage);
    }

    @Override
    public void layouts() {
        // Locals
        final int W_CB = 115;
        final int W_TF_AUTHOR = 300;
        final int W_YC = 60;
        final int W_B = 130;
        
        final int Y_LINE1 = ORIGIN;
        final int X_CB_REGULAR = (WL_FRAME - 2*W_CB - 4*ORIGIN)/2 - 2*SPACE;
        final int X_CB_RARE = X_CB_REGULAR + W_CB + 4*ORIGIN;
        
        final int W_L_TITLE = 40;
        final int X_L_TITLE = ORIGIN + 16*SPACE;
        final int Y_LINE2 = Y_LINE1 + H_COMP + DOUBLE_LINE;
        final int W_TF_TITLE = 680;
        final int X_TF_TITLE = X_L_TITLE + W_L_TITLE + SPACE;
        
        
        final int W_L_LNA1 = 110;
        final int X_L_LNA1 = ORIGIN + 2*SPACE;
        final int Y_LINE3 = Y_LINE2 + H_COMP + LINE;
        final int X_TF_LNA1 = X_L_LNA1 + W_L_LNA1 + SPACE;
        
        final int W_S_AUTHOR = 2*SPACE;
        final int H_S_AUTHOR = 3*(2*H_COMP + LINE) + 2*LINE;
        final int X_S_AUTHOR = X_TF_LNA1 + W_TF_AUTHOR + ORIGIN;
        
        final int W_L_BIRTH = 75;
        final int X_L_BIRTH = X_S_AUTHOR + W_S_AUTHOR + ORIGIN;
        final int Y_LINE3_DEMI = Y_LINE3 + LINE + SPACE;
        final int X_YC_BIRTH = X_L_BIRTH + W_L_BIRTH + SPACE;
        final int W_L_DEATH = 75;
        final int X_L_DEATH = X_YC_BIRTH + W_YC + ORIGIN;
        final int X_YC_DEATH = X_L_DEATH + W_L_DEATH + SPACE;
        
        final int W_L_FNA1 = 120;
        final int X_L_FNA1 = ORIGIN;
        final int Y_LINE4 = Y_LINE3 + H_COMP + LINE;
        final int X_TF_FNA1 = X_L_FNA1 + W_L_FNA1 + SPACE;
        
        final int W_L_LNA2 = 100;
        final int X_L_LNA2 = ORIGIN + 4*SPACE;
        final int Y_LINE5 = Y_LINE4 + H_COMP + LINE;
        final int X_TF_LNA2 = X_L_LNA2 + W_L_LNA2 + SPACE;
        
        final int W_L_ID = 20;
        final int X_L_ID = X_S_AUTHOR + W_S_AUTHOR + ORIGIN;
        final int Y_LINE5_DEMI = Y_LINE5 + LINE + SPACE;
        final int W_TF_ID = 100;
        final int X_TF_ID = X_L_ID + W_L_ID + SPACE;
        final int X_B_ID = X_TF_ID + W_TF_ID + SPACE;
        
        final int W_L_FNA2 = 120;
        final int X_L_FNA2 = ORIGIN;
        final int Y_LINE6 = Y_LINE5 + H_COMP + LINE;
        final int X_TF_FNA2 = X_L_FNA2 + W_L_FNA2 + SPACE;
        
        final int W_L_LNA3 = 100;
        final int X_L_LNA3 = ORIGIN + 4*SPACE;
        final int Y_LINE7 = Y_LINE6 + H_COMP + LINE;
        final int X_TF_LNA3 = X_L_LNA3 + W_L_LNA3 + SPACE;
        
        final int W_L_YEAR_PUB = 125;
        final int X_L_YEAR_PUB = X_S_AUTHOR + W_S_AUTHOR + ORIGIN;
        final int Y_LINE7_DEMI = Y_LINE7 + LINE + SPACE;
        final int X_YC_PUB = X_L_YEAR_PUB + W_L_YEAR_PUB + SPACE;
        final int W_L_PRICE = 35;
        final int X_L_PRICE = X_YC_PUB + W_YC + ORIGIN;
        final int W_TF_PRICE = 50;
        final int X_TF_PRICE = X_L_PRICE + W_L_PRICE + SPACE;
        
        final int W_L_FNA3 = 115;
        final int X_L_FNA3 = ORIGIN + SPACE;
        final int Y_LINE8 = Y_LINE7 + H_COMP + LINE;
        final int X_TF_FNA3 = X_L_FNA3 + W_L_FNA3 + SPACE;
        
        final int W_S_EDITION = WL_FRAME - 4*ORIGIN;
        final int X_S_EDITION = (WL_FRAME - W_S_EDITION)/2 - 2*SPACE;
        final int Y_LINE9 = Y_LINE8 + H_COMP + ORIGIN;
        
        final int W_L_PUB = 150;
        final int Y_LINE10 = Y_LINE9 + H_COMP + LINE;
        final int X_L_PUB = X_S_EDITION + 4*SPACE;
        final int W_TF_PUB = 200;
        final int X_TF_PUB = X_L_PUB + W_L_PUB + SPACE;
        final int W_L_CITY = 35;
        final int X_L_CITY = X_TF_PUB + W_TF_PUB + ORIGIN;
        final int W_TF_CITY = 100;
        final int X_TF_CITY = X_L_CITY + W_L_CITY + SPACE;
        final int W_L_ISBN = 35;
        final int X_L_ISBN = X_TF_CITY + W_TF_CITY + ORIGIN;
        final int W_TF_ISBN = 100;
        final int X_TF_ISBN = X_L_ISBN + W_L_ISBN + SPACE;
        final int W_L_CDU = 35;
        final int X_L_CDU = X_TF_ISBN + W_TF_ISBN + ORIGIN;
        final int W_TF_CDU = 100;
        final int X_TF_CDU = X_L_CDU + W_L_CDU + SPACE;
        final int W_L_PAGES = 40;
        final int X_L_PAGES = X_TF_CDU + W_TF_CDU + ORIGIN;
        final int W_TF_PAGES = 100;
        final int X_TF_PAGES = X_L_PAGES + W_L_PAGES + SPACE;
        
        final int W_L_SHOWIMAGE = 265;
        final int H_L_SHOWIMAGE = H_S_AUTHOR + H_COMP + LINE;
        final int X_L_SHOWIMAGE = X_TF_TITLE + W_TF_TITLE + ORIGIN;
        
        final int W_L_IMAGE = 115;
        final int W_TF_IMAGE = 500;
        final int X_L_IMAGE =
            (WL_FRAME - W_L_IMAGE - W_TF_IMAGE - W_B - 2*SPACE)/2 - 2*SPACE;
        final int Y_LINE11 = Y_LINE10 + H_COMP + ORIGIN;
        final int X_TF_IMAGE = X_L_IMAGE + W_L_IMAGE + SPACE;
        final int X_B_IMAGE = X_TF_IMAGE + W_TF_IMAGE + SPACE;
        
        final int Y_LINE12 = Y_LINE11 + H_COMP + ORIGIN;
        
        final int X_B_SAVE = (WL_FRAME - W_B) / 2 - 2*SPACE;
        final int Y_LINE13 = Y_LINE12 + H_COMP/2 + ORIGIN - 2*SPACE;
        
        // Panel
        setLayout(null);
        // Components
        cb_regularBook.setBounds(X_CB_REGULAR,Y_LINE1,W_CB,H_COMP);
        cb_rareBook.setBounds(X_CB_RARE, Y_LINE1, W_CB, H_COMP);
        
        l_title.setBounds(X_L_TITLE, Y_LINE2, W_L_TITLE, H_COMP);
        tf_title.setBounds(X_TF_TITLE, Y_LINE2, W_TF_TITLE, H_COMP);
        l_showImage.setBounds(
            X_L_SHOWIMAGE, Y_LINE2, W_L_SHOWIMAGE, H_L_SHOWIMAGE);
        
        l_1authorLastName.setBounds(X_L_LNA1, Y_LINE3, W_L_LNA1, H_COMP);
        tf_1authorLastName.setBounds(X_TF_LNA1, Y_LINE3, W_TF_AUTHOR, H_COMP);
        sep_author.setBounds(X_S_AUTHOR, Y_LINE3, W_S_AUTHOR, H_S_AUTHOR);
        l_birth.setBounds(X_L_BIRTH, Y_LINE3_DEMI, W_L_BIRTH, H_COMP);
        yc_birth.setBounds(X_YC_BIRTH, Y_LINE3_DEMI, W_YC, H_COMP);
        l_death.setBounds(X_L_DEATH, Y_LINE3_DEMI, W_L_DEATH, H_COMP);
        yc_death.setBounds(X_YC_DEATH, Y_LINE3_DEMI, W_YC, H_COMP);
        
        l_1autorFirstName.setBounds(X_L_FNA1, Y_LINE4, W_L_FNA1, H_COMP);
        tf_1autorFirstName.setBounds(X_TF_FNA1, Y_LINE4, W_TF_AUTHOR, H_COMP);
        
        l_2authorLastName.setBounds(X_L_LNA2, Y_LINE5, W_L_LNA2, H_COMP);
        tf_2authorLastName.setBounds(X_TF_LNA2, Y_LINE5, W_TF_AUTHOR, H_COMP);
        l_bookID.setBounds(X_L_ID, Y_LINE5_DEMI, W_L_ID, H_COMP);
        tf_bookID.setBounds(X_TF_ID, Y_LINE5_DEMI, W_TF_ID, H_COMP);
        b_autoID.setBounds(X_B_ID, Y_LINE5_DEMI, W_B, H_COMP);
        
        l_2authorFirstName.setBounds(X_L_FNA2, Y_LINE6, W_L_FNA2, H_COMP);
        tf_2authorFirstName.setBounds(X_TF_FNA2, Y_LINE6, W_TF_AUTHOR, H_COMP);
        
        l_3authorLastName.setBounds(X_L_LNA3, Y_LINE7, W_L_LNA3, H_COMP);
        tf_3authorLastName.setBounds(X_TF_LNA3, Y_LINE7, W_TF_AUTHOR, H_COMP);
        
        l_year.setBounds(X_L_YEAR_PUB, Y_LINE7_DEMI, W_L_PUB, H_COMP);
        yc_year.setBounds(X_YC_PUB, Y_LINE7_DEMI, W_YC, H_COMP);
        l_price.setBounds(X_L_PRICE, Y_LINE7_DEMI, W_L_PRICE, H_COMP);
        tf_price.setBounds(X_TF_PRICE, Y_LINE7_DEMI, W_TF_PRICE, H_COMP);
        
        l_3authorFirstName.setBounds(X_L_FNA3, Y_LINE8, W_L_FNA3, H_COMP);
        tf_3authorFirstName.setBounds(X_TF_FNA3, Y_LINE8, W_TF_AUTHOR, H_COMP);
        
        sep_edition.setBounds(X_S_EDITION, Y_LINE9, W_S_EDITION, H_COMP);
        
        l_publisher.setBounds(X_L_PUB, Y_LINE10, W_L_PUB, H_COMP);
        tf_publisher.setBounds(X_TF_PUB, Y_LINE10, W_TF_PUB, H_COMP);
        l_city.setBounds(X_L_CITY, Y_LINE10, W_L_CITY, H_COMP);
        tf_city.setBounds(X_TF_CITY, Y_LINE10, W_TF_CITY, H_COMP);
        l_isbn.setBounds(X_L_ISBN,Y_LINE10,W_L_ISBN,H_COMP);
        tf_isbn.setBounds(X_TF_ISBN, Y_LINE10, W_TF_ISBN, H_COMP);
        l_cdu.setBounds(X_L_CDU, Y_LINE10, W_L_CDU, H_COMP);
        tf_cdu.setBounds(X_TF_CDU, Y_LINE10, W_TF_CDU, H_COMP);
        l_pages.setBounds(X_L_PAGES, Y_LINE10, W_L_PAGES, H_COMP);
        tf_pages.setBounds(X_TF_PAGES, Y_LINE10, W_TF_PAGES, H_COMP);
        
        l_imageCover.setBounds(X_L_IMAGE, Y_LINE11, W_L_IMAGE, H_COMP);
        tf_imageCover.setBounds(X_TF_IMAGE, Y_LINE11, W_TF_IMAGE, H_COMP);
        b_choiceImage.setBounds(X_B_IMAGE, Y_LINE11, W_B, H_COMP);
        
        sep_save.setBounds(X_S_EDITION, Y_LINE12, W_S_EDITION, H_COMP);
        b_saveBook.setBounds(X_B_SAVE, Y_LINE13, W_B, 2*H_COMP);
    }

    @Override
    public void styles() {
        // Border show image
        Border borderImage = BorderFactory.createLineBorder(Color.BLACK, 1);
        l_showImage.setBorder(borderImage);
    }

    @Override
    public void polices() {
        // Locals
        Map<TextAttribute, Object> font_super = new HashMap<>();
        font_super.put(
            TextAttribute.SUPERSCRIPT, TextAttribute.SUPERSCRIPT_SUPER);
        Map<TextAttribute, Object> font_sub = new HashMap<>();
        font_sub.put(TextAttribute.SUPERSCRIPT, TextAttribute.SUPERSCRIPT_SUB);
    }
    
    // Setters and Getters
    public JLabel getL_showImage() {
        return l_showImage;
    }

    public void setL_showImage(JLabel l_showImage) {
        this.l_showImage = l_showImage;
    }
    
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

    public JTextField getTf_title() {
        return tf_title;
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

    public void setTf_title(JTextField tf_title) {
        this.tf_title = tf_title;
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
