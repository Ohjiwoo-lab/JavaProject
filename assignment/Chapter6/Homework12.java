/*
 * [12번 과제] 문제 10의 갬블링 게임을 n명이 하도록 수정한다. 실행 예시와 같이 게임에 참여하는 섬수의 수를 입력받고 각 선수의 이름을 입력받도록 수정한다.
 * 같은 챕터 내이기 때문에 Person10이 아닌 Person12로 수정하여 작성한다.
 */

package Chapter6;
import java.util.Scanner;

// 게임을 진행하기 위한 클래스(이는 10번 과제와 완벽히 동일하다. 한 사람에 대한 게임 진행을 하는 클래스이므로 사람 수가 늘어나더라도 이는 변하지 않기 때문이다.)
class Person12{
    String name, enter;
    Scanner scanner = new Scanner(System.in);

    // 인자 있는 생성자
    public Person12(String name){
        this.name = name;  // 이름을 초기화한다.
    }

    // 게임을 진행하기 위한 메소드
    public boolean game(){
        System.out.print("[" + name + "] : <Enter>");
        enter = scanner.nextLine();  // Enter 키를 입력받음

        int num[] = new int[3];  // 수를 저장할 int 배열
        System.out.print("\t\t");
        for(int i = 0; i < 3; i++){  // Math 클래스의 random() 메소드로 총 3개의 정수를 난수로 생성한다.
            num[i] = (int)(Math.random()*3 + 1);  // 1.0~3.0 사이의 랜덤한 실수를 리턴하면 이를 int 형으로 타입 캐스팅한다.
            System.out.print("\t" + num[i]);  // 생성한 난수를 출력한다.
        }

        if(num[0] == num[1] && num[1] == num[2]){  // num[0]와 num[1]이 같고, num[1]과 num[2]가 같으면 자동으로 num[0]와 num[2]는 같다. == 연산자로 비교해준 뒤, 모두 같으면 true를 리턴한다.
            System.out.println("\t" + name + "님이 이겼습니다!");
            return true;
        }
        else {
            System.out.println("\t 아쉽군요!");
            return false;  // 하나라도 다른 수가 있다면 false를 리턴한다.
        }
    }
}

public class Homework12 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("갬블링 게임에 참여할 선수 숫자>> ");
        int personNum = scanner.nextInt();  // 선수 숫자를 입력받음
        Person12 p[] = new Person12[personNum];  // 선수 숫자만큼 Person12 객체를 저장하기 위한 배열을 선언한다. 이제 이 배열에 각 객체를 저장할 것이다.

        for(int i = 0; i < personNum; i++){  // 선수 숫자만큼 반복
            System.out.print((i + 1) + "번째 선수 이름>> ");
            String name = scanner.next();  // 이름 입력
            p[i] = new Person12(name);  // 입력받은 이름으로 객체 생성하여 p 배열에 저장
        }

        boolean flag = true;
        while(flag){
            // 선수들 중 모두 같은 수가 나온 경우에만 while 문을 빠져나가면서 프로그램이 종료된다.
            // Person12 클래스의 game() 메소드가 3개의 수가 모두 같은 수가 나온 경우만 true를 리턴하기 때문에 이렇게 구현하였다.
            for(int i = 0; i < personNum; i++) {  // 선수 숫자만큼 반복
                if (p[i].game()) {  // 어느 선수가 이긴 경우
                    flag = false;  // 전체 while 문을 빠져나가기 위함
                    break;
                }
            }
        }
    }
}
