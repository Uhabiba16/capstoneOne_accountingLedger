package com.ps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    static Scanner scanner= new Scanner(System.in);
    public static void main(String[] args) {

        int mainMenuCommand;

        do{
            System.out.println("\nWelcome to Your Financial Tracker");
            System.out.println("\n1) Add Deposit");
            System.out.println("2) Make Payment");
            System.out.println("3) Ledger");
            System.out.println("0) Exit");
            System.out.print("\nEnter Option:");
            mainMenuCommand=scanner.nextInt();
            scanner.nextLine();
            
            switch (mainMenuCommand){
                case 1:
                    //display add deposit option
                    addDeposit();
                    break;
                case 2:
                    //display add make payment option
                    makePayment();
                    break;
                case 3:
                    //display ledger
                    ledger();
                    break;
                case 0:
                    System.out.println("\nExiting... Come Again!");
                    break;
                default:
                    System.out.println("\nInvalid input! Try again.");
            }

        }while(mainMenuCommand !=0);

    }

    private static void addDeposit() {
    }

    private static void makePayment() {
    }

    private static void ledger() {
        int ledgeMenuCommand;

        System.out.println("\n--mainMenu: Ledger--");
        System.out.println("\n1)Display All Entries:");
        System.out.println("2)Filter by Deposit");
        System.out.println("3)Filter by Payment");
        System.out.println("4)Repots");
        System.out.println("0)Back to Main Menu");
        System.out.print("\nEnter Option from Ledger Menu:");
        ledgeMenuCommand=scanner.nextInt();
        scanner.nextLine();

        switch (ledgeMenuCommand){
            case 1:
                displayAllEntries();
                break;
            case 2:
                filterByDeposit();
                break;
            case 3:
                filterByPayment();
                break;
            case 4:
                reports();
                break;
            case 0:// back to home page 
                System.out.println("\nGoing back to Main Menu...");
                break;
            default:
                System.out.println("\nInvalid Input! Back to Main Menu");
        }
    }

    private static void displayAllEntries() {
    }

    private static void filterByDeposit() {
    }

    private static void filterByPayment() {
    }

    private static void reports() {
        int reportMenuCommand;
        do{
        System.out.println("\n--mainMenu: ledger: Reports--");
        System.out.println("\n1)Month to Date");
        System.out.println("2)Previous Month");
        System.out.println("3)Year to Date");
        System.out.println("4)Previous Year");
        System.out.println("5)Search by Vendor");
        System.out.println("0)Back to ledger");
        System.out.print("\nEnter Option from Reports Menu:");
        reportMenuCommand= scanner.nextInt();
        scanner.nextLine();
        
        switch (reportMenuCommand){
            case 1:
                monthToDate();
                break;
            case 2:
                previousMonth();
                break;
            case 3:
                yearToDate();
                break;
            case 4:
                previousYear();
                break;
            case 5:
                searchByVendor();
                break;
            case 0:
                System.out.println("\nGoing Back to Ledger Menu...");
                ledger();
                break;
            default:
                System.out.println("\nInvalid Input! Try Again...");
        }
                
        }while(reportMenuCommand !=0);
    }

    private static void monthToDate() {
    }

    private static void previousMonth() {
    }

    private static void yearToDate() {
    }

    private static void previousYear() {
    }

    private static void searchByVendor() {
    }
}