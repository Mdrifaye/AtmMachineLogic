import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;


class AtmMachine {
    static Scanner sc = new Scanner(System.in);
    // States for citi bank user
    LocalDate previousDate = LocalDate.now();

    double avi_balance_for_citi_bank_user;
    int valid_pin_for_citi_bank_user;
    String Acc_holder_name_for_citi_bank_user = "Rifaye";
    // String Other_bank_acc_holder_name = "Suhail";
    boolean CB_user = true;

    //states for other bank user
    double avi_balance_for_other_bank_user;
    int valid_pin_for_other_bank_user;
    String acc_holder_name_for_other_bank_user = "Suhail";
    //boolean CB_user = true;

    // for logical work
    int transaction_limit = 3;
    double per_day_amount_limit = 20000;
    double today_amount_limit = 0;//it will incremented based on withdraw amount to check per day money limit
    double Atm_machine_balance;
    //double total_Atm_balance = 0;//it will incremented based on withdraw amount to check atm machine balance
    int next_day_limit_initialize = 1;

    // constructor
    public AtmMachine() {
        // L.O.I
    }

    // for declaring start time and end time
    LocalTime startTime = LocalTime.of(20, 02);
    LocalTime EndTime = LocalTime.of(20, 01);

    static {
        System.out.println("\t\t\tATM Machine Project");
        System.out.println("\n\t\tDeveloped by : Mohammed Rifaye M");
        System.out.println("\t\t--------------------------------\n");

    }

    public double EnterWithdrawAmount() throws Exception {
        System.out.println("\n\t\tThis ATM having only [100,200,500]");
        Thread.sleep(300);
        System.out.print("\nEnter the amount to Withdraw : ");
        double wd_amount = sc.nextDouble();
        return wd_amount;
    }
    
