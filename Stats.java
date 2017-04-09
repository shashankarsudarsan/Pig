
/**
 * A class that implements a simple statistic tracking array
 * @version 1.0
 * @author  Shashankar Sudarsan
 * @since   2017-04-08
 */

public class Stats {

    //private array of size 2
    private int[] Stat = new int[2];

    /**
     * creates an empty array
     */
    public Stats()
    {
        // Nothing to do here
    }

    /**
     * Creates an array with specified values
     * for JUnit testers
     * @param first: assigned to the first cell
     * @param second: assigned to the second cell
     */
    public Stats(int first, int second)
    {
        Stat[0] = first;
        Stat[1] = second;
    }

    /**
     * Calculates the number of games played
     * @return The total number of played games
     */
    public int getTotalGames() {
        return (Stat[0] + Stat[1]);
    }


    public void incrementUserWins() {
        Stat[0]++;
    }


    public void incrementComputerWins() {
        Stat[1]++;
    }

    /**
     *
     * @param choice: depending on the value of choice
     * the corresponding average (percent) is returned:
     * if choice is 0, return the average for a user
     * if choice is 1, return the average for a computer
     * otherwise return -1
     * @return percentage of won games for user/computer depending on the choice
     */
    public float averageGames(int choice)
    {
    	float avg=0;
        if(choice==0){
        	avg = (float)Stat[0]/(Stat[0]+Stat[1]);         	
        }        	
        else if(choice==1){
        	avg = (float)Stat[1]/(Stat[0]+Stat[1]);        
        }
		return 100*avg;  
    }


    public void printStats()
    {
        System.out.println("--- Statistics ---");
        System.out.println("  Computer won: " + averageGames(1) + "%, You won: " + averageGames(0) + "%");
        System.out.println();
    }

    public void reset() {
        Stat[0] = 0;
        Stat[1] = 0;
    }

}

