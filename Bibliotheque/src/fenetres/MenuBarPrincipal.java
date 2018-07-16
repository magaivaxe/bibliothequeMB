/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenetres;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import listeners.BaseListeners;
import listeners.SortirListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import listeners.AProposListener;

/**
 *
 * @author sire_marcos
 */
public class MenuBarPrincipal extends JMenuBar implements InterfaceFenetres{
    // JMenus
    private JMenu bibliotheque;
    // JMenuItems
    private JMenuItem aPropos, sortir;
    // Autres
    private JSeparator separateur;
    // Listeners
    BaseListeners aProposListener, sortirListener;
    // Constructeur
    public MenuBarPrincipal() {
        initialiser();
    }

    @Override
    public void initialiser() {
        // JMenu et ses JMenuItems
        aPropos = new JMenuItem();
        aPropos.setText("À Propos");
        aPropos.setMnemonic(KeyEvent.VK_P); 
        aProposListener = new AProposListener();
        aPropos.addActionListener(aProposListener);
        
        separateur = new JSeparator();
        
        sortir = new JMenuItem();
        sortir.setText("Sortir");
        sortir.setMnemonic(KeyEvent.VK_S);
        sortir.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        sortirListener = new SortirListener();
        sortir.addActionListener(sortirListener);
        
        bibliotheque = new JMenu();
        bibliotheque.setText("Bibliothèque");
        bibliotheque.setMnemonic(KeyEvent.VK_B);
        
        this.add(bibliotheque);
        bibliotheque.add(aPropos);
        bibliotheque.add(separateur);
        bibliotheque.add(sortir);
        
    }

    @Override
    public void definirLayout() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
