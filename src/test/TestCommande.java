package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import metier.Catalogue;
import metier.Commande;
import metier.Produit;
import services.Facade;


/**
 * Référence : Docs tests unitaires JUnit.txt 
 * @author Paul KOUASSI
 *
 */
public class TestCommande 
{

	/*--- Attribut(s) ---*/
	static Catalogue leCatalogue = null;
	private Facade facade = null;
	private Commande commande = null;
	static Integer nbProduitsCatalogue;
	Random random = new Random();

	/**
	 * Préparation globale avant tous les tests
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	public static void setUpBeforeClass() throws Exception 
	{
		System.out.println("Initialisation avant les tests...");
		System.out.println("Chargement du catalogue...");
		leCatalogue = Catalogue.getInstance();
		System.out.println("Récupération du nombre total de produits...");
		nbProduitsCatalogue = leCatalogue.getNbProduits();
	}

	/**
	 * Nettoyages globaux après tous les tests
	 * @throws java.lang.Exception
	 */
	@AfterAll
	public static void tearDownAfterClass() throws Exception 
	{
		leCatalogue = null;
		nbProduitsCatalogue = null;
		System.out.println("Libération de la mémoire...");
		System.out.println("Fin des tests...");
	}

	/**
	 * Configuration avant chaque test
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception 
	{
		System.out.println("Création d'une nouvelle facade...");
		facade = new Facade();

		System.out.println("Création et remplissage d'un panier...");
		for (Produit produit : leCatalogue.getProduits())
		{
			//Choix aléatoire des produits à ajouter au panier
			if (random.nextBoolean())
			{
				int qteAleatoire = random.nextInt(10000);
				produit.addToStock(qteAleatoire);
				System.out.println("Stock de " + produit.getNom() + " : " + produit.getStock());
				facade.ajoutPanier(produit, random.nextInt(qteAleatoire));
			}
		}

	}

	/**
	 * Configuration après chaque test
	 * @throws java.lang.Exception
	 */
	@AfterEach
	public void tearDown() throws Exception 
	{
		System.out.println("Suppression de la facade...");
		facade = null;
		System.out.println("Suppression de la commande...");
		commande = null;
	}

	/**
	 * TestCommande : Test n°1
	 * @throws Exception 
	 */
	@Test
	public void testNbDetailsCommande() throws Exception 
	{
		///Transformation des détails panier en détails commande
		facade.creerClient("KOUASSI", "Yao Paul", "135 rue Véron");
		commande = facade.passerCommande();

		///Vérification
		assertEquals(facade.getPanier().getArticles().size(),commande.getDetails().size(),
				"il faut autant de produits dans le panier que dans la commande");
	}

	/**
	 * TestCommande : Test n°2
	 * @throws Exception 
	 */
	@Test
	public void testMontanteCommande() throws Exception 
	{
		///Transformation des détails panier en détails commande
		facade.creerClient("KOUASSI", "Yao Paul", "135 rue Véron");
		commande = facade.passerCommande();

		///Vérification
		assertEquals(facade.getPanier().getMontantTotal(),commande.getMontant(),
				"Le montant total de la commande ne correspond pas à celui du panier");

	}
}
