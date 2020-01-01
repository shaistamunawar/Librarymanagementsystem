
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Books {

    public String Bookid;
    public String bookName;
    public String Publisher;
    public String Author;
    public String Bookshelf;

    public static int bookCount;
    public static int issuedBookCount;
    public static int returnedBookCount;

    public Books() {
        Bookid = null;
        bookName = null;
        Publisher = null;
        Author = null;
        Bookshelf = null;
    }

    public Books(String bi, String bn, String pub, String aut, String bs) {
        Bookid = bi;
        bookName = bn;
        Publisher = pub;
        Author = aut;
        Bookshelf = bs;
    }

    @Override
    public String toString() {
        return Bookid + ", " + bookName + ", " + Publisher + ", " + Author + ", " + Bookshelf;
    }
    
    public static Books[] getAllBooks(String filename) {

        File file = null;
        int count = 0;
        
        if (filename.equals("books")) {
            file = new File("records\\books.txt");
            count = bookCount;
        } else if (filename.equals("issuedBooks")) {
            file = new File("records\\issuedBooks.txt");
//            System.out.println(file.toPath());
            count = issuedBookCount;
        } else if (filename.equals("returnedBooks")) {
            file = new File("records\\returnedBooks.txt");
            count = returnedBookCount;
        }
        
        BufferedReader br = null;

        Books[] books = null;

        try {
            br = new BufferedReader(new FileReader(file));
            books = new Books[count];

            String line = "";
            String[] bookArray = new String[5];

            for (int i = 0; (line = br.readLine()) != null; i++) {
                bookArray = line.split(":");
//                System.out.println(line);
                books[i] = new Books(bookArray[0], bookArray[1], bookArray[2], bookArray[3], bookArray[4]);
//                System.out.println(line+"\n");
            }

        } catch (Exception e) {
        }

//        for (int i=0; i<books.length; i++) {
//            System.out.println(books[i].toString());
//        }
        return books;
    }

    public static boolean issueBook(String bookID) {
        File booksFile = new File("records\\books.txt");
        File issuedBooksFile = new File("records\\issuedBooks.txt");

        BufferedReader br = null;
        BufferedWriter bw = null;
        String book = "";

        try {
            br = new BufferedReader(new FileReader(booksFile));

            String line = "";
            String[] bookArray = new String[5];

            for (int i = 0; (line = br.readLine()) != null; i++) {
                bookArray = line.split(":");
                if (bookArray[0].equals(bookID)) {
                    book = line;
                    //bw.write(line);
                    Books.countBooks("");
                    //System.out.println(line);
                    //return true;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            bw = new BufferedWriter(new FileWriter(issuedBooksFile.getAbsoluteFile(), true));
            bw.write(book + "\r\n");
            bw.flush();

            return true;
        } catch (Exception e) {

        }

        return false;
    }

    public static boolean returnBook(String bookID) {
        File returnedBooksFile = new File("records\\returnedBooks.txt");
        File issuedBooksFile = new File("records\\issuedBooks.txt");
        Books.countBooks("");
        
        BufferedReader br = null;
        BufferedWriter bw = null;
        String book = "";
        String[] issuedBooks = new String[Books.issuedBookCount-1];
        
        try {
            br = new BufferedReader(new FileReader(issuedBooksFile));

            String line = "";
            String[] bookArray = new String[5];

            for (int i = 0; (line = br.readLine()) != null; ) {
                bookArray = line.split(":");
                if (bookArray[0].equals(bookID)) {
                    book = line;
                }
                else {
                    issuedBooks[i] = line;
                    i++;
                }
            }
            System.out.println(Arrays.toString(issuedBooks));
            Books.countBooks("");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            bw = new BufferedWriter(new FileWriter(returnedBooksFile.getAbsoluteFile(), true));
            bw.write(book + "\r\n");
            bw.flush();
            
        } catch (Exception e) {
        }
        
        try {
            bw = new BufferedWriter(new FileWriter(issuedBooksFile));
            for (int i=0; i<issuedBooks.length-1; i++) {
                bw.write(issuedBooks[i] + "\r\n");
            }
            bw.flush();
            
            return true;
        } catch (Exception e) {
        }

        return false;
    }
    
    public static void countBooks(String filename) {
        File file;
        BufferedReader br = null;
        
        bookCount = 0;
        issuedBookCount = 0;
        returnedBookCount = 0;
        
        try {
            file = new File("records\\books.txt");
            br = new BufferedReader(new FileReader(file));
            while (br.readLine() != null) {
                bookCount++;
            }
            
            file = new File("records\\issuedBooks.txt");
            br = new BufferedReader(new FileReader(file));
            while (br.readLine() != null) {
                issuedBookCount++;
            }
            
            file = new File("records\\returnedBooks.txt");
            br = new BufferedReader(new FileReader(file));
            while (br.readLine() != null) {
                returnedBookCount++;
            }
        } catch (Exception e) {
        }
        
    }

}
