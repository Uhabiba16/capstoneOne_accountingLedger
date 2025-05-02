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
![Screenshot 2025-05-02 015326](https://github.com/user-attachments/assets/81f70d7e-f833-426d-8614-485e20eef3b1)

![Screenshot 2025-05-02 015501](https://github.com/user-attachments/assets/5d6ae66c-a7b1-4d9d-86ca-959153a12bc8)

![Screenshot 2025-05-02 015430](https://github.com/user-attachments/assets/54a32b16-cca9-4c7b-8b6f-3160cb03564c)

![Screenshot 2025-05-02 015417](https://github.com/user-attachments/assets/cb564210-ea5c-4e2b-9256-fb07c3735752)

![Screenshot 2025-05-02 015400](https://github.com/user-attachments/assets/0b612b69-e7fb-4d67-ae79-571025fb2124)

