package prob3;

public class Sparrow extends Bird {
	protected String name;

	public String toString() {
		return "참새의 이름은 "+name+" 입니다.";
	}
	
	public void fly() {
		System.out.println("참새("+name+")가 날아다닙니다.");
	}
	public void sing() {
		System.out.println("참새("+name+")가 소리내어 웁니다.");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
