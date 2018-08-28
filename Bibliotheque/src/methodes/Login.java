/*
 * Tous les doits au groupe Gustavo Pacheco, Marcos Gomes et Mohamed Nidhal
 */
package methodes;

import tables.UsersMotDePasse;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
     
     public String findRole(String user){
        // Locals
        String role = "";
        try {
            Statement stmt;
            stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery(
                "SELECT role from Utilisateurs where idUtilisateur = '"+user+"'");
            while (rs.next()) {
                role = rs.getString("role");
            }         

        } catch (SQLException e) {
            System.err.println("role non trouvable");
        }
        return role;
     }
//==============================================================================
    
}
