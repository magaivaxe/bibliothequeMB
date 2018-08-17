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
    
    // Objects
    private JTextArea textArea;
    private JComboBox<String> cmb_status;
    private JButton b_cancel, b_update;
    
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
        final String [] statusBook = {
            "Choisir status","Archive mort","Perdu","Renovation"
        };
        final String B_CANCEL = "Annuler";
        final String B_UPDATE = "Enregistrer status";
        // Components
        textArea = new JTextArea();
        cmb_status = new JComboBox<>(statusBook);
        b_cancel = new JButton(B_CANCEL);
        b_update = new JButton(B_UPDATE);
        // Panel
        add(textArea);add(cmb_status);add(b_cancel);add(b_update);
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
    
    // Getters
    public JComboBox<String> getCmb_status() {
        return cmb_status;
    }
    
}
