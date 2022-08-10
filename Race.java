
/**
 * Class holding individual races.
 *
 * Anna Waldron 
 * 5/25/2020
 */
import java.util.Scanner;
import java.lang.Math;
public class Race
{
    private int num_of_racers;
    private double[] sortedTimes;
    private double[] unsortedTimes;
    
    //constructor sets integer number for racers.
    public Race(int racers)
    {
        num_of_racers = racers;
    }
    //Void method that uses user input to get times for race and sets an 
    //array that will then be sorted.
    public void readInTimes()
    {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Enter the race times (in seconds)");
            String[] temp = new String[num_of_racers];
            String holder = "";
            holder = keyboard.nextLine();
            temp = holder.split(" ");
            unsortedTimes = new double[num_of_racers];
            for(int i = 0; i < num_of_racers; i++){
                unsortedTimes[i] = Double.parseDouble(temp[i]);
            }
            
    }
    //Void method that sorts an unsorted array from least to greatest.
    public void sortInAscending()
    {
        sortedTimes = new double[num_of_racers];
        for(int i = 0; i < num_of_racers; i++){
            sortedTimes[i] = unsortedTimes[i];
        }
        for(int j = 0; j < num_of_racers; j++){
            for(int m = j+1; m < num_of_racers; m++){
                if((sortedTimes[j] > sortedTimes[m]) && (j != m)){
                    double temp = sortedTimes[m];
                    sortedTimes[m] = sortedTimes[j];
                    sortedTimes[j] = temp;
                }
            }
        }
    }
    //Getter method that returns an array of sorted times.
    public double[] getSortedTimes()
    {
        return sortedTimes;
    }
    //Getter method that returns an integer for the number of racers.
    public int getNumOfRacers()
    {
        return num_of_racers;
    }
}
