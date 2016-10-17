package action;
import java.util.ArrayList;
import java.sql.*;
import model.Author;
import model.Book;

public class Edit {
	private Book aBook=new Book();
	private ArrayList<Author> authors = new ArrayList<Author>();
	private int warring=0;
	private Book newBook=new Book();
	private Author aAuthor = new Author();
	public String turn2edit() throws Exception {	
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
			sql = "select * from book3 where ISBN=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, aBook.getIsbn());
			rs = stmt.executeQuery();
            System.out.println("查询完成");
            aBook.setIsbn(aBook.getIsbn());
            while (rs.next()){
            	aBook.setTitle(rs.getString(2));
            	aBook.setAuthorId(rs.getString(3));
            	aBook.setPublisher(rs.getString(4));
            	aBook.setPublishDate(rs.getString(5));
            	aBook.setPrice(rs.getString(6));
            }
            
			sql = "select * from author3";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
            System.out.println("查询完成");
			Author tempAuthor=null;
            while (rs.next()){
            	//System.out.println("123");

            	tempAuthor = new Author();
            	tempAuthor.setAuthorId(rs.getString(1));
            	//System.out.println(rs.getString(1));
            	tempAuthor.setName(rs.getString(2));
            	tempAuthor.setAge(rs.getString(3));
            	tempAuthor.setCountry(rs.getString(4));
            	//System.out.println(tempAuthor.getName());
            	getAuthors().add(tempAuthor);
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
	

	public String edit() throws Exception {	
		String url = "jdbc:mysql://localhost:3306/test1";
		String user="root";
		String password="lalala";
		try {
			Class.forName("com.mysql.jdbc.Driver");
            System.out.println("修改初始化完成");
			String sql;
			Connection conn = null;
			PreparedStatement stmt = null;
			System.out.println("修改开始连接数据库");
			conn = DriverManager.getConnection(url,user,password);
            System.out.println("修改链接完成");
			System.out.println(getNewBook().getIsbn());
			System.out.println(aBook.getIsbn());

			
			sql = "UPDATE `book3` SET `Title`=?,`AuthorID`=?,`Publisher`=?,`PublishDate`=?,`Price`=? WHERE `ISBN`=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(6, getNewBook().getIsbn());
			stmt.setString(1, getNewBook().getTitle());
			stmt.setString(2, getNewBook().getAuthorId());
			stmt.setString(3, getNewBook().getPublisher());
			stmt.setString(4, getNewBook().getPublishDate());
			stmt.setString(5, getNewBook().getPrice());
			stmt.executeUpdate();
            System.out.println("修改完成");
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


	public Book getNewBook() {
		return newBook;
	}


	public void setNewBook(Book newBook) {
		this.newBook = newBook;
	}


	public Author getaAuthor() {
		return aAuthor;
	}


	public void setaAuthor(Author aAuthor) {
		this.aAuthor = aAuthor;
	}
	
}
