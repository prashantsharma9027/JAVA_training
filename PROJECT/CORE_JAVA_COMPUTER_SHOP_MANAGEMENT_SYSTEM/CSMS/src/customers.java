import java.util.Scanner;

public class customers {
    Scanner input = new Scanner(System.in);
    customer thecustomers[] = new customer[50];

    public static int count = 0;

    public void addcustomer(customer s)
    {
        for (int i = 0; i < count; i++) {

            if (s.regNum.equalsIgnoreCase(thecustomers[i].regNum)) {

                System.out.println("customer of Reg Num " + s.regNum + " is Already Registered.");
                return;
            }
        }

        if (count <= 50) {
            thecustomers[count] = s;
            count++;
        }
    }

    public void showAllcustomers()
    {
        System.out.println("customer Name\t\tReg Number");
        for (int i = 0; i < count; i++) {

            System.out.println(thecustomers[i].customerName + "\t\t" + thecustomers[i].regNum);
        }
    }

    public int iscustomer()
    {
        System.out.println("Enter Reg Number:");

        String regNum = input.nextLine();

        for (int i = 0; i < count; i++) {

            if (thecustomers[i].regNum.equalsIgnoreCase(regNum)) {
                return i;
            }
        }

        System.out.println("customer is not Registered.");
        System.out.println("Get Registered First.");

        return -1;
    }

    public void checkOutitem(items item)
    {
        int customerIndex = this.iscustomer();

        if (customerIndex != -1) {
            System.out.println("checking out");

            item.showAllitems();
            item b = item.checkOutitem();

            System.out.println("checking out");
            if (b != null) {

                if (thecustomers[customerIndex].itemsCount <= 3) {

                    System.out.println("adding item");
                    thecustomers[customerIndex].borroweditems[thecustomers[customerIndex].itemsCount] = b;
                    thecustomers[customerIndex].itemsCount++;

                    return;
                }
                else {

                    System.out.println("customer Can not Borrow more than 3 items.");
                    return;
                }
            }
            System.out.println("item is not Available.");
        }
    }

    public void checkInitem(items item)
    {
        int customerIndex = this.iscustomer();
        if (customerIndex != -1) {

            System.out.println("S.No\t\t\titem Name\t\t\tAuthor Name");

            customer s = thecustomers[customerIndex];

            for (int i = 0; i < s.itemsCount; i++) {

                System.out.println(s.borroweditems[i].sNo + "\t\t\t"
                                + s.borroweditems[i].itemName + "\t\t\t"
                                + s.borroweditems[i].companyName);
            }

            System.out.println("Enter Serial Number of item to be Checked In:");

            int sNo = input.nextInt();

            for (int i = 0; i < s.itemsCount; i++) {
                if (sNo == s.borroweditems[i].sNo) {
                    item.checkInitem(s.borroweditems[i]);
                    s.borroweditems[i] = null;

                    return;
                }
            }

            System.out.println("item of Serial No " + sNo + "not Found");
        }
    }
}
