import java.util.ArrayList;
import java.util.Collections;
import java.util.MissingFormatArgumentException;
import java.util.Random;
import java.util.Scanner;

import com.sun.tools.javac.util.Pair;

public class A1_Game_300113347 {

	static Scanner input=new Scanner(System.in);
	public static void wait_for_player() {
		 /*()->None
	    Pauses the program until the user presses enter
	    */
		
		try {
			String in= input.nextLine();
			System.out.println();
		}
		catch (Exception e) {
			;
		}
	}
	
	
	public static ArrayList<String> make_deck() {
		
		 /*()->list of str
        Returns a list of strings representing the playing deck,
        with one queen missing.
        */
		ArrayList <String> deck=new ArrayList<String>();
		String[] suits= {"\u2660", "\u2661", "\u2662", "\u2663"};
		String [] ranks= {"1", "2", "3", "4","5", "6", "7", "8", "9", "J", "Q", "K", "A"};
		
		for (String suit: suits) {
			for (String rank: ranks) {
				
				deck.add(rank+suit);
			}
			
		}
		return deck;
	}
	
	public static void shuffle_deck(ArrayList <String> deck) {
		Collections.shuffle(deck);
	}
	
	
	public static  String[] deal_cards(ArrayList <String> deck) {
		
		ArrayList <String> dealer = new ArrayList <String>();
		ArrayList <String> other= new ArrayList <String> ();
		Pair <ArrayList, ArrayList> choice= Pair.with(dealer, other);
		
		for (int x=0; x<51; x++) {
			
			if (x%2==0) {
				other.add(deck.get(x));
			}
			else {
				dealer.add(deck.get(x));
			}
	
		}
		return 
	}
	public static void main(String[] args) {
		
	}

}
