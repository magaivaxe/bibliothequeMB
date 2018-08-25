/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framesListeners;

import frames.NewMotPasse;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author sire_marcos
 */
public class MPOListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        Thread tmp = new Thread(new Runnable() {
            @Override
            public void run() {
                NewMotPasse nmp;
                nmp = new NewMotPasse();
                nmp.setVisible(true);
            }
        });
        tmp.start();
    }
    
}
