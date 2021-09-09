package ch03;

public class Person {
	private String name;
	
	public Person() {
		System.out.println("Person 클래스의 생성자가 호출");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
