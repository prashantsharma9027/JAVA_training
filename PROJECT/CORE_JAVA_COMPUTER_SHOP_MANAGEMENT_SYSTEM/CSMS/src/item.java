import java.util.Scanner;

public class item {

    public int sNo;
    public String itemName;
    public String companyName;
    public int itemQty;
    public int itemQtyCopy;

    Scanner input = new Scanner(System.in);

    public  item()
    {

        System.out.println("Enter Serial No of item   :");
        this.sNo = input.nextInt();
        input.nextLine();

        System.out.println("Enter item Name           :");
        this.itemName = input.nextLine();

        System.out.println("Enter Company Name         :");
        this.companyName = input.nextLine();

        System.out.println("Enter Quantity of items    :");
        this.itemQty = input.nextInt();
        itemQtyCopy = this.itemQty;
    }
}
