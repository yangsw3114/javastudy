package prob2;

public class SmartPhone extends MusicPhone{
	public void execute(String function) {
		if(function.equals("앱")) {
			App();
			return;
		}
		super.execute(function);
	}
	
	private void App() {
		System.out.println("앱 실행");
	}
}
