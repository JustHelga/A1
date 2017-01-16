
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

/**
 * The class <b>A1Q4</b> is an implementation of the
 * ``Old Maid'' card game, based on the Python implementation
 * given in ITI1020
 *
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */
public class A1Q4{

	/**
	* Array used to store the full deck of cards,
	*/
	private static String[] deck;

	/**
	* The current number of cards in the full deck of cards
	*/
	private static int sizeDeck;

	/**
	* Array used to store the player's deck of cards
	*/
	private static String[] playerDeck;

	/**
	* The current number of cards in the player's deck of cards
	*/
	private static int sizePlayerDeck;

	/**
	* Array used to store the computer's deck of cards
	*/
	private static String[] computerDeck;

	/**
	* The current number of cards in the computer's deck of cards
	*/
	private static int sizeComputerDeck;


	/**
	* An instance of java.util.Scanner, which will get input from the
	* standard input
	*/
 	private static Scanner sc;

	/**
	* An instance of java.util.Random, to generate random numbers
	*/
 	private static Random generator;

	/** 
     * Constructor of the class. Creates the full deck of cards
     */
 
 	public  A1Q4(){
		
		sc = new Scanner(System.in);
		generator = new Random();

		String[] suits = {"s", "h", "d", "c"};
		String[] ranks = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
		sizeDeck = suits.length*ranks.length - 1;
		deck = new String[sizeDeck];
		int index = 0;
		for(int i =0 ; i < ranks.length; i++){
			for(int j =0 ; j < suits.length; j++){
				if(!(ranks[i]=="Q" && suits[j]=="c")){
					deck[index++]= ranks[i] + " of " + suits[j];
				}
			}
		}
	}

	/** 
     * Waits for user input
     */
	private static void waitForUserInput(){
		sc.nextLine();
	}

	/**
	*  Deals the cards, taking sizeDeck cards out of deck, and deals them
	*  into playerDeck and computerDeck, starting with playerDeck
	*/
	private static void dealCards(){



// REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION


		sizePlayerDeck=0;
		playerDeck=new String[sizeDeck/2+1];
		sizeComputerDeck=0;
		computerDeck=new String[sizeDeck/2];

		int additionalIndex=0;


		for (sizePlayerDeck=0; sizePlayerDeck<playerDeck.length; sizePlayerDeck++){
			ArrayStringsTools.appendItem(playerDeck, sizePlayerDeck, deck[additionalIndex]);
			additionalIndex+=2;

		}

		additionalIndex=1;

		for (sizeComputerDeck=0; sizeComputerDeck<computerDeck.length; sizeComputerDeck++){
			ArrayStringsTools.appendItem(computerDeck, sizeComputerDeck, deck[additionalIndex]);
			additionalIndex+=2;

		}
	}

	/**
	*  Removes all the pairs of cards from the array deckOfCards, that currently
	* contains currentSize cards. deckOfCards is unsorted. It should also not
	* be sorted once the method terminates. 
	*
    *   @param deckOfCards the array of Strings representing the deck of cards
    *   @param currentSize the number of strings in the arrayOfStrings,
    *			stored from arrayOfStrings[0] to arrayOfStrings[currentSize-1] 
    *   @return the number of cards in deckOfCards once the pair are removed
    */
	private static int removePairs(String[] deckOfCards, int currentSize){
	
// REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
		ArrayStringsTools.sortArray(deckOfCards, currentSize);

		for (int i = 0; i < deckOfCards.length - 1; i++) {
			if (deckOfCards[i] == null || deckOfCards[i +  1] == null)
				continue;
			
			if (deckOfCards[i].substring(0, 1).equals(deckOfCards[i + 1].substring(0, 1))) {
				currentSize = ArrayStringsTools.removeItemByIndex(deckOfCards, currentSize, i + 1);
				currentSize = ArrayStringsTools.removeItemByIndex(deckOfCards, currentSize, i);
				i--;
			}
		}
			
		ArrayStringsTools.shuffleArray(deckOfCards, currentSize);
		return currentSize;


	}

