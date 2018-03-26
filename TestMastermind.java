package mastermind;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestMastermind {

		Ordinateur ord ;
		List<Couleur> pionsList ; 

		@Before
		public void setUp()  {

			ord = new Ordinateur();
			pionsList = new ArrayList<>();
			pionsList.add(Couleur.R);
			pionsList.add(Couleur.O);
			pionsList.add(Couleur.O);
			pionsList.add(Couleur.J);
		}

		@After
		public void tearDown() {
			ord = null;
			pionsList = null;
		}

		
		@Test(expected =IllegalArgumentException.class) // tester la taille du réponse
		public void stringToCouleurTest1() throws Exception {
			ord.stringToCouleur("ROJ");
		}
		@Test(expected =IllegalArgumentException.class)// tester la validité du réponse
		public void stringToCouleurTest2() throws Exception {
			ord.stringToCouleur("ROOZ");
		}
		@Test
		public void stringToCouleurTest3() throws Exception {
			ord.stringToCouleur("ROOJ");
		}
		@Test
		public void validerReponseTest1() throws Exception {
	
			ord.setPions(pionsList);		
			String reponseUtilisateur = "NBJV";
			ord.stringToCouleur(reponseUtilisateur);
			ord.validerReponse();
			Assert.assertEquals(ord.getNbrPionsJuste(), 0);
			Assert.assertEquals(ord.getNbrPionsCouleurJuste(), 1);
		}

		@Test
		public void validerReponseTest2() throws Exception {
		
			
			ord.setPions(pionsList);
			
			String reponseUtilisateur = "JJOR";
			ord.stringToCouleur(reponseUtilisateur);
			ord.validerReponse();
			Assert.assertEquals(ord.getNbrPionsJuste(), 1);
			Assert.assertEquals(ord.getNbrPionsCouleurJuste(), 2);
		}
		@Test
		public void validerReponseTest3() throws Exception {
		
			
			ord.setPions(pionsList);
			
			String reponseUtilisateur = "RJRO";
			ord.stringToCouleur(reponseUtilisateur);
			ord.validerReponse();
			Assert.assertEquals(ord.getNbrPionsJuste(), 1);
			Assert.assertEquals(ord.getNbrPionsCouleurJuste(), 2);
		}

		@Test
		public void validerReponseTest4() throws Exception {
		
			
			ord.setPions(pionsList);
			
			String reponseUtilisateur = "ORJO";
			ord.stringToCouleur(reponseUtilisateur);
			ord.validerReponse();
			Assert.assertEquals(ord.getNbrPionsJuste(), 0);
			Assert.assertEquals(ord.getNbrPionsCouleurJuste(), 4);
		}

		@Test
		public void validerReponseTest5() throws Exception {
		
			
			ord.setPions(pionsList);
			
			String reponseUtilisateur = "ROOJ";
			ord.stringToCouleur(reponseUtilisateur);
			ord.validerReponse();
			Assert.assertEquals(ord.getNbrPionsJuste(), 4);
			Assert.assertEquals(ord.getNbrPionsCouleurJuste(), 0);
		}




}
