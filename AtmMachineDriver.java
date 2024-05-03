import java.util.Scanner;

class AtmMachineDriver {
    static Scanner sc = new Scanner(System.in);
    static AtmMachine ref = new AtmMachine();
    
    static boolean my_app = true;

    public static void main(String[] args) throws Exception {
        System.out.println("\t\tNOTE :This is for your testing purpouse only");
        System.out.print("\t\tEnter the amount balance in ATM machine : ");
        ref.Atm_machine_balance=sc.nextDouble();
        System.out.print("\n\t\tSet The Pin Number for city bank user : ");
        ref.valid_pin_for_citi_bank_user = sc. nextInt();
        System.out.print("\n\t\tEnter the Available balance for city bank Account : ");
        ref.avi_balance_for_citi_bank_user = sc.nextDouble();
        System.out.print("\n\t\tSet Pin Number for Other Bank User : ");
        ref.valid_pin_for_other_bank_user = sc.nextInt();
        System.out.print("\n\t\tEnter the Available Balance for Other Bank Account: ");
        ref.avi_balance_for_other_bank_user = sc.nextDouble();
        System.out.println("\n\t\t\"Now The Main Logic is Started below\"");
        System.out.println("\t\t--------------------------------------------------");
        System.out.println("\t\t**************************************************\n\n");
        do {
            HomePage();
        } while (my_app);

    }

    public static void HomePage() throws Exception{
        System.out.println("\t\t********Welcome To Citi Bank ATM********");
            System.out.println("\nPress 1 if you're Citi Bank User\n\nPress 2 if you're Other Bank User\n\nPress 0 for Exit");
            int bank_option = sc.nextInt();
            switch (bank_option) {
                case 1: {
                        // for citi bank user only
                        // To enter the pin to make transaction
                        Processing();
                        EnterPinForCitiBankUser();
                        break;
                    }
                case 2: {
                        // for other bank users
                        // To enter the pin to make transaction
                        Processing();
                        EnterPinForOtherBankUser();
                        break;
                    }
                case 0: {
                        // To exit the atm without dooing transaction
                        System.out.println("\t\t********Thank you for visiting Citi Bank Atm********");
                        System.out.println("\t\t----------------------------------------------------");
                        System.out.println("");
                        my_app = false;
                        break;
                    }
                default: {
                    // for invalid enter option
                    System.out.println("Please enter the valid option");
                    HomePage();
                    break;
                }

            }

    }
    public static void EnterPinForCitiBankUser() throws Exception {
        System.out.println("\n\t\t\tHello Citi Bank User");
        System.out.print("\nPlease Enter the pin : ");
        int user_enter_pin = sc.nextInt();
        Processing();
        System.out.println("\t\tHello, " + ref.Acc_holder_name_for_citi_bank_user + "\n");
        AfterPinEnterForCitiBankUser(user_enter_pin);
    }

    public static void EnterPinForOtherBankUser() throws Exception {
        System.out.println("\n\t\t\tHello Other Bank User");
        System.out.print("\nPlease Enter the pin : ");
        int user_enter_pin = sc.nextInt();
        Processing();
        System.out.println("\t\tHello, " + ref.acc_holder_name_for_other_bank_user + "\n");
        AfterPinEnterForOtherBankUser(user_enter_pin);
    }

    public static void AfterPinEnterForCitiBankUser(int user_enter_pin) throws Exception {
        if (ref.valid_pin_for_citi_bank_user == user_enter_pin) {
            // pin number valid withdraw will be process for citi bank user
            System.out.println("1.Withdraw Money\n\n2.Check Balance\n\n3.Change Pin");
            System.out.print("\nEnter your option : ");
            int withdraw_option = sc.nextInt();
            switch (withdraw_option) {
                case 1: {
                    // for money withdraw after enter the valid pin for citi bank user
                    Processing();
                    ref.WithdrawForCitiBankUser();
                    break;
                }
                case 2: {
                    // for check balance after enter the valid pin for citi bank user
                    ref.checkBalanceForCitiBankUser();
                    break;
                }
                case 3: {
                    // change the pin after enter the valid pin for citi bank user
                    ref.ChangePinForCitiBankUser();
                    break;
                }
                default: {
                    // invalid withdraw option selection
                    Processing();
                    System.out.println("\t\tInvalid Option please choose correct option\n");
                    AfterPinEnterForCitiBankUser(user_enter_pin);
                    break;
                }
            }
        } else {
            // pin number is not valid error should be displayed
            System.out.println("\t\tInvalid Pin\n\n\t\tPlease Enter the valid pin");
            EnterPinForCitiBankUser();
            //Thread.sleep(1000);
        }

    }

    public static void AfterPinEnterForOtherBankUser(int user_enter_pin) throws Exception {
        if (ref.valid_pin_for_other_bank_user == user_enter_pin) {
            // pin number valid withdraw will be process for Other bank user
            System.out.println("1.Withdraw Money\n\n2.Check Balance\n\n3.Change Pin");
            System.out.print("\nEnter your option : ");
            int withdraw_option = sc.nextInt();
            switch (withdraw_option) {
                case 1: {
                    // for money withdraw after enter the valid pin for other bank user
                    Processing();
                    ref.WithdrawForOtherBankUser();
                    break;
                }
                case 2: {
                    // for check balance after enter the valid pin for other bank user
                    ref.checkBalanceForOtherBankUser();
                    break;
                }
                case 3: {
                    // change the pin after enter the valid pin for other bank user
                    ref.ChangePinForOtherBankUser();
                    break;
                }
                default: {
                    // invalid withdraw option selection
                    Processing();
                    System.out.println("\t\tInvalid Option please choose correct option");
                    AfterPinEnterForOtherBankUser(user_enter_pin);
                    break;
                }
            }
        } else {
            // pin number is not valid error should be displayed
            System.out.println("\t\tInvalid Pin\n\n\t\tPlease Enter the valid pin\n");
            EnterPinForOtherBankUser();
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