/*
 * [과제 12번] 간단한 콘서트 예약 시스템
 * 기능
 * - 공연은 하루에 한 번 있다.
 * - 좌석은 S석, A석, B석으로 나뉘며, 각각 10개의 좌석이 있다.
 * - 예약 시스템의 메뉴는 "예약", "조회", "취소", "끝내기"가 있다.
 * - 예약은 한 자리만 가능하고, 좌석 타입, 예약자 이름, 좌석 번호를 순서대로 입력받아 예약한다.
 * - 조회는 모든 좌석을 출력한다.
 * - 취소는 예약자의 이름을 받아 취소한다.
 * - 없는 이름, 없는 번호, 없는 메뉴, 잘못된 취소 등에 대해서 오류 메시지를 출력하고 사용자가 다시 시도하도록 한다.
 */

package Chapter4;
import java.util.Scanner;

//실제로 예약, 조회, 취소를 할 수 있는 메소드를 포함한 클래스
class SystemAssign{
    private static Scanner scanner;
    String[][] seats = new String [3][10];  //30개의 좌석을 저장할 수 있는 문자열 배열(2차원 배열로 선언하여 S 10개, A 10개, B 10개를 각각 표현함)

    //좌석을 저장할 수 있는 배열 초기화하는 생성자
    public SystemAssign() {
        for (int i = 0; i < 3; i++) {
            for(int j = 0; j < 10; j++) {
                seats[i][j] = " --- ";
            }
        }
    }

    //좌석타입 1개에 대한 현재 좌석의 상태를 출력해주는 메소드(seatChoice를 매개변수로 받아 좌석타입을 구분함)
    public void printSeat(int seatChoice) {
        String SAB = null;

        switch (seatChoice) {  //switch 문을 통해 어떤 좌석 타입을 출력할지 정함.
            case 1:
                SAB = "S>>";
                break;
            case 2:
                SAB = "A>>";
                break;
            case 3:
                SAB = "B>>";
                break;
        }
        System.out.print(SAB); //좌석타입을 출력

        for (int i = 0; i < 10; i++) {  //해당 좌석에 해당하는 배열을 모두 출력
            System.out.print(seats[seatChoice - 1][i]);
        }
        System.out.println();
    }

    //좌석이 선택되었는지 아닌지를 구별해주는 메소드(좌석이 비어있으면 매개변수로 넘겨준 name으로 배열을 채우고 true를 리턴, 이미 선택되었으면 false를 리턴)
    public boolean already(int seatChoice, int seatNum, String name) {
        if(seats[seatChoice - 1][seatNum - 1].equals(" --- ")) {
            seats[seatChoice - 1][seatNum - 1] = (name + " ");  //예약자 이름으로 배열에 저장함.
            return true;
        }
        else
            return false;
    }

    //실제로 좌석을 예약하는 메소드
    public void reserve() {
        scanner = new Scanner(System.in);

        while(true) {
            System.out.print("좌석 구분 : S(1), A(2), B(3)>>>");
            int choice = scanner.nextInt();  //좌석타입을 입력받음.

            try {  //예외처리(만약 알맞은 좌석타입을 입력하면 그냥 넘어가지만, 잘못된 타입을 입력하면 예외가 발생하면서 다시 선택하라는 문구가 출력)
                if(choice < 1 || choice > 3)
                    throw new Exception();
            }catch(Exception e) {
                System.out.println("다시 선택해주세요.");
                continue;
            }

            printSeat(choice);  //좌석타입에 대한 현재 상태를 출력

            boolean flag2 = true;
            System.out.print("이름>> ");
            String name = scanner.next();  //예약자 이름을 입력받음.
            int seatNum = 0;

            while(flag2) {  //flag2를 통해 알맞은 좌석번호를 입력할 때까지 반복적으로 입력받음.

                System.out.print("번호>> ");
                seatNum = scanner.nextInt();  //좌석번호 입력받음.
                if(seatNum < 1 || seatNum > 10)  //번호가 1~10사이에 속하지 않는경우(잘못된 입력)
                    System.out.println("번호 범위에서 오류가 발생하였습니다. 다시 입력해주세요.");
                else
                    flag2 = false;  //그렇지 않으면 제대로 입력한 것이므로 flag2를 false로 바꿈으로써 while 문을 빠져나갈 준비를 함.
            }

            //already 메소드를 통해 예약자가 선택한 좌석을 예약하면서, 이미 선택된 좌석인지 확인. 
            if(already(choice, seatNum, name)) {
                System.out.println("<<<예약을 완료하였습니다.>>>"); //true면 제대로 예약이 된 것(비어있던 좌석)
            }
            else {  //이미 다른 사용자가 예약한 경우
                System.out.println("이미 예약된 좌석입니다.");
            }
            break;
        }
    }

