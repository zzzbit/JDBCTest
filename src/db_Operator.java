
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class db_Operator {
	private Connection con = null;
	private Statement st = null;

	public db_Operator() {
	}

	// 连接数据库
	public db_Operator(String dbtype, String dbName, String usrName, String pwd) {
		String url = null;
		if (dbtype.equals("sqlserver")) {
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				System.out.println("classNotFound");
			}
			url = "jdbc:sqlserver://localhost:1433;DatabaseName=" + dbName;
		} else if (dbtype.equals("mysql")) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("classNotFound");
			}
			url = "jdbc:mysql://localhost:3306/" + dbName;
		} else {
			System.out.println("wrong db type");
		}
		try {
			con = DriverManager.getConnection(url, usrName, pwd);
			st = con.createStatement();
		} catch (SQLException e) {
			System.out.println("connectionIsFaile");
		}

	}

	// 执行sql语句
	public boolean db_Execute(String sql) {
		try {
			st.executeUpdate(sql);
			return true;
		} catch (Exception err) {
			System.out.println("插入、修改或删除出错，请检查sql语句");
			return false;

		}
	}
	
	// 查询
	public ResultSet db_Query(String sql) {
		try {
			return st.executeQuery(sql);
		} catch (Exception err) {
			System.out.println("查询出错，请检查sql语句");
			return null;
		}

	}

	// 关闭
	public void db_Close() {
		try {
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			System.out.println("数据库关闭失败");
		}

	}
}
