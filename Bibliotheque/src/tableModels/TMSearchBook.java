
package tableModels;

import framesInterfaces.DataTables;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;
import tableData.SearchedBook;

/**
 *
 * @author Marcos Gomes
 */
public class TMSearchBook extends DefaultTableModel
    implements DataTables<SearchedBook> {
    // Fields
    private final int rowLength;
    
    // Objects
    private final String [] collumnNames = {"CDU","Auteur","Titre","Type"};
    
    // Constructor
    public TMSearchBook(){
        super();
        rowLength = this.collumnNames.length;
        setColumnCount(rowLength);
        setColumnIdentifiers(collumnNames);
        setRowCount(0);
    }
    
    @Override
    public void setRows(LinkedList<SearchedBook> list){
        // Set rows number before add
        setRowCount(0);
        SearchedBook sb = new SearchedBook();
        Iterator iter = list.iterator();
        // Loop to fill table
        while (iter.hasNext()) {
            // loop locals
            Object [] row = new Object[rowLength];
            sb = (SearchedBook) iter.next();
            // Fill row
            row[0] = sb.getCdu();
            row[1] = sb.getAuteur();
            row[2] = sb.getTitre();
            row[3] = sb.getType();
            // Add row
            addRow(row);
        }
    }
    
    @Override
    public LinkedList<SearchedBook> getRow(int [] selectedRows){
        // Locals
        LinkedList<SearchedBook> toReturn = new LinkedList<>();
        // Nestes loop to get values
        for (int i = 0; i < selectedRows.length; i++) {
            // Loop locals
            SearchedBook sb = new SearchedBook();
            String [] row = new String[rowLength];
            // Loop get values from cells
            for (int j = 0; j < rowLength; j++) {
                row[j] = getValueAt(selectedRows[i], j).toString();
            }
            // Set values to object
            sb.setCdu(row[0]);
            sb.setAuteur(row[1]);
            sb.setTitre(row[2]);
            sb.setType(row[3]);
            // Add to list
            toReturn.add(sb);
        }
        return toReturn;
    }
}

