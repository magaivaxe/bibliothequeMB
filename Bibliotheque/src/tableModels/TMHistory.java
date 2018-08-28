
package tableModels;

import framesInterfaces.DataTables;
import java.util.ArrayList;
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
    public void setRows(ArrayList<SearchedHistory> list) {
        
    }

    @Override
    public ArrayList<SearchedHistory> getRow(int[] row) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
