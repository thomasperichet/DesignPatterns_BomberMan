package Connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.sql.Date;

import javax.xml.bind.DatatypeConverter;


import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.*;
public class JDBCPostgres {
	/* Connexion à la base de données */
	String utilisateur = "postgres";
	String motDePasse = "123456789";
	Connection connexion = null;

	public JDBCPostgres( String utilisateur, String motDePasse) {

		 try {
			 	Class.forName("org.postgresql.Driver");
			 	Connection connexion = DriverManager.getConnection("jdbc:postgresql://localhost/pg_bomberman", utilisateur, motDePasse);
	            if (connexion != null) {
	                System.out.println("Connected to the database!");
	            } else {
	                System.out.println("Failed to make connection!");
	            }

	            this.connexion=connexion;
	        } catch (SQLException e) {
	            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
	}
	public Connection getConnection() {
		return this.connexion;
	}
	
	public boolean mailExiste(String mail) {
		
		try {
			PreparedStatement ps = this.connexion.prepareStatement("SELECT count(*) FROM joueur WHERE email = ?");
			ps.setString(1, mail);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getInt(1)==0) {
					return false;
				}
				return true;
			}



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}
	public String hacheMDP(String motdepasse) {
		String password = motdepasse;

		MessageDigest md=null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		md.update(password.getBytes());
		byte[]digest = md.digest();
		String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
		return myHash;
	}
	/*public void insererJoueur(Joueur j) {
		
		try {
			PreparedStatement ps = this.connexion.prepareStatement("INSERT INTO Joueur (email,motDePasse,pseudo,date_create,sexe,niveau,chemin_avatar) VALUES (?,?,?,?,?,?,?);");
			ps.setString(1, j.getEmail());
			ps.setString(2, hacheMDP(j.getMotDePasse()));
			ps.setString(3, j.getPseudo());
			ps.setObject(4, j.getDate_create());
			ps.setLong(5, j.getSexe());
			ps.setLong(6,j.getNiveau());
			ps.setString(7, j.getCheminAvatar());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}*/
	
	public boolean joueurExiste(String email, String mdp) {

		try {
			PreparedStatement ps = this.connexion.prepareStatement("SELECT count(*) FROM joueur WHERE email = ? AND motDePasse = ?");
			ps.setString(1, email);
			ps.setString(2, hacheMDP(mdp));

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getInt(1)==0) {
					return false;
				}
				return true;
			}



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/*public Joueur getJoueur(String email) {
		try {
			PreparedStatement ps = this.connexion.prepareStatement("SELECT id, email, motdepasse,pseudo,date_create, sexe, niveau,chemin_avatar FROM joueur WHERE email = ?");
			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Joueur j = new Joueur();
				j.setId(rs.getInt(1));
				j.setEmail(email);
				j.setMotDePasse(rs.getString(3));
				j.setPseudo(rs.getString(4));
				Date date = (Date) rs.getObject(5);
				j.setDate_create(date.toLocalDate());
				j.setSexe(rs.getInt(6));
				j.setNiveau(rs.getInt(7));
				j.setCheminAvatar(rs.getString(8));
				return j;
			}



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}*/
	
}
