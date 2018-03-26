package mastermind;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Test {

		Ordinateur ord ;

		@Before
		public void setUp() throws ChaineDeCaracteresNullOuVide {

			ord = new Ordinateur ();
		}

		@After
		public void tearDown() {
			ord = null;
		}

		
		@Test(expected = AuteurDejaExistantDansArticl.class)
		public void ajouterAuteurTest1() throws Exception {
			article.ajouterAuteur(aut);
			article.ajouterAuteur(aut);
		}

		@Test
		public void ajouterAuteurTest2() throws Exception {
			article.ajouterAuteur(aut);
			Assert.assertEquals(article.getAuteurs().size(), 1);
			Assert.assertTrue(article.getAuteurs().indexOf(aut) > -1);
		}
	

}
