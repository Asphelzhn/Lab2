package action;
import model.Author;
import model.Book;
import java.sql.*;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
//lallala
public class Add extends ActionSupport{
	private Book newBook = new Book();
	private ArrayList<Book> books = new ArrayList<Book>();
	private ArrayList<Author> authors = new ArrayList<Author>();
	private Author newAuthor = new Author();
	private int warring=0;
	
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
			ResultSet rs = null;
			System.out.println("开始连接数据库");
			conn = DriverManager.getConnection(url,user,password);
            System.out.println("链接完成");
			sql = "select * from book3 where isbn=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, newBook.getIsbn());
			rs = stmt.executeQuery();
			if(rs.next())
			{
				warring=1;
				System.out.println("ISBNerror");
				return "ISBNerror";
			}

			
			sql = "INSERT INTO `book3`(`ISBN`, `Title`, `AuthorID`, `Publisher`, `PublishDate`, `Price`) VALUES (?,?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, newBook.getIsbn());
			stmt.setString(2, newBook.getTitle());
			stmt.setString(3, newBook.getAuthorId());
			stmt.setString(4, newBook.getPublisher());
			stmt.setString(5, newBook.getPublishDate());
			stmt.setString(6, newBook.getPrice());
			stmt.executeUpdate();
			
            System.out.println("开始查找");
			sql = "select * from book3";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
            System.out.println("查询完成");
			Book tempBook=null;
            while (rs.next()){
            	tempBook = new Book();
            	tempBook.setIsbn(rs.getString(1));
            	tempBook.setTitle(rs.getString(2));
            	tempBook.setAuthorId(rs.getString(3));
            	tempBook.setPublisher(rs.getString(4));
            	tempBook.setPublishDate(rs.getString(5));
            	tempBook.setPrice(rs.getString(6));
            	getBooks().add(tempBook);
            }
            rs.close();
            stmt.close();
            conn.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
            System.out.println("连接失败!");
			e.printStackTrace();
		}
		return "success";
	}

	public String addAuthor() throws Exception {	
		String url = "jdbc:mysql://localhost:3306/test1";
		String user="root";
		String password="lalala";
		try {
			Class.forName("com.mysql.jdbc.Driver");
            System.out.println("初始化完成");
			String sql;
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			System.out.println("开始连接数据库");
			conn = DriverManager.getConnection(url,user,password);
            System.out.println("链接完成");
			sql = "select * from book3 where isbn=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, newBook.getIsbn());
			rs = stmt.executeQuery();
			
			sql = "insert into author3(name,age,country) values(?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, newAuthor.getName());
			stmt.setString(2, newAuthor.getAge());
			stmt.setString(3, newAuthor.getCountry());
			stmt.executeUpdate();
			
            rs.close();
            stmt.close();
            conn.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
            System.out.println("连接失败!");
			e.printStackTrace();
		}
		return "addAuthorSuccess";
	}
	
	public Book getNewBook() {
		return newBook;
	}

	public void setNewBook(Book newBook) {
		this.newBook = newBook;
	}

	public Author getNewAuthor() {
		return newAuthor;
	}

	public void setNewAuthor(Author newAuthor) {
		this.newAuthor = newAuthor;
	}

	public ArrayList<Book> getBooks() {
		return books;
	}

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}







	public ArrayList<Author> getAuthors() {
		return authors;
	}







	public void setAuthors(ArrayList<Author> authors) {
		this.authors = authors;
	}


	public int getWarring() {
		return warring;
	}


	public void setWarring(int warring) {
		this.warring = warring;
	}


}
