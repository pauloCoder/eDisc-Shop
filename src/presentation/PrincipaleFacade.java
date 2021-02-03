package presentation;

import metier.Client;
import metier.Produit;
import services.Facade;
import services.IFacade;

/***
 * 
 * @author Paul KOUASSI
 *
 */
public class PrincipaleFacade 
{

	public static void main(String[] args) throws Exception 
	{
		/**Instanciation de la facade : on charge le catalogue
		 * via le constructeur de la Facade**/
		IFacade facade = new Facade();
		int nbProduits = facade.getNbProduits();
		
		/** Parcours du caatlogue et insertion de certains produits
		 * dans le panier **/
		System.out.println("Catalogue des produits : ");
		System.out.println("------------------------");
		for (int i = 0 ; i < nbProduits ; i++)
		{
			Produit produit = facade.getProduit(i);
			
			//Affichage des produits
			System.out.println(produit);
			//Ajout des produits -- Produit n°2 - n°4 : Savon noir - Matelas doux  
			if (i == 1 || i == 3)
			{
				facade.ajoutPanier(produit, 2);
			}
		}
		
		/** Affichage du panier **/
		System.out.println("\n------------------------\n");
		System.out.println(facade.getPanier());
		System.out.println("\n------------------------\n");
		
		/** Création d'un client et passage d'une commande **/
		Client client = facade.creerClient("KOUASSI", "Yao Paul Williams", "135 rue Véron");
		facade.passerCommande();
		
		/** Vérification : on imprime le client et la commande **/
		System.out.println("Client : " + client);
		System.out.println(facade.afficherCommande());


		

	}

}
