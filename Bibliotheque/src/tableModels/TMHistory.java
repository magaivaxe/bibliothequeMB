/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableModels;

import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;
import tableData.SearchedHistoty;

/**
 *
 * @author sire_marcos
 */
public class TMHistory extends DefaultTableModel
    implements DataTables<SearchedHistoty>{

    @Override
    public void setRows(LinkedList<SearchedHistoty> list) {
        
    }

    @Override
    public LinkedList<SearchedHistoty> getRow(int[] row) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
