/*
 * Tous les doits au groupe Gustavo Pacheco, Marcos Gomes et Mohamed Nidhal
 */
package methodes;

import tables.UsersMotDePasse;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.util.Date.parse;

/**
 *
 * @author luizgustavopacheco
 */
public class Login extends ConnectParent {
    
    //Atributs
    Reinitialisation u = new Reinitialisation();
    UsersMotDePasse umdp = new UsersMotDePasse();
    
    String idConfirmee = u.idConfirmee;
    String mdpe;
    String id;
    String mdpDecrypte;

    //Constructeur
    public Login() {
    }

//==============================================================================
//LOGIN
//PREND L'IDUTILISATEUR ET CHERCHE LE MOT DE PASSE POUR COMPARER
    
     public UsersMotDePasse trouverMotDePasse(String idUtilisateurEntree,String motDePasseEntree) {

        UsersMotDePasse aRetourner = new UsersMotDePasse();
        try {
            //select * from UsersMotDePasse where idUtilisateur="Utilisateur" and mdpEncripte=AES_ENCRYPT('123util','123util');
            Statement stmt;
            stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery("select * from UsersMotDePasse "
                    + "where idUtilisateur="+"'"+idUtilisateurEntree+"'"
                    + " and mdpEncripte=AES_ENCRYPT('"+motDePasseEntree+"','"+motDePasseEntree+"')");
            while (rs.next()) {
                aRetourner = new UsersMotDePasse(rs.getString("idUtilisateur"),rs.getString("mdpEncripte"));
		id = rs.getString("idUtilisateur");
		mdpe = rs.getString("mdpEncripte");
	
            }
        } catch (SQLException e) {
            System.err.println("Identificateur non trouvable");
        }
        return aRetourner;
    }

//==============================================================================
                    
     String mdpEncrypte = umdp.getMdpEncripte();


     
     public String decrypterMotDePasse(String motDePasseEntree) {

        try {
            //Cette requête foncitionne bien
            //select AES_DECRYPT(AES_ENCRYPT('123util','123util'),'123util') as mdpDecrypte from UsersMotDePasse where mdpEncripte=AES_ENCRYPT('123util','123util');
            Statement stmt;
            stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery("select AES_DECRYPT(AES_ENCRYPT('"+motDePasseEntree+"','"+motDePasseEntree+"'),'"+motDePasseEntree+"') as mdpDecrypte"
                    + " from UsersMotDePasse "
                    + "where mdpEncripte=AES_ENCRYPT('"+motDePasseEntree+"','"+motDePasseEntree+"')");
            while (rs.next()) {
		mdpDecrypte = rs.getString("mdpDecrypte");
            }         

        } catch (SQLException e) {
            System.err.println("motDePasseEntree non trouvable");
        }
        return mdpDecrypte;
    }

//==============================================================================
     
     public String comparerMotDePasse(String motDePasseEntree, String mdpDecrypte)
     {
            if(motDePasseEntree.compareTo(mdpDecrypte)==0)
            {System.out.println("MOT DE PASSE CONFIRMÉ");} 
             else{ System.out.println("MOT DE PASSE ERRONÉ");}
        return null;
     }
//==============================================================================
    
}
