# Financial Tracker Application
A simple application for tracking deposits, payments, and generating financial reports.

This application allows users to keep track of their transactions by recording deposits and payments, viewing 
transaction history, and generating reports based on custom date ranges or vendors, which is stored in the CSV file.
---
## Features
**Add Deposit:** Record a deposit transaction with a description, vendor, and amount.

**Make Payment:** Record a payment transaction with a description, vendor, and amount.

**Ledger:** View all transactions, filter by deposits or payments.

**Reports:** A sub-menu of ledger which generate reports for month-to-date, previous month, year-to-date, previous year, or
search transactions by vendor.
---
## Interesting Code Example
Here's an interesting piece of code from my project that handles generating a report for Month to Date transactions. 
It filters transactions based on the current month and year.
```java
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
```
### why interesting?
This method fetches the current year and month using Java's LocalDate.now(). Then, it loops through all the 
transactions and checks if the transaction's year and month match the current year and month. If they do, the 
transaction is printed on the console.If the year is not mentioned it would have printed all the other years transaction 
of the month we are in. 

---
# ScreenShots
![](C:\Users\Student\pluralsight\capstones\capstone1\screenshots\Screenshot 2025-05-02 015326.png "Methods")
![the welcome menu](C:\Users\Student\pluralsight\capstones\capstone1\screenshots\Screenshot 2025-05-02 015400.png "welcome")
![](C:\Users\Student\pluralsight\capstones\capstone1\screenshots\Screenshot 2025-05-02 015417.png "ledgerMenu")
![](C:\Users\Student\pluralsight\capstones\capstone1\screenshots\Screenshot 2025-05-02 015430.png "reportsSubMenu")
![](C:\Users\Student\pluralsight\capstones\capstone1\screenshots\Screenshot 2025-05-02 015501.png "reportExample")

