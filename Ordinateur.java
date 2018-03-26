package mastermind;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Ordinateur {
	public List<Couleur> pions;
	public List<Couleur> reponseUtilisateur;
	public int nbrPionsJuste ; 
	public int nbrPionsCouleurJuste ;
	
	
	public Ordinateur() {
		pions = new ArrayList<>();
		reponseUtilisateur= new ArrayList<>();
		nbrPionsJuste =0; 
		nbrPionsCouleurJuste =0;
	}

	public Couleur randomCouleur() {
	    int pick = new Random().nextInt(Couleur.values().length);
	    return Couleur.values()[pick];
	}
	
	public void choisirPions () {
		for (int i =0;i<4;i++) {
			pions.add(randomCouleur());
		}
	}
	public void stringToCouleur(String string) {
		if (string.length() !=4) {
			throw new IllegalArgumentException("format de reponse invalide");
		}
		for (int i=0 ; i<4;i++) {
			if (string.charAt(i) =='R')
			{
				reponseUtilisateur.add(Couleur.R);
				
			}
			else if (string.charAt(i) =='J')
			{
				reponseUtilisateur.add(Couleur.J);
				
			} 
			else if (string.charAt(i) =='B')
			{
				reponseUtilisateur.add(Couleur.B);
				
			} 
			else if (string.charAt(i) =='O')
			{
				reponseUtilisateur.add(Couleur.O);
				
			} 
			else if (string.charAt(i) =='V')
			{
				reponseUtilisateur.add(Couleur.V);
				
			} 
			else if (string.charAt(i) =='N')
			{
				reponseUtilisateur.add(Couleur.N);
				
			} 
			else {
				throw new IllegalArgumentException("verifier votre réponse \n");
			}
		}
	}

	public void validerReponse() {
		int i ;
		for (i=0 ;i<reponseUtilisateur.size();i++){
			if(reponseUtilisateur.get(i).equals(pions.get(i))) {
				nbrPionsJuste++;
				pions.set(i,null);
				reponseUtilisateur.set(i,null);
			}
			
		}		
		for (int j=0; j<reponseUtilisateur.size();j++){
			if (pions.indexOf(reponseUtilisateur.get(j)) >-1 && reponseUtilisateur.get(j)!=null )   {
			nbrPionsCouleurJuste++;	
			int k = pions.indexOf(reponseUtilisateur.get(j));
			pions.set(k,null);
		}
		
	}
		
		 
}
	public void reinitialiser() {
		reponseUtilisateur.clear();
		nbrPionsJuste = 0;
		nbrPionsCouleurJuste =0;
	}
}