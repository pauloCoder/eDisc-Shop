package services;

import metier.Client;
import metier.Commande;
import metier.Panier;
import metier.Produit;

/***
 * Façade fournissant une interface simplifiée du
 * fonctionnement des composantes métiers
 * @author Paul KOUASSI
 *
 */

public interface IFacade 
{
	/*--- Méthode concernant les produits ---*/
	/**
	 * Méthode permettant de récupérer le produit à la position
	 * courante 
	 * @param posCourante : position du produit
	 * @return Produit
	 */
	Produit getProduit(int posCourante);
	
	/**
	 * Méthode permettant de récuperer le nombre de 
	 * produits contenus dans le catalogue 
	 * @return nombre de produits
	 */
	int getNbProduits();
	
	/*--- Méthode concernant le panier ---*/
	/**
	 * Accesseur du panier
	 * @return le panier
	 */
	Panier getPanier();
	
	/**
	 * Mutateur du panier
	 * @param panier : panier remplaçant
	 * @return 
	 * @return void
	 */
	void setPanier(Panier panier);
	
	/**
	 * Méthode permettant d'ajouter un produit 
	 * dans le panier
	 * @param produit : produit à ajouter
	 * @param quantite : quantité du produit concerné
	 * @throws Exception 
	 */
	void ajoutPanier(Produit produit,int quantite) throws Exception;
	
	/*--- Méthode concernant le client ---*/
	
	/**
	 * Méthode permettant de créer un client
	 * @param nom : nom du client
	 * @param prenom : prénom du client
	 * @param adresse : adresse du client
	 * @return Client
	 */
	Client creerClient(String nom, String prenom, String adresse);
	
	/*--- Méthode concernant la commande ---*/
	
	/**
	 * Méthode permettant de passer la commande des articles
	 * sélectionnés par le client
	 * @throws Exception 
	 */
	Commande passerCommande() throws Exception;
	
	/**
	 * Méthode permettant d'afficher les différents articles concernés
	 * par la commande du client
	 * @return
	 * @throws Exception 
	 */
	String afficherCommande() throws Exception;

}
