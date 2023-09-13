package coffee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CoffeeDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:testdb";
	String user = "scott";
	String password = "tiger";

	public Connection dbcon() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			if (con != null)
				System.out.println("ok");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public void close(AutoCloseable... a) {
		for (AutoCloseable item : a) {
			try {
				item.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//전체 레코드 수
	public int getTotal() {
		int count = 0;
		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		String sql = " select count(*) from coffeetbl ";
		
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		close(con,pst,rs);
		return count;
	}
	
	//현재 페이지에 대한 목록 가져오기
	public ArrayList<Coffee> getListPage(int curpage, int pageSize){
		ArrayList<Coffee> list = new ArrayList<>();
		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		int startPage = 1, endPage = 8;
		startPage = ((curpage-1)*pageSize) +1;
		endPage = curpage * pageSize;
		
		String sql = "select * from (select rownum num, code, name, price from coffeetbl) "
				+ "where num between ? and ?";
		
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, startPage);
			pst.setInt(2, endPage);
			rs = pst.executeQuery();
			while(rs.next()) {
				String code = rs.getString(2);
				String name = rs.getString(3);
				String price = rs.getString(4);
				Coffee c = new Coffee(code, name, price);
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		close(con,pst,rs);
		return list;
	}
	
	//전체 보여주기
		public ArrayList<Coffee> selectAll() {
			ArrayList<Coffee> list = new ArrayList<>();
			Connection con = dbcon();
			PreparedStatement pst = null;
			ResultSet rs = null;

			String sql = "select * from member_tbl_11";

			try {
				pst = con.prepareStatement(sql);
				rs = pst.executeQuery();
				while (rs.next()) {
					String code = rs.getString(1);
					String name = rs.getString(2);
					String price = rs.getString(3);

					Coffee c = new Coffee(code, name, price);
					list.add(c);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			close(con,pst,rs);
			return list;
		}
		
	
	public static void main(String[] args) {
		CoffeeDao dao = new CoffeeDao();
		
		ArrayList<Coffee> list = new ArrayList<>();
		list = dao.selectAll();
		System.out.println(list);
		
		ArrayList<Coffee> list2 = new ArrayList<>();
		list2 = dao.getListPage(2, 4);
		System.out.println(list2);
	}
}
