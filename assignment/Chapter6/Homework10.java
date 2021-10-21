/*
 * [10번 과제] 갬블링 게임을 만들어보자. 게임은 2사람이 진행한다. 이들의 이름을 키보드로 입력받으며 각 사람은 Person10 클래스로 작성한다.
 * 그러므로 프로그램에는 2개의 Person10 객체가 생성되어야 한다. 두 사람은 번갈아 가면서 게임을 진행하는데 각 사람이 자기 차례에서 <Enter> 키를 입력하면, 3개의 난수가 발생되고,
 * 이 숫자가 모두 같으면 승자가 되고 게임이 끝난다. 난수의 범위를 너무 크게 잡으면 3개의 숫자가 일치하게 나올 가능성이 적기 때문에 숫자의 범위는 1~3까지로 한다.
 */

package Chapter6;
import java.util.Scanner;

// 게임을 진행하기 위한 클래스
class Person10{
    String name, enter;
    Scanner scanner = new Scanner(System.in);

    // 인자 있는 생성자
    public Person10(String name){
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

public class Homework10 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        // 수희 이름 입력받고 객체 생성
        System.out.print("1번째 선수 이름>> ");
        String name1 = scanner.nextLine();  // 입력
        Person10 p1 = new Person10(name1);  // 입력받은 이름으로 객체 생성

        // 연수 이름 입력받고 객체 생성
        System.out.print("2번째 선수 이름>> ");
        String name2 = scanner.nextLine();  // 입력
        Person10 p2 = new Person10(name2);  // 입력받은 이름으로 객체 생성

        while(true){
            // 수희 또는 연수 중 모두 같은 수가 나온 경우에만 while 문을 빠져나가면서 프로그램이 종료된다.
            // Person10 클래스의 game() 메소드가 3개의 수가 모두 같은 수가 나온 경우만 true를 리턴하기 때문에 이렇게 구현하였다.
            if(p1.game()){  // 수희가 이긴 경우
                break;
            }
            if(p2.game()){  // 연수가 이긴 경우
                break;
            }
        }
    }
}
