package metier;
/***
 * Classe Produit contenant les différentes informations 
 * concernant le produit
 * Classe persistante
 * @author Paul KOUASSI
 *
 */
public class Produit 
{
	/*---Attributs---*/
	private static int compteur;
	private int code;
	private String nom;
	private double prix;
	private String description;
	private int stock;
	private String imageUrl;
	
	/*---Constructeurs---*/
	
	/**
	 * @param code : numéro de code du produit
	 * @param stock : quantité en stock du produit
	 * @param prix : prix du produit
	 * @param nom : nom du produit
	 * @param imageUrl : url de l'image du produit
	 * @param description : description du produit
	 */
	
	public Produit(int code , String nom, double prix,  int stock, String description , String imageUrl) 
	{
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.stock = stock;
		this.description = description;
		this.imageUrl = imageUrl;
	}
	
	public Produit(String nom, double prix,  int stock, String description , String imageUrl) 
	{
		this.code = ++compteur;
		this.nom = nom;
		this.prix = prix;
		this.stock = stock;
		this.description = description;
		this.imageUrl = imageUrl;
	}
	
	public Produit(String nom, double prix,  int stock, String description) 
	{
		this.code = ++compteur;
		this.nom = nom;
		this.prix = prix;
		this.stock = stock;
		this.description = description;
		this.imageUrl = null;
	}
	

	
	/*---Acceseurs et mutateurs des attributs---*/
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	/*--- Méthodes ---*/
	/**
	 * Méthode permettant de retirer une quantité de produit
	 * au stock
	 * @param quantite : quantité à retirer
	 * @throws Exception 
	 */
	public void removeFromStock(int quantite) throws Exception
	{
		if (this.getStock() < quantite)
		{
			throw new Exception("La quantité de " + this.getNom() + 
					" choisie est supérieure à celle disponible " +
					"(Stock disponible : " + this.getStock() + " ! )");
		}
		else
		{
			//Mis à jour du stock de produit
			this.setStock(this.getStock() - quantite);
		}
	}
	
	/**
	 * Méthode permettant d'ajouter une quantité de produit 
	 * au stock
	 * @param quantite : quantité à ajouter
	 */
	public void addToStock(int quantite)
	{
		this.setStock(this.getCode() + quantite);
	}
	
	/*---Affichage---*/ 
	@Override
	public String toString()
	{
		return "Code produit : PRODN" + this.code + " / Nom produit : " + this.nom
				+ " / Prix produit : " + this.prix + " € / Stock produit : " +
				this.stock + " / Descriptif produit : " + this.description + 
				" / Url image : " + this.imageUrl;
	}
	
}
