package ch03;

public class StaticMethod {
	int n;
	static int m;
	
	void f1() {
		System.out.println(n);
	}
	
	void f2() {
		System.out.println(StaticMethod.m);
		//같은 클래스에서는 스태틱변수 접근에서는 클래스 이름 생략이 가능하다.
		System.out.println(m);
	}
	void f3() {
		f2();
	}
	
	static void s1() {
		//System.out.println(n);
		//오류: static method에서는 인스턴스 변수에 접근할 수 없다.
	}
	
	static void s2() {
		System.out.println(StaticMethod.m);
		//같은 클래스에서는 스태틱변수 접근에서는 클래스 이름 생략이 가능하다.
		System.out.println(m);
	}
	
	static void s3() {
		//f1(); //static method에서는 인스턴스 메서드에 접근할수 없다.
	}
	
	static void s4() {
		StaticMethod.s1();
		//같은 클래스에서는 스태틱변수 접근에서는 클래스 이름 생략이 가능하다.
		s1();
	}
}
