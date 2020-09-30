/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedule;

import java.util.ArrayList;


/**
 * Employee class for creating Employee objects which contain the name,
 * Valencia availability, CC availability
 * @author rebec
 */
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
       boolean add = false; //add tracks if the availability was successfully added
       Availability newAvail = new Availability();
       newAvail.createNewAvail(row, col);
       
       /*if row # is between 7-18 and the availability is valid attempt to 
        add to the Valencia list*/
       if(newAvail.isValid() && (row >= 7 && row <= 18)){
           vcList.addTime(newAvail);
           add = true;
       }
       //otherwise if row # is between 23-32 attempt to add to CC list
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
