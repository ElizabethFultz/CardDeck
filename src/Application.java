/**
 * The Application Class exists to test the Card class, CardDeck class, and Dealer class. 
 * 
 * @author Elizabeth Fultz
 * @version 2.0
 * Dealing Cards Project
 * Spring 2019
 */

public class Application {

	public static void main(String[] args) {
		
		Dealer dealer = new Dealer();
			for(int count = 0;count < 5; count++) {
				
				dealer.deal();
				
				System.out.println(dealer.toString());
				System.out.println("Your hand has: " + dealer.evaluateHand());
				System.out.println();
				
			}//end loop
				
	}//end main

}//end Application class
