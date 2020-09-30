/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedule;


/**
 * Class for creating an Employee's availability for the Valencia campus
 * @author rebec
 */
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
     * Method adds the given time to the proper DayList
     * @param newAvail 
     */
    public void addTime(Availability newAvail) {
        String day = newAvail.getDay();

        /*compare the day of the given availbility to each day the campus is open
        and add to proper list*/
        
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
