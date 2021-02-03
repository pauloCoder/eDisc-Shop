package services;

import metier.Catalogue;
import metier.Client;
import metier.Panier;
import metier.Produit;

/***
 * Implémentation de la facade 
 * @author Paul KOUASSI
 *
 */
public class Facade implements IFacade 
{
	/*--- Attributs ---*/
	private Catalogue leCatalogue = null;
	private Panier panier = null;
	
	/*--- Constructeur(s) ---*/
	public Facade() 
	{
		this.leCatalogue = Catalogue.getInstance();
	}

	/*--- Implémentation des méthodes de l'interface ---*/

	@Override
	public Produit getProduit(int posCourante) 
	{
		Produit produit = null;
		produit = this.leCatalogue.getProduits().get(posCourante);
		return produit;
	}

	@Override
	public int getNbProduits() 
	{
		return this.leCatalogue.getNbProduits();
	}
	
	@Override
	public Panier getPanier() 
	{
		if (this.panier == null)
			panier = new Panier();
		return this.panier;
	}

	@Override
	public void setPanier(Panier panier) 
	{
		this.panier = panier;
	}

	@Override
	public void ajoutPanier(Produit produit, int quantite) throws Exception 
	{
		this.getPanier().addDetailPanier(produit, quantite);
	}

	@Override
	public Client creerClient(String nom, String prenom, String adresse) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void passerCommande() 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public String afficherCommande() 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
