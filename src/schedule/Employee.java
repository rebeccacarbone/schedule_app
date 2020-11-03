/**
 * Description: Employee class for creating Employee objects which contain the name
 * and Availability lists for each campus. 
 * @author rebec
 */
package schedule;

import java.util.ArrayList;

public class Employee {
   private String name;
   private VCList vcList = new VCList();
   private CCList ccList = new CCList();
   
   /**
    * Set name of Employee
    * @param newName 
    */
   public void setName(String newName) {
       name = newName;
   }
   
   /**
    * Returns String with the Employee name
    * @return 
    */
   public String getName() {
       return name;
   }
   
   /**
    * Uses row and column numbers to add a new availability for the employee
    * by checking which campus the numbers correspond to and calling appropriate
    * methods
    * @param row
    * @param col
    * @return 
    */
   public boolean addAvail(int row, int col) {
       boolean add = false; //tracks if the availability was successfully added
       Availability newAvail = new Availability();
       /*createNewAvail(row,col) determines whether the given row and column
       values match expected input from the excel availability sheet. if not
       a new availability will not be created
       */
       newAvail.createNewAvail(row, col); 
       
       /*row # between 7-18 corresponds to Valencia Campus on the excel sheet
       if createNewAvail() was successful (in which case isValid() returns true)
       then the input is valid and a new time can be added to the VCList*/
       if(newAvail.isValid() && (row >= 7 && row <= 18)){
           vcList.addTime(newAvail);
           add = true;
       }
       /*otherwise, rows 23-32 correspond to Canyon Country and the same steps
       shall be taken to attempt to add a time to the CCList*/
       else if (newAvail.isValid() && (row >= 23 && row <= 32)) {
           ccList.addTime(newAvail);
           add = true;
       }
       return add;
   }
   
   /**
    * Returns a String comprised of the Employee's name and their availability
    * for each campus
    * @return 
    */
   public String toString() {
       String st = name + "\n";
       st+= vcList.toString();
       st+= ccList.toString();
       return st;
   }

   
   

    
}
