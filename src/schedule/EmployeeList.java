/*
 * Class to keep track of all Employees and their Availability. Currently
 * utilizing an ArrayList but working toward using a Database.
 */
package schedule;

import java.util.ArrayList;


public class EmployeeList {
    //ArrayList of all employees
    private ArrayList<Employee> employees = new ArrayList();
    
    public void add(Employee newEmployee) {
        employees.add(newEmployee);
    }
  
    
    
}
