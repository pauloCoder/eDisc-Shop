package metier;
/***
 * Classe DétailPanier contenant un produit sélectionné ainsi
 * que sa quantité. Ici la quantité n'est pas déduite du stock
 * mais vérifier virtuellement pour ne pas dépasser la limite
 * @author Paul KOUASSI
 *
 */
public class DetailPanier 
{
	/*---Attributs---*/
	private Produit produit;
	private int stockVirtuel; 
	private int quantite;
	private double sousTotal;
	private Panier panier;
	
	/*--- Constructeur(s) ---*/
	/**
	 * @param produit : produit choisit
	 * @param quantite : quantité du produit choisit
	 */
	public DetailPanier(Produit produit, int quantite) throws Exception 
	{
		this.produit = produit;
		this.stockVirtuel = produit.getStock();
		if (this.stockVirtuel < quantite)
		{
			throw new Exception("La quantité de " + this.produit.getNom() + 
					" choisie est supérieure à celle disponible " +
					"(Stock disponible : " + this.stockVirtuel + " ! )");
		}
		else
		{
			this.quantite = quantite;
			this.stockVirtuel -= quantite; //Mise à jour du stock virtuel
		}
		this.sousTotal = this.produit.getPrix() * this.quantite;
	}
	
	/*--- Accesseurs et mutateus ---*/
	public Produit getProduit() 
	{
		return produit;
	}

	public void setProduit(Produit produit) 
	{
		this.produit = produit;
	}

	public int getStockVirtuel() 
	{
		return stockVirtuel;
	}

	public void setStockVirtuel(int quantite) throws Exception 
	{
		if (this.stockVirtuel < quantite)
		{
			throw new Exception("La quantité de " + this.produit.getNom() + 
					" choisie est supérieure à celle disponible " +
					"(Stock disponible : " + this.stockVirtuel + " ! )");
		}
		else
		{
			this.stockVirtuel -= quantite; //Mise à jour du stock virtuel
		}
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) 
	{
		this.quantite = quantite;
	}

	public double getSousTotal() 
	{
		return sousTotal;
	}

	public void setSousTotal(double sousTotal) 
	{
		this.sousTotal = sousTotal;
	}

	public Panier getPanier() 
	{
		return panier;
	}

	public void setPanier(Panier panier) 
	{
		this.panier = panier;
	}

	/*--- Affichage ---*/
	@Override
	public String toString()
	{
		return "Code produit : PRODN" + this.produit.getCode() + " / Nom produit : " + this.produit.getNom()
				+ " / Prix produit : " + this.produit.getPrix() + " € / Quantité produit : " +
				this.getQuantite() + " / Stock virtuel : " + this.getStockVirtuel() 
				+ " / Sous total : " + this.getSousTotal() + " €";
	}

}
