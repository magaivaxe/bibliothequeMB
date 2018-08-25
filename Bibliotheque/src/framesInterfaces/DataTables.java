/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framesInterfaces;

import java.util.LinkedList;

/**
 *
 * @author sire_marcos
 * @param <T>
 */
public interface DataTables<T> {
    
    public void setRows(LinkedList<T> list);
    
    public LinkedList<T> getRow(int [] row);
}
