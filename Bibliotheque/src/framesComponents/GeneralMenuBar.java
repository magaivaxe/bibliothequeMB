/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framesComponents;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import framesInterfaces.DefineComponents;

/**
 *
 * @author sire_marcos
 */
public class GeneralMenuBar extends JMenuBar implements DefineComponents{
    // Fields
    
    // Objects
    private JMenu m_biblio;
    private JMenuItem mi_aPropos,mi_quiter;
    
    public static GeneralMenuBar courant;
    
    // Constructors
    public GeneralMenuBar() {
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
        final String M_BIBLIOTHEQUE = "Bibliothèque";
        final String A_PROPOS = "À propos...";
        final String QUITER = "Quiter";
        // Menu items
        mi_aPropos = new JMenuItem(A_PROPOS);
        mi_quiter = new JMenuItem(QUITER);
        // Menus
        m_biblio = new JMenu(M_BIBLIOTHEQUE);
        m_biblio.add(mi_aPropos); m_biblio.add(new JSeparator());
        m_biblio.add(mi_quiter);
        // Menubar
        add(m_biblio);
    }

    @Override
    public void layouts() {
        // Accelerators
        mi_quiter.setAccelerator(
            KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
    }

    @Override
    public void styles() {
    }

    @Override
    public void polices() {
    }
    
    // Getters
    public JMenuItem getMi_aPropos() {return mi_aPropos;}

    public JMenuItem getMi_quiter() {return mi_quiter;}
}
