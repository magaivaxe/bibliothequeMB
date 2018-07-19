/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenetres;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

/**
 *
 * @author sire_marcos
 */
public class MenuBarPrincipal extends JMenuBar{
    // Objets
    private JMenu bibliotheque;
    private JMenuItem aPropos, sortir;
    private JSeparator separateur;
    // Constructeur
    public MenuBarPrincipal() {
        initialiser();
    }

    public void initialiser() {
        // JMenu et ses JMenuItems
        aPropos = new JMenuItem();
        aPropos.setText("À Propos");
        aPropos.setMnemonic(KeyEvent.VK_P); 
        
        separateur = new JSeparator();
        
        sortir = new JMenuItem();
        sortir.setText("Sortir");
        sortir.setMnemonic(KeyEvent.VK_S);
        sortir.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        
        bibliotheque = new JMenu();
        bibliotheque.setText("Bibliothèque");
        bibliotheque.setMnemonic(KeyEvent.VK_B);
        
        this.add(bibliotheque);
        bibliotheque.add(aPropos);
        bibliotheque.add(separateur);
        bibliotheque.add(sortir);
    }

    public void definirListeners(){
        sortir.addActionListener((e) ->{
            System.out.println("teste");
        });
        aPropos.addActionListener((e) ->{
            
        });
    }
    
}
