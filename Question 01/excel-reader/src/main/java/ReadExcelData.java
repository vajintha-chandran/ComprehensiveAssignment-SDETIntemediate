import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;

public class ReadExcelData {

    public static void main(String[] args) {
        String excelFilePath = "C:\\Users\\Vajintha C\\Desktop\\Comprehensive Assignment\\Question 01\\Employee Details.xlsx"; // if in root of project

        try (FileInputStream fis = new FileInputStream(new File(excelFilePath));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet("Emp Basic Details");

            if (sheet == null) {
                System.out.println("Sheet not found.");
                return;
            }
            // Iterate through rows
            for (Row row : sheet) {
                // Skip header row
                if (row.getRowNum() == 0) continue;

                // Read cells
                int empNo = (int) row.getCell(0).getNumericCellValue();
                String empName = row.getCell(1).getStringCellValue();
                String empDesignation = row.getCell(2).getStringCellValue();
                double empSalary = row.getCell(3).getNumericCellValue();
                String empDepartment = row.getCell(4).getStringCellValue();

                // Print to console
                System.out.println("EMP No: " + empNo +
                                   ", Name: " + empName +
                                   ", Designation: " + empDesignation +
                                   ", Salary: " + empSalary +
                                   ", Department: " + empDepartment);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

