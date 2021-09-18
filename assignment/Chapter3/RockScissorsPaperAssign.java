/*
 * [과제 16번] 컴퓨터와 독자 사이의 가위 바위 보 게임을 하도록 프로그램을 작성
 * 독자가 가위 바위 보 중 하나를 입력하고 <Enter> 키를 치면, 프로그램은 가위 바위 보 중에서 랜덤하게 하나를 선택하고 컴퓨터가 낸 것으로 한다.
 * 독자가 입력한 값과 랜덤하게 선택한 값을 비교하여 누가 이겼는지 판단한다. 독자가 '그만'을 입력하면 게임은 끝난다.
 */

package Chapter3;
import java.util.Random;
import java.util.Scanner;

public class RockScissorsPaperAssign {
    public static void main(String[] args){
        String str[] = {"가위", "바위", "보"};  //문자열 배열

        Random random = new Random();  //컴퓨터가 내는 값을 랜덤하게 수를 선택하기 위해 객체 생성
        Scanner scanner = new Scanner(System.in);  //scanner 객체 생성

        System.out.println("컴퓨터와 가위 바위 보 게임을 합니다.");
        while(true) {
            System.out.print("가위 바위 보!>>");
            String user_case = scanner.nextLine();  //객체를 이용해 실제로 문자열을 받아오는 코드(여기서 실제로 키보드를 통해 입력받는다), 사용자가 입력한 값이다.

            if(user_case.equals("그만"))  //사용자가 그만을 입력하면 while 문을 빠져나온다.
                break;

            int computer_case = random.nextInt(3);  //bound를 3으로 설정하여 0,1,2 중 하나를 랜덤하게 선택한다. 이 0,1,2는 각각 str 배열의 가위, 바위, 보와 매치되어 컴퓨터가 내는 값이 된다.

            //사용자가 입력한 값과 컴퓨터가 선택한 값을 비교한다.
            if(user_case.equals(str[computer_case]))  //두 가지가 같은 경우는 미리 검사를 하면 컴퓨터가 낸 값이 '바위' 일 때, '가위' 일 때, '보' 일 때 각각 사용자가 입력한 값은 2가지 경우만 존재하므로 더 간편해진다.
                System.out.println("사용자 = " + user_case + ", 컴퓨터 = " + str[computer_case] + ", 비겼습니다.");

            else if(str[computer_case].equals("바위")){
                if(user_case.equals("가위"))
                    System.out.println("사용자 = " + user_case + ", 컴퓨터 = " + str[computer_case] + ", 컴퓨터가 이겼습니다.");
                else
                    System.out.println("사용자 = " + user_case + ", 컴퓨터 = " + str[computer_case] + ", 사용자가 이겼습니다.");
            }
            else if(str[computer_case].equals("가위")){
                if(user_case.equals("보"))
                    System.out.println("사용자 = " + user_case + ", 컴퓨터 = " + str[computer_case] + ", 컴퓨터가 이겼습니다.");
                else
                    System.out.println("사용자 = " + user_case + ", 컴퓨터 = " + str[computer_case] + ", 사용자가 이겼습니다.");
            }
            else {
                if(user_case.equals("바위"))
                    System.out.println("사용자 = " + user_case + ", 컴퓨터 = " + str[computer_case] + ", 컴퓨터가 이겼습니다.");
                else
                    System.out.println("사용자 = " + user_case + ", 컴퓨터 = " + str[computer_case] + ", 사용자가 이겼습니다.");
            }
        }
        System.out.println("게임을 종료합니다...");
        scanner.close();
    }
}
