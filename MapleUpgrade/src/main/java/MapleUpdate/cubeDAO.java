package MapleUpdate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class cubeDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:testdb";
	String user = "scott";
	String password = "tiger";
	
	//dbcon : db연결
	public Connection dbcon() {
		Connection con = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			if(con!= null) {
				System.out.println("연결");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	//close : 자원 할당해제
	public void close(AutoCloseable ...a) {
		for(AutoCloseable item : a) {
			try {
				item.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<String> AllCart(){
		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;
		System.out.println("실행1");
		String sql = "select * from cube_cart";
		
		ArrayList<String> list = new ArrayList<>();
		
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			System.out.println("실행2");
			while(rs.next()) {
				list.add(rs.getString(1));
				list.add(rs.getString(2));
				System.out.println("실행3");
				System.out.println(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		close(rs,pst,con);
		return list;
	}
	
	public void AddCart(Cube cube) {
		Connection con = dbcon();
		PreparedStatement pst = null;
		
		String sql = "insert into cube_cart value(?,?)";
		
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1,cube.getName());
			pst.setString(2,cube.getPrice());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(con,pst);
	}
	
	public void deleteCart(String name) {
		Connection con = dbcon();
		PreparedStatement pst = null;
		String sql = "delete from cube_cart where name = ?";
		
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, name);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(con,pst);
	}
	
	public static void main(String[] args) {
		
		cubeDAO  dao = new cubeDAO();
		System.out.println( dao.AllCart());
		
	}
}
