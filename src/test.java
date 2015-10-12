import java.sql.ResultSet;
import java.sql.SQLException;


public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		db_Operator my = new db_Operator("mysql","student","root","root");
		ResultSet rs = my.db_Query("SELECT * FROM student.09");
		try {
			while (rs.next()) {
				System.out.println(rs.getInt("age"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
