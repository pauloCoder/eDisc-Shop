package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import metier.Catalogue;
import metier.Produit;
import services.Facade;

/**
 * Référence : Docs tests unitaires JUnit.txt 
 * @author Paul KOUASSI
 *
 */

public class TestPanier 
{
	/*--- Attribut(s) ---*/
	static Catalogue leCatalogue = null;
	private Facade facade = null;
	Integer posAleatoire = null;
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
		posAleatoire = random.nextInt(nbProduitsCatalogue);
		System.out.println("Récupération d'un position aléatoire pour "
				+ "le produit ("+ posAleatoire +")");
		
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
		System.out.println("Reset de la position...");
		posAleatoire = null;
	}

	/**
	 * Test Panier : Test n°1
	 * @throws Exception 
	 */
	@Test
	public void testAjoutDetailPanier() throws Exception 
	{
		Produit produit = leCatalogue.getProduits().get(posAleatoire);
		facade.ajoutPanier(produit, 3);
		assertEquals(facade.getProduit(posAleatoire).getCode(), produit.getCode(), 
				"Le produit n'a pas été retrouvé");
	}
	
	/**
	 * Test panier : Test n°2
	 * @throws Exception 
	 */
	@Test
	public void testStock() throws Exception
	{
		Produit produit = leCatalogue.getProduits().get(posAleatoire);
		produit.addToStock(1000);
		
		int qteAleatoire = random.nextInt(999) + 1;
		facade.ajoutPanier(produit, qteAleatoire);
		int stock = produit.getStock() - qteAleatoire;
		int stockVirtuel = facade.getPanier().getArticles().get(0).getStockVirtuel();
		assertEquals(stockVirtuel,stock,"Les stocks ne sont pas égaux");
	}
	
	/**
	 * Test panier : Test n°3
	 */
	@Test
	public void testStockException()
	{
		Produit produit = leCatalogue.getProduits().get(posAleatoire);		
		assertThrows(Exception.class,()->facade.ajoutPanier(produit, 1000));
	}
	
	/**
	 * Test panier : Test n°4
	 * @throws Exception 
	 */
	@Test
	public void testAjoutMultiDetailsPanier() throws Exception
	{
		Produit produit = leCatalogue.getProduits().get(posAleatoire);
		produit.addToStock(100);
		
		facade.ajoutPanier(produit, 6);
		facade.ajoutPanier(produit, 25);
		facade.ajoutPanier(produit, 65);
		int qte = 96;
		int qteVirtuel = facade.getPanier().getArticles().get(0).getQuantite();
		assertEquals(qteVirtuel,qte,"Les quantités ne sont pas égales");

	}
	
	/**
	 * Test panier : Test n°5
	 * @throws Exception 
	 */
	@Test
	public void testAjoutNul() throws Exception
	{
		Produit produit = leCatalogue.getProduits().get(posAleatoire);
		produit.addToStock(1000);
		
		int qteAleatoire = random.nextInt(999) + 1;
		facade.ajoutPanier(produit, qteAleatoire);
		facade.ajoutPanier(produit, 0);
		int qteVirtuel = facade.getPanier().getArticles().get(0).getQuantite();
		assertEquals(qteVirtuel,qteAleatoire,"La quantité doit rester inchangée !");

	}

}
