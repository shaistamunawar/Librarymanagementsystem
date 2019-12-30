
import java.util.Scanner;

public class Book_ {

    Books thebook[] = new Books[50];
    public static int count;
    Scanner input = new Scanner(System.in);

    public int comparebookobjects(Books b1, Books b2) {
        if (b1.Bookid.equals(b2.Bookid)) //Property name incoreect
        {
            System.out.println("book of this id already exists");
            return 0;
        }
        return 1;

    }

    public void addBook(Books b) {
        for (int i = 0; i < count; i++) {
            if (this.comparebookobjects(b, this.thebook[i]) == 0) {

                return;

            }
            if (count < 50) {
                thebook[count] = b;
                count++;
            } else {
                System.out.println("No space left to add new books");
            }

        }
    }

    public void searchbyid() {
        System.out.println("\t\t\tSearch book by id\n\n");

        String Bookid;
        System.out.println("enter id of book");
        Bookid = input.next();
        int flag = 0;
        System.out.println("Bookid\t\tbookname\t\tPublisher\t\tAuthor");
        for (int i = 0; i < count; i++) {
            if (Bookid.equals(thebook[i].Bookid)) {
                System.out.println(thebook[i].Bookid + " " + thebook[i].bookName + " " + thebook[i].Publisher + " " + thebook[i].Author);
                flag++;
                return;

            }
        }
        if (flag == 0) {
            System.out.println("book doesnot exist!" + Bookid);
        }
    }

    public void showallbooks() {
        System.out.println("show all books");
        System.out.println("Bookid\t\tbookName\t\tPublisher\t\tAuthor");
        for (int i = 0; i < count; i++) {
            System.out.println("Bookid=" + thebook[i].Bookid + "bookname=" + thebook[i].bookName + "Publisher=" + thebook[i].Publisher + "auhtor=" + thebook[i].Author);

        }
    }

    public void displaymenue() {
        System.out.println("Enter 0 to exist application");
        System.out.println("Enter 1 to addBook");
        System.out.println("Enter 2 Searchid");
        System.out.println("Enter 3 to showallbooks");
        System.out.println("Enter 4 to issue book");
        System.out.println("Enter 5 to return book");

    }

    public int Availability(String Bookid) {
        for (int i = 0; i < count; i++) {
            if (Bookid.equals(thebook[i].Bookid)) {

                if (Books.bookCount > 0) {
                    System.out.println("Book is available");
                    return i;
                }
                System.out.println("Book is Unavailable");
                return -1;
            }

        }
        return -1;
    }

    public Books issuebook() {
        System.out.println("Enter Bookid");
        String Bookid = input.next();
        int bookindex = Availability(Bookid);
        if (bookindex != -1) {
            Books.bookCount--;

            return thebook[bookindex];
        }
        return null;

    }

    public void returnbook(Books b) {
        for (int i = 0; i < count; i++) {
            if (b.equals(thebook[i])) {
                Books.bookCount++;
                return;
            }

        }
    }

}