    //좌석의 상태를 조회하는 메소드
    public void search() {
        for (int i = 0; i < 3; i++)
            printSeat(i + 1); //총 3번 반복하면서 1개의 좌석타입을 출력해주는 메소드를 호출(결과적으로 3개의 좌석타입이 모두 출력)
        System.out.println("<<<조회를 완료하였습니다.<>>");
    }

    //예약한 좌석을 취소할 수 있는 메소드
    public void cancel() {
        scanner = new Scanner (System.in);

        boolean miniflag1 = true;
        int choice = 0;
        while(miniflag1) { //miniflag1을 통해 올바른 좌석 타입을 입력할 때까지 입력받는다.
            System.out.print("좌석구분 : S(1), A(2), B(3) >>> ");
            choice = scanner.nextInt();
            if(choice < 1 || choice > 3) //1~3사이의 수를 입력하지 않으면 계속 반복하며 다시 입력함.
                System.out.println("좌석 범위에서 오류가 발생하였습니다. 다시 입력해주세요.");
            else  //제대로 입력한 것이므로 miniflag1을 false로 바꿔 while 문을 빠져나감.
                miniflag1 = false;

        }

        printSeat(choice); //취소할 좌석타입의 상태를 출력

        boolean miniflag2 = true;
        int count = 0;
        while(miniflag2) { //이제 또다시 올바른 이름을 입력할 때까지 반복
            boolean miniflag3 = true;
            System.out.print("이름>> ");
            String name = scanner.next(); //취소할 예약자명 입력받음

            while(miniflag3) {
                count = 0;
                for(int i = 0; i < 10; i++) {  //좌석타입에 대한 모든 좌석 탐색
                    if(seats[choice - 1][i].equals(name + " ")) { //만약 제대로 예약자를 입력하면 취소진행
                        seats[choice - 1][i] = " --- "; //해당 좌석에 다시 비어있음을 의미하는 --- 문자열 삽입
                        count = 1;  //count를 1로 바꿔 제대로 취소되었음을 표시
                    }
                }
                if (count != 1){  //count가 1인 경우는 이름을 잘 입력하여 취소가 된 경우이므로 이 경우는 이름을 잘못 입력한 것임.
                    System.out.println("잘못된 이름을 입력하셨습니다. 다시 선택해주세요");
                    miniflag3 = false;
                }else if(count == 1) {  //제대로 취소함(두 개의 while 문을 모두 종료)
                    System.out.print("<<<취소를 완료하였습니다.>>>"+"\n");
                    miniflag2 = false; //취소를 완료하면 첫 번째 while문 종료
                    miniflag3 = false;  //miniflag3는 언제나 false로 바뀜(잘못된 이름을 입력하든, 제대로 입력하든 다시 입력하기 위해선 두 번째 while문은 빠져나가야하기 때문이다)
                }
            }
        }
    }
}

//main 클래스(예약, 취소, 조회를 control한다)
public class ReservationSystemAssign {

    private static Scanner scanner;

    /*
     * 메인 아이디어:
     * 처음 이 문제를 접하였을 때는, 좌석타입 별로 객체를 생성해야하고자 하였다. 그래서 객체 1개에 대해 예약, 취소, 조회 기능을 할 수 있도록 할려했다.
     * 그랬더니, 문제가 너무 복잡해지고 잘 풀리지 않았다. 따라서 객체를 하나를 생성하되, 그 객체에서 좌석타입 3개에 대한 모든 기능을 수행하도록 하였다.
     * 클래스 SystemAssign 클래스 자체에 좌석타입별로 10개씩 저장가능한 2차원 배열을 선언하고 이 배열을 이용하여 모든 작업을 수행한다.
     * 좌석 상태 출력, 예약, 조회, 취소 등을 모두 각각 메소드로 구현하여 사용자의 입력에 따라 메소드를 실행할 수 있도록 하였다.
     */
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        SystemAssign m = new SystemAssign();  //객체 1개 생성
        int menuNum;
        boolean flag = true;

        System.out.println("명품콘서트홀 예약 시스템입니다.");

        while(flag) { //flag를 통해 무한반복을 설정
            System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4>>");
            menuNum = scanner.nextInt();  //수행할 작업을 입력받음.

            try {  //이 역시 예외처리를 해준다. 1~4 사이를 입력하지 않는다면 다시 입력하도록 한다.
                if (menuNum < 1 || menuNum > 4)
                    throw new Exception();
            }catch (Exception e) {
                System.out.println("다시 선택해주세요.");
                continue;
            }

            switch(menuNum) {  //switch 문으로 사용자 입력에 따라 해당하는 객체의 메소드를 호출한다.
                case 1:
                    m.reserve();  //예약
                    break;
                case 2:
                    m.search();  //조회(모든 좌석)
                    break;
                case 3:
                    m.cancel();  //취소
                    break;
                case 4:  //종료
                    System.out.println("종료합니다.");
                    flag = false;  //4가 입력된 경우만 flag를 false로 설정하여 while 문을 빠져나가도록 함.
            }
        }
        scanner.close();
    }
}

