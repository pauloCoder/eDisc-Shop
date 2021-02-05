package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import metier.Catalogue;
import metier.Panier;
import metier.Produit;
import services.Facade;

/**
 * Référence : Docs tests unitaires JUnit.txt 
 * @author Paul KOUASSI
 *
 */

class TestPanier 
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
	static void setUpBeforeClass() throws Exception 
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
	static void tearDownAfterClass() throws Exception 
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
	void setUp() throws Exception 
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
	void tearDown() throws Exception 
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
	void testAjoutDetailPanier() throws Exception 
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
	void testStock() throws Exception
	{
		Produit produit = leCatalogue.getProduits().get(posAleatoire);
		facade.ajoutPanier(produit, 3);
		int stock = produit.getStock() - 3;
		Panier panier = facade.getPanier();
		int stockVirtuel = panier.getArticles().get(0).getStockVirtuel();
		assertEquals(stockVirtuel,stock,"Les stocks ne sont pas égaux");
	}
	
	/**
	 * Test panier : Test n°4
	 */
	@Test
	void testAjoutMultiDetailsPanier()
	{
		fail("Not yet implemented");
	}
	
	/**
	 * Test panier : Test n°5
	 */
	@Test
	void testAjoutNul()
	{
		fail("Not yet implemented");
	}

}
