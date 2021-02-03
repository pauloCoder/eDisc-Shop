package metier;

import java.util.ArrayList;
import java.util.List;

/***
 * Classe client contenant les différents informations
 * concernant le client
 * @author Paul KOUASSI
 *
 */
public class Client 
{
	/*---Attributs---*/
	private static int compteur;
	private int code;
	private String nom;
	private String prenom;
	private String adresse;
	private List<Commande> commandes;
	
	/*---Constructeurs---*/
	/**
	 * @param code : code du client
	 * @param nom : nom du client
	 * @param prenom : prénom du client
	 * @param adresse : adresse du client
	 */
	public Client(int code, String nom, String prenom, String adresse) 
	{
		this.commandes = new ArrayList<Commande>();
		this.code = code;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}
	
	public Client(String nom, String prenom, String adresse) 
	{
		this.code = ++compteur;
		this.commandes = new ArrayList<Commande>();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}
	
	/*--- Accesseurs et mutateurs ---*/
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	/*---Affichage---*/
	@Override
	public String toString() 
	{
		return " [ Nom - Prénom(s) : " + this.nom.toUpperCase() + " " 
				+ this.prenom + " / Adresse client : " + this.adresse + "]";
	}



}
