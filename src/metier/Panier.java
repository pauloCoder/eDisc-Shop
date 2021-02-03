package metier;

import java.util.ArrayList;
import java.util.List;

/***
 * Classe Panier contenant tous les produits que 
 * le client envisage de passer en commande. 
 * @author Paul KOUASSI
 *
 */
public class Panier 
{
	/*---Attribut(s)---*/
	private List<DetailPanier> articles = null;

	/*--- Constructeur ---*/
	public Panier() 
	{
		articles = new ArrayList<DetailPanier>();
	}
	
	/*--- Accesseur du panier ---*/
	
	public List<DetailPanier> getArticles() 
	{
		return articles;
	}
	
	/*--- Méthodes ---*/
	/**
	 * Méthode permettant de calculer le montant total
	 * des articles se trouvant dans le panier (Le cumul 
	 * des sous totaux des détails panier)
	 * @return
	 */
	public double getMontantTotal() 
	{
		double montantTotal = 0;
		for (DetailPanier dp : articles)
		{
			montantTotal += dp.getSousTotal();
		}
		return montantTotal;
	}

	/**
	 * Méthode permettant de calculer le nombre d'articles total
	 * dans le panier (Correspond à la somme des articles contenus 
	 * dans les détails panier Dp)
	 * @return
	 */
	public int getQuantiteArticlesDp() 
	{
		int quantiteArticlesDp = 0;
		
		for (DetailPanier dp : articles)
		{
			quantiteArticlesDp += dp.getQuantite();
		}
		
		return quantiteArticlesDp;
	}
	
	/**
	 * Méthode permettant d'ajouter un détail panier au panier
	 * @param dp : détail panier à ajouter
	 * @throws Exception 
	 */
	public void addDetailPanier(DetailPanier dp) throws Exception
	{
		/*
		 * Recherche du produit du DetailPanier dp
		 * dans le panier.
		 * dp : détail panier que l'utilisateur souhaite ajouter
		 * dpr : détail panier existant possiblement dans le panier
		 * et contenant le produit de dp
		 */
		DetailPanier dpr = rechercheDetailPanier(dp.getProduit());
		
		//Si le produit du détail panier dp n'existe pas dans le panier
		//on en créé un nouveau sinon on met à jour l'existant
		if (dpr == null)
		{
			articles.add(dp);
			//Connexion entre le panier et le détail panier
			dp.setPanier(this);
		}
		else
		{
			//Mise à jour du stock virtuel, de la quantité et du sous total
			dpr.setStockVirtuel(dp.getQuantite());
			dpr.setQuantite(dpr.getQuantite() + dp.getQuantite());
			dpr.setSousTotal(dpr.getSousTotal() + dp.getSousTotal());
		}
	
	}
	
	/**
	 * Méthode permettant de créer un détail panier à partir
	 * du produit voulu
	 * @param produit : produit concerné par le détail panier
	 * @param quantite : quantité du produit concerné
	 * @throws Exception
	 */
	public void addDetailPanier(Produit produit,int quantite) throws Exception
	{
		DetailPanier dp = new DetailPanier(produit, quantite);
		//Ajout du détail panier au panier
		this.addDetailPanier(dp);
	}
	
	
	/**
	 * Méthode permettant de déterminer si le produit du 
	 * détail panier  appartient déja au panier
	 * @param dp : détail panier à  rechercher
	 * @return
	 */
	private DetailPanier rechercheDetailPanier(Produit produitCourant)
	{
		//produitCourant : produit du détail panier à chercher dans panier
		//dpr : détail panier à retourner
		//dpp : détail panier parcourant le panier pour la recherche
		
		DetailPanier dpr = null;
		for (DetailPanier dpp : articles)
		{
			if (dpp.getProduit().getCode() == produitCourant.getCode())
			{
				dpr = dpp; // Détail panier contenu dans le panier

			}
		}
		return dpr;
	}
	
	
	
	/*--- Affichage ---*/
	@Override
	public String toString()
	{
		if (articles.size() == 0)
		{
			return "Votre panier est vide !";
		}
		else
		{
			StringBuilder message = new StringBuilder("Contenu du panier : \n");
			message.append("------------------\n");
			for(DetailPanier dp : articles)
			{
				message.append(dp + "\n");
			}
			message.append("Articles dans le panier : " + this.articles.size() + 
			" / Quantité total d'articles : " + this.getQuantiteArticlesDp()  +
			" / Montant total : " + this.getMontantTotal() +  "€");
			return message.toString();
		}
		
		
	}
	
}
