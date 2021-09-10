package prob04;

public class Person {
	public static int numberOfPerson;
	private int age;
	String name;
	
	public Person() 
	{
		this.age=12;
		this.name="";
		numberOfPerson++;
	}
	
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
		numberOfPerson++;
	}
	
	public void selfIntroduce() {
		System.out.println("내 이름은 " + name + "이며, 나이는 " + age + "살입니다.");
	}
	
	public int getPopulation() {
		return numberOfPerson;
	}
}