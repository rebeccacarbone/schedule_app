/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedule;

import java.util.ArrayList;

/**
 * Class for creating a DayList object which contains all the availability
 * an employee has for a given day
 * @author rebec
 */
public class DayList {

    private String day;
    //arraylist of strings made up of the employee's available times for the given day
    private ArrayList<String> times = new ArrayList<>();

    /**
     * Constructor sets the correct day for the DayList
     * @param newDay 
     */
    public DayList(String newDay) {
        setDay(newDay);
    }

    /**
     * Method for setting the day variable
     * @param newDay 
     */
    public final void setDay(String newDay) {
        day = newDay;
    }

    /**
     * Method to add a time to the times arraylist
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
