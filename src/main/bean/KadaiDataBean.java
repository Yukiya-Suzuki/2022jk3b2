package bean;

import java.io.Serializable;

public class KadaiDataBean implements Serializable{
	private static final long serialVesionUID = 1L;
	
	private int id;
	private String name;
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
}
	
