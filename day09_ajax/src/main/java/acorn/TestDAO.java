package acorn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TestDAO {
	//데이터베이스 연결정보
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:testdb";
	String user="scott";
	String password="tiger";
	
	public Connection dbcon(){
		Connection con = null;
		//객체생성하는 코드
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	/* 전체조회
	public ArrayList<Member> getMemberList(){
		
	}*/
	
	/* 개별조회
	public Member selectOne(String id) {
		
	}*/
	public static void main(String[] arg) {
		TestDAO dao = new TestDAO();
		Connection con = dao.dbcon();
		if(con!= null) System.out.println("db ok");
		String name = dao.selectOne("dy");
		System.out.println(name);
		
	}
	public String selectOne(String id) {
		PreparedStatement pst = null;
		Connection con = dbcon();
		String sql = "select name from acorntbl where id=?";
		
		String name = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			//rs.next : 한줄씩 넘김, 조건에 넣으면 데이터 있으면 true반환 없으면 false
			if(rs.next()) {
				name = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return name;
	}
	
}