    // Behaviour
    public void WithdrawForCitiBankUser() throws Exception {
        // withdraw the money if pin is valid
        //Processing();
        LocalDate currentDate = LocalDate.now();
        //System.out.println("Previous Date : " + previousDate);
        //System.out.println("Today Date : " + currentDate);
        if (transaction_limit > 0) {
            // for transaction limit
            if(today_amount_limit != per_day_amount_limit) {
                //for if user is eligible for 
                if(Atm_machine_balance != 0) {
                    double wd_amount = EnterWithdrawAmount();
                    if(wd_amount > 0) {
                        // user should not withdraw amount less than 0
                        // or to accept positive amount
                        if (wd_amount % 100 == 0 || wd_amount % 200 == 0 || wd_amount % 500 == 0) {
                            // for user enter the valid amount which is accept rs 100,200,500
                            if(wd_amount <= per_day_amount_limit){
                                //for if user enter more than limit in single transaction
                                if (wd_amount <= avi_balance_for_citi_bank_user) {
                                    // if user withdraw the valid amount
                                    //if(today_amount_limit != per_day_amount_limit) {
                                        today_amount_limit += wd_amount;// if withdraw is completed it will add the amount in per day amount limit
                                        if(today_amount_limit <= per_day_amount_limit){
                                            // this will work if the user per day amount limit is under 20000
                                            //if (today_amount_limit <= per_day_amount_limit) {
                                            // per day amount is available
                                            //total_Atm_balance += wd_amount;
                                            if(wd_amount <= Atm_machine_balance){
                                                //if atm machine money is greater than withdraw money
                                                avi_balance_for_citi_bank_user -= wd_amount;
                                                Atm_machine_balance -= wd_amount;
                                                System.out.println("\n\t\tPlease collect your cash");
                                                Thread.sleep(250);
                                                System.out.println("\n\t\tYour available balance is : " + avi_balance_for_citi_bank_user + "\n");
                                                Thread.sleep(250);
                                                System.out.println("\t\tThank You for Using Citi Bank ATM");
                                                System.out.println("\t\t---------------------------------\n");
                                                //today_amount_limit += wd_amount;// if withdraw is completed it will add the amount in per day amount limit
                                                --transaction_limit;// for transaction limit
                                                //today_amount_limit -= wd_amount;// if withdraw is completed it will add the amount in per day amount limit
                                            } else {
                                                //total_Atm_balance -= wd_amount; // to avoid if if not withdraw machine have money
                                                today_amount_limit -= wd_amount;// if withdraw is completed it will add the amount in per day amount limit
                                                // if atm machine doesnt have money
                                                System.out.println("\t\tAtm Don't have money");
                                                System.out.println("\n\t\tPlease try After some time");
                                                System.out.println("\t\t--------------------------\n");
                                                AtmMachineDriver.HomePage();
                                            }   
                                            //total_Atm_balance -= wd_amount;
                                            //System.out.println("\n\t\tAtm Machine Having Rs: " + Atm_machine_balance); 
                                            /* } else {
                                                //else, will work if per day withdraw is equal to per day amount limit
                                                System.out.println("\t\tYour today amount limit is exist");
                                                System.out.println("\n\t\tPlease Try tomorrow");
                                            }*/
                                            /* } else {
                                                today_amount_limit -= wd_amount;// if withdraw is completed it will add the amount in per day amount limit
                                                // per day amount limit is exist
                                                //System.out.println("Your today balance limit is : " + (today_amount_limit - per_day_amount_limit));
                                                System.out.println("\t\tYour today amount limit is exist");
                                                System.out.println("\n\t\tPlease Try tomorrow");
                                                //System.out.println("\n\t\tYou Entered more than limit");
                                                //WithdrawForCitiBankUser();

                                            }*/
                                        } else {
                                            //it will work if the user withdraw more than limit in second or third transaction
                                            today_amount_limit -= wd_amount;// if withdraw is completed it will add the amount in per day amount limit
                                            System.out.println("\t\tYour today remaining withdraw limit is : " + (per_day_amount_limit - today_amount_limit));
                                            Processing();
                                            WithdrawForCitiBankUser();
                                        }
                                    /*} else {
                                        //today_amount_limit -= wd_amount;// if withdraw is completed it will add the amount in per day amount limit
                                        // per day amount limit is exist
                                        //System.out.println("Your today balance limit is : " + (today_amount_limit - per_day_amount_limit));
                                        System.out.println("\t\tYour today amount limit is exist...");
                                        System.out.println("\n\t\tPlease Try tomorrow");
                                        //System.out.println("\n\t\tYou Entered more than limit");
                                        //WithdrawForCitiBankUser();
                                    }*/
                                } else {
                                    // if user enter the amount exist from available balance
                                    System.out.println("\t\tInsufficiant Balance\n");
                                    System.out.println("\t\tYour Balance is Rs: " + avi_balance_for_citi_bank_user + "\n");
                                    System.out.println("\t\tThank you for Using Citi Bank ATM");
                                    System.out.println("\t\t----------------------------------\n");
                                    AtmMachineDriver.HomePage();
                                }
                            } else {
                                //For more then limit in single transaction
                                System.out.println("\n\t\tYou Entered more than limit");
                                System.out.println("\t\tYour remaining withdraw limit is : " + (per_day_amount_limit - today_amount_limit));
                                Processing();
                                WithdrawForCitiBankUser();
                            }
                        } else {
                            // invalid amount based on what currency is available in ATM machine
                            System.out.println("\n\t\tInvalid Amount\n\t\tPlease try valid amount");
                            Processing();
                            WithdrawForCitiBankUser();
                        }
                    } else {
                        // if user enter withdraw amount is less than 0
                        System.out.println("\t\tPlease enter valid Amount");
                        Processing();
                        WithdrawForCitiBankUser();
                    }
                } else {
                    System.out.println("\t\tAtm Don't have money");
                    System.out.println("\n\t\tPlease try After some time");
                    System.out.println("\t\t--------------------------\n");
                    AtmMachineDriver.HomePage();
                }
            } else {
                // per day amount limit is exist
                if(previousDate.isEqual(currentDate)){
                    System.out.println("\t\tYour Today Amount Limit Exceeded");
                    System.out.println("\n\t\tPlease Try tomorrow");
                } else {
                    previousDate = currentDate;
                    transaction_limit = 3;
                    today_amount_limit = 0;
                    //Processing();
                    WithdrawForCitiBankUser();
                }
                //today_amount_limit -= wd_amount;// if withdraw is completed it will add the amount in per day amount limit
                //System.out.println("Your today balance limit is : " + (today_amount_limit - per_day_amount_limit));
                //System.out.println("\n\t\tYou Entered more than limit");
                //WithdrawForCitiBankUser();
            }
        } else {
            // transaction limit exist
            if(previousDate.isEqual(currentDate)){
                System.out.println("\t\tYour Today Transaction limit Exceeded");
                System.out.println("\n\t\tPlease Try tomorrow");
            } else {
                previousDate = currentDate;
                transaction_limit = 3;
                today_amount_limit = 0;
                //Processing();
                WithdrawForCitiBankUser();
            }
            /* 
            LocalTime ExactTime = LocalTime.now();

            if (ExactTime.isAfter(EndTime)) { //it represent next day
                // this is current time is in next day
                System.out.println("Next Day");

                while(next_day_limit_initialize <= 1){
                    today_amount_limit = 0;
                    transaction_limit = 3;
                    next_day_limit_initialize++;
                }
                Withdraw();
            } else {
                // this is current time is before the current day
                next_day_limit_initialize = 1;*/
                //System.out.println("\t\tTransaction limit Exist for Today");
                //System.out.println("\n\t\tPlease Try tomorrow");
            //}
        }
    }

