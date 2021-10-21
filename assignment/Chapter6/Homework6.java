/*
 * [과제 6번] 경과시간을 맞추는 게임을 작성한다.
 * 예시를 참고하여, <Enter> 키를 입력하면 현재 초 시간을 보여주고, 여기서 10초에 더 근접하도록 다음 <Enter> 키를 입력한 사람이 이기는 게임이다.
 */

package Chapter6;
import java.util.Calendar;
import java.util.Scanner;

// 사람마다 게임을 진행할 수 있도록 구성한 클래스
class Person{
    Calendar now = Calendar.getInstance();  // Calendar 객체 생성
    Scanner scanner = new Scanner(System.in);   // Scanner 객체 생성
    private String name, enter;
    private int sec1, sec2;

    // 인자 있는 생성자
    public Person(String name){
        this.name = name;  // 현재 게임을 진행 중인 사용자의 이름을 저장함
    }

    // 엔터를 입력받으면 시간을 계산하여 리턴하는 메소드
    public int calcCalendar(){
        System.out.print(name + "시작 <Enter>키 >>");
        sec1 = pressEnter();  // Enter를 누르면 현재 초 시간을 저장함
        System.out.print("10초 예상 후 <Enter>키 >>");
        sec2 = pressEnter();  // Enter를 누르면 현재 초 시간을 저장함

        int elapsedTime = sec2 - sec1;  // 두 시간의 차를 구함
        /*
         * sec2에서 sec1을 빼면 두 시간사이의 차이를 구할 수 있다. 만약 이 초가 양수라면 sec2가 더 이후의 초라는 것이므로 단순히 차이를 리턴하면 된다.
         * 하지만 만약 음수라면, sec2가 60초를 넘어가서 크기로는 작은 수의 초가 되었다는 의미이다. 따라서 이 경우에는 차이에 60을 더한 값을 리턴해야한다.
         */
        if(elapsedTime < 0){  // 차이가 음수인 경우에는
            elapsedTime = elapsedTime + 60;  // 차이에 60을 더해준다.
        }
        return elapsedTime;  // 두 시간의 차를 리턴
    }

    // 엔터를 실제로 입력받는 메소드
    public int pressEnter(){
        enter = scanner.nextLine();  // Scanner 객체로 enter를 입력받는다.
        now = Calendar.getInstance();  // Calendar 객체 생성, 같은 사람이 2번 사용하기 때문에 한 번 더 생성해준다.

        int second = now.get(Calendar.SECOND);  // Calendar 객체의 get 메소드를 이용하여 현재 시간을 가져온다.
        System.out.println("\t현재 초 시간 = " + second);  // 현재 시간을 출력한 뒤
        return second;  // 리턴한다.
    }
}

public class Homework6 {
    public static void main(String[] args){
        String person[] = {"황기태", "이재문"};  // 사용자 이름 배열

        // 각 사용자에 대해 Person 객체를 생성한다.
        Person p1 = new Person(person[0]);
        Person p2 = new Person(person[1]);

        int result[] = new int[2];  // 사용자 2명에 대한 게임 기록을 저장할 배열을 선언한다.
        System.out.println("10초에 가까운 사람이 이기는 게임입니다.");
        result[0] = p1.calcCalendar();  // 객체의 메소드로 게임 진행(사람 1에 대한 결과)
        result[1] = p2.calcCalendar();  // 사람 2에 대한 결과

        System.out.print(person[0] + "의 결과 " + result[0] + ", " + person[1] + "의 결과 " + result[1] + ", " + "승자는 ");
        /*
         * 결과를 비교할 때는 단순히 result[0] < result[1] 이런 식으로 하면 안된다.
         * 왜냐하면 얼마나 10초에 가까운 가를 토대로 판단해야하기 때문에 저런식으로 하면 단순히 더 많은 초를 한 사람이 이기기 되기 때문이다.
         * 따라서 10에서 결과를 뺀 값을 Math 클래스의 abs 메소드를 이용하여 절댓값으로 취해준다.
         * 이러면 항상 양수의 값이 될 테므로 이를 비교하여 결과의 승자를 구하면 된다.
         * 이때 10에서 뺀 값이므로 작은 값을 가진 사람이 이기게 된다는 것을 유의해야한다.
         */
        if(Math.abs(10 - result[0]) < Math.abs(10 - result[1])){  // 사람 2명에 대한 결과를 비교한다.
            System.out.println(person[0]);  // 사람 1이 더 10초에 가까움(사람1 win)
        }
        else if(Math.abs(10 - result[0]) > Math.abs(10 - result[1])){
            System.out.println(person[1]);  // 사람 2가 더 10초에 가까움(사람2 win)
        }
        else{
            System.out.println("비겼습니다.");  // 비긴 경우
        }
    }
}
