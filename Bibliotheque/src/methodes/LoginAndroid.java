/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methodes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import tables.UsersMotDePasse;

/**
 *
 * @author luizgustavopacheco
 */
public class LoginAndroid extends ConnectParent {
       //Atributs

    String mdpeA;
    String courrielA;
    String mdpDecrypteA;
    String idA;

    //Constructeur
    public LoginAndroid() {
    } 

//==============================================================================
//LOGIN ANDROID
//PREND L'IDUTILISATEUR ET CHERCHE LE MOT DE PASSE POUR COMPARER
    
     public String trouverMotDePasseANDROID(String courrielEntree,String motDePasseEntree) {

        try {
//select Utilisateurs.idUtilisateur,UsersMotDePasse.mdpEncripte from UsersMotDePasse
//inner join Utilisateurs on UsersMotDePasse.idUtilisateur=Utilisateurs.idUtilisateur 
//where courriel="123@ex.com" and mdpEncripte=AES_ENCRYPT('123util','123util');
            Statement stmt;
            stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery("select UsersMotDePasse.mdpEncripte,Utilisateurs.idUtilisateur from UsersMotDePasse "
                    + "inner join Utilisateurs on UsersMotDePasse.idUtilisateur=Utilisateurs.idUtilisateur"
                    + "where courriel="+"'"+courrielEntree+"'"
                    + " and mdpEncripte=AES_ENCRYPT('"+motDePasseEntree+"','"+motDePasseEntree+"')");
            while (rs.next()) {
                mdpeA = rs.getString("mdpEncripte");
		idA = rs.getString("idUtilisateur");
		
	System.out.println("TEST 1 ");
            }
        } catch (SQLException e) {
            System.err.println("Courriel non trouvable");
        }
        return mdpeA;
    }

//==============================================================================

     public String decrypterMotDePasseANDROID(String motDePasseEntree) {

        try {
            
            Statement stmt;
            stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery("select AES_DECRYPT(AES_ENCRYPT('"+motDePasseEntree+"','"+motDePasseEntree+"'),'"+motDePasseEntree+"') as mdpDecrypte"
                    + " from UsersMotDePasse "
                    + "where mdpEncripte=AES_ENCRYPT('"+motDePasseEntree+"','"+motDePasseEntree+"')");
            while (rs.next()) {
		mdpDecrypteA = rs.getString("mdpDecrypte");
                System.out.println("TEST 2 ");
            }        

        } catch (SQLException e) {
            System.err.println("motDePasseEntree non trouvable");
        }
        return mdpDecrypteA;
    }

//==============================================================================
     
     public String comparerMotDePasseANDROID(String motDePasseEntree, String mdpDecrypteA)
     {
            if(motDePasseEntree.compareTo(mdpDecrypteA)==0)
            {System.out.println("MOT DE PASSE CONFIRMÉ SUR ANDROID");} 
             else{ System.out.println("MOT DE PASSE ERRONÉ SUR ANDROID");}
        return null;
     }
//==============================================================================     
    
}
