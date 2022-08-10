
/**
 * Class that runs other classes to report on a race.
 *
 * Anna Waldron
 * 5/25/2020
 */
import java.util.Scanner;
import java.lang.Math;
public class ReportDriver
{
    //Main method that uses a while loop to get race information on a max of
    //6 drivers and continues on to the next race if user input is 'y'.
    //creates a Race object and a RaceReport object.
    public static final void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        boolean run = true;
        while(run)
        {
            System.out.println("How many racers? (three is min " +
            "and six is max)");
            int racers = keyboard.nextInt();
            Race currentRace = new Race(racers);
            currentRace.readInTimes();
            currentRace.sortInAscending();
            RaceReport report = new RaceReport(currentRace);
            report.writeReport();
            //testVariableValues();
            System.out.print("Enter another race? (y/n): ");
            String check = keyboard.next();
            System.out.println("\n");
            if(check.equals("n")){
               run = false; 
            }   
        }
    }
    //Void method to track variables of number of racers and race times.
    public void testVariableValues(Race currentRace)
        {
            if(currentRace.getNumOfRacers() <= 6){
                System.out.println("Accurate number of racers, 6 or less.");
            }
            else{
                System.out.println("Number of racers input is incorrect.");
            }
            if(currentRace.getSortedTimes().length <= 6){
                System.out.println("Valid array creation length.");
            }
            else{
                System.out.println("Invalid array creation length.");
            }
        }
}
