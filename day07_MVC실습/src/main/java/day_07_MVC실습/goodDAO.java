package day_07_MVC실습;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class goodDAO {
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
			if(con != null) {
				System.out.println("ok");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	//close : 자원 할당해제 
	public void close(AutoCloseable ... a) {
		for(AutoCloseable item : a) {
			try {
				item.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//전체 리스트 조회
	public ArrayList<String> selectAll(){
		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		//sql문
		String sql = "select * from goodstbl";
		
		ArrayList<String> list = new ArrayList<>();
		
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				list.add(rs.getString(1));
				list.add(rs.getString(2));
				list.add(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//자원해제
		close(rs, pst, con);
		return list;
	}
	
	//search : id로 검색
	public String selectOne(String id) {
		//db연결
		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String name = null;
		
		//sql
		String sql = "select * from goodstbl where id = ?";
		
		try {
			//sql 장전
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			
			//sql 실행
			rs = pst.executeQuery();
			if(rs.next()) {
				//검색결과 객체 생성
				name = rs.getString(2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		close(con,pst,rs);
		
		return name;
	}
	
	//insert : 데이터 삽입 (방법1)
	public void insertMenu(String id, String name, String price) {
		Connection con = dbcon();
		PreparedStatement pst = null;
		
		String sql = "insert into goodstbl values(?,?,?)";
		
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, name);
			pst.setString(3, price);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(con,pst);
	}
	//insert : 데이터 삽입 (방법2)
	public void insertMenu2(Good good) {
		Connection con = dbcon();
		PreparedStatement pst = null;
		
		String sql = "insert into goodstbl values(?,?,?)";
		
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, good.getId());
			pst.setString(2, good.getName());
			pst.setString(3, good.getPrice());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(con,pst);
	}
	
	//delete : 데이터 삭제
	public void deleteMenu(String id) {
		Connection con = dbcon();
		PreparedStatement pst = null;
		
		String sql = "delete from goodstbl where id = ?";
		
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(con,pst);
	}
	
	public Good UpdateMenu(String id, String price) {
		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Good updateMenu = null;
		
		String sql = "update goodstbl set price = ? where id = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, price);
			pst.setString(2, id);
			rs = pst.executeQuery();
			if(rs.next()) {
				String id_tmp = rs.getString(1);
				String name_tmp = rs.getString(2);
				String price_tmp = rs.getString(3);
				updateMenu = new Good(id_tmp,name_tmp,price_tmp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(con,pst,rs);
		return updateMenu;
	}
	
	//메인함수(테스트)
	public static void main(String[] args) {
		goodDAO dao = new goodDAO();
		
		ArrayList<String> list = dao.selectAll();
		System.out.println(list);
	}
}
