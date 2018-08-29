
package framesComponents;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import tableModels.TMHistory;
import framesInterfaces.DefineComponents;
import java.awt.Font;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

/**
 *
 * @author Marcos Gomes
 */
public class HistoryPanel extends JPanel implements DefineComponents{
    // Fields
    
    // Objects
    private JLabel l_startDate, l_finalDate;
    private JDateChooser dc_startDate, dc_finalDate;
    private JButton  b_renew, b_change, b_search;
    private JScrollPane scrollPane;
    private JTable ta_history;
    private TMHistory tm_history;
        // Hide to users
        private JCheckBox cb_phone, cb_id;
        private JTextField tf_search;
    
    public static HistoryPanel courant;
    
    // Constructor
    public HistoryPanel() {
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
        final String L_STARTDATE = "Date de début:";
        final String L_FINALDATE = "Date finale:";
        final String CB_PHONE = "Téléphone";
        final String CB_ID = "ID";
        final String B_SEARCH = "Rechercher";
        final String B_RENEW = "Renouveler";
        final String B_CHANGE = "Changer";
        // Components
        l_startDate = new JLabel(L_STARTDATE);
        l_finalDate = new JLabel(L_FINALDATE);
        dc_startDate = new JDateChooser();
        dc_finalDate = new JDateChooser();
        
        cb_phone = new JCheckBox(CB_PHONE);
        cb_id = new JCheckBox(CB_ID);
        tf_search = new JTextField();
        
        b_search = new JButton(B_SEARCH);
        b_renew = new JButton(B_RENEW);
        b_change = new JButton(B_CHANGE);
        
        tm_history = new TMHistory();
        ta_history = new JTable(tm_history);
        scrollPane = new JScrollPane(ta_history);
        // Panel
        add(l_startDate);add(l_finalDate);add(dc_startDate);add(dc_finalDate);
        add(cb_phone);add(cb_id);add(tf_search);add(b_search);add(b_renew);
        add(b_change);add(scrollPane);
    }

    @Override
    public void layouts() {
        // Locals
        final int W_CB_PHONE = 100;
        final int W_CB_ID = 50;
        final int W_TF_SEARCH = 200;
        final int W_DC = 130;
        final int W_L_START = 95;
        final int W_L_FINAL = 75;
        final int W_B = 120;
        final int Y_CB_PHONE = ORIGIN;
        final int X_CB_PHONE = 
            (WL_FRAME - 2*W_DC - W_CB_ID - W_CB_PHONE - W_TF_SEARCH - W_L_START
                - W_L_FINAL - W_B - 7*SPACE - 2*ORIGIN)/2 - 3*SPACE;
        final int X_CB_ID = X_CB_PHONE + W_CB_PHONE + SPACE;
        final int X_TF_SEARCH = X_CB_ID + W_CB_ID + SPACE;
        final int X_L_START = X_TF_SEARCH + W_TF_SEARCH + 2*ORIGIN;
        final int X_DC_START = X_L_START + W_L_START + SPACE;
        final int X_L_FINAL = X_DC_START + W_DC + 2*SPACE;
        final int X_DC_FINAL = X_L_FINAL + W_L_FINAL + SPACE;
        final int X_B_SEARCH = X_DC_FINAL + W_DC + 2*SPACE;
        
        final int W_SPANE = WL_FRAME - 4*ORIGIN;
        final int H_SPANE = HL_FRAME - 8*ORIGIN + 2*SPACE;
        final int X_SPANE = (WL_FRAME - W_SPANE) / 2 - 2*SPACE;
        final int Y_SPANE = Y_CB_PHONE + H_COMP + 4*SPACE;
        
        final int X_B_CHANGE = X_SPANE + W_SPANE - 2*W_B - 3*ORIGIN;
        final int Y_B_CHANGE = Y_SPANE + H_SPANE + 3*SPACE;
        final int X_B_RENEW = X_B_CHANGE + W_B + 3*ORIGIN;
        // Panel layout
        setLayout(null);
        // Components layout
        cb_phone.setBounds(X_CB_PHONE, Y_CB_PHONE, W_CB_PHONE, H_COMP);
        cb_id.setBounds(X_CB_ID, Y_CB_PHONE, W_CB_ID, H_COMP);
        tf_search.setBounds(X_TF_SEARCH, Y_CB_PHONE, W_TF_SEARCH, H_COMP);
        l_startDate.setBounds(X_L_START, Y_CB_PHONE, W_L_START, H_COMP);
        dc_startDate.setBounds(X_DC_START, Y_CB_PHONE, W_DC, H_COMP);
        l_finalDate.setBounds(X_L_FINAL, Y_CB_PHONE, W_L_FINAL, H_COMP);
        dc_finalDate.setBounds(X_DC_FINAL, Y_CB_PHONE, W_DC, H_COMP);
        b_search.setBounds(X_B_SEARCH, Y_CB_PHONE, W_B, H_COMP);
        
        scrollPane.setBounds(X_SPANE, Y_SPANE, W_SPANE, H_SPANE);
        
        b_change.setBounds(X_B_CHANGE, Y_B_CHANGE, W_B, H_COMP);
        b_renew.setBounds(X_B_RENEW, Y_B_CHANGE, W_B, H_COMP);
    }

    @Override
    public void styles() {
        // Locals valiables
        final int W_TM = scrollPane.getWidth();
        final int C = (int) W_TM / 20;
        final int W_TYPE = 2*C;
        final int W_DATE = 2*C;
        final int W_STATUS = 2*C;
        final int W_DESCRIPTION = 14*C;
        // Locals objects
        TableColumn tc_type = ta_history.getColumnModel().getColumn(0);
        TableColumn tc_date = ta_history.getColumnModel().getColumn(1);
        TableColumn tc_description = ta_history.getColumnModel().getColumn(2);
        TableColumn tc_status = ta_history.getColumnModel().getColumn(3);
        // Table
        tc_type.setPreferredWidth(W_TYPE);
        tc_date.setPreferredWidth(W_DATE);
        tc_description.setPreferredWidth(W_DESCRIPTION);
        tc_status.setPreferredWidth(W_STATUS);
    }

    @Override
    public void polices() {
        // Table header
        JTableHeader tableHeader = ta_history.getTableHeader();
        tableHeader.setFont(Font.getFont(FONT_HEADER));
    }
    
    // Getters
    public JDateChooser getDc_startDate() {return dc_startDate;}

    public JDateChooser getDc_finalDate() {return dc_finalDate;}

    public JButton getB_renew() {return b_renew;}

    public JButton getB_change() {return b_change;}

    public TMHistory getTm_history() {return tm_history;}

    public JCheckBox getCb_phone() {return cb_phone;}

    public JCheckBox getCb_id() {return cb_id;}

    public JTextField getTf_search() {return tf_search;}

    public JButton getB_search() {return b_search;}
    
}
