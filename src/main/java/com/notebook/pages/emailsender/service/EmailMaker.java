package com.notebook.pages.emailsender.service;

import com.notebook.pages.emailsender.entity.Email;
import com.notebook.pages.emailsender.entity.Receiver;
import com.notebook.pages.emailsender.exception.NotValidException;

import java.io.*;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.ss.usermodel.Row;


public class EmailMaker
{
/* extracting data from excel */
private static void extractingDataFromExcel(List<Email> emails,File inputFile)
{
        try
        {
            FileInputStream file = new FileInputStream(inputFile);

            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext())
            {
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                emails.add(new Email(
                null,  //sender we already set sender
                new Receiver(row.getCell(0).getStringCellValue(),row.getCell(1).getStringCellValue(),row.getCell(2).getStringCellValue()),
                row.getCell(3).getStringCellValue(), //email subject
                row.getCell(4).getStringCellValue(),  //email body
                null // attachements
                ));
            }
            file.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
}
/* --------------------------- */
  public static List<Email> makeEmailFromExcelFile(File file)throws NotValidException
  {
    List<Email> emails=new LinkedList<Email>();
    if(!file.getName().trim().endsWith(".xls") && !file.getName().trim().endsWith(".xlsx"))
    {
      throw new NotValidException("Excel file is required ");
    }
    extractingDataFromExcel(emails,file);
    return emails;
  }
}
