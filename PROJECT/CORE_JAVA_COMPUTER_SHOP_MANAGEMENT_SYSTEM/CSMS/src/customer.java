import java.util.Scanner;

public class customer {
    
    String customerName;
    String regNum;

    item borroweditems[] = new item[3];
    public int itemsCount = 0;
    
    Scanner input = new Scanner(System.in);
    
    public customer()
    {
        System.out.println("Enter customer Name:");
        
        this.customerName = input.nextLine();
        
        System.out.println("Enter Registration Number:");
        this.regNum = input.nextLine();
    }
}
