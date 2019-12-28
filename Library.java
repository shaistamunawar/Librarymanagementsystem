/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
public class Library {
    public static void main(String[] args){
    Scanner input=new Scanner(System.in);
    System.out.println("please select");
    books b=new books();
    int choice;
    int searchchoice;
    do{
        b.displaymenue();
        choice=input.nextInt();
        switch(choice){
            case 1:
                booklibrary bl=new booklibrary();
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
                booklibrary b1=new booklibrary();
                b.returnbook(b1);
                break;
            default:
                System.out.println("error");
                
                
                
        }
        
        
    }
    while(choice!=0);
    }
    
}