    public void WithdrawForOtherBankUser() throws Exception {
        // withdraw the money if pin is valid
        /* System.out.println("\n\t\tThis ATM having only [100,200,500]");
        Thread.sleep(500);
        System.out.print("\nEnter the amount to Withdraw : ");
        double wd_amount = sc.nextDouble();
        Processing();*/
        if(Atm_machine_balance != 0) {
            double wd_amount = EnterWithdrawAmount();
            if (wd_amount > 0) {
                // user should not withdraw amount less than 0
                if (wd_amount <= avi_balance_for_other_bank_user) {
                    // if user withdraw the valid amount
                    if (wd_amount % 100 == 0 || wd_amount % 200 == 0 || wd_amount % 500 == 0) {
                        // for user enter the valid amount which is accept rs 100,200,500
                        // per day amount is available
                        // today_amount_limit += wd_amount;// if amount is valid it
                        // will add the
                        // amount in per day amount limit
                        //total_Atm_balance += wd_amount;
                        if(wd_amount <= Atm_machine_balance){
                            //if atm machine have money is greate than withdraw money
                            avi_balance_for_other_bank_user -= wd_amount;
                            Atm_machine_balance -= wd_amount;
                            System.out.println("\t\tPlease collect your cash\n");
                            Thread.sleep(250);
                            System.out.println("\t\tYour available balance is : " + avi_balance_for_other_bank_user + "\n");
                            Thread.sleep(250);
                            System.out.println("\t\tThank You for Using Citi Bank ATM");
                            System.out.println("\t\t----------------------------------\n");
                            --transaction_limit;// for transaction limit

                        } else {
                            //total_Atm_balance -= wd_amount;
                            // if atm machine doesnt have money
                            System.out.println("\t\tAtm Don't have money");
                            System.out.println("\n\t\tPlease try After some time");
                            System.out.println("\t\t--------------------------\n");
                            AtmMachineDriver.HomePage();
                        }
                    } else {
                        // invalid amount based on what currency is available in ATM machine
                        System.out.println("\t\tInvalid Amount\n\n\t\tPlease try valid amount\n");
                        WithdrawForOtherBankUser();
                    }
                } else {
                    // if user enter the amount exist from available balance
                    //System.out.println("\t\tInsufficiant Balance\n\t\tPlease Enter the valid amount\n");
                    System.out.println("\n\t\tInsufficiant Balance\n");
                    System.out.println("\t\tYour Balance is Rs: " + avi_balance_for_other_bank_user + "\n");
                    System.out.println("\t\tThank you for Using Citi Bank ATM");
                    System.out.println("\t\t----------------------------------\n");
                    AtmMachineDriver.HomePage();
                }
            } else {
                // if user enter withdraw amount is less than 0
                System.out.println("\t\tPlease enter valid Amount");
                WithdrawForOtherBankUser();
            }
        } else {
            System.out.println("\t\tAtm Don't have money");
            System.out.println("\n\t\tPlease try After some time");
            System.out.println("\t\t--------------------------\n");
            AtmMachineDriver.HomePage();
        }
    }

    public void checkBalanceForCitiBankUser() throws Exception {
        // check the balance if pin is valid
        Processing();
        System.out.println("\t\tYour available balance is : " + avi_balance_for_citi_bank_user);
        System.out.println("\n\t\tThank You for Using Citi Bank ATM");
        System.out.println("\t\t---------------------------------\n");
    }
    public void checkBalanceForOtherBankUser() throws Exception {
        // check the balance if pin is valid
        Processing();
        System.out.println("\t\tYour available balance is : " + avi_balance_for_other_bank_user);
        System.out.println("\n\t\tThank You for Using Citi Bank ATM");
        System.out.println("\t\t---------------------------------\n");
    }

    public void ChangePinForCitiBankUser() throws Exception {
        // change the old pin if user enter the valid pin
        System.out.print("Enter the New Pin : ");
        int new_pin = sc.nextInt();
        if (new_pin == valid_pin_for_citi_bank_user) {
            System.out.println("\n\t\tOld Pin Cannot be a New pin again");
            ChangePinForCitiBankUser();
        } else {
            valid_pin_for_citi_bank_user = new_pin;
            System.out.println("\n\t\tNew pin Changed Successfully\n");
        }
    }

    public void ChangePinForOtherBankUser() throws Exception {
        // change the old pin if user enter the valid pin
        System.out.print("Enter the New Pin : ");
        int new_pin = sc.nextInt();
        if (new_pin == valid_pin_for_other_bank_user) {
            System.out.println("\n\t\tOld Pin Cannot be a New pin again");
            ChangePinForCitiBankUser();
        } else {
            valid_pin_for_other_bank_user = new_pin;
            System.out.println("\n\t\tNew pin Changed Successfully\n");
        }
    }

    public static void Processing() throws Exception {
        System.out.print("Processing");
        Thread.sleep(250);
        System.out.print(".");
        Thread.sleep(250);
        System.out.print(".");
        Thread.sleep(250);
        System.out.println(".");
        Thread.sleep(250);
    }
}