package model;

public class Category {
	private Integer id;
	private String name;
	private Integer parent;
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	
	
}
