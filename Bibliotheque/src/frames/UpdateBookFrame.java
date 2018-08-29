/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import framesComponents.BookPanel;
import framesInterfaces.DefineActions;
import framesInterfaces.DefineComponents;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author sire_marcos
 */
public final class UpdateBookFrame 
        extends JFrame implements DefineActions, DefineComponents {
    // Fields
    
    // Objects
    private JPanel bookPanel;
    
    public static UpdateBookFrame courrant;
    
    // Constructor
    public UpdateBookFrame(){
        initialiserComposants();
        layouts();
        styles();
        polices();
        definirListeners();
        definirDefaults();
        courrant = this;
    }
    
    @Override
    public void initialiserComposants() {
        // Locals
        final String TITRE = "Mise à jour des livres";
        // Frame
        setTitle(TITRE);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        // Panels
        bookPanel = new BookPanel();
        // Frame
        add(bookPanel);
    }

    @Override
    public void layouts() {
        // Frame
        setResizable(false);
        setSize(WL_FRAME, HL_FRAME);
        setLocationRelativeTo(null);
    }

    @Override
    public void styles() {
    }

    @Override
    public void polices() {
    }
    
    @Override
    public void definirListeners() {
        
    }

    @Override
    public void definirDefaults() {
        
    }
}
