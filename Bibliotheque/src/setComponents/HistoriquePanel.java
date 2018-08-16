/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setComponents;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import tableModels.TMHistory;

/**
 *
 * @author sire_marcos
 */
public class HistoriquePanel extends JPanel implements InterfaceComponents{
    // Fields
    
    // Objects
    private JLabel l_startDate, l_finalDate;
    private JDateChooser dc_startDate, dc_finalDate;
    private JCheckBox cb_phone, cb_id;
    private JTextField tf_search;
    private JButton b_search, b_renew;
    private JScrollPane scrollPane;
    private JTable table;
    private TMHistory tm_history;
    
    public static HistoriquePanel courant;
    
    // Constructor
    public HistoriquePanel() {
        initialiserComposants();
        layouts();
        styles();
        polices();
        courant = this;
    }

    @Override
    public void initialiserComposants() {
    }

    @Override
    public void layouts() {
        
    }

    @Override
    public void styles() {
        
    }

    @Override
    public void polices() {
        
    }
    
}
