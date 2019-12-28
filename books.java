/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

  import java.util.Scanner;
public class books {
    booklibrary thebook[]=new booklibrary[50];
    public static int count;
    Scanner input=new Scanner(System.in);
    public int comparebookobjects(booklibrary b1,booklibrary b2){
        if(b1.bookid==b2.bookid){
            System.out.println("book of this id already exists");
            return 0;
        }
        return 1;
        
    }
    public void addBook(booklibrary b){
        for(int i=0;i<count;i++){
            if(this.comparebookobjects(b,this.thebook[i])==0){ 
                
                return;
                        
                        
            } 
            if(count<50){
                thebook[count]=b;
                count++;
            }
            else{
                System.out.println("No space left to add new books");
            }
            
            
        }
    }
    public void searchbyid(){
        System.out.println("\t\t\tSearch book by id\n\n");
    
    int bookid;
    System.out.println("enter id of book");
    bookid=input.nextInt();
    int flag=0;
    System.out.println("bookid\t\tbookname\t\tpublisher\t\tAuthor");
    for(int i=0;i<count;i++)
        if(bookid==thebook[i].bookid){
            System.out.println(thebook[i].bookid+" "+thebook[i].bookName+" "+thebook[i].publisher+" "+thebook[i].author);
            flag++;
            return;
            
        }
    if(flag==0)
        System.out.println("book doesnot exist!"+bookid);
            }
    public void showallbooks(){
        System.out.println("show all books");
        System.out.println("bookid\t\tbookName\t\tpublisher\t\tauthor");
        for(int i=0;i<count;i++){
            System.out.println("bookid="+thebook[i].bookid+"bookname="+thebook[i].bookName+"publisher="+thebook[i].publisher+"auhtor="+thebook[i].author);
            
        }
    }
    public void displaymenue(){
        System.out.println("Enter 0 to exist application");
        System.out.println("Enter 1 to addBook");
        System.out.println("Enter 2 Searchid");
        System.out.println("Enter 3 to showallbooks");
        System.out.println("Enter 4 to issue book");
        System.out.println("Enter 5 to return book");
        
        
    }
    public int Availability(int bookid){
        for(int i=0;i<count;i++){
            if(bookid==thebook[i].bookid){
        
            if(thebook[i].bookquantitycopy>0){
                System.out.println("Book is available");
                return i;
            }
            System.out.println("Book is Unavailable");
            return-1;
    }
       
        }
         return -1;
    }
    public booklibrary issuebook(){
        System.out.println("Enter bookid");
        int bookid=input.nextInt();
        int bookindex=Availability(bookid);
        if(bookindex!=-1){
            thebook[bookindex].bookquantitycopy--;
            
           return thebook[bookindex];
        }
        return null;
        
    }
    public void returnbook(booklibrary b){
    for(int i=0;i<count;i++){
        if(b.equals(thebook[i])){
            thebook[i].bookquantitycopy++;
            return;
        }
        
    
        }
}
    
        
 
        
    
}
