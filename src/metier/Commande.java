package metier;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/***
 * Classe Commande contenant toutes les informations
 * concernant une commande client
 * Classe persistante
 * @author Paul KOUASSI
 *
 */
public class Commande 
{
	/*--- Attribut(s) ---*/
	private static int compteur;
	private int no;
	private Date date;
	private double montant;
	private List<DetailCommande> details = null;
	private Client client;
	
	/*--- Constructeur(s)---*/
	/**
	 * @param noCommande : numéro de la commande
	 * @param dateCommande : date de la commande
	 * @param client : client passant la commande
	 */
	public Commande(Client client, int noCommande, Date dateCommande , double montant) 
	{
		this.no = noCommande;
		this.date = dateCommande;
		this.details = new ArrayList<DetailCommande>();
		this.montant = montant;
		this.client = client;
	}
	
	public Commande(Client client, Date dateCommande , double montant) 
	{
		this.no = ++compteur;
		this.date = dateCommande;
		this.details = new ArrayList<DetailCommande>();
		this.montant = montant;
		this.client = client;
	}
	
	/*--- Accesseurs et mutateurs ---*/
		
	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public double getMontant() {
		return montant;
	}


	public void setMontant(double montant) {
		this.montant = montant;
	}


	public List<DetailCommande> getDetails() {
		return details;
	}


	public void setDetails(List<DetailCommande> details) {
		this.details = details;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}
	
	/*--- Méthodes ---*/
	
	/**
	 * 
	 * @param dc : détail commande à ajouter aux commandes
	 */
	public void addDetailCommande(DetailCommande dc)
	{
		//Ajout d'un détail commandes aux commandes
		details.add(dc);
		//Connexion entre le détail commande et la commande
		dc.setCommande(this);		
	}
	
	/**
	 * Méthode permettant de calculer le nombre d'articles total
	 * dans la commande (Correspond à la somme des articles contenus 
	 * dans les détails commandes Dc)
	 * @return
	 */
	public int getQuantiteArticlesDc() 
	{
		int quantiteArticlesDc = 0;
		
		for (DetailCommande dc : details)
		{
			quantiteArticlesDc += dc.getQuantite();
		}
		
		return quantiteArticlesDc;
	}
	/*--- Affichage ---*/
	@Override
	public String toString()
	{
		
		StringBuilder message = new StringBuilder();
		message.append("Commande n°" + this.getNo() + " : ");
		message.append(this.getClient() + "\n");
		for(DetailCommande dc : details)
		{
			message.append(dc + "\n");
		}
		message.append("Articles dans la commande : " + this.details.size() + 
		" / Quantité total d'articles : " + this.getQuantiteArticlesDc() +
		" / Montant total : " + this.getMontant() +  "€");
		return message.toString();
		
	}



}
