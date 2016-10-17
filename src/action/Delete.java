package action;
import model.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Author;

public class Delete {
	private Book aBook = new Book();
	private ArrayList<Book> books = new ArrayList<Book>();
	private Author aAuthor = new Author();
	private Author authorOut = new Author();
	private ArrayList<Author> authors = new ArrayList<Author>();
	
	public String execute() throws Exception {	
		String url = "jdbc:mysql://localhost:3306/test1";
		String user="root";
		String password="lalala";
		try {
			Class.forName("com.mysql.jdbc.Driver");
            System.out.println("初始化完成");
			String sql;
			Connection conn = null;
			PreparedStatement stmt = null;
			System.out.println("开始连接数据库");
			conn = DriverManager.getConnection(url,user,password);
            System.out.println("链接完成");
			sql = "delete from book3 where isbn=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, aBook.getIsbn());
			stmt.executeUpdate();
            stmt.close();
            conn.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
            System.out.println("连接失败!");
			e.printStackTrace();
		}
		return "success";
	}
	
	
	public Book getaBook() {
		return aBook;
	}
	public void setaBook(Book aBook) {
		this.aBook = aBook;
	}
	public Author getaAuthor() {
		return aAuthor;
	}
	public void setaAuthor(Author aAuthor) {
		this.aAuthor = aAuthor;
	}
	public ArrayList<Book> getBooks() {
		return books;
	}
	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}

	public Author getAuthorOut() {
		return authorOut;
	}

	public void setAuthorOut(Author authorOut) {
		this.authorOut = authorOut;
	}

	public ArrayList<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(ArrayList<Author> authors) {
		this.authors = authors;
	}
}
