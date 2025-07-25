package com.ps;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Transaction> transactions = new ArrayList<>();
    static LocalDateTime now = LocalDateTime.now();
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static void main(String[] args) {
        loadTransactions();

        int mainMenuCommand;

        do {
            System.out.println("\nWelcome to Your Financial Tracker");
            System.out.println("\n1) Add Deposit");
            System.out.println("2) Make Payment");
            System.out.println("3) Ledger");
            System.out.println("0) Exit");
            System.out.print("\nEnter Option:");
            mainMenuCommand = scanner.nextInt();
            scanner.nextLine();

            switch (mainMenuCommand) {
                case 1:
                    addDeposit();
                    break;
                case 2:
                    makePayment();
                    break;
                case 3:
                    ledger();
                    break;
                case 0:
                    System.out.println("\nExiting... Come Again!");
                    break;
                default:
                    System.out.println("\nInvalid input! Try again.");
            }

        } while (mainMenuCommand != 0);

    }

    private static void addDeposit() {
        LocalDate date = LocalDate.now();
        String formattedTime = now.format(formatter);
        System.out.print("Enter Description:");
        String description = scanner.nextLine();
        System.out.print("Enter Vendor:");
        String vendor = scanner.nextLine();
        System.out.print("Enter Amount:");
        float price = scanner.nextFloat();


        Transaction depositTransaction = new Transaction(date, formattedTime, description.trim(), vendor.trim(), price);

        System.out.println("\nTransaction credited to your account successfully!");
        try {
            BufferedWriter bufWriter = new BufferedWriter(new FileWriter("transactions.csv", true));
            bufWriter.write("\r" + depositTransaction);
            bufWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        transactions.add(depositTransaction);
    }

    private static void makePayment() {
        LocalDate date = LocalDate.now();
        String formattedTime = now.format(formatter);
        System.out.print("Enter Description:");
        String description = scanner.nextLine();
        System.out.print("Enter Vendor:");
        String vendor = scanner.nextLine();
        System.out.print("Enter Amount:");
        float price = scanner.nextFloat();

        Transaction mPaymentTransaction = new Transaction(date, formattedTime, description.trim(), vendor.trim(), price * (-1));
        System.out.println("\nTransaction debited from your account successfully!");
        try {
            BufferedWriter bufWriter = new BufferedWriter(new FileWriter("transactions.csv", true));
            bufWriter.write("\r" + mPaymentTransaction);
            bufWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        transactions.add(mPaymentTransaction);
    }

    private static void ledger() {
        int ledgeMenuCommand;

        System.out.println("\n--mainMenu: Ledger--");
        System.out.println("\n1)Display All Entries");
        System.out.println("2)Filter by Deposit");
        System.out.println("3)Filter by Payment");
        System.out.println("4)Repots");
        System.out.println("0)Back to Main Menu");
        System.out.print("\nEnter Option from Ledger Menu:");
        ledgeMenuCommand = scanner.nextInt();
        scanner.nextLine();

        switch (ledgeMenuCommand) {
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
    }//Menu for Ledger

    private static void loadTransactions() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("transactions.csv"));

            String input;

            while ((input = bufferedReader.readLine()) != null) {
                String[] fields = input.split("\\|");

                LocalDate date = LocalDate.parse(fields[0]);
                String formattedTime = fields[1];
                String department = fields[2];
                String vendor = fields[3];
                float price = Float.parseFloat(fields[4]);


                Transaction transaction = new Transaction(date, formattedTime, department, vendor, price);

                transactions.add(transaction);
            }

            bufferedReader.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void displayAllEntries() {
        System.out.println("--All Transactions--\n");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    private static void filterByDeposit() {
        System.out.println("\n--Deposits to The Account--");
        for (Transaction transaction : transactions) {
            float deposit = transaction.getAmount();
            if (deposit > 0) {
                System.out.println(transaction);
            }
        }
    }

    private static void filterByPayment() {
        System.out.println("\n--Payments From The Account--");
        for (Transaction transaction : transactions) {
            float payments = transaction.getAmount();
            if (payments < 0) {
                System.out.println(transaction);
            }
        }
    }

    private static void reports() {
        int reportMenuCommand;
        do {
            System.out.println("\n--mainMenu: ledger: Reports--");
            System.out.println("\n1)Month to Date");
            System.out.println("2)Previous Month");
            System.out.println("3)Year to Date");
            System.out.println("4)Previous Year");
            System.out.println("5)Search by Vendor");
            System.out.println("0)Back to Ledger Menu");
            System.out.print("\nEnter Option from Reports Menu:");
            reportMenuCommand = scanner.nextInt();
            scanner.nextLine();

            switch (reportMenuCommand) {
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

        } while (reportMenuCommand != 0);
    }//Menu for reports

    private static void monthToDate() {
        System.out.println("--Month to Date Transactions--\n");
        int currentYear = LocalDate.now().getYear();
        int currentMonth = LocalDate.now().getMonthValue();
        for (Transaction transaction : transactions) {
            int tYear = transaction.getDate().getYear();
            int tMonth = transaction.getDate().getMonthValue();
            if (tMonth == currentMonth && tYear == currentYear) {
                System.out.println(transaction);
            }
        }
    }

    private static void previousMonth() {
        System.out.println("--Transactions from Last Month--\n");
        int currentYear = LocalDate.now().getYear();
        int currentMonth = LocalDate.now().getMonthValue();
        for (Transaction transaction : transactions) {
            int tYear = transaction.getDate().getYear();
            int tMonth = transaction.getDate().getMonthValue();
            if (tYear == currentYear && (tMonth == currentMonth - 1)) {
                System.out.println(transaction);
            }
        }
    }

    private static void yearToDate() {
        System.out.println("--Year To Date Transactions--\n");
        int currentYear = LocalDate.now().getYear();
        for (Transaction transaction : transactions) {
            int tYear = transaction.getDate().getYear();
            if (tYear == currentYear) {
                System.out.println(transaction);
            }
        }
    }

    private static void previousYear() {
        System.out.println("--Transactions from Last Year--\n");
        int currentYear = LocalDate.now().getYear();
        for (Transaction transaction : transactions) {
            int tYear = transaction.getDate().getYear();
            if (tYear == currentYear - 1) {
                System.out.println(transaction);
            }
        }
    }

/// hfuyfuitfufufuyfuc
    //TEST

    private static void searchByVendor() {
        System.out.print("Please enter vendor name:");
        String vendorNameInput = scanner.nextLine();
        System.out.println("\nTransactions filtered by Vendor:" + vendorNameInput.toUpperCase());
        for (Transaction transaction : transactions) {
            String currentVendorName = transaction.getVendor();
            if (currentVendorName.equalsIgnoreCase(vendorNameInput)) {
                System.out.println(transaction);
            }
        }
    }
}