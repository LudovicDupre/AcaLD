package JAvanc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Resto {

		public static void main(String[] args) throws IOException{
			
			PrintWriter out = new PrintWriter("order.txt");
				// Assemblage des listes de choix:
				List<String> entre = Arrays.asList("1-Salade","2-soupe","3-Quiche","4-Aucune");
				List<String> plat = Arrays.asList("1-poulet","2-Boeuf","3-Poisson","4-Vegetarien","5-Aucun");
				List<String> acco = Arrays.asList("1-riz","2-pates","3-frite","4-légume","5-Aucun");
				List<String> boiss = Arrays.asList("1-eau plate","2-eau gazeuse","3-soda","4-vin","5-Aucune");
				List<String> dessert = Arrays.asList("1-tarte","2-mousse","3-Tiramisu","4-Aucun");
				// Input et test de l'input de l'utilisateur :
				System.out.println("Combien de menu desirez-vous?");
				Scanner sc = new Scanner(System.in);
				while (sc.hasNextInt() == false) {sc.next();} 
				int nbMenu = sc.nextInt();
				// Initialisation et boucle des menus : 
				for (int i=0 ; i<nbMenu ; i++) {
					List<String> order = new ArrayList<>();

					System.out.println("Début commande "+ (i+1) +". Choisissez une entree :" +entre);
					int entreNb = sc.nextInt();
					if (entre.size()>entreNb ) order.add(entre.get(entreNb-1));

					System.out.println("Choisissez un plat :"+plat);
					int platNb = sc.nextInt();
					if (plat.size()>platNb )  order.add(plat.get(platNb-1));

					System.out.println("Choisissez un accompagnement :"+acco);
					int accoNb = sc.nextInt();
					if (acco.size()>accoNb ) order.add(acco.get(accoNb-1));

					System.out.println("Choisissez une boisson :"+boiss);
					int boissNb = sc.nextInt();
					if (boiss.size()>boissNb ) order.add(boiss.get(boissNb-1));

					System.out.println("Choisissez un dessert :"+dessert);
					int dessertNb = sc.nextInt();
					if (dessert.size()>dessertNb ) order.add(dessert.get(dessertNb-1));
					// Impression puis clear de la commande et saut à la ligne.
					out.println("************Résume de la commande n° " + (i+1) + "**************\n" + String.join("\n", order));
					order.clear();
					System.out.println(); 
				}
				sc.close();
			
			out.close();
		}
}
