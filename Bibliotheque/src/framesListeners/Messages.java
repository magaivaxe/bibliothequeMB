/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framesListeners;

import javax.swing.JOptionPane;

/**
 *
 * @author sire_marcos
 */
public class Messages {
    // Singleton
    private Messages() {}
    
    public static Messages getInstance() {return MessagesHolder.INSTANCE;}
    
    private static class MessagesHolder {
        private static final Messages INSTANCE = new Messages();
    }
    
    /**
     * Method to show the message dialog
     * @param msg
     * @param title
     * @param type 
     */
    public void showMessages(String msg){
        // Locals
        String title = "Message";
        //
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.OK_OPTION);
    }
    
    public int warningMessages(String msg){
        // Locals
        String title = "Attention!";
        //
        int r = JOptionPane.showConfirmDialog(null, msg, title,
                JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
        return r;
    }
}
