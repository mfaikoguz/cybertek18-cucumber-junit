package com.cybertek.test;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelWrite {
    public static void main(String[] args) throws Exception {
        XSSFWorkbook workbook;
        XSSFSheet sheet;
        XSSFRow row;
        XSSFCell cell;

        String path = "src/SampleData.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);

        // workbook > sheet > row > cell

        // loading excel workbook into class
        workbook = new XSSFWorkbook(fileInputStream);

        // get our sheet
        sheet = workbook.getSheet("Employees");

        // King's row
        row = sheet.getRow(1);

        // King's cell
        cell = row.getCell(1);

        // storing adam's name cell if you are frequently using it
        XSSFCell adamsCell = sheet.getRow(2).getCell(0);
        System.out.println("Before: " + adamsCell);

        adamsCell.setCellValue("Madam");
        System.out.println("After: " + adamsCell);


        //TODO: CHANGE STEVEN'S NAME TO TOM
        for (int rowNum = 0; rowNum < sheet.getPhysicalNumberOfRows(); rowNum++) {
            if (sheet.getRow(rowNum).getCell(0).toString().equals("Steven")) {
                sheet.getRow(rowNum).getCell(0).setCellValue("Tom");
            }
        }

        //TODO: CHANGE NEENA'S JOB_ID TO DEVELOPER
        for (int rowNum = 0; rowNum < sheet.getPhysicalNumberOfRows(); rowNum++) {
            if (sheet.getRow(rowNum).getCell(0).toString().equals("Neena")) {
                sheet.getRow(rowNum).getCell(2).setCellValue("Developer");
            }
        }


        // create a fileOutputStream to specify which file we are writing to
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

        // closes all at the end
        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();


    }
}
