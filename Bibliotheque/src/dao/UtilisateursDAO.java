/*
 * Tous les doits au groupe Gustavo Pacheco, Marcos Gomes et Mohamed Nidhal
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import tables.Utilisateurs;




/**
 *
 * @author eleves
 */
public class UtilisateursDAO extends DAO<Utilisateurs> {
    // Contructeur
    public UtilisateursDAO() {
        super();
    }
    // Méthodes
    public Utilisateurs rechercher(String idUtilisateur) {
        // locaux
        Utilisateurs aRetouner = new Utilisateurs();
        // Essaye de la requête
        try {
            ResultSet resultat = this.connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeQuery(
                            "select * from Utilisateurs"
                                    + "where idUtilisateur = " + idUtilisateur
                    );
            // Attribution à l'objet utilisateur les valeurs de la requête
            if (resultat.first()) {
                aRetouner = new Utilisateurs(
                        resultat.getString("idUtilisateur"),
                        resultat.getString("nom"),
                        resultat.getString("preNom"),
                        resultat.getString("adresse"),
                        resultat.getString("telephone"),
                        resultat.getString("courriel"),
                        resultat.getDate("dateNe"), 
                        resultat.getDate("dateRegistre"),
                        resultat.getString("role"), 
                        resultat.getString("statusUT"));
            }
        } catch (SQLException e) {
        }
        
        return aRetouner;
    }

    @Override
    public Utilisateurs inserer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Utilisateurs mettreAJour() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Utilisateurs rechercher() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    //SET @place = 0;
    //SELECT @place := @place + 1 AS place, pseudo, points FROM joueurs ORDER BY points DESC;
    }

   
    
}
