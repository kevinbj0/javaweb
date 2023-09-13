package MapleUpdate;

import java.util.ArrayList;

public class cubeService {
	cubeDAO dao = new cubeDAO();
	
	public ArrayList<String> AllCart(){
		ArrayList<String> list = dao.AllCart();
		return list;
	}
	public void addCart(Cube cube) {
		dao.AddCart(cube);
	}
	
	public void delectCart(String name) {
		dao.deleteCart(name);
	}
}
