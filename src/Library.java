
import java.util.Scanner;

public class Library {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("please select");
        Book_ b = new Book_();
        int choice;
        int searchchoice;
        do {
            b.displaymenue();
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    Books bl = new Books(); //efault constructor needed in the class
                    b.addBook(bl);
                    break;
                case 2:
                    b.searchbyid();
                    break;
                case 3:
                    b.showallbooks();
                    break;
                case 4:
                    b.issuebook();
                    break;
                case 5:
                    Books b1 = new Books();
                    b.returnbook(b1);
                    break;
                default:
                    System.out.println("error");

            }

        } while (choice != 0);
    }

}
