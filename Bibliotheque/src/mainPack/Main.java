/*
 * Tous les doits au groupe Gustavo Pacheco, Marcos Gomes et Mohamed Nidhal
 */
package mainPack;



import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import methodes.Emprunt;
import methodes.Historique;
import methodes.Insertions;
import methodes.Login;
import methodes.LoginAndroid;
import methodes.Reinitialisation;
import methodes.RechercherParTitre;
import tables.UsersMotDePasse;
import tables.Utilisateurs;

/**
 *
 * @author luizgustavopacheco
 */
public class Main{

    public static void main(String[] args) throws SQLException {
        
        Date date = new Date(); 
        String dateRegistreAInserer = new SimpleDateFormat("yyyy-MM-dd").format(date);
        
        String idUtilisateurEntree = "Utilisateur";
        String motDePasseEntree = "123util";
        
        Reinitialisation r = new Reinitialisation();
        Utilisateurs ut = r.rechercher(idUtilisateurEntree);
        //System.out.println("TEST "+ut.toString());        
        
        String dateNeEntree = "1234-12-12";
        String nouveauMotDePasse = "123encrypte";

        //LOGIN===============================================================OK
        Login l = new Login();
        UsersMotDePasse umdp = new UsersMotDePasse();                
        //umdp = l.trouverMotDePasse(idUtilisateurEntree,motDePasseEntree);
        //System.out.println("TEST "+umdp.toString()); 
        
        String mdpEncrypte = umdp.getMdpEncripte();
        String mdpDecrypte = l.decrypterMotDePasse(motDePasseEntree);
        //System.out.println("TEST MOT DE PASSE ENCRYPTE "+mdpEncrypte); 
        System.out.println("TEST MOT DE PASSE DECRYPTE "+mdpDecrypte);

        //l.trouverMotDePasse(idUtilisateurEntree,motDePasseEntree);
        //l.comparerMotDePasse(motDePasseEntree,mdpDecrypte);
        
        //LOGIN ANDROID=========================================================

        String courrielEntree = "123@ex.com";

        //RÉINITIALISER MOT DE PASSE============================================OK        
        String idConfirmee = r.chercherUtilisateur(idUtilisateurEntree, dateNeEntree);
        //r.changerMotDePasse(idConfirmee, nouveauMotDePasse);déjà fait  
        
        //RECHERCHE DE LIVRE PAR TITRE==========================================OK
        String titreEntre = "Nom du livre";
        RechercherParTitre rpt = new RechercherParTitre();
        //rpt.rechercherSimple(titreEntre);

        //INSERTIONS============================================================
        Insertions in = new Insertions();

        //INSÉRER LIVRES========================================================OK        
        String idLivreAInserer = "livre";
        String cduAInserer = "12345678";
        String titreAInserer = "Nom du livre";                                
        String typeLivreAInserer = "regulier";
        //in.insererLivres(idLivreAInserer, cduAInserer, titreAInserer, dateRegistreAInserer, typeLivreAInserer);déjà fait
        
        
        //INSÉRER UTILISATEUR===================================================OK        
        String idUtilisateurAInserer = "lpg";
        String nomAInserer="Pacheco";
        String preNomAInserer="Luiz Gustavo"; 
        String dateNeAInserer= "1976-02-16"; 
        String adresseAInserer="2125 RueSM app1409";
        String telephoneAInserer="5145153176";
        String courrielAInserer="pacheco.luizgustavo@gmail.com";
        //in.insererUtilisateur(idUtilisateurAInserer,nomAInserer,preNomAInserer,dateNeAInserer,adresseAInserer,telephoneAInserer,courrielAInserer,dateRegistreAInserer);déjà fait
           
        //INSERER MOT DE PASSE==================================================OK
        String mdpEncripteAInserer = "123lgp";
        //in.insererMotDePAsse(idUtilisateurAInserer,mdpEncripteAInserer);déjà fait
        
        //INSERER RESERVATION===================================================
        //creer condition pour eviter conflit de date

        //in.insererReservation(0,"livre1", "Utilisateur", "2018-07-30", "annule");déjà fait
        //in.insererReservation(1,"livre1","NidhalAfrican","2018-08-01","fini");déjà fait
        //in.insererReservation(2,"livre", "NidhalAfrican", "2018-08-15", "fini");déjà fait
        //in.insererReservation(3,"livre1", "GustavoPach", "2018-08-16", "fini");déjà fait
        //in.insererReservation(4,"livre", "NidhalAfrican", "2018-08-29", "attente");déjà fait
        //in.insererReservation(5,"livre1","Utilisateur","2018-09-02","attente");déjà fait

       //RESERVATION DE LIVRES=================================================OK
        
        int idReservation= 6;
        String idLivreReservation = "livre1";
        String idUtilisateurReservation = "GustavoPach";
        String datePrevueReservation = "2018-09-17";                                
        String statusRsReservation = "attente";
 
        //in.insererReservation(idReservation, idLivreReservation, idUtilisateurReservation, datePrevueReservation, statusRsReservation);        
        
        //HITORIQUES WEB ET ANDROID=============================================OK
        Historique historique = new Historique();
        //historique.chercherHistoriqueWeb();
        //historique.chercherHistoriqueAndroid(idUtilisateurEntree);
        
        //EMPRUNTS DE LIVRES====================================================OK
        //ATTENTION L'EMPRUNT NE PEUT PAS ÊTRE SUPPRIMÉ!!!!!!!!!!!!
        //in.insererEmprunt(3,"livre","NidhalAfrican","2018-08-30","2018-09-13","cours");déjà fait
	//in.insererEmprunt(4,"livre1","GustavoPach","2018-08-16","2018-09-01","cours");déjà fait
       
        int idEmpruntAEmprunter = 5; 
        int idDuLivreReserve = 6;//exemple en haut dans reservation de livres
        String idLivreAEmprunter = "livre1"; 
        String idUtilisateurAEmprunter = "Utilisateur"; 
        String dateEmpAEmprunter = "2018-09-02"; 
        String dateRenAEmprunter = "2018-09-16"; 
        String statusEMAEmprunter = "cours";
        
        //pour emprunter sans reservation
        //in.insererEmprunt(idEmpruntAEmprunter,idLivreAEmprunter,idUtilisateurAEmprunter,dateEmpAEmprunter,dateRenAEmprunter,statusEMAEmprunter);
        
        //pour emprunter avec reservation
        //in.insererEmprunt(idEmpruntAEmprunter,idLivreAEmprunter,idUtilisateurAEmprunter,dateEmpAEmprunter,dateRenAEmprunter,statusEMAEmprunter);
        Emprunt emp = new Emprunt();
        //emp.emprunterChangeReservation(idDuLivreReserve);
        
        //pour retourner le livre
        //emp.retounerLivre(idEmpruntAEmprunter);

    }
    
}