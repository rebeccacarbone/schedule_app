/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedule;


/**
 * Class representing the list of availability a given Employee has for the
 * Canyon Country campus
 * @author rebec
 */
public class CCList {
    private final String LOCATION = "Canyon Country Campus";
    //initialize individual lists of availability for each day the campus is open 
    private DayList monday = new DayList("Monday");
    private DayList tuesday = new DayList("Tuesday");
    private DayList wednesday = new DayList("Wednesday");
    private DayList thursday = new DayList("Thursday");
    
    /**
     * Method adds an available time to the correct day
     * @param newAvail 
     */
    public void addTime(Availability newAvail) {
        String day = newAvail.getDay();

        /*compare the day attached to the given availability until a match is found
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
        }
    }
    
    /**
     * Returns a string comprised of the availability for each day and the 
     * name of the campus
     * @return 
     */
    public String toString() {
        String st = LOCATION + ": \n";
        st+= monday.toString();
        st+= tuesday.toString();
        st+= wednesday.toString();
        st+= thursday.toString();
        return st;
    }
}
