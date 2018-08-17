
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
import interfaces.DefineComponents;

/**
 *
 * @author Marcos Gomes
 */
public class HistoryPanel extends JPanel implements DefineComponents{
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
        
        tm_history = new TMHistory();
        table = new JTable(tm_history);
        scrollPane = new JScrollPane(table);
        // Panel
        add(l_startDate);add(l_finalDate);add(dc_startDate);add(dc_finalDate);
        add(cb_phone);add(cb_id);add(tf_search);add(b_search);add(b_renew);
        add(scrollPane);
    }

    @Override
    public void layouts() {
        // Components bounds
        
        // Panel layout
        setLayout(null);
        // Components layout
        
    }

    @Override
    public void styles() {
        
    }

    @Override
    public void polices() {
        
    }
    
}
