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
//==============================================================================
//LOGIN
//PREND L'IDUTILISATEUR ET CHERCHE LE MOT DE PASSE POUR COMPARER
    
     public String trouverMotDePasse(String idUtilisateurEntree) {
        System.out.println("Paramètre de rechercher() "+idUtilisateurEntree);

        try {
            Statement stmt;
            stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery("select * from UsersMotDePasse "
                    + "where idUtilisateur = "+"'"+ idUtilisateurEntree+"'");
            while (rs.next()) {
                System.out.println("Test dans rs.next()!!!!!");
                
		id = rs.getString("idUtilisateur");
		mdpe = rs.getString("mdpEncripte");
            	
                System.out.println("IDENTIFICATEUR ="  + id);
		System.out.println("MOT DE PASSE ="  + mdpe);		
            }
        } catch (SQLException e) {
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
    @Override
    public UsersMotDePasse rechercher() {
        throw new UnsupportedOperationException("Not supported yet.");
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
