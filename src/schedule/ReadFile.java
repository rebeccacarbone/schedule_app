package schedule;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;

/**
 *
 * @author rebec
 */
public class ReadFile {

    static EmployeeList employees = new EmployeeList();
    //create the Employee for the Excel file to be read
    static Employee employee = new Employee();
    //create HSSFRow for reading excel file
    static HSSFRow row;

    public static void readSchedule() throws FileNotFoundException, IOException {
        //create reference to the excel file - need to change later for use on other computers
        FileInputStream fis = new FileInputStream(new File("Availability Form.xls"));

        //create excel workbook and spreadsheet from the workbook
        HSSFWorkbook workbook = new HSSFWorkbook(fis);
        HSSFSheet spreadsheet = workbook.getSheetAt(0);
        //initialize row iterator to move through the file, start at row 0
        Iterator< Row> rowIterator = spreadsheet.iterator();
        row = spreadsheet.getRow(0);
        //keep count of the row #
        int rowCount = 0;

        //loop through entire excel file
        while (rowIterator.hasNext()) {
            //move to next row
            row = (HSSFRow) rowIterator.next();
            //create cell iterator to move through each cell in a row
            Iterator< Cell> cellIterator = row.cellIterator();
            //keep count of the column #, but needs to reset after each row
            int colCount = 0;

            //loop through entire row
            while (cellIterator.hasNext()) {
                //start at first cell
                Cell cell = cellIterator.next();

                //check the cell type and perform appropriate operations
                if (cell.getCellType() == CellType.STRING) {
                    String temp = cell.getStringCellValue();
                    //check if the String in the cell is a name
                    if (!checkName(temp)) {
                        //if not a name, check if it's a time
                        checkTime(temp, rowCount, colCount);
                    }
                }
                colCount++;
            }
            rowCount++;
            System.out.println();
        }
        //close the file
        fis.close();

        System.out.println(employee.toString());
    }

    /**
     * Method checks if the cell contains a name, if so it creates a new
     * employee object with given name
     * @param temp
     * @return 
     */
    public static boolean checkName(String temp) {
        boolean name = false;
        //ensure length > 4 so it doesn't throw an error
        //then check if the cell starts with "Name"
        if (temp.length() > 4 && temp.substring(0, 4).equals("Name")) {
            name = true;
            //set employee name after cutting off "Name: " part of cell
            employee.setName(temp.substring(6));
        }
        
        return name;
    }

    /**
     * Method checks if the cell contains a time, if so it adds the time
     * to the employee object
     * @param cell
     * @param row
     * @param col
     * @return 
     */
    public static boolean checkTime(String cell, int row, int col) {
        boolean isTime = false;
        //check if the employee has entered A for available, and check that row #
        //correspond to proper place in the excel file
        if (cell.equalsIgnoreCase("A") && (row >= 7 && row <= 18) || 
                (row >= 23 && row <= 32) && (col >= 2 && col <= 12)) {
            //set isTime to the return value of addAvail to ensure it is properly added
            isTime = employee.addAvail(row, col);
        }
        return isTime;
    }

}
