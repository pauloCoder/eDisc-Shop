package metier;
import java.util.List;
import java.util.Vector;
/***
 * Classe <singleton> permettant de stocker les différents
 * produits qui seront proposés au visiteur
 * @author Paul KOUASSI
 *
 */

public class Catalogue 
{
	/*---Attributs---*/
	@SuppressWarnings("unused")
	private String nomCatalogue;
	private List<Produit> produits;
	private static Catalogue leCatalogue = null;
	
	/*---Constructeurs---*/
	/**
	 * @param nomCatalogue : nom du catalogue
	 * @param produits : liste des articles contenues dans le catalogue
	 */
	private Catalogue()
	{
		this.nomCatalogue = "Cashmire";
		this.produits = new Vector<>();
	}

	/*---Méthodes---*/
	//Méthode d'instanciation de la classe
	public static Catalogue getInstance()
	{
		if(leCatalogue == null)
		{
			leCatalogue = new Catalogue();
			leCatalogue.initCatalogue();
		}
		return leCatalogue;
	}
	
	//Initialisation du catalogue avec certains produits
	private void initCatalogue()
	{
		produits.add(new Produit("Savon noir",12.45,10,"Embellit et rafermit la peau"));
		produits.add(new Produit("Beurre demi-sel", 2, 15,"Pâtisserie et cuisine"));	
		produits.add(new Produit("Sucre roux", 2.35,25,"Préparation des cookies etc..."));
		produits.add(new Produit("Matelas doux", 95.12, 3, "Pour un sommeil réparateur,rien de mieux"));
		produits.add(new Produit("Brosse électrique",19.99,11,"Vitesse, précision et blancheur"));
	}
	
	//Méthode retournant la liste des articles
	public List<Produit> getProduits()
	{
		return produits;
	}
	
	//Méthode d'ajout d'un produit à la liste des articles
	public void addProduit(Produit produit)
	{
		produits.add(produit); 
	}
	
	//Méthode retournant le nombre total de produit dans le catalogue
	public int getNbProduits()
	{
		return produits.size();
	}
	
	/*---Affichage---*/
	@Override
	public String toString()
	{
		
		StringBuilder message = new StringBuilder("Contenu du catalogue : \n");
		for(Produit prod : produits)
		{
			message.append(prod + "\n");
		}
		return message.toString();
		
	}
}