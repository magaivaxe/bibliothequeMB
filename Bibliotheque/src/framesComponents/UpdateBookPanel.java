/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framesComponents;

import interfaces.DefineComponents;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Class to change book status from search panel
 * @author Marcos Gomes
 */
public class UpdateBookPanel extends JPanel implements DefineComponents{
    // Fields
    private final String [] statusBook = {
        "Choisir status","Archive mort","Perdu","Renovation"};
    // Objects
    private JTextArea textArea;
    private JComboBox<String> cmb_status;
    private JButton b_cancel, b_saveUpdate;
    
    public static UpdateBookPanel courant;
    
    // Constructor
    public UpdateBookPanel() {
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
        final String B_CANCEL = "Annuler";
        final String B_UPDATE = "Enregistrer status";
    }

    @Override
    public void layouts() {
        // Locals
        
        // Panel
        setLayout(null);
        // Components
        
    }

    @Override
    public void styles() {
        
    }

    @Override
    public void polices() {
        
    }
    
}