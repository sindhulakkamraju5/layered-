package com.pace.library.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.pace.library.dao.BookDAO;
import com.pace.library.entity.book;

public class BookServiceProvider {
	ArrayList<book>bookList=new ArrayList<book>();
    BookDAO bookDAO=new BookDAO();
	
	//reading book data service
	public ArrayList<book>getBookService()throws ClassNotFoundException,SQLException{
		bookList=bookDAO.getBooks();
		return bookList;
		
		
	}
	//showing book data service
	public void showBooksService(ArrayList<book>bookList)throws ClassNotFoundException,SQLException{
		System.out.println("In service layer");
		bookList=bookDAO.getBooks();
		bookDAO.showBookList(bookList);
	}
	//inserting book data service
	public void InsertBookService(book book)throws ClassNotFoundException,SQLException{
		bookDAO.insertBookDetails(book);
	}
	//deleting book data service
	public void deleteBookService(int id)throws ClassNotFoundException,SQLException{
		boolean isBookDeleted=bookDAO.deleteBook(id);
		if(isBookDeleted==true) {
			System.out.println("Book with id"+id+"was deleted");
			
		}else {
			System.out.println("Book with id"+id+" is unavailable");
		}
		
	}
	//updating book data service
	public void updateBookService(int id)throws ClassNotFoundException,SQLException{
		boolean isBookUpdate=bookDAO.updateBook(id);
		//boolean isBookDeleted=bookDAO.updateBook(id);
		if(isBookUpdate==true) {
			System.out.println("Book with id"+id+"was updated!");
			}else {
				System.out.println("Book with id"+id+"is unavailable");
			}
	}
	}
