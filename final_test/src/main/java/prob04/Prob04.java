package prob04;

public class Prob04 {

	public static void main(String[] args) {
		Person Kim = new Person(12, "김자바");
		Current_numOfPerson();
		//김자바 생성후 현재 인구수 출력
		Person Park = new Person(27, "박자바");
		Current_numOfPerson();
		//박자바 생성후 현재 인구수 출력
		Person Lee = new Person(28, "이자바");
		Current_numOfPerson();
		//이자바 생성후 현재 인구수 출력
		
		Kim.selfIntroduce();
		Park.selfIntroduce();
		Lee.selfIntroduce();
		//자바들의 자기소개
	}
	
	public static void Current_numOfPerson() {
		System.out.println("현재 인구수는 " + Person.numberOfPerson + "명 입니다.");
	}

}
