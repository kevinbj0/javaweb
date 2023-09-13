package Movie;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class movieService {
	movieDAO dao = new movieDAO();
	
	public JSONArray getMovieList() {
		ArrayList<Movie> list = dao.getMovieList();
		JSONArray arr = new JSONArray();
		for(int i=0; i<list.size(); i++) {
			Movie m = list.get(i);
			JSONObject o  = new JSONObject();
			o.put("name", m.getName());
			o.put("count", m.getCount());
			arr.put(o);
		}
		
		return arr;
	}
}
