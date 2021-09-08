package prob04;

public class Depart extends Employee{
	private String develop;
	public Depart() {	
	}
	
	public Depart(String name, int salary, String develop) {
		super.setName(name);
		super.setSalary(salary);
		this.develop=develop;
	}
	
	public void getInformation() {
		System.out.println( "이름:" + super.getName() + " 연봉:" + super.getSalary() + " 부서:"+develop);
	}
	
}
