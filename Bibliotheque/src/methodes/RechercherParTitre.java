/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methodes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import tables.Livres;

/**
 *
 * @author luizgustavopacheco
 */
public class RechercherParTitre extends ConnectParent {
   
         public Livres rechercherSimple(String titreEntre) {

        try {
            //select livres.titre,livres.cdu,auteurs.p_a_PreNom,auteurs.p_a_Nom,livres.typeLivre 
            //from Livres inner join Livres_Editions on livres.idLivre=Livres_Editions.idLivre 
            //inner join Auteurs on Livres_Editions.idAuteur=Auteurs.idAuteur
            //where livres.titre='Nom du livre';
            
            Statement stmt;
            stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery("select livres.titre,livres.cdu,auteurs.p_a_PreNom,auteurs.p_a_Nom,livres.typeLivre"
                    + " from livres inner join Livres_Editions on livres.idLivre=Livres_Editions.idLivre"
                    + " inner join Auteurs on Livres_Editions.idAuteur=Auteurs.idAuteur"
                    + " where livres.titre="+"'"+titreEntre+"'");
            while (rs.next()) {//cdu, titre, TypeLivres
                String titre = rs.getString("titre");
                String cdu = rs.getString("cdu");
		String p_a_PreNom = rs.getString("p_a_PreNom");
		String p_a_Nom = rs.getString("p_a_Nom");
		String typeLivre = rs.getString("typeLivre");
                
                System.out.println("----------------------------------------------");
		System.out.println("TITRE DU LIVRE   "  + titre);
		System.out.println("CDU LOCALISATION "  + cdu);
		System.out.println("PRÉNOM D'AUTEUR  "  + p_a_PreNom);
		System.out.println("NOM D'AUTEUR     "  + p_a_Nom);
		System.out.println("TYPE DU LIVRE    "  + typeLivre);
		System.out.println("----------------------------------------------");
            }
        } catch (SQLException e) {
            System.err.println("Titre non trouvable");
        }
        return null;
    }
    
}
