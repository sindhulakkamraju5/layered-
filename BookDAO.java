package com.pace.library.dao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.pace.library.entity.book;
import com.pace.library.helper.Dbconnector;


public class BookDAO {

	//private static final int ArrayList = 0;
	//private static final int Book = 0;
	// JDBC API classes for data Retrieval
	private Connection connection = null;
	private PreparedStatement pstatement= null;
	private ResultSet resultSet = null;

	//Book book = new Book();
	ArrayList<book> bookList = null;
	private static String bookQry = "select * from book";

	/**********************Get Books************************/
	public ArrayList<book> getBooks()throws  ClassNotFoundException,SQLException {
	// process to get books from table into bookList:
	// 1. get the book data from table
	// 2. add each book to BookList
	// 3. return BookList
	try {
	//open the connection
	connection = Dbconnector.createConnection();
	//create pstatement
	pstatement = connection.prepareStatement(bookQry);
	//get the result
	resultSet = pstatement.executeQuery();
	book book ;
	bookList = new ArrayList<book>();
	while(resultSet.next()) {
	int bookId;
	String bookName;
	String author;
	float price;
	// declare the pojo
	book = new book();
	// get the row details
	bookId = resultSet.getInt(1);
	bookName = resultSet.getString(2);
	author = resultSet.getString(3);
	price = resultSet.getFloat(4);
	// Add this data to book bean
	// set the pojo with retrieved values from the row

	book.setBookId(bookId);
	book.setBname(bookName);
	book.setAuthor(author);
	book.setPrice(price);

	// add the book to booklist
	bookList.add(book);
	book = null;

	}// end of the while loop

	}catch(SQLException sqlex) {

	}finally {
	// close connection
	// now data is in array list object , close the connection
	Dbconnector.closeConnection();
	}
	//return bookList;
	return bookList;
	}
	/*******************Show list of books ***********************/
	public void showBookList(ArrayList<book> bookList2) {
	System.out.println("In DAO layer");
	for(book book: bookList2) {
	System.out.println(book.getBookId());
	System.out.println("\t" + book.getBname());
	System.out.println("\t" + book.getAuthor());
	System.out.println("\t" + book.getPrice());
	}
	}
	/******************Inserting book data **********************/
	public void insertBookDetails(book book) throws ClassNotFoundException,SQLException{
	connection = Dbconnector.createConnection();
	String insQry = "insert into book values(?,?,?,?)";
	pstatement = connection.prepareStatement(insQry);
	pstatement.setInt(1,book.getBookId());
	pstatement.setString(2,book.getBname());
	pstatement.setString(3,book.getAuthor());
	pstatement.setFloat(4,book.getPrice());

	int rows = pstatement.executeUpdate();
	System.out.println(rows + "Rows Inseted!");
	Dbconnector.closeConnection();

	}
	/******************************* Deleting book *******************/
	public boolean deleteBook(int id) throws SQLException ,ClassNotFoundException{
	pstatement = null;
	// Scanner scnr = new Scanner (System.in);
	connection = Dbconnector.createConnection();
	String delQry = "delete from book where id = ?";
	pstatement = connection.prepareStatement(delQry);
	pstatement.setInt(1,id);
	int rows = pstatement.executeUpdate();
	boolean isDelete = true;
	if(rows !=0) {// if row is non-zero , it is deleted
	isDelete = true; // status of deletion
	}else {
	isDelete = false;
	}
	Dbconnector.closeConnection();
	return isDelete;
	}
	   /******************************** Updating book  ******************************/
	public boolean updateBook(int id) throws SQLException,ClassNotFoundException{
	pstatement = null;

	connection=Dbconnector.createConnection();
	String updPriceQry="update book set price=price+price*0.01 where id=?";
	pstatement=null;
	pstatement=connection.prepareStatement(updPriceQry);
	pstatement.setInt(1, id);
	int rows=pstatement.executeUpdate();
	boolean isUpdate=true;
	if(rows!=0) {//if row available,it is deleted
		isUpdate=true;//status of updation
	}else {
		isUpdate=false;//status of updation
	}
	Dbconnector.closeConnection();
	return isUpdate;
	}
}


