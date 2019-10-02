/**
 * This class exists to create a cards with a face and suit value. 
 * 
 * @author Elizabeth Fultz
 * @version 1.0
 * Dealing Cards Project
 * Spring 2019
 */

public class Card {
	
	private final String face; //this will be used to create a place for a face value in the card object
	private final String suit; //this will be used to create a place for a suit value in the card object
	
	/**
	 * 
	 * @param face the value of face based on the calling method
	 * @param suit the value of suit based on the calling method
	 */
	public Card(String face, String suit) {	
		
		this.face = face; 
		this.suit = suit;
		
	}//end constructor
	
	/**
	 * 
	 * @return the current face value
	 */
	public String getFace() {
		
		return face;
		
	}//end getFace
	
	/**
	 * 	
	 * @return the current suit value
	 */
	public String getSuit() {
		
		return suit;
		
	}//end getSuit

	@Override
	public String toString() {
	 
		return  face + " of " + suit;
		
	}//end toString

}//end Class
