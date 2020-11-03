/*
 * Description: Class for tracking an Employee's availability for the 
 * Valencia Campus. Each day of the week has a correspdoning DayList containing
 * their availability.
 */
package schedule;

public class VCList {

    private final String LOCATION = "Valencia Campus";
    //create individual availability lists for each day
    private DayList monday = new DayList("Monday");
    private DayList tuesday = new DayList("Tuesday");
    private DayList wednesday = new DayList("Wednesday");
    private DayList thursday = new DayList("Thursday");
    private DayList friday = new DayList("Friday");
    private DayList saturday = new DayList("Saturday");

    /**
     * Determines the corresponding day for the given Availability object
     * and adds the time to the correct day
     * @param newAvail 
     */
    public void addTime(Availability newAvail) {
        String day = newAvail.getDay();

       /*compare the day attached to the given Availability until a match is found
        then add the availability to the corresponding list*/
        switch (day) {
            case "Monday":
                monday.addTime(newAvail);
                break;
            case "Tuesday":
                tuesday.addTime(newAvail);
                break;
            case "Wednesday":
                wednesday.addTime(newAvail);
                break;
            case "Thursday":
                thursday.addTime(newAvail);
                break;
            case "Friday":
                friday.addTime(newAvail);
                break;
            case "Saturday":
                saturday.addTime(newAvail);

        }
    }
    
    /**
     * Returns a String with the location name and each day's availability 
     * @return 
     */
    public String toString() {
        String st = LOCATION + ": \n";
        st+= monday.toString();
        st+= tuesday.toString();
        st+= wednesday.toString();
        st+= thursday.toString();
        st+= friday.toString();
        st+= saturday.toString();
        return st;
    }
}
