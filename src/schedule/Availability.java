/*
 * Description: Availability class for creating an availability object. Handles
 * input from the excel file and translates it into a day and time which is stored
 * as an availability
 */
package schedule;

public class Availability {

    private String day;
    private String time;

    /**
     * Method for creating a new availability object
     * @param row
     * @param col
     * @return 
     */
    public boolean createNewAvail(int row, int col) {
        boolean validAvail = false;
        if (setDay(col) && setTime(row)) {  //check that setDay() and setTime return true
            validAvail = true; //if both return true, the input is a valid availability
        }
        return validAvail;
    }

    /**
     * Method to set the day of the availability object
     * @param col
     * @return 
     */
    private boolean setDay(int col) {
        boolean isDay = false;
        switch (col) { //check that the column number corresponds to a day
            case 2:
                day = "Monday";
                isDay = true;
                break;
            case 4:
                day = "Tuesday";
                isDay = true;
                break;
            case 6:
                day = "Wednesday";
                isDay = true;
                break;
            case 8:
                day = "Thursday";
                isDay = true;
                break;
            case 10:
                day = "Friday";
                isDay = true;
                break;
            case 12:
                day = "Saturday";
                isDay = true;
        }
        return isDay;
    }

    /**
     * Method to set the time of the availability object
     * @param row
     * @return 
     */
    private boolean setTime(int row) {
        boolean isTime = false;
        if (row >= 7 && row <= 18) { //check that the row number corresponds to a time (Valencia Campus)
            switch (row) {
                case 7:
                    time = "7:45-9:00";
                    isTime = true;
                    break;
                case 8:
                    time = "9:00-10:00";
                    isTime = true;
                    break;
                case 9:
                    time = "10:00-11:00";
                    isTime = true;
                    break;
                case 10:
                    time = "11:00-12:00";
                    isTime = true;
                    break;
                case 11:
                    time = "12:00-1:00";
                    isTime = true;
                    break;
                case 12:
                    time = "1:00-2:00";
                    isTime = true;
                    break;
                case 13:
                    time = "2:00-3:00";
                    isTime = true;
                    break;
                case 14:
                    time = "3:00-4:00";
                    isTime = true;
                    break;
                case 15:
                    time = "4:00-5:00";
                    isTime = true;
                    break;
                case 16:
                    time = "5:00-6:00";
                    isTime = true;
                    break;
                case 17:
                    time = "6:00-7:00";
                    isTime = true;
                    break;
                case 18:
                    time = "7:00-8:00";
                    isTime = true;
            }
        } else if (row >= 23 && row <= 32) { //if the above is not true, check the same for Canyon Country campus
            switch (row) {
                case 23:
                    time = "9:00-10:00";
                    isTime = true;
                    break;
                case 24:
                    time = "10:00-11:00";
                    isTime = true;
                    break;
                case 25:
                    time = "11:00-12:00";
                    isTime = true;
                    break;
                case 26:
                    time = "12:00-1:00";
                    isTime = true;
                    break;
                case 27:
                    time = "1:00-2:00";
                    isTime = true;
                    break;
                case 28:
                    time = "2:00-3:00";
                    isTime = true;
                    break;
                case 29:
                    time = "3:00-4:00";
                    isTime = true;
                    break;
                case 30:
                    time = "4:00-5:00";
                    isTime = true;
                    break;
                case 31:
                    time = "5:00-6:00";
                    isTime = true;
                    break;
                case 32:
                    time = "6:00-7:00";
                    isTime = true;
                    break;
            }
        }
        return isTime;

    }

    /**
     * Returns false if the day and/or time are null
     * @return 
     */
    public boolean isValid() {
        boolean valid = true;
        if (day == null || time == null) { //assume the availability is valid but if not, change to false
            valid = false;
        }
        return valid;
    }

    /**
     * Returns the day attached to the availability object
     * @return 
     */
    public String getDay() {
        return day;
    }

    /**
     * Returns the time attached to the availability object
     * @return 
     */
    public String getTime() {
        return time;
    }

}
