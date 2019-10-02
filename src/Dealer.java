import java.util.Arrays;

/**
 * The Dealer class exists to deal the cards and then check the hand for any valid poker hands
 * 
 * @author Elizabeth Fultz
 * @version 4.0
 * Dealing Cards Project
 * Spring 2019
 */

public class Dealer {
	
	private Card[] hand; //hand will be used to represent the hand that a player is delt
	private CardDeck cardDeck; //cardDeck will be used as the deck that holds the cards
	private int[] suits; //suits counts the suit values in the hand
	private int[] faces; //faces counts the face values in the hand
	
	/**
	 * This empty argument constructor initializes the cardDeck, suits and faces arrays, and shuffles the deck
	 */
	public Dealer() {
		
		cardDeck = new CardDeck();
		cardDeck.shuffle();
			
		suits = new int[5];
		faces = new int[5];
		
	}//end empty constructor
	
	/**
	 * This method resets the suits and faces counters and deals the hand array 5 cards
	 */
	public void deal() {
		
		resetCounters();
		
		hand = new Card[5];
		for(int cards = 0; cards < hand.length; cards++)
			hand[cards] = cardDeck.deal();
		
	}//end deal
	
	/**
	 * This method evaluates the cards in the hand array to check if there are any matches with the poker hands provided  
	 * @return the final value of evaluations
	 */
	public String evaluateHand() {
		
		for(int count = 0; count < hand.length; count++) {
			
			Card card = hand[count];
			
			switch (card.getSuit()) {
			case "Hearts":
				suits[count] = 1;
				break;
			case "Spades":
				suits[count] = 2;
				break;
			case "Diamonds":
				suits[count] = 3;
				break;
			case "Clubs":
				suits[count] = 4;
				break;
			default:
				suits[count] = 0;
				
			}//end suits switch
			
			switch (card.getFace()) {
			case "Ace":
				faces[count] = 1;
				break;
			case "Duce":
				faces[count] = 2;
				break;
			case "Three":
				faces[count] = 3;
				break;
			case "Four":
				faces[count] = 4;
				break;
			case "Five":
				faces[count] = 5;
				break;
			case "Six":
				faces[count] = 6;
				break;
			case "Seven":
				faces[count] = 7;
				break;
			case "Eight":
				faces[count] = 8;
				break;
			case "Nine":
				faces[count] = 9;
				break;
			case "Ten":
				faces[count] = 10;
				break;
			case "Jack":
				faces[count] = 11;
				break;
			case "Queen":
				faces[count] = 12;
				break;
			case "King":
				faces[count] = 13;
				break;
			default:
				faces[count] = 0;
				
			}//end face switch
			
		}//end loop
			
		Arrays.sort(suits);
		Arrays.sort(faces);
		
		String evaluations = "";
		if(pair() == true)
			evaluations = "a pair";
		
		if(twoPair() == true)
			evaluations = "two pair";
	
		if(threeOfKind() == true)
			evaluations = "three of a kind";
		
		if(fourOfKind() == true)
			evaluations = "four of a kind";
		
		if(flush() == true)
			evaluations = "a flush";
		
		if(stright() == true)
			evaluations = "a stright";
		
		if(fullHouse() == true)
			evaluations = "a full house";
		
		return evaluations;
		
	}//end evaluateHand
	
	/**
	 * 
	 * @return true if the hand contains a pair
	 */
	private boolean pair() {
		
		if(faces[0] == faces[1]
			|| faces[1] == faces[2]
			|| faces[2] == faces[3]
			|| faces[3] == faces[4])
			
			return true;
		else
			return false;
		
	}// end pair
	
	/**
	 * 
	 * @return true if the hand contains two pair
	 */
	private boolean twoPair() {
		
		if(faces[0] == faces[1]
			&& faces[2] == faces[3])
			return true;
		
		else if(faces[1] == faces[2]
				&& faces[3] == faces[4])
				return true;
		
			else if (faces[0] == faces[1]
					&& faces[3] == faces[4])
					return true;
				else 
					return false;
		
	}// end twoPair
	
	/**
	 * 
	 * @return true if the hand contains three of a kind
	 */
	private boolean threeOfKind() {
		
		if(faces[0] == faces[1]
			&& faces[1] == faces[2])
			return true;
		
		else if(faces[1] == faces[2]
				&& faces[2] == faces[3])
				return true;
		
			else if (faces[2] == faces[3]
					&& faces[3] == faces[4])
					return true;
		
				else 
					return false;
		
	}// end threeOfKind
	
	/**
	 * 
	 * @return true if the hand contains four of a kind
	 */
	private boolean fourOfKind() {
		
		if(faces[0] == faces[1]
			&& faces[1] == faces[2]
			&& faces[2] == faces[3])
			return true;
		
		else if(faces[1] == faces[2]
				&& faces[2] == faces[3]
				&& faces[3] == faces[4])
				return true;
		
			else 
				return false;
		
	}// end fourOfKind
	
	/**
	 * 
	 * @return true if the hand contains a flush
	 */
	private boolean flush() {
	
		if (suits[0] == suits[1] 
			&& suits[1] == suits[2]
            && suits[2] == suits[3]
            && suits[3] == suits[4])
			return true;
		
		else
			return false;
				
	}// end flush
	
	/**
	 * 
	 * @return true if the hand contains a stright
	 */
	private boolean stright() {
		
		if(faces[0] + 1 == faces[1]
			&& faces[1] + 1 == faces[2]
			&& faces[2] + 1 == faces[3]
			&& faces[3] + 1 == faces[4])
			return true;
		
		else
			return false;
		
	}// end stright

	/**
	 * 
	 * @return true if the hand contains a full house
	 */
	private boolean fullHouse() {
		
		if(faces[0] == faces[1]
			&& faces[2] == faces[3]
			&& faces[3] == faces[4])
					return true;
		else if(faces[3] == faces[4]
				&& faces[0] == faces[1]
				&& faces[1] == faces[2])
					return true;
		
			else
				return false;					
		
	}// end fullHouse
	
	/**
	 * This method resets the suits and face counters so that all values equal 0
	 */
	private void resetCounters() {
		
		for(int count = 0; count < 5; count++) {
			suits[count] = 0;
			faces[count] = 0;
		}//end loop
		
	}// end resetCounters
		
	/**
	 * @return the hand array
	 */
	public Card[] getHand() {
	
		return hand;
	
	}//end getHand

	/**
	 * @return the cardDeck
	 */
	public CardDeck getCardDeck() {
		
		return cardDeck;
	
	}//end getCardDeck

	/**
	 * @return the suits array
	 */
	public int[] getSuits() {
		
		return suits;
	
	}//end getSuits

	/**
	 * @return the faces array
	 */
	public int[] getFaces() {
	
		return faces;
	
	}//end getFaces

	/**
	 * @param hand the array hard is to be set to
	 */
	public void setHand(Card[] hand) {
	
		this.hand = hand;
	
	}//end setHand

	/**
	 * @param cardDeck the cardDeck to set
	 */
	public void setCardDeck(CardDeck cardDeck) {
	
		this.cardDeck = cardDeck;
	
	}//end setCardDeck

	/**
	 * @param suits the array suits is to be set to
	 */
	public void setSuits(int[] suits) {
	
		this.suits = suits;
	
	}//end setSuits

	/**
	 * @param faces the array faces is to be set to
	 */
	public void setFaces(int[] faces) {
	
		this.faces = faces;
	
	}//end setFaces

	@Override
	public String toString() {
		
		return "Hand = " + Arrays.toString(hand);
		
	}//end toString
	
}//end Dealer class
