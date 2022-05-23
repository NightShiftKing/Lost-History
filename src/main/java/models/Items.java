package main.java.models;

public class Items extends GameObjects {

	private static final long serialVersionUID = 1L;

	public boolean allowpickup = false; 
	public String name;

	public Items(int x, int y) {
		super(x, y);
		
	}

	public boolean isAllowpickup() {
		return allowpickup;
	}

	public void setAllowpickup(boolean allowpickup) {
		this.allowpickup = allowpickup;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void disapear(int x , int y) {
		super.setX(1000);
	}

}
