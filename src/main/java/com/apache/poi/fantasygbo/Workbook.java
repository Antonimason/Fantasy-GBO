package com.apache.poi.fantasygbo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class Workbook {

    public static void workbook(String player1, String player2, String player3, String contestant1, String contestant2, String contestant3, String contestant4, String contestant5, String contestant6, String contestant7, String contestant8, String contestant9) {
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("FantasyGBO");

            HSSFRow rowhead = sheet.createRow((short) 0);
            rowhead.createCell(0).setCellValue("Player");
            rowhead.createCell(1).setCellValue("Contestant");
            rowhead.createCell(2).setCellValue("Week 1");
            rowhead.createCell(3).setCellValue("Week 2");
            rowhead.createCell(4).setCellValue("Week 3");
            rowhead.createCell(5).setCellValue("Total");
            rowhead.createCell(6).setCellValue("Result");

            HSSFRow row1 = sheet.createRow((short) 1);
            row1.createCell(0).setCellValue(player1);
            row1.createCell(1).setCellValue(contestant1);
            HSSFCell cell1 = row1.createCell(5);
            cell1.setCellFormula("SUM(C2:E2)");
            
            HSSFRow row2 = sheet.createRow((short) 2);
            row2.createCell(0).setCellValue(player1);
            row2.createCell(1).setCellValue(contestant2);
            HSSFCell cell2 = row2.createCell(5);
            cell2.setCellFormula("SUM(C3:E3)");

            HSSFRow row3 = sheet.createRow((short) 3);
            row3.createCell(0).setCellValue(player1);
            row3.createCell(1).setCellValue(contestant3);
            HSSFCell cell3 = row3.createCell(5);
            cell3.setCellFormula("SUM(C4:E4)");

            HSSFRow row4 = sheet.createRow((short) 4);
            row4.createCell(0).setCellValue(player2);
            row4.createCell(1).setCellValue(contestant4);
            HSSFCell cell4 = row4.createCell(5);
            cell4.setCellFormula("SUM(C5:E5)");

            HSSFRow row5 = sheet.createRow((short) 5);
            row5.createCell(0).setCellValue(player2);
            row5.createCell(1).setCellValue(contestant5);
            HSSFCell cell5 = row5.createCell(5);
            cell5.setCellFormula("SUM(C6:E6)");

            HSSFRow row6 = sheet.createRow((short) 6);
            row6.createCell(0).setCellValue(player2);
            row6.createCell(1).setCellValue(contestant6);
            HSSFCell cell6 = row6.createCell(5);
            cell6.setCellFormula("SUM(C7:E7)");

            HSSFRow row7 = sheet.createRow((short) 7);
            row7.createCell(0).setCellValue(player3);
            row7.createCell(1).setCellValue(contestant7);
            HSSFCell cell7 = row7.createCell(5);
            cell7.setCellFormula("SUM(C8:E8)");

            HSSFRow row8 = sheet.createRow((short) 8);
            row8.createCell(0).setCellValue(player3);
            row8.createCell(1).setCellValue(contestant8);
            HSSFCell cell8 = row8.createCell(5);
            cell8.setCellFormula("SUM(C9:E9)");

            HSSFRow row9 = sheet.createRow((short) 9);
            row9.createCell(0).setCellValue(player3);
            row9.createCell(1).setCellValue(contestant9);
            HSSFCell cell9 = row9.createCell(5);
            cell9.setCellFormula("SUM(C10:E10)");

            FileOutputStream fileOut = new FileOutputStream("fantasy.csv");
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            System.out.println("Your csv file has been created");
        } catch (IOException e) {
            System.out.println(e);
        }

    }
    
    public static String getBook(String path) {
        try{
        FileInputStream file = new FileInputStream(new File(path));
        HSSFWorkbook workbook = new HSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
          for (Row row : sheet) {
                // Itera sobre las celdas de la fila actual
                for (Cell cell : row) {
                    // Imprime el contenido de la celda
                    if(cell.equals(row.getCell(6))){
                        break;
                    }else{
                        switch (cell.getCellType()) {
                            case STRING:
                                String cellValue = new String(cell.getStringCellValue());
                                System.out.print(cellValue + "\t");
                                break;
                            case NUMERIC:
                                System.out.print(Double.parseDouble(cell.getNumericCellValue() + "\t"));
                                break;
                            default:
                                System.out.print(" \t");
                        }
                    }
                }
                System.out.println(); // Salto de línea después de cada fila
            }
            
            // Cierra el flujo de entrada
        file.close();
        workbook.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public static String getResult(String path){
        try{
        FileInputStream file = new FileInputStream(new File(path));
        HSSFWorkbook workbook = new HSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
          for (Row row : sheet) {
                // Itera sobre las celdas de la fila actual
                System.out.print(row.getCell(0) + "\t");
                System.out.print(row.getCell(1) + "\t");
                System.out.print(row.getCell(6) + "\t");
                System.out.println(); // Salto de línea después de cada fila
            }
            
            // Cierra el flujo de entrada
        file.close();
        workbook.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public static String modifyBook(String path, String week){
        try{
            Scanner points = new Scanner(System.in);
            int weekNumber;
            switch(week){
                case "week1":
                    weekNumber = 2;
                    break;
                case "week2":
                    weekNumber = 3;
                    break;
                case "week3":
                    weekNumber = 4;
                    break;
                case "result":
                    weekNumber = 6;
                    break;
                default:
                    points.close();
                    return "Sorry, your week is not allowed";
            }
            
            FileInputStream filemodi = new FileInputStream(new File(path));
            HSSFWorkbook workbook = new HSSFWorkbook(filemodi);
            Sheet sheet = workbook.getSheetAt(0);
            
            //Week points
            if(weekNumber >= 2 || weekNumber <= 4){
                for(int i = 1; i <= 9; i++){
                    HSSFRow row = (HSSFRow) sheet.getRow((short) i);
                    int point;
                    do{
                       System.out.println("How many points will you add to " + row.getCell(1));
                       point = points.nextInt();
                       if(point < 0 || point > 5) System.out.println("Sorry, you must enter a number between 0 and 5.");
                    }while(point < 0 || point > 5);
                    row.createCell(weekNumber).setCellValue(point);
                }
                //result points
            }else if(weekNumber == 6){
                for(int i = 1; i <= 9; i++){
                    HSSFRow row = (HSSFRow) sheet.getRow((short) i);
                    int point;
                    do{
                       System.out.println("How many points will you add to " + row.getCell(1));
                       point = points.nextInt();
                       if(point < 0 || point > 15) System.out.println("Sorry, you must enter a number between 0 and 15.");
                    }while(point < 0 || point > 15);
                    row.createCell(weekNumber).setCellValue(point);
                }
            }
            
            filemodi.close();
            points.close();
            FileOutputStream outputStream = new FileOutputStream(path);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
            System.out.println("Points have been added to everyone");
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public static String getWinner(String path){
        try{
        FileInputStream file = new FileInputStream(new File(path));
        HSSFWorkbook workbook = new HSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
        DataFormatter df = new DataFormatter();
          for (Row row : sheet) {
                // Itera sobre las celdas de la fila actual
                Cell cellTotal = evaluator.evaluateInCell(row.getCell(5));
                Cell cellResult = row.getCell(6);
                if(df.formatCellValue(cellTotal).equals(df.formatCellValue(cellResult))){
                    System.out.println("Contestant " + row.getCell(1) + " is the winner, therefore Player " + row.getCell(0) + " won.");
                    break;
                }
        }
            
        file.close();
        workbook.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

}
