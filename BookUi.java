package com.pace.library.presentation;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Scanner;

import com.pace.library.entity.book;
import com.pace.library.service.BookServiceProvider;

public class BookUi {

	public static void main(String[] args)throws ClassNotFoundException,SQLException{
		// TODO Auto-generated method stub
		book book=new book();
		ArrayList<book>bookList=new ArrayList<book>();
		
		BookServiceProvider bookServiceProvider=new BookServiceProvider();
		Scanner scnr=new Scanner(System.in);
		int choice;
		while(true) {
			System.out.println("1.Add Book Details 2.Show Book Details 3.Delete Book details 4.Update Book 5.Exit\n");
			System.out.println("Enter Your choice");
			choice=scnr.nextInt();
			scnr.nextLine();
			switch(choice) {
			case 1:
				book=null;
				book=new book();
				System.out.println("Enter book id,book name,author,price");
				book.setBookId(scnr.nextInt());
				scnr.nextLine();
				book.setBname(scnr.nextLine());
				book.setAuthor(scnr.nextLine());
				book.setPrice(scnr.nextFloat());
				scnr.nextLine();
				bookServiceProvider.InsertBookService(book);
				break;
			case 2:
				//1.get books
				bookList=bookServiceProvider.getBookService();
				System.out.println("No.of rows in the table="+bookList.size());
				//2.show books
				bookServiceProvider.showBooksService(bookList);
				break;
			case 3:
				System.out.println("Enter the book Id");
				int id=scnr.nextInt();
				scnr.nextLine();
				bookServiceProvider.deleteBookService( id);
				break;
			case 4:
				System.out.println("Enter the  book id");
				int bid=scnr.nextInt();
				scnr.nextLine();

				break;
			case 5:
				System.out.println("Thank you for using our application");
				System.exit(0);//to terminate the Application
				break;
				
			 
			}
			
		}

	}

}
