/*
 * Tous les doits au groupe Gustavo Pacheco, Marcos Gomes et Mohamed Nidhal
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import tables.UsersMotDePasse;

/**
 *
 * @author eleves
 */
public class UsersMotDePasseDAO extends DAO<UsersMotDePasse> {

    String id;
    String mdpe;
    UtilisateursDAO u = new UtilisateursDAO();
    String idConfirmee = u.idConfirmee;
    String mdpeChangee;

//==============================================================================
//LOGIN
//PREND L'IDUTILISATEUR ET CHERCHE LE MOT DE PASSE POUR COMPARER
    
     public String trouverMotDePasse(String idUtilisateurEntree) {

        try {
            Statement stmt;
            stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery("select * from UsersMotDePasse "
                    + "where idUtilisateur = "+"'"+ idUtilisateurEntree+"'");
            while (rs.next()) {
		id = rs.getString("idUtilisateur");
		mdpe = rs.getString("mdpEncripte");
                //System.out.println("IDENTIFICATEUR ="  + id);
		//System.out.println("MOT DE PASSE ="  + mdpe);		
            }
        } catch (SQLException e) {
            System.err.println("Identificateur non trouvable");
        }
        return mdpe;
    }
     
     public String comparerMotDePasse(String motDePasseEntree)
     {
            if(motDePasseEntree.compareTo(mdpe)==0)
            {System.out.println("Mot de passe confirmé");} 
             else{ System.out.println("Mot de passe erroné");}
        return null;
     }
//==============================================================================
//RÉINITIALISER MOT DE PASSE
//PREND L'IDUTILISATEUR ET SA DATE DE NAISSANCE POUR CONFIRMER L'IDENTITÉ
//PREND L'IDENTITÉ ET CHANGE LE MOT DE PASSE
     
     public String changerMotDePasse(String idConfirmee, String nouveauMotDePasse)
     {
         System.out.println("Tester "+idConfirmee+" "+nouveauMotDePasse);
 //update UsersMotDePasse set mdpEncripte='123lgp' where idUtilisateur='GustavoPach';
         
         try {
            Statement stmt;
            stmt = connect.createStatement();
            stmt.executeUpdate("update UsersMotDePasse "
                    + "set mdpEncripte="+"'"+ nouveauMotDePasse+"'"
                    + "where idUtilisateur="+"'"+ idConfirmee+"'");
          
		System.out.println("LE NOUVEAU MOT DE PASSE EST "  + nouveauMotDePasse 
                        +" POUR L'UTILISATEUR "+idConfirmee);		
    
        } catch (SQLException e) {
            
        }
        return nouveauMotDePasse;
        }  
  
   

//==============================================================================    
    @Override
    public UsersMotDePasse rechercher() {
            throw new UnsupportedOperationException("Not supported yet.");
//         // locaux
//        UsersMotDePasse aRetouner = new UsersMotDePasse();
//        
//        // Essaye de la requête
//        try {
//
//            ResultSet resultat = this.connect
//                    .createStatement(
//                            ResultSet.TYPE_SCROLL_INSENSITIVE,
//                            ResultSet.CONCUR_UPDATABLE
//                    ).executeQuery(
//                            "select * from UsersMotDePasse"//PROBLÈME: SANS WHERE COMMENT PASSER TOUS LES VALEURS??
//                    );
//            
//            // Attribution à l'objet utilisateur les valeurs de la requête            
//            while(resultat.next()) {
//                aRetouner = new UsersMotDePasse(
//                        resultat.getString("idUtilisateur"),
//                        resultat.getString("mdpEncripte"));
//            }
//        } catch (SQLException e) {
//        }
//        
//        return aRetouner;
    }

    @Override
    public UsersMotDePasse inserer() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public UsersMotDePasse mettreAJour() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
