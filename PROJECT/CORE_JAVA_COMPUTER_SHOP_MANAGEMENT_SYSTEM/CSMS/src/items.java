import java.util.Scanner;


public class items {

    item theitems[] = new item[50];
    public static int count;

    Scanner input = new Scanner(System.in);

    public int compareitemObjects(item b1, item b2)
    {
        if (b1.itemName.equalsIgnoreCase(b2.itemName)) {

            System.out.println("item of this Name Already Exists.   ");
            System.out.println("************************************");
            return 0;
        }

        if (b1.sNo == b2.sNo) {
            System.out.println("item of this Serial No Already Exists.");
            return 0;
        }
        return 1;
    }

    public void additem(item b)
    {

        for (int i = 0; i < count; i++) {
            if (this.compareitemObjects(b, this.theitems[i]) == 0)
                return;
        }

        if (count < 50) {
            theitems[count] = b;
            count++;
        }
        else {
            System.out.println("we can only add up to 50 items in this java project.");
        }
    }

    public void searchBySno()
    {
        System.out.println("\t\t\t\t******** SEARCH BY SERIAL NUMBER **********\n");
        int sNo;
        System.out.println("Enter Serial No of item:");
        sNo = input.nextInt();
        int flag = 0;
        System.out.println("S.No\t\tName\t\tCompany\t\tAvailable Qty\t\tTotal Qty");

        for (int i = 0; i < count; i++) {
            if (sNo == theitems[i].sNo) {
                System.out.println(theitems[i].sNo + "\t\t"
                                + theitems[i].itemName + "\t\t"
                                + theitems[i].companyName + "\t\t"
                                + theitems[i].itemQtyCopy + "\t\t"
                                + theitems[i].itemQty);
                flag++;
                return;
            }
        }
        System.out.println("------------------------------------");
        if (flag == 0)
            System.out.println("No item for Serial No " + sNo + " Found.");
    }

    public void searchByComapnyName()
    {

        System.out.println("\t\t\t\tSEARCH BY COMPANY'S NAME");

        input.nextLine();

        System.out.println("Enter Company Name:");
        String companyName = input.nextLine();

        int flag = 0;

        System.out.println("S.No\t\tName\t\tCompany\t\tAvailable Qty\t\tTotal Qty");

        for (int i = 0; i < count; i++) {
            if (companyName.equalsIgnoreCase(theitems[i].companyName)) {
                System.out.println(
                        theitems[i].sNo + "\t\t"
                                + theitems[i].itemName + "\t\t"
                                + theitems[i].companyName + "\t\t"
                                + theitems[i].itemQtyCopy + "\t\t"
                                + theitems[i].itemQty);
                flag++;
            }
        }


        if (flag == 0)
            System.out.println("No items of " + companyName + " Found.");
    }

    public void showAllitems()
    {

        System.out.println("\t\t\t\tSHOWING ALL itemS\n");
        System.out.println("S.No\t\tName\t\tCompany\t\tAvailable Qty\t\tTotal Qty");

        for (int i = 0; i < count; i++) {

            System.out.println(theitems[i].sNo + "\t\t"
                            + theitems[i].itemName + "\t\t"
                            + theitems[i].companyName + "\t\t"
                            + theitems[i].itemQtyCopy + "\t\t"
                            + theitems[i].itemQty);
        }
    }

    public void upgradeitemQty()
    {

        System.out.println("\t\t\t\tUPGRADE QUANTITY OF A item\n");
        System.out.println("Enter Serial No of item");

        int sNo = input.nextInt();

        for (int i = 0; i < count; i++) {
            if (sNo == theitems[i].sNo) {
                System.out.println("Enter No of items to be Added:");
                int addingQty = input.nextInt();
                theitems[i].itemQty += addingQty;
                theitems[i].itemQtyCopy += addingQty;

                return;
            }
        }
    }

    public void dispMenu()
    {

        // Displaying menu
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("1 : Add new item.");
        System.out.println("2 : Upgrade Quantity of a item.");
        System.out.println("3 : Search a item.");
        System.out.println("4 : Show All items.");
        System.out.println("5 : Register customer.");
        System.out.println("6 : Show All Registered customers.");
        System.out.println("7 : Check Out item. ");
        System.out.println("8 : Check In item");
        System.out.println("0 : Exit Application.");
        System.out.println("-------------------------------------------------------------------------------------------------------");
    }

    public int isAvailable(int sNo)
    {

        for (int i = 0; i < count; i++) {
            if (sNo == theitems[i].sNo) {
                if (theitems[i].itemQtyCopy > 0) {

                    System.out.println("item is Available.");
                    return i;
                }
                System.out.println("item is Unavailable");
                return -1;
            }
        }

        System.out.println("No item of Serial Number " + " Available in Library.");
        return -1;
    }


    public item checkOutitem()
    {

        System.out.println("Enter Serial No of item to be Checked Out.");
        int sNo = input.nextInt();

        int itemIndex = isAvailable(sNo);

        if (itemIndex != -1) {
            theitems[itemIndex].itemQtyCopy--;
            return theitems[itemIndex];
        }
        return null;
    }

    public void checkInitem(item b)
    {
        for (int i = 0; i < count; i++) {
            if (b.equals(theitems[i])) {
                theitems[i].itemQtyCopy++;
                return;
            }
        }
    }
}
