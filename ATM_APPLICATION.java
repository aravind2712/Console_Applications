import java.util.Scanner;

public class ATM {
    static Scanner sc = new Scanner(System.in);
    static int[] noOfCurrency = {0, 0, 0, 0};
    static int[] currency = {100, 200, 500, 2000};
    static int total = 0;
    static String name = "Aravind";
    static int uspin = 3264;
    static int usbalance = 56000;

    //user

    public static void withdraw() {
        System.out.println("Enter Withdraw Amount ");
        System.out.println("Multiples Of ");
        for (int i = 0; i < 4; i++) {
            if (noOfCurrency[i] > 0)
                System.out.print(currency[i] + "s ");
        }
        int withDrawAmt = sc.nextInt();
        if (withDrawAmt > total) {
            System.out.println("Enter Minimum Amount ");
        } else {
            int noOfNote = 0;
            for (int j = 3; j >= 0; j--) {
                while (withDrawAmt >= currency[j] && noOfCurrency[j] > 0) {
                    withDrawAmt -= currency[j];
                    noOfCurrency[j]--;
                    noOfNote++;
                }
                System.out.println("Collect Your note" + noOfNote);
            }
            total -= withDrawAmt;
            usbalance -= withDrawAmt;
            System.out.println("Amount Withdrawed Succesfully " + noOfNote);
            System.out.println("Collect Your Amount");

        }
    }

    public static void pinChange() {
        System.out.println("Enter Your Old Pin : ");
        int n = sc.nextInt();
        if (n == uspin) {
            System.out.println("Enter new pin");
            uspin = sc.nextInt();
            System.out.println("Your Pin Has Been changed Succesfully");
        }else{
            System.out.println("Wrong password...");
        }
    }

    public static void deposit() {
        int total = usbalance;
        for (int i = 0; i < 4; i++) {
            System.out.println("Enter No of " + currency[i] + "->");
            int n = sc.nextInt();
            noOfCurrency[i] += n;
            total += currency[i] * n;
            usbalance += currency[i] * n;
        }
    }


    private static void checkBalance() {
        System.out.println("Balance : " + usbalance);
    }

    public static void userlogin() {
        System.out.println("You Have Choosen User Login");
        System.out.println("Enter User Name and Password");
        String userName = sc.next();
        int userPassword = sc.nextInt();
        int usop = 0;
        if (userName.equals(name) && userPassword == uspin) {
            do {
                System.out.println("Welcome");
                System.out.println("1.Withdraw Amount");
                System.out.println("2.Check Balance");
                System.out.println("3.Pin change");
                System.out.println("4.Direct Deposit");
                System.out.println("5.Exit");
                System.out.println("Enter Your Choice");
                usop = sc.nextInt();
                switch (usop) {
                    case 1:
                        withdraw();
                        break;
                    case 2:
                        checkBalance();
                        break;
                    case 3:
                        pinChange();
                        break;
                    case 4:
                        deposit();
                        break;
                    case 5:
                        break;
                }
            } while (usop != 5);
        }else{
            System.out.println("Invalid UserName and Password");
        }
    }


    //Admin
    public static void addamount() {
        for (int i = 0; i < 4; i++) {
            System.out.println("Enter No of " + currency[i] + "->");
            noOfCurrency[i] += sc.nextInt();
        }
    }

    public static void atmBalance() {
        int tot = 1000;
        for (int i = 0; i < 4; i++) {
            System.out.println("No of " + currency[i] + "->" + noOfCurrency[i]);
            tot += currency[i] * noOfCurrency[i];
        }
        total = tot;
        System.out.println(tot);
    }

    public static void admin() {
        System.out.println("You Have Choosen Admin Login");
        System.out.println("Enter Admin Name and Password");
        String adminName = sc.next();
        int adminPassword = sc.nextInt();
        int adop = 0;
        if (adminName.equals("Admin") && adminPassword == 98765) {
            do {
                System.out.println("Welcome Admin");
                System.out.println("1.Load");
                System.out.println("2.Check Balance");
                System.out.println("3.Exit");
                System.out.println("Enter Your Choice");
                adop = sc.nextInt();
                switch (adop) {
                    case 1:
                        System.out.println("Enter amount");
                        addamount();
                        break;
                    case 2:
                        System.out.println("ATM Balance");
                        atmBalance();
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Invalid Input");
                        break;
                }
            } while (adop != 3);
        } else {
            System.out.println("check Admin Name and Password");
        }
    }



    public static void main(String[] args) {
        int ch = 0;
        do {
            System.out.println("Welcome");
            System.out.println("ATM Application");
            System.out.println("1.Admin Login");
            System.out.println("2.User Login");
            System.out.println("3.Exit");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    admin();
                    break;
                case 2:
                    userlogin();
                    break;
                case 3:
                    break;
            }
        } while (ch != 3);
        System.out.println("Thanks for Using");
    }
}
