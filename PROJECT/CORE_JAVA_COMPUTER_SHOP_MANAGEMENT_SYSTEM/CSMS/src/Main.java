import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("\n\n******************** COMPUTER SHOP MANAGEMENT SYSTEM ********************");
        System.out.println("----- Please Enter Your Choice (1-10) -------\n");

        items ob = new items();
        customers obcustomer = new customers();

        int choice;
        int searchChoice;

        do {
            ob.dispMenu();
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    item b = new item();
                    ob.additem(b);
                    break;
                case 2:
                    ob.upgradeitemQty();
                    break;
                case 3:
                    System.out.println("    1 : Search with item with Serial No.");
                    System.out.println("    2 : Search with item's Company Name.");

                    searchChoice = input.nextInt();
                    switch (searchChoice) {
                        case 1:
                            ob.searchBySno();
                            break;
                        case 2:
                            ob.searchByComapnyName();
                    }
                    break;
                case 4:
                    ob.showAllitems();
                    break;
                case 5:
                    customer s = new customer();
                    obcustomer.addcustomer(s);
                    break;
                case 6:
                    obcustomer.showAllcustomers();
                    break;
                case 7:
                    obcustomer.checkOutitem(ob);
                    break;
                case 8:
                    obcustomer.checkInitem(ob);
                    break;
                default:
                    System.out.println("OOPS! you have entered wrong choice -----");
                    System.out.println("----- PLEASE RE ENTER THE CHOICE -----" + "");
            }
        }
        while (choice != 0);
    }
}
