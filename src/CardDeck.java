import java.security.SecureRandom;
import java.util.Arrays;

/**
 * The Card Deck Class exists to create a deck of cards using the Card object class I created.
 * 
 * @author Elizabeth Fultz
 * @version 3.0
 * Dealing Cards Project
 * Spring 2019
 */

public class CardDeck {
	
	private Card[] cardDeck; //cardDeck will be used to create the deck of 52 cards
	private int currentCard = 0; //currentCard will be used to determine the card that is on top of the deck
	private static final int NUMBER_OF_CARDS = 52; //NUMBER_OF_CARDS will be used to set the number of cards created and put into the deck
	private static final SecureRandom randomNumbers = new SecureRandom(); //randomNumbers will be used to shuffle the cards
	
	/**
	 * This empty argument constructor initializes the cardDeck and creates the cards with a face and suit value
	 */
	public CardDeck() {
		
		cardDeck = new Card[NUMBER_OF_CARDS];
		
		String[] suitArray = {"Hearts", "Spades", "Diamonds", "Clubs"};
		String[] faceArray = {"Ace", "Duce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
		
	    for (int suit = 0; suit < suitArray.length; suit++) {
	        for (int face = 0; face < faceArray.length; face++) {
	            cardDeck[currentCard] = new Card(faceArray[face], suitArray[suit]);
	            currentCard++;
	        }//end face loop
	    }//end suit loop
		
	}//end empty constructor
	
	/**
	 * The shuffle method shuffles the cards in a random order
	 */
	public void shuffle() {
		
		  currentCard = 0;
		
		  for(int first = 0; first < cardDeck.length; first++) {
				
			  int second = randomNumbers.nextInt(NUMBER_OF_CARDS);
				
			  Card hold = cardDeck[first];
			  cardDeck[first] = cardDeck[second];
			  cardDeck [second] = hold;
			  
			}//end loop
		
	}// end shuffle
	
	/**
	 * 
	 * @return the current card on 'top' of the deck
	 */
	public Card deal() {
		
		if(currentCard < cardDeck.length)
			return cardDeck[currentCard++];
		else
			return null;
		
	}//end deal	
	

	/**
	 * @return the cardDeck
	 */
	public Card[] getCardDeck() {

		return cardDeck;
	
	}//end getCardDeck

	/**
	 * @return the value for the currentCard
	 */
	public int getCurrentCard() {
		
		return currentCard;
	
	}//end getCurrentCard

	/**
	 * @return the value of the numberOfCards variable 
	 */
	public static int getNumberOfCards() {
	
		return NUMBER_OF_CARDS;
	
	}// end getNumberOfCards

	/**
	 * @return the randomnumbers
	 */
	public static SecureRandom getRandomNumbers() {
		
		return randomNumbers;
	
	}//end getRandomNumber

	/**
	 * @param cardDeck the array of cardDeck to set
	 */
	public void setCardDeck(Card[] cardDeck) {
		
		this.cardDeck = cardDeck;
	
	}//end setCardDeck

	/**
	 * @param currentCard the value of currentCard to be set
	 */
	public void setCurrentCard(int currentCard) {
		
		if(currentCard >= 0)
			this.currentCard = currentCard;
		else
			this.currentCard = 0;
	}//end setCurrentCard

	@Override
	public String toString() {
		
		return Arrays.toString(cardDeck);
		
	}//end toString

}//end CardDeck class
