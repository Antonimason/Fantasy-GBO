package com.apache.poi.fantasygbo;


import java.util.Scanner;

public class FantasyGBO {
    
    //MAIN MENU
    public static String Start(){
        System.out.println("Press \n 1 - Add Player and Contestants \n 2 - Add weekly points \n 3 - Check prediction \n 4 - check result \n 5 - Check the winner \n 6 - Exit");
        Scanner playerSelection = new Scanner(System.in);
        String starting = playerSelection.nextLine();
        playerSelection.close();
        return starting;
    }
    
    //POINTS MENU
    public static String weekElection() {
        System.out.println("Press \n 1 - to add points in the week  \n 2 - to add points in the week 2 \n 3 - to add points in the week 3 \n 4 - to add points in the result list \n  5 - Exit");
        Scanner weekSelection = new Scanner(System.in);
        String week = weekSelection.nextLine();
        weekSelection.close();
        return week;
    }
    public static void main(String[] args) {
       
        boolean trigger = false;
        String name1;
        String contestant1;
        String contestant2;
        String contestant3;
        String contestant4;
        String contestant5;
        String contestant6;
        String contestant7;
        String contestant8;
        String contestant9;
                
        while(trigger == false){
        String menu = Start();
        
        switch(menu){
        case "1":
            System.out.println("You choose to add a player");
            try{ 
                Scanner playerName = new Scanner(System.in);
                System.out.println("Give me a name of the first player");
                name1 = playerName.nextLine();
                System.out.println("Give me a name of 3 contestant");
                contestant1 = playerName.nextLine();
                contestant2 = playerName.nextLine();
                contestant3 = playerName.nextLine();
                System.out.println("Give me a name of the second player");
                String name2 = playerName.nextLine();
                System.out.println("Give me a name of 3 the contestant");
                contestant4 = playerName.nextLine();
                contestant5 = playerName.nextLine();
                contestant6 = playerName.nextLine();
                System.out.println("Give me a name of the third player");
                String name3 = playerName.nextLine();
                System.out.println("Give me a name of 3 the contestant");
                contestant7 = playerName.nextLine();
                contestant8 = playerName.nextLine();
                contestant9 = playerName.nextLine();

                System.out.println("Players and Contestants have been added to the list");
                Workbook.workbook(name1, name2, name3, contestant1, contestant2, contestant3, contestant4, contestant5, contestant6, contestant7, contestant8, contestant9);
                playerName.close();
                break;
            }catch(Exception e){
                System.out.println(e);
            }
        case "2":
            try{
                String week = weekElection();
                switch(week){
                    case "1":
                        Workbook.modifyBook("fantasy.csv","week1");
                        break;
                    case "2":
                        Workbook.modifyBook("fantasy.csv","week2");
                        break;
                    case "3":
                        Workbook.modifyBook("fantasy.csv","week3");
                        break;
                    case "4":
                        Workbook.modifyBook("fantasy.csv","result");
                        break;
                    case "5":
                        Start();
                        break;
                    default:
                        System.out.println("You must press a number between 1 - 5");
                        weekElection();
                }
            }catch(Exception e){
                System.out.println(e);
            }
        case "3":
            try{
               Workbook.getBook("fantasy.csv");
            }catch(Exception e){
                System.out.println(e);
            };
            break;
        case "4":
            System.out.println("Here is the result list");
            try{
               Workbook.getResult("fantasy.csv");
            break;
            }catch(Exception e){
                System.out.println(e);
            }
        case "5":
            try{
                Workbook.getWinner("fantasy.csv");
            
            break;
            }catch(Exception e){
                System.out.println(e);
            }
        case "6":
            trigger = true;
            break;
        default:
            System.out.println("You must press a number between 1 - 6");
            Start();
        }
        
        } 
    }
}
