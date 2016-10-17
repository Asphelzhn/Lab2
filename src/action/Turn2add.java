package action;

import java.util.ArrayList;
import java.sql.*;
import model.Author;
import model.Book;

public class Turn2add {
	private Book newBook = new Book();
	private Author newAuthor = new Author();
	private ArrayList<Author> authors = new ArrayList<Author>();
	private int warring;
	
	public String excute() throws Exception {	
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
            if(newBook.getIsbn()!=null)
            	setWarring(1);
            else if(newAuthor.getAuthorId()!=null)
            	setWarring(2);
            else 
            	setWarring(0);
            System.out.println(getWarring());
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
	
	
	
}
