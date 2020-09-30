/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedule;

import java.util.ArrayList;

/**
 *
 * @author rebec
 */
public class EmployeeList {
    private ArrayList<Employee> employees = new ArrayList();
    
    public void add(Employee newEmployee) {
        employees.add(newEmployee);
    }
    
    public ArrayList<String> search(String name) {
        ArrayList<String> matches = new ArrayList();
        
        for(Employee curr: employees) {
            if(curr.getName().equals(name)) {
                matches.add(curr.getName());
            }
        }
        return matches;
    }
    
    
}
