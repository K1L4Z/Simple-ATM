package atm;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class ATM{
      
    String[] account1 = {"username","password","fname","surname","age","0.00"};
    Scanner scan = new Scanner(System.in);
    boolean islogin = false;
    boolean updatebal = false;
    boolean iscreated = false;
    
    void acctlogin(){//is account log in or not?
        if (islogin==true){
            option();
        }
        islogin = false;
    }
    
    void start(){ //MAIN MENU
        Scanner scan = new Scanner(System.in);
        System.out.println("\nCreate an Account or Log in?");
        String opt = scan.next();
        
            switch (opt){
                case "Create":
                    create();
                    System.out.println();
                    break;
                case "create":
                    create();
                    System.out.println();
                    break;
                case "Login":
                    login();
                    System.out.println();
                    break;
                case "login":
                    login();
                    System.out.println();
                    break;
                default:
                    System.out.println("type \"Create\" to create an account or \"Login\" to log in");
                    System.out.println();
                    start();
                    break;
            }
    }
    
    void create(){//create an account
        System.out.println("Create an Account \n");
        System.out.println("First Name");
        account1[2] = scan.next();
        System.out.println("Last Name");
        account1[3] = scan.next();
        System.out.println("Age:");
        account1[4] = scan.next();
        System.out.println("Username:");
        account1[0] = scan.next();
        System.out.println("Password:");
        account1[1] = scan.next();
        iscreated=true;
        displayInfo();
        String opt = scan.next();
        switch (opt){
            case "Menu":
                start();
                break;
            case "menu":
                start();
                break;
            case "Login":
                login();
                break;
            case "login":
                login();
                break;
            default:
                System.out.print("something is wrong and i dont know where the foc");
                break;
        }
    }
    
    
    void login(){
        System.out.print("Username: ");
        String user = scan.next();
        System.out.print("Password: ");
        String pass = scan.next();
        if (account1[0].equals(user)&&account1[1].equals(pass)){
            System.out.println("\nGood day!");
            islogin = true;
            account();
        }else{
            System.out.print("Incorrect username or password.\n");
            start();
        }
    }
    
    void account(){// account is already login 
        islogin = true;
        acctlogin();
        option();
    }
    void option(){
        System.out.print("\nWhat do you want to do with your account?\n\n\"Profile\"\n\"Balance\"\n\"Deposit\"\n\"Withdraw\"\n\"Logout\"\n");
        String choose = scan.next();
            switch(choose){
                case "Balance":
                    balance();
                case "balance":
                    balance();
                case "Deposit":
                    deposit();
                case "deposit":
                    deposit();
                case "Withdraw":
                    withdraw();
                case "withdraw":
                    withdraw();
                case "Logout":
                    islogin=false;
                    start();
                case "logout":
                    islogin=false;
                    System.out.println();
                    start();
                case "Profile":
                    displayInfo();
                case "profile":
                    displayInfo();
            }
    }
    
    void displayInfo(){
        String[] account = {"Username:","Password:","First Name:","Last Name:","Age:\t","Balance:"};
        if(iscreated==true){
            System.out.println("\nYour account has been created\n");
            for (int i = 0;i < 6; i++ ){
                System.out.println(account[i]+"\t" + account1[i]);}
                iscreated=false;
                start();
        }else if(updatebal==true){
            System.out.println("\nYour account has been updated\n");
            for (int i = 0;i < 6; i++ ){
                System.out.println(account[i]+"\t" + account1[i]);}
                option();
                updatebal=false;
        }else if (islogin==true){
            System.out.println("\nYour Account Details\n");
            for (int i = 0;i < 6; i++ ){
                System.out.println(account[i]+"\t" + account1[i]);}
            option();
        } else {
            System.out.println("\nWhat do you want to do now? \n\n\"Menu\"\n\"Login\"");
        }
    }
    
        void balance(){
            LocalDateTime dateObj = LocalDateTime.now();
            DateTimeFormatter formatDateObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String date = dateObj.format(formatDateObj);
            System.out.println("\nAs of " + date + ".\nYour balance is:\t" + account1[5]);
            account();
        }
         
        void deposit(){
            System.out.println("\nHow much do you want to deposit?");
            todeposit(scan.nextDouble());
            updatebal = true;
        }
        
        void todeposit(Double depo){
            Double bal = Double.parseDouble(account1[5]);
            Double newBal = bal + depo;
            String newBalance = Double.toString(newBal);
            account1[5] = newBalance;
            updatebal=true;
            displayInfo();
        }
        void withdraw(){
            System.out.println("\nHow much do you want to withdraw?");
            towithdraw(scan.nextDouble());
            updatebal = true;
        }
        
        void towithdraw(Double wdraw){
            Double bal = Double.parseDouble(account1[5]);
            if (bal<wdraw){
                System.out.println("Insufficient balance");
                account();
            } else {
                Double newBal = bal - wdraw;
                String newBalance = Double.toString(newBal);
                account1[5] = newBalance;
                updatebal=true;
                displayInfo();
            }
        }
        
    public static void main(String[] args){
        ATM ohmygadWOW = new ATM();
        ohmygadWOW.start();
    }
}
