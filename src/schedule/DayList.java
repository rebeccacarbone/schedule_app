/*
 * Description: Class for creating a DayList objet which contains all the
 * Availability an Employee has for a given day
 */
package schedule;
import java.util.ArrayList;

public class DayList {

    private String day;
    //ArrayList of strings made up of the employee's available times for the given day
    private ArrayList<String> times = new ArrayList<>();

    /**
     * Constructor sets the correct day for the DayList
     * @param newDay 
     */
    public DayList(String newDay) {
        setDay(newDay);
    }

    /**
     * Method for setting the day variable and verifying the input
     * is a proper day
     * @param newDay 
     */
    public void setDay(String newDay) {
        //convert newDay to lower case to ensure mixed case does not
        //mess up the results
        String check = newDay.toLowerCase();
        if(check.equals("monday") || check.equals("tuesday") || 
           check.equals("wednesday") || check.equals("thursday") ||
           check.equals("friday") || check.equals("saturday")) {
            day = newDay;
        }
        else {
            System.out.println("Not a valid input");
        }
    }

    /**
     * Method to add a time to the times ArrayList
     * @param newAvail 
     */
    public void addTime(Availability newAvail) {
        times.add(newAvail.getTime());
    }
    
    /**
     * Returns the day of the given DayList
     * @return 
     */
    public String getDay() {
        return day;
    }

    /**
     * Returns a string made up of the day and each corresponding time
     * @return 
     */
    public String toString() {
        String st = day + ": \n";

        for (int i = 0; i < times.size(); i++) {
            st += times.get(i);
            st += "\n";
        }
        return st;
    }
    
}
