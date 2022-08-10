
/**
 * Class to report on a race.
 *
 * Anna Waldron
 * 5/25/2020
 */
public class RaceReport
{
    private Race currentRace;

    //constructor which takes a Race object and stores it as its variable.
    public RaceReport(Race given_race)
    {
        currentRace = given_race;
    }
    //Void method that prints out statistic froms the race.  Calls other 
    //helper methods for finding the statistics and printing out the array.
    public void writeReport()
    {
        System.out.print("Sorted race times...");
        printArray(currentRace.getSortedTimes());
        System.out.print("First place (time in seconds): ");
        System.out.println(currentRace.getSortedTimes()[0]);
        System.out.print("Second place (time in seconds): ");
        System.out.println(currentRace.getSortedTimes()[1]);
        System.out.print("Third place (time in seconds): ");
        System.out.println(currentRace.getSortedTimes()[2] + "\n");
        checkDuplicates();
        System.out.print("The range of the race times (in seconds): ");
        System.out.printf("%.3f\n", getRange());
        System.out.print("The average time of all racers (in seconds): ");
        System.out.printf("%.3f\n", getAverage());
        System.out.print("The average time of the top three racers ");
        System.out.print("(in seconds): ");
        System.out.printf("%.3f\n\n", getAverageTopRacers());
    }
    //Void method which checks whether multiple racers tied for first place
    //and uses if statements to decide wether to print out the ties.
    public void checkDuplicates()
    {
        double first_place = currentRace.getSortedTimes()[0];
        int duplicates = 0;
        for(int i = 1; i < currentRace.getNumOfRacers(); i++){
            if(currentRace.getSortedTimes()[i] == first_place){
                duplicates += 1;
            }
        }
        if(duplicates > 0){
            if(duplicates == 1){
                System.out.println("Two racers shared first place.");
            }
            else if(duplicates == 2){
                System.out.println("Three racers shared first place.");
            }
            else if(duplicates >= 3)
            {
                System.out.println("More than three racers shared " + 
                "first place.");
            }
        }
    }
    //Method to get the range of race times that returns a double for the
    //range.
    public double getRange()
    {
        double range = 0;
        int end = currentRace.getNumOfRacers();
        range = currentRace.getSortedTimes()[end - 1] - 
        currentRace.getSortedTimes()[0];
        return range;
    }
    //Method to get the average times for the top 3 racers and returns a 
    //double of that value.
    public double getAverageTopRacers()
    {
        double average = 0;
        average += currentRace.getSortedTimes()[0] + 
        currentRace.getSortedTimes()[1] + currentRace.getSortedTimes()[2];
        average = average / 3;
        return average;
    }
    //Void method which takes a double array and prints out the values
    //seperated by a white space.
    public void printArray(double[] sorted_array)
    {
        int length = currentRace.getNumOfRacers();
        for(int i = 0; i < length; i++){
            System.out.print(sorted_array[i] + " ");
        }
        System.out.print("\n");
    }
    //Method to find the average of all racers and returns the value as a 
    //double.
    public double getAverage()
    {
        double average = 0;
        int total_racers = currentRace.getNumOfRacers();
        double[] temp = currentRace.getSortedTimes();
        for(int i = 0; i < temp.length; i++){
            average += temp[i];
        }
        average = average / total_racers;
        return average;
    }
}
