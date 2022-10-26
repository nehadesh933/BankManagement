package hackathon2;


import java.util.Scanner;

class Bank {
   private String accno;
   private String name;
   private long balance;
  
   int at;
   int n;
   

   Scanner KB = new Scanner(System.in);

   //method to open an account
   void openAccount() {
       System.out.print("Enter Account No: ");
       accno = KB.next();
       System.out.print("Enter Name: ");
       name = KB.next();
       System.out.print("Enter Balance: ");
       balance = KB.nextLong();
      
   }

   //method to display account details
   void showAccount() {
       System.out.println(accno + "," + name + "," + balance);
   }

   //method to deposit money
   void deposit() {
       long amt;
       System.out.println("Enter the Amount to Deposit : ");
       amt = KB.nextLong();
       balance = balance + amt;
   }

   //method to withdraw money
   void withdrawal() {
       long amt;
       System.out.println("Enter the Amount to withdraw : ");
       amt = KB.nextLong();
       if (balance >= amt) {
           balance = balance - amt;
       } else {
           System.out.println("Insuffecient balance,Transaction Failed..");
       }
       
        
       
   }
   

   //method to search an account number
   boolean search(String acn) {
       if (accno.equals(acn)) {
           showAccount();
           return (true);
       }
       return (false);
   }
}

public class BankManagement {
   public static void main(String arg[]) {
       Scanner KB = new Scanner(System.in);

       //create initial accounts
       System.out.print("How many Customers details do you want to input : ");
       int n = KB.nextInt();
       Bank ch[] = new Bank[n];
       for (int i = 0; i < ch.length; i++) {
           ch[i] = new Bank();
           ch[i].openAccount();
       }

       //run loop until menu 5 is not pressed
       int choice;
       do {
           System.out.println("Main Menu\n1. Display All\n 2. Search By Account\n 3. Deposit\n 4. Withdrawal\n 5.Exit ");
               System.out.println("e Choice :"); choice = KB.nextInt();
               switch (choice) {
                   case 1:
                       for (int i = 0; i < ch.length; i++) {
                           ch[i].showAccount();
                          
                       }
                       break;

                   case 2:
                       System.out.print("Enter Account No to Search...: ");
                       String acn = KB.next();
                       boolean found = false;
                       for (int i = 0; i < ch.length; i++) {
                           found = ch[i].search(acn);
                           if (found) {
                               break;
                           }
                       }
                       if (!found) {
                           System.out.println("Search Failed..Account Not Exist..");
                       }
                       break;

                   case 3:
                       System.out.print("Enter Account No : ");
                       acn = KB.next();
                       found = false;
                       for (int i = 0; i < ch.length; i++) {
                           found = ch[i].search(acn);
                           if (found) {
                               ch[i].deposit();
                              
                               break;
                           }
                       }
                       if (!found) {
                           System.out.println("Search Failed..Account Not Exist..");
                       }
                       break;

                   case 4:
                       System.out.print("Enter Account No : ");
                       acn = KB.next();
                       found = false;
                       for (int i = 0; i < ch.length; i++) {
                           found = ch[i].search(acn);
                           if (found) {
                            
                            
                            
                               break;
                           }
                       }
                       if (!found) {
                           System.out.println("Search Failed..Account Not Exist..");
                       }
                       break;

                   case 5:
                       System.out.println("Good Bye,thank you.");
                       break;
               }
           }
           while (choice != 5);
       }
   }