package prob05;

import java.util.*;

public class prob05 {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			Boolean id_clear = false;
			Boolean pwd_clear = false;
		
			ArrayList<User> user_info = new ArrayList<User>(); //유저들을 저장하기 위한 리스트배열
			User Jhon = new User("jhon","1234");
			user_info.add(Jhon);
			
			System.out.print("아이디를 입력하시오 :");
			String id = sc.nextLine();
			System.out.print("비밀번호를 입력하시오 :");
			String password = sc.nextLine();
			
			for(int i=0; i<user_info.size(); i++) {

				id_clear=user_info.get(i).findId(id);
				pwd_clear=user_info.get(i).findPwd(password);
				
				if(id_clear==true&&pwd_clear==true) 
				{
					System.out.println("로그인 성공");
				}
			}
			
			
		}catch(UserNotFoundException ex){
			System.out.println("존재하지 않는 사용자입니다.");
		}
		
		catch(PasswordDismatchException ex){
			System.out.println("비밀번호가 틀렸습니다.");
		}

		
		
	}

}
