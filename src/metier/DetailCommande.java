package metier;

/***
 * Classe DétailCommande contenant un produit sélectionné ainsi
 * que sa quantité. La quantité est déduite du stock
 * Classe persistante
 * @author Paul KOUASSI
 *
 */
public class DetailCommande 
{
	/*--- Attributs ---*/
	private Produit produit;
	private int quantite;
	private double sousTotal;
	private Commande commande;
	
	/*--- Constructeur(s) ---*/
	/**
	 * Constructeur permettant de construire une détail commande
	 * à partir d'un détail panier
	 * @param dp : détail panier
	 * @param commande : commande contenant le produit courant
	 * @throws Exception 
	 */
	public DetailCommande(DetailPanier dp) throws Exception  
	{
		this.produit = dp.getProduit();
		if (this.produit.getStock() < dp.getQuantite())
		{
			throw new Exception("La quantité de " + this.produit.getNom() + 
					" choisie est supérieure à celle disponible " +
					"(Stock disponible : " + this.produit.getStock() + " ! )");
		}
		else
		{
			this.quantite = dp.getQuantite();
			this.produit.removeFromStock(dp.getQuantite());  //Mise à jour du stock réel
		}
		this.sousTotal = this.produit.getPrix() * this.quantite;
	}
	
	/*--- Accesseurs et mutateus ---*/
	
	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getSousTotal() {
		return sousTotal;
	}

	public void setSousTotal(double sousTotal) {
		this.sousTotal = sousTotal;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	/*--- Affichage ---*/
	@Override
	public String toString()
	{
		return "Code produit : PRODN" + this.produit.getCode() + " / Nom produit : " + 
				this.produit.getNom() + " / Prix produit : " + this.produit.getPrix() + " € / Quantité produit : " +
				this.getQuantite() + " / Stock : " + this.produit.getStock() 
				+ " / Sous total : " + this.getSousTotal() + " €";
	}
}
