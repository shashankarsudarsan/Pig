
import java.util.*;

class Pig {


    //Counter to maintain the human's score
    private int counterH = 0;

    //Counter to maintain the computer's score
    private int counterC = 0;

    //This variable specifies the minimum score required to win the game
    private int GAME_OVER = 20;

    //Object of Random class to get a random value
    Random rand = new Random();

    //Object of Stats class to maintain statistics
    static Stats stats = new Stats();


    /**
     * This function models the Human's turn. Two dies are rolled in each turn.
     * If both the rolls result in 1, the entire score is reset to 0 and the control is passed to the computer
     * If either of the rolls is 1, the control is passed to the computer
     * If the rolls aren't equal to 1, but are identical, the score is added and the Human is forced to continue
     * If the rolls aren't equal to 1, but aren't identical, the score is added and the Human is asked for his choice between continue and hold
     */
    void  HumanMove(){

        int die1=0,die2=0,turnScore=0,decsn=1;
        Scanner in = new Scanner(System.in);
        System.out.println("**** Your turn starts ****");
        while(decsn==1){        	
	        die1 = rand.nextInt(6)+1;
	        die2 = rand.nextInt(6)+1;
	        System.out.println("Your roll - Die 1: "+die1+" Your roll - Die 2: "+die2);
	        if(die1==1&&die2==1){
	        	turnScore=0;
	        	counterH=0;
	        	break;
	        }
	        else if(die1==1||die2==1){
	        	turnScore=0;
	        	break;
	        }
	        else if(die1==die2){
	        	turnScore = turnScore+die1+die2;
	        	continue;
	        }
	        else{
	        	turnScore = turnScore+die1+die2;
	        	System.out.println("Your score in this turn - "+turnScore);
	        	System.out.println("Enter a number: 1 to continue, 2 to stop/hold");
	        	decsn = in.nextInt();
	        }	        
        }        
    	counterH = counterH + turnScore;
        System.out.println("Your total score in this turn - "+turnScore);
        System.out.println("Overall total score - "+counterH);        
    }


    /**
     * This function models the Computer's turn. Two dies are rolled in each turn.
     * If both the rolls result in 1, the entire score is reset to 0 and the control is passed to the computer
     * If either of the rolls is 1, the control is passed to the computer
     * If the rolls aren't equal to 1, but are identical, the score is added and the Human is forced to continue
     * If the rolls aren't equal to 1, but aren't identical, the score is added and the Human is asked for his choice between coninue and hold
     */
    void  ComputerMove(){

    	int die1=0,die2=0,turnScore=0,decsn=1;
        Scanner in = new Scanner(System.in);
        System.out.println("**** Computer's turn starts ****");
        while(decsn==1){        	
	        die1 = rand.nextInt(6)+1;
	        die2 = rand.nextInt(6)+1;
	        System.out.println("Computer's roll - Die 1: "+die1+" Computer's roll - Die 2: "+die2);
	        if(die1==1&&die2==1){
	        	turnScore=0;
	        	counterC=0;
	        	break;
	        }
	        else if(die1==1||die2==1){
	        	turnScore=0;
	        	break;
	        }
	        else if(die1==die2){
	        	turnScore = turnScore+die1+die2;
	        	counterC = counterC + turnScore;
	        	continue;
	        }
	        else{
	        	turnScore = turnScore+die1+die2;
	        	counterC = counterC + turnScore;
	        	System.out.println("Computer's score in this turn - "+turnScore);	        	
	        	decsn = rand.nextInt(2)+1;
	        }	        
        }
        System.out.println("Computer's total score in this turn - "+turnScore);
        System.out.println("Overall total score - "+counterC);
    }


    /**
     * This method displays the overall scores
     */
    private void getScores()
    {
        System.out.println("-----------------------------------");
        System.out.println("Scores.  You: " + counterH + ", Computer: " + counterC );
        System.out.println("-----------------------------------");
    }

    /**
     * This method models the game by passing control between the human and the computer.
     * Whoever succeeds in scoring at least GAME_OVER number of points first, wins the game.
     * Ensure that Human always starts first
     * @return 1: if the human wins, 2: if the computer wins
     */
    int game() {
    	while(counterH<GAME_OVER && counterC<GAME_OVER){
    		HumanMove();
    		this.getScores();
    		ComputerMove();  
    		this.getScores();
    	}
    	if(counterH>GAME_OVER)
    		return 1;
    	else
    		return 2;
    }

    /**
     * This method is used to reset the Human's score before a new game.
     */
    void resetCounterH()
    {
        counterH = 0;
    }

    /**
     * This method is used to reset the Computer's score before a new game.
     */
    void resetCounterC()
    {
        counterC = 0;
    }

    public static void main(String [] args) {

        Pig pig = new Pig();
        Stats st = new Stats();
        Scanner sc = new Scanner(System.in);
        int ip=0;
        do {
           pig.resetCounterH();
           pig.resetCounterC();
           if(pig.game()==1){
        	   System.out.println("You won this game!");
           	   st.incrementUserWins();
           }
           else{
        	   System.out.println("Computer won this game!");
           	   st.incrementComputerWins();
           }
           st.printStats();
           System.out.println("Do you want to play again? Enter 1 for Yes, 2 for No");
           ip = sc.nextInt();
        } while(ip!=2);
        System.out.println("Thank You for playing!");
        sc.close();        
    }
}
