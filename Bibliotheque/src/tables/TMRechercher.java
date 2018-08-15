/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;


import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sire_marcos
 */
public class TMRechercher extends DefaultTableModel{
    // Fields
    private String [] collumnNames = {
        "Auteur",
        "Titre",
        "Année",
        "Quantité"
    };
    // Constructor
    public TMRechercher(){
        super();
        setColumnCount(collumnNames.length);
        setColumnIdentifiers(collumnNames);
        setRowCount(0);
    }
    
    public void setRows(){
        
    }
    
    public LinkedList<String> getRow(int [] row){
        LinkedList<String> returner = new LinkedList<>();
        
        
        
        return returner;
    }
}

