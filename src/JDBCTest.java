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
		// 1.ע������
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 2.�������
		// url = "jdbc:mysql://localhost:3306/" + dbName;
		url = "jdbc:sqlserver://localhost:1433;DatabaseName=" + dbName;
		Connection connection = DriverManager.getConnection(url,
				usrName, pwd);
		// 3.��ȡ���ʽ
		Statement statement = connection.createStatement();
		// 4.��ȡ����
		statement.executeUpdate("");
		ResultSet rs = statement.executeQuery("");
		// 5.��ʾ���������
		while (rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
		}
		// 6.�ͷ���Դ
		rs.close();
		statement.close();
		connection.close();
	}

}
