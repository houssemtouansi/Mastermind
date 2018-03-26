package mastermind;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InterfaceTextuelle {
	
	public static void main (String[]args) {
		String rep ; 
		List <String> list = new ArrayList<>();
		Ordinateur ordinateur = new Ordinateur();
		ordinateur.choisirPions();	
		
		List <Couleur> liste = new ArrayList<>();
		for (int i = 0 ; i<4 ; i++) {
			liste.add(ordinateur.pions.get(i));}
		System.out.println("J'ai choisi ma combinaison , à vous de devenir ! ,\n"
				+ "les couleur possible sont R,J,B,O,V,N \n" +"|----------------------| \n"
				+"| .... | . | . | 1/10  | \n"+"|----------------------| \n");		
		
		int n=1;
		while(n<=10) {			
			for (int j = 0 ; j<4 ; j++) ordinateur.pions.set(j, liste.get(j));
			Scanner sc = new Scanner(System.in);
			rep = sc.nextLine();
			ordinateur.stringToCouleur(rep);
			ordinateur.validerReponse();
			list.add("| "+rep+" | "+ordinateur.nbrPionsJuste+" | "+ordinateur.nbrPionsCouleurJuste+" | "+n+ " /10 |\n");
			System.out.println("|----------------------| \n");
			for (int k =0 ; k<list.size();k++)
				System.out.println(list.get(k));
			System.out.println("| .... | . | . | " +(n+1) + " /10 |\n");
			System.out.println("|----------------------| \n");
			if(ordinateur.nbrPionsJuste ==4) {
				System.out.println("bravo ! vous avez gagner en " +n+ " tours");
				break;
			}
			ordinateur.reinitialiser();
			n++;		
			
	}
		if (n==11) {
			System.out.println("vous avez perdu :'(");
		}
		
	
}}

