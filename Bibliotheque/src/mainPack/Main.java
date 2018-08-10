/*
 * Tous les doits au groupe Gustavo Pacheco, Marcos Gomes et Mohamed Nidhal
 */
package mainPack;

import dao.UsersMotDePasseDAO;
import dao.UtilisateursDAO;
import java.util.Scanner;
import javafx.application.Application;
import javafx.stage.Stage;
import tables.UsersMotDePasse;
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
     * La classe pilote pour tester sur la console
     */
    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        System.out.println("Tapez l'identificateur: ");
        String idUtilisateurEntree = scn.nextLine();
        System.out.println("Tapez le mot de passe: ");
        String motDePasseEntree = scn.nextLine();
        
        // PREMIÈRE RECHERCHE TEST
        UtilisateursDAO udao = new UtilisateursDAO();
        Utilisateurs ut = udao.rechercher(idUtilisateurEntree);
        System.out.println(ut.toString());
        
        //LOGIN
        UsersMotDePasseDAO umdpdao = new UsersMotDePasseDAO();
        UsersMotDePasse umdp = new UsersMotDePasse();
        //System.out.println(umdp.toString());
        
        umdpdao.trouverMotDePasse(idUtilisateurEntree);
        umdpdao.comparerMotDePasse(motDePasseEntree);
        
        //RÉINITIALISER MOT DE PASSE
        System.out.println("Tapez la date de naissance: ");
        String dateNeEntree = scn.nextLine();

        System.out.println("Tapez le nouveau mot de passe: ");
        String nouveauMotDePasse = scn.nextLine();    

        String idConfirmee = udao.chercherUtilisateur(idUtilisateurEntree, dateNeEntree);
        umdpdao.changerMotDePasse(idConfirmee, nouveauMotDePasse);
        
        
    }
    
}
