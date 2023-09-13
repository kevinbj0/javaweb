package day_07_MVC실습;

import java.util.ArrayList;

public class goodService {
	//Dao 생성
	goodDAO dao = new goodDAO();
	
	//전체 상품 검색
	public ArrayList<String> getMenuList(){
		ArrayList<String> list = dao.selectAll();
		return list;
	}
	
	//search : id로 검색
	public String getMenuOne(String id) {
		String name = dao.selectOne(id);
		return name;
	}
	//insert : 데이터 추가
	public void insertMenu(Good good) {
		dao.insertMenu2(good);
	}
	//delect : 데이터 삭제
	public void delectMenu(String id) {
		dao.deleteMenu(id);
	}
	
	//update : 데이터 수정
	public void updateMenu(String id, String price) {
		dao.UpdateMenu(id, price);
	}
	
}
