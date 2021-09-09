package ch03;

public class StudentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s1=new Student();
		s1.setGrade(1);
		s1.setMajor("cs");
		s1.setName("둘리"); //((Person))s1).setName("둘리");
		
		Person p1=s1; //Upcasting(암시적)
		p1.setName("둘리");
		
		Student s2 = (Student)p1; // downcasting(명시적)
		s2.setMajor("cs");
	}

}
