/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methodes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author luizgustavopacheco
 */

public class Historique extends ConnectParent {

         public void chercherHistoriqueAndroid(String idUtilisateurEntree) throws SQLException {
             	Statement stmt;
		stmt = connect.createStatement();
				
		ResultSet rs = stmt.executeQuery("(select Emprunts.idEmprunt as Type,Emprunts.dateEmp as Date,Livres.titre as Description"
                    + " from Emprunts inner join Livres on Emprunts.idLivre=Livres.idLivre where idUtilisateur ="+"'"+idUtilisateurEntree+"'"
                    + "order by Emprunts.dateEmp desc limit 3)"        
                    + " union all (select Reservations.idReservation,Reservations.datePrevue,Livres.titre "
                    + "from Reservations inner join Livres on Reservations.idLivre=Livres.idLivre where idUtilisateur ="+"'"+idUtilisateurEntree+"'"
                    + "order by Reservations.datePrevue desc limit 3)"        
                    + " union all (select RendezVous.idRendezVous,RendezVous.datePrevue,Livres.titre "
                    + "from RendezVous inner join Livres on RendezVous.idLivre=Livres.idLivre where idUtilisateur ="+"'"+idUtilisateurEntree+"'"
                    + "order by RendezVous.datePrevue desc limit 3) limit 9");
          

            
                System.out.println("HISTORIQUE INDIVIDUEL POUR ANDROID------------");
            while (rs.next()) {
                String type = rs.getString("Type");
                String date = rs.getString("Date");
		String description = rs.getString("Description");

                System.out.println("----------------------------------------------");
		System.out.println("TYPE        "  +type);
		System.out.println("DATE        "  +date);
		System.out.println("DESCRIPTION "  +description);
		System.out.println("----------------------------------------------");

            }
         }

     public void chercherHistoriqueWeb() throws SQLException {
        try {
            Statement stmt;
            stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery("select * from HistWeb");
                System.out.println("HISTORIQUE PAGE WEB---------------------------");
            while (rs.next()) {
                String type = rs.getString("Type");
                String date = rs.getString("Date");
		String description = rs.getString("Description");

                System.out.println("----------------------------------------------");
		System.out.println("TYPE        "  +type);
		System.out.println("DATE        "  +date);
		System.out.println("DESCRIPTION "  +description);
		System.out.println("----------------------------------------------");
		               
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("VIEW non trouvable");
        }
    }        
}
