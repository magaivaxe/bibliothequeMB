
package tableModels;

import interfaces.DataTables;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;
import tableData.SearchedHistory;

/**
 *
 * @author Marcos Gomes
 */
public class TMHistory extends DefaultTableModel
    implements DataTables<SearchedHistory>{
    // Fields
    private final int rowLength;
    
    // Objects
    private final String [] collumnNames = {
        "Type","Date","Description","Status"
    };
    
    // Constructors
    public TMHistory() {
        super();
        this.rowLength = collumnNames.length;
        setColumnCount(rowLength);
        setColumnIdentifiers(collumnNames);
        setRowCount(0);
    }
    
    @Override
    public void setRows(LinkedList<SearchedHistory> list) {
        
    }

    @Override
    public LinkedList<SearchedHistory> getRow(int[] row) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
