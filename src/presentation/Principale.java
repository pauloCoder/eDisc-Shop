package presentation;

import java.util.Date;

import metier.Catalogue;
import metier.Client;
import metier.Commande;
import metier.DetailCommande;
import metier.DetailPanier;
import metier.Panier;
import metier.Produit;

/**
 * 
 * @author Paul KOUASSI
 *
 */
public class Principale 
{
	public static void main(String[] args) throws Exception 
	{
		
		/**Création du client**/
		Client client = new Client("KOUASSI", "Yao Paul", "135 rue Véron");
		
		/**Chargement et affichage du catalogue**/
		Catalogue cat = Catalogue.getInstance();
		System.out.println(cat);
		System.out.println("-------------------------------------------");
		
		/**Création d'un panier et ajout de certains produits**/
		Panier panier = new Panier();
		Panier panier2 = new Panier();
		for (int i = 0 ; i < cat.getNbProduits(); i++)
		{
			Produit produit = cat.getProduits().get(i);
			if(i == 1 || i == 2)
			{
				//Produit n°2 - n°3 : Savon noir - Beurre demi sel  
				panier.addDetailPanier(new DetailPanier(produit,8));
			}
			if (i == 3)
			{
				//Produit n°4 : Matelas doux 
				panier2.addDetailPanier(produit,2);
			}
		}
		
		//Produit n°2 - n°4 : Savon noir - Beurre demi sel  
		panier.addDetailPanier(cat.getProduits().get(1),7);
		panier.addDetailPanier(new DetailPanier(cat.getProduits().get(3),1));
		//Produit n°5 : Brosse électrique
		panier2.addDetailPanier(new DetailPanier(cat.getProduits().get(4),11));
		
		/**Affichage du panier**/
		//System.out.println(panier);
		//System.out.println("-------------------------------------------");
		
		/**Création d'une commande (Transformation des détails panier en 
		 * détails commande)**/
		Commande commande = new Commande(client,new Date(),panier.getMontantTotal());
		for (DetailPanier dp : panier.getArticles())
		{
			commande.addDetailCommande(new DetailCommande(dp));
		}
		
		Commande commande2 = new Commande(client,new Date(),panier2.getMontantTotal());
		for (DetailPanier dp : panier2.getArticles())
		{
			commande2.addDetailCommande(new DetailCommande(dp));
		}

		/**Affichage de la commande**/
		System.out.println(commande);
		System.out.println("-------------------------------------------");
		System.out.println(commande2);
		System.out.println("-------------------------------------------");
		//System.out.println(cat);

	}
}
