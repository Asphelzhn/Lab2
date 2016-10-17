package model;


public class Book {
	private String isbn;
	private String title;
	private String authorId;
	private String publisher;
	private String publishDate;
	private String Price;
	
	
	/*
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String url = "jdbc:mysql://localhost:3306/test1";
		String user="root";
		String password="lalala";

		try {
			Class.forName("com.mysql.jdbc.Driver");

			String sql;
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			
			conn = DriverManager.getConnection(url,user,password);
			
			sql = "insert into book values(3,'aaa',2,'b','123','123.4')";
			stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();
			
			sql = "delete from book where isbn=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, 123123);
			stmt.executeUpdate();
			
			sql = "select * from book";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
            while (rs.next()){
                System.out.print(rs.getString(1)+'\t');
                System.out.print(rs.getString(2)+'\t');
                System.out.print(rs.getString(3)+'\t');
                System.out.print(rs.getString(4)+'\t');
                System.out.print(rs.getString(5)+'\t');
                System.out.print(rs.getString(6)+'\t'+'\n');
            }
            rs.close();
            stmt.close();
            conn.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
            System.out.println("连接失败!");
			e.printStackTrace();
		}
	}
*/

	public String getIsbn() {
		return isbn;
	}



	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getAuthorId() {
		return authorId;
	}



	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}



	public String getPublishDate() {
		return publishDate;
	}



	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}



	public String getPrice() {
		return Price;
	}



	public void setPrice(String price) {
		Price = price;
	}



	public String getPublisher() {
		return publisher;
	}



	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	
}
