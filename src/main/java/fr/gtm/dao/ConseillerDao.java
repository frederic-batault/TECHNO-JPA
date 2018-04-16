package fr.gtm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.gtm.domaine.*;

public class ConseillerDao {
	
//	private Statement connect() {
//		try {
//			// Chargement du driver (dans le pilote)
//			Class.forName("com.mysql.jdbc.Driver");
//
//			// Connexion � la base de donnee
//			String url = "jdbc:mysql://localhost:3306/proxibanquebdd";
//			String login = "root";
//			String mdp = "";
//			Connection connection = DriverManager.getConnection(url, login, mdp);
//
//			// Pr�paration de la requete
//			Statement stmt = connection.createStatement();
//			return stmt;
//		} catch (ClassNotFoundException e) {
//			System.out.println("Probl�me chargement du driver !");
//			e.printStackTrace();
//			Statement stmt = null;
//			return stmt;
//		} catch (SQLException e) {
//			System.out.println("Probl�me de connexion � la base de donn�e !");
//			e.printStackTrace();
//			Statement stmt = null;
//			return stmt;
//		}
//	}


	private ConnectionDao conDao = new ConnectionDao();
	private Connection con = conDao.connect();
	private Statement st;
	private ResultSet result;
/*
	public boolean createConseiller(Conseiller leConseiller) {
		boolean reponse = false; // Creation de la variable de sortie
		try {
			Statement stmt = this.connect(); // Connexion et preparation de la requete
			String sql = "INSERT INTO `conseiller`(`nom`, `prenom`, `login`,`nbClient`) VALUES ('"
					+ leConseiller.getNom() + "', '" + leConseiller.getPrenom() + "', '" + leConseiller.getLogin()+ "', '"
					+ leConseiller.getPassword() + "', '"+ leConseiller.getNbClient() + ");";
			int result = stmt.executeUpdate(sql); // Ex�cution de la requ�te
			if (result > 0) { // Lecture des r�sultats
				reponse = true;
			} else {
				reponse = false;
			}
			return reponse; // retour de la r�ponse
		} catch (SQLException e) {
			System.out.println("Probl�me lors de la cr�ation du conseiller !");
			e.printStackTrace();
			return reponse;
		}
	}
*/
	public Conseiller getConseiller(Conseiller leConseiller) {
		try {
			String sql = "SELECT  idconseiller,nom,prenom,login,password,nbClient FROM conseiller WHERE login = '"+
							leConseiller.getLogin()+"' and password = '"+leConseiller.getPassword()+"'";
			this.st = this.con.createStatement();
			this.result = this.st.executeQuery(sql); // Ex�cution de la requete
			//result.next();
			if(result.next()) {
				leConseiller.setIdConseiller(result.getInt("idconseiller"));
				leConseiller.setNom(result.getString("nom"));// Recuperation des donnees
				leConseiller.setPrenom(result.getString("prenom"));
	//			leConseiller.setLogin(result.getString("login"));
	//			leConseiller.setPassword(result.getString("password"));
				leConseiller.setNbClient(result.getInt("nbClient"));
//			}else {
//				leConseiller.setIdConseiller(0);
			}
			return leConseiller; // retour de la reponse
		} catch (SQLException e) {
			System.out.println("Probl�me lors de la r�cup�ration du client !");
			e.printStackTrace();
			return leConseiller;
		}
	}

}