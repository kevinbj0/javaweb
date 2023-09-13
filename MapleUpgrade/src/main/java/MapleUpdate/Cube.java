package MapleUpdate;

public class Cube {
	String name;
	String price;
	
	public Cube(String name, String price) {
		super();
		this.name = name;
		this.price = price;
	}

	
	public Cube() {
		// TODO Auto-generated constructor stub
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Cube [name=" + name + ", price=" + price + "]";
	}
}