	/**
	*  Get a valid index of a card to be removed from computerDeck.
	*	Note: this method does not check that the input is indeed an integer and
	*	will crash if something else is provided.
	*  @return the valid input.
	*/
	private static int getValidInput(){
		

// REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
		sc=new Scanner(System.in);

		System.out.println("I have " + sizeComputerDeck + " cards. If 1 stands for my first card and");
		System.out.println(sizeComputerDeck + " for my last card, which of my cards would you like?");
		int position = 0;
		try {
			position = sc.nextInt();			
		} catch (InputMismatchException e){
			sc.next();
		}
		
		while (!(position>=1 && position<=sizeComputerDeck)){
			System.out.println("Invalid input. Please enter an integer between 1 and "+sizeComputerDeck);
			try {
				position = sc.nextInt();
			} catch (InputMismatchException e){
				sc.next();
			}

		}

		return position;
	}


	/**
	*  The actual game, as per the Python implementation
	*/
	public static void playGame(){

 // REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION

		ArrayStringsTools.shuffleArray(deck, sizeDeck);
		dealCards();
		System.out.println("Hello. My name is Robot and I am the dealer.");
		System.out.println("Welcome to my card game!");
		System.out.println("Your current deck of cards is:\n");
		ArrayStringsTools.printArray(playerDeck, sizePlayerDeck);
		System.out.println("\nDo not worry. I cannot see the order of your cards");

		System.out.println("Now discard all the pairs from your deck. I will do the same.");
		waitForUserInput();

		sizePlayerDeck=removePairs(playerDeck, sizePlayerDeck);
		sizeComputerDeck=removePairs(computerDeck, sizeComputerDeck);

		int roundParity=0;
		while (sizeComputerDeck>0 && sizePlayerDeck>0){
			if (roundParity==0){
				System.out.println("***********************************************************");
				System.out.println("Your turn.");
				System.out.println("\nYour current deck of cards is:\n");

				ArrayStringsTools.printArray(playerDeck, sizePlayerDeck);

				int cardPosition=getValidInput();
				
				if (cardPosition == 1){
					System.out.println("You asked for my "+cardPosition+"st card.");
				}
				else if (cardPosition==2){
					System.out.println("You asked for my "+cardPosition+"nd card.");
				}
				else if (cardPosition==3){
					System.out.println("You asked for my "+cardPosition+"rd card.");
				}
				else{
					System.out.println("You asked for my "+cardPosition+"th card.");
				}
				
				System.out.println("Here it is "+computerDeck[cardPosition-1]);
				ArrayStringsTools.printArray(computerDeck, sizeComputerDeck);

				sizePlayerDeck=ArrayStringsTools.appendItem(playerDeck, sizePlayerDeck, computerDeck[cardPosition-1]);

				System.out.println("\nWith "+computerDeck[cardPosition-1]+" added, your current deck of cards is:");
				ArrayStringsTools.printArray(playerDeck, sizePlayerDeck);

				sizeComputerDeck=ArrayStringsTools.removeItemByIndex(computerDeck, sizeComputerDeck, cardPosition-1);

				sizePlayerDeck=removePairs(playerDeck, sizePlayerDeck);

				System.out.println("And after discarding pairs and shuffling, your deck is:\n");
				ArrayStringsTools.printArray(playerDeck, sizePlayerDeck);

				waitForUserInput();

				roundParity=1;
			}
			
			else{
				System.out.println("***********************************************************");
				System.out.println("My turn.\n");

				Random rand=new Random();
				int cardPosition = 0;
				cardPosition = rand.nextInt(sizePlayerDeck);

				sizeComputerDeck=ArrayStringsTools.appendItem(computerDeck, sizeComputerDeck, playerDeck[cardPosition]);
				sizePlayerDeck=ArrayStringsTools.removeItemByIndex(playerDeck,sizePlayerDeck,cardPosition);
			    sizeComputerDeck= removePairs(computerDeck, sizeComputerDeck);

				if (cardPosition==0) {
					System.out.println("I took your 1st card");
				}
				else if (cardPosition==1){
					System.out.println("I took your 2nd card");
				}
				else if (cardPosition==2){
					System.out.println("I took your 3rd card");
				}
				else{
					System.out.println("I took your "+(cardPosition+1)+"th card");
				}

				waitForUserInput();
				roundParity=0;
			}

		}
		


		
	}


	/**
     * The main method of this program. Creates the game object
     * and calls the playGame method on it.
     * @param args ignored
	 */    

 
	public static void main(String[] args){
	
		A1Q4 game = new A1Q4();		

		game.playGame();
	
		
	}
}