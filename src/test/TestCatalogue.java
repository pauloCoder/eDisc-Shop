/**
 * 
 */
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
 * Différents types d'assert: 
 * ==========================
 * assertArrayEquals 	: deux tableaux sont ils égaux ?
 * assertEquals			: deux valeurs sont elles égales ?
 *
 * assertTrue			: ce booléen est il vrai ?
 * assertFalse			: ce booléen est il faux ?
 *
 * assertNull			: cette référence est elle nulle ?
 * assertNotNull		: cette référence est elle non nulle ?
 *
 * assertSame			: ces deux objets sont ils bien les mêmes ?
 * assertNotSame		: ces deux objets sont ils bien différents ?
 * 
 * assertThat 			: une condition spécifiée par un "matcher" est elle satifaite ?
 *							(supposition)
 *			Ex 			:  assertThat(leCompte, IsInstanceOf.instanceOf(Compte1.class));
 *						   assertThat(leCompte, IsNull.notNullValue());
 *
 *	Pour plus de détails voir le javadoc de JUnit5 
 *		(https://junit.org/junit5/docs/current/api/overview-summary.html, et pour les assertions :
 *		 https://junit.org/junit5/docs/current/api/org/junit/jupiter/api/Assertions.html)
 */
/**
 * Référence : Docs tests unitaires JUnit.txt 
 * @author Paul KOUASSI
 *
 */
public class TestCatalogue 
{

	/*--- Attributs ---*/
	private static Catalogue leCatalogue = null;
	private Facade facade = null;
	private Produit produit = null;
	Integer posAleatoire = null;
	static Integer nbProduitsCatalogue = null;
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
		facade = new Facade();
		//Position aléatoire d'un produit
		posAleatoire = random.nextInt(nbProduitsCatalogue);
		System.out.println("Choix alétoire de la position d'un produit : position = " 
		+ posAleatoire  + "...");

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	public void tearDown() throws Exception 
	{
		facade = null;
		posAleatoire = null;
		produit = null;
	}
	

	/**
	 * TestCatalogue : Test n°1
	 * Test method for {@link services.Facade#getProduit(int)}.
	 */
	@Test
	public void testGetProduit() 
	{
		//Produit retourné par la façade
		Produit produit = leCatalogue.getProduits().get(posAleatoire);
		assertEquals(produit.getCode(),leCatalogue.getProduits().get(posAleatoire).getCode(),
					 "Les produits ne correspondent pas");
	}

	/**
	 * TestCatalogue : Test n°2
	 * Test method for {@link services.Facade#getNbProduits()}.
	 */
	@Test
	public void testGetNbProduits() 
	{
		//Nombre de produits contenus dans la façade
		int nbProduitsFacade = facade.getNbProduits();
		assertEquals(nbProduitsFacade,nbProduitsCatalogue,"Les quantités ne sont pas égales");
	}
	
	/**
	 * TestCatalogue : Test n°3
	 */
	@Test
	public void testGetPositionInitiale()
	{
		//Produit en position égale au nombre de produits
		produit = facade.getProduit(nbProduitsCatalogue);
		assertEquals(produit.getCode(),leCatalogue.getProduits().get(0).getCode(),"Le produit ne correspond pas à"
					+ " celui en position initiale !");
	}

}
