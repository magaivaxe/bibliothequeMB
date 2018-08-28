
package tableModels;

import framesInterfaces.DataTables;
import java.util.ArrayList;
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
    public void setRows(ArrayList<SearchedBook> list){
        // Set rows number before add
        setRowCount(0);
        // Loop to fill table
        for (int i = 0; i < list.size(); i++) {
            Object [] row = new Object[rowLength];
            // Fill row
            row[0] = list.get(i).getCdu();
            row[1] = list.get(i).getAuteur();
            row[2] = list.get(i).getTitre();
            row[3] = list.get(i).getType();
            // Add row
            addRow(row);
        }
    }
    
    @Override
    public ArrayList<SearchedBook> getRow(int [] selectedRows){
        // Locals
        ArrayList<SearchedBook> toReturn = new ArrayList<>();
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

