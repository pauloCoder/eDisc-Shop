package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({TestCatalogue.class,TestClient.class,TestCommande.class,TestPanier.class})
public class AllTests 
{
	//Regroupement de tests
}
