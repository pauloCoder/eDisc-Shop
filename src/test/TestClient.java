package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import metier.Client;
import services.Facade;

/**
 * Référence : Docs tests unitaires JUnit.txt 
 * @author Paul KOUASSI
 *
 */
public class TestClient {
	
	/*--- Attribut(s) ---*/
	private Facade facade = null;
	
	/**
	 * Préparation globale avant tous les tests
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	public static void setUpBeforeClass() throws Exception 
	{
		
	}

	/**
	 * Nettoyages globaux après tous les tests
	 * @throws java.lang.Exception
	 */
	@AfterAll
	public static void tearDownAfterClass() throws Exception 
	{
		
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
	}

	/**
	 * TestClient : Test n°1
	 * @return
	 */
	@Test
	public void testCreerClient() 
	{
		Client client = null;
		client = facade.creerClient("KOUASSI", "Yao Paul", "135 rue Véron");
		assertEquals("KOUASSI", client.getNom(),"Les noms sont différents");
		assertEquals("Yao Paul", client.getPrenom(),"Les prénoms sont différents");
		assertEquals("135 rue Véron", client.getAdresse(),"Les adresses sont différentes");
	}

}
