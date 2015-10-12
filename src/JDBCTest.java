import java.sql.*;

public class JDBCTest {

	/**
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {
		String dbName = null;
		String usrName = null;
		String pwd = null;
		String url;
		// 1.注册驱动
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 2.获得连接
		// url = "jdbc:mysql://localhost:3306/" + dbName;
		url = "jdbc:sqlserver://localhost:1433;DatabaseName=" + dbName;
		Connection connection = DriverManager.getConnection(url,
				usrName, pwd);
		// 3.获取表达式
		Statement statement = connection.createStatement();
		// 4.读取数据
		statement.executeUpdate("");
		ResultSet rs = statement.executeQuery("");
		// 5.显示结果集数据
		while (rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
		}
		// 6.释放资源
		rs.close();
		statement.close();
		connection.close();
	}

}
