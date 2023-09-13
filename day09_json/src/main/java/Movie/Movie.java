package Movie;

public class Movie {
	String name;
	String count;
	public Movie(String name, String count) {
		super();
		this.name = name;
		this.count = count;
	}
	
	public Movie() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Movie [name=" + name + ", count=" + count + "]";
	}
}
