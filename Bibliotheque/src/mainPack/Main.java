/*
 * Tous les doits au groupe Gustavo Pacheco, Marcos Gomes et Mohamed Nidhal
 */
package mainPack;

import dao.UtilisateursDAO;
import javafx.application.Application;
import javafx.stage.Stage;
import tables.Utilisateurs;

/**
 *
 * @author sire_marcos
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        UtilisateursDAO udao = new UtilisateursDAO();
        
        Utilisateurs ut = udao.rechercher("GustavoPach");
        System.out.println(ut.toString());
    }
    
}
