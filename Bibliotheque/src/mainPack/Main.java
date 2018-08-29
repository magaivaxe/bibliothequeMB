
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
        String role = "role2";
        String id = "admin";
        Acceuil acceuil = new Acceuil(role, id);
        acceuil.setVisible(true);
    }
    
}
