/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableModels;

import interfaces.DataTables;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;
import tableData.SearchedUser;

/**
 *
 * @author Marcos
 */
public final class TMSearchUser
    extends DefaultTableModel implements DataTables<SearchedUser> {
    // Fields
    private int rowLength;
    private String [] collumnNames = {"ID", "Utilisateur", "Status"};
    
    // Constructor
    public TMSearchUser() {
        super();
        rowLength = this.collumnNames.length;
        setColumnCount(rowLength);
        setColumnIdentifiers(collumnNames);
        setRowCount(0);
    }
    @Override
    public void setRows(LinkedList<SearchedUser> list) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public LinkedList<SearchedUser> getRow(int[] row) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
