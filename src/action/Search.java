package action;

import java.sql.*;
import java.util.ArrayList;
import model.Author;
import model.Book;

public class Search {
	private Book aBook = new Book();
	private ArrayList<Book> books = new ArrayList<Book>();
	private Author aAuthor = new Author();
	private Author authorOut = new Author();
	private ArrayList<Author> authors = new ArrayList<Author>();
	private int putoutAuthor;
	private int tooMuchAuthor=0;
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
			sql = "select * from author3 where name=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, aAuthor.getName());
			rs = stmt.executeQuery();
			Author temp=null;
			while(rs.next())
			{
				temp = new Author();
				temp.setAuthorId(rs.getString(1));
				temp.setName(rs.getString(2));
				temp.setAge(rs.getString(3));
				temp.setCountry(rs.getString(4));
				authors.add(temp);
			}
			if(authors.isEmpty())
			{
				warring=1;
				return "noAuthor";
			}
			else if (authors.size()>1)
				tooMuchAuthor=1;
            authorOut.setName(authors.get(0).getName());
			
			sql = " select * from book3 where authorid=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, authors.get(0).getAuthorId());
			rs = stmt.executeQuery();
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
            putoutAuthor=1;
            rs.close();
            stmt.close();
            conn.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
            System.out.println("连接失败!");
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	
	public String searchByBookName() throws Exception {	
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
			
			sql = " select * from book3 where title=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, aBook.getTitle());
			rs = stmt.executeQuery();
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
            if(books.isEmpty())
            {
            	warring=1;
            	return "noBooks";
            }
            putoutAuthor=0;
            rs.close();
            stmt.close();
            conn.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
            System.out.println("连接失败!");
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	
	
	public Book getaBook() {
		return aBook;
	}
	public void setaBook(Book aBook) {
		this.aBook = aBook;
	}
	public ArrayList<Book> getBooks() {
		return books;
	}
	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}
	public Author getaAuthor() {
		return aAuthor;
	}
	public void setaAuthor(Author aAuthor) {
		this.aAuthor = aAuthor;
	}



	public ArrayList<Author> getAuthors() {
		return authors;
	}



	public void setAuthors(ArrayList<Author> authors) {
		this.authors = authors;
	}



	public Author getAuthorOut() {
		return authorOut;
	}



	public void setAuthorOut(Author authorOut) {
		this.authorOut = authorOut;
	}

	public int getPutoutAuthor() {
		return putoutAuthor;
	}

	public void setPutoutAuthor(int putoutAuthor) {
		this.putoutAuthor = putoutAuthor;
	}

	public int getTooMuchAuthor() {
		return tooMuchAuthor;
	}

	public void setTooMuchAuthor(int tooMuchAuthor) {
		this.tooMuchAuthor = tooMuchAuthor;
	}

	public int getWarring() {
		return warring;
	}

	public void setWarring(int warring) {
		this.warring = warring;
	}
}
