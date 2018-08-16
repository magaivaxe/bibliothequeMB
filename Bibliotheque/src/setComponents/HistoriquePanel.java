/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setComponents;

import javax.swing.JPanel;

/**
 *
 * @author sire_marcos
 */
public class HistoriquePanel extends JPanel implements InterfaceComponents{
    // Fields
    
    // Objects
    
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
