package services;

import java.util.Date;

import metier.Catalogue;
import metier.Client;
import metier.Commande;
import metier.DetailCommande;
import metier.DetailPanier;
import metier.Panier;
import metier.Produit;

/***
 * Représente la façade applicative (couche de services). 
 * Regroupe les traitements nécessaire à une session de 
 * consultation / achat d'un visiteur.
 * NB : une façade sera associée à chaque utilisateur
 * @author Paul KOUASSI
 *
 */
public class Facade implements IFacade 
{
	/*--- Attributs ---*/
	private Catalogue leCatalogue = null;
	private Panier panier = null;
	private Client client = null;
	private Commande commande = null;
	
	/*--- Constructeur(s) ---*/
	public Facade() 
	{
		this.leCatalogue = Catalogue.getInstance();
	}

	/**--- Implémentation des méthodes de l'interface ---**/
	
	/*------------------------- Catalogue --------------------------*/
	
	/**
	 * Méthode permettant de récupérer le produit à la position
	 * passée en paramètre au sein du catalogue
	 * @param posCourante : position du produit 
	 * @return le produit concerné
	 */
	@Override
	public Produit getProduit(int posCourante) 
	{
		Produit produit = null;
		if (posCourante == this.leCatalogue.getNbProduits())
			posCourante = 0;
		produit = this.leCatalogue.getProduits().get(posCourante);
		return produit;
	}

	/**
	 * Méthode permettant de récuperer le nombre de 
	 * produits contenus dans le catalogue 
	 * @return nombre de produits
	 */
	@Override
	public int getNbProduits() 
	{
		return this.leCatalogue.getNbProduits();
	}
	
	/*------------------------- Panier --------------------------*/
	
	/**
	 * Accesseur du panier.Si le client n'a
	 * pas encore de panier on lui en fournit
	 * un vide
	 * @return le panier
	 */
	@Override
	public Panier getPanier() 
	{
		if (this.panier == null)
			panier = new Panier();
		return this.panier;
	}

	/**
	 * Mutateur du panier
	 * @param panier : panier remplaçant
	 * @return 
	 * @return void
	 */
	@Override
	public void setPanier(Panier panier) 
	{
		this.panier = panier;
	}

	/**
	 * Méthode permettant d'ajouter un produit 
	 * dans le panier
	 * @param produit : produit à ajouter
	 * @param quantite : quantité du produit concerné
	 * @throws Exception 
	 */
	@Override
	public void ajoutPanier(Produit produit, int quantite) throws Exception 
	{
		if (this.panier == null)
			panier = new Panier();
		this.panier.addDetailPanier(produit, quantite);
	}

	/*------------------------- Client --------------------------*/
	
	/**
	 * Méthode permettant de créer un client
	 * @param nom : nom du client
	 * @param prenom : prénom du client
	 * @param adresse : adresse du client
	 * @return le client créé
	 */
	@Override
	public Client creerClient(String nom, String prenom, String adresse) 
	{
		if (client == null)
		{
			this.client = new Client(nom,prenom,adresse);
		}
		return this.client;
	}

	@Override
	public Commande passerCommande() throws Exception 
	{
		if (this.commande == null && this.client != null)
		{
			if (this.panier.getArticles().size() != 0)
			{
				/*
				 * Initialisation de la commande et ajout de tous les détails commandes
				 * à la commande
				 */
				this.commande = new Commande(this.client,new Date(),this.panier.getMontantTotal());
				for (DetailPanier dp : this.panier.getArticles())
				{
					this.commande.addDetailCommande(new DetailCommande(dp));
				}
			}
			else
			{
				throw new Exception("Impossible de passer une commande. Le panier est vide !");
			}
		}
		else
		{
			throw new Exception("Seuls les clients peuvent passer des commandes !");
		}
		
		return this.commande;
	}

	@Override
	public String afficherCommande() throws Exception 
	{
		if (this.commande == null)
		{
			throw new Exception("Votre commande ne contient aucun article");
		}
		return this.commande.toString();
	}

}
