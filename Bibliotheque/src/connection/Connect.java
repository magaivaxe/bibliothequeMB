/*
 * Tous les doits au groupe Gustavo Pacheco, Marcos Gomes et Mohamed Nidhal
 */
package connection;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 * pour faire la connection avec la base de donneés
 * @author Gustavo
 */
public class Connect {
        
       
        private static String url = "jdbc:mysql://localhost:3306/bibliothequeMB_DB";
	private static String user = "root";
	private static String passwd = "16thfeb76";
        private static Connection connection;
        
    public static Connection connecter(){
       if (connection == null){
           try {
               Class.forName("com.mysql.jdbc.Driver");
               connection = DriverManager.getConnection(url, user, passwd);
               System.out.println("Ça fonctionneeeeeeeee!!!!!!!!");
           } catch (Exception e) {
               throw new IllegalStateException("Impossible connecter", e);
           }
       }
       return connection;
    }

    
}
