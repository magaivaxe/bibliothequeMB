
package mainPack;

import frames.Acceuil;
import frames.Identifier;

/**
 *
 * @author Marcos Gomes
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // App initialisator
//        Identifier identifier = new Identifier();
//        identifier.setVisible(true);
        // Tests
        Log.getInstance().createLogFile("Marcao");
        Log.getInstance().writeLogFile("Je suis cool");
        Log.getInstance().writeLogFile("next");
    }
    
}
