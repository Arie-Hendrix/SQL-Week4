package entity;

public class Dragon {

	private int id;
	private String name;
	private String color;
	private String size;
	private int age;
	
	public Dragon (int id, String name, String color, String size, int age) {
		this.setId(id);
		this.setName(name);
		this.setColor(color);
		this.setSize(size);
		this.setAge(age);
	}
	
	public int getId() {
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
