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

class SystemAssign{
    private static Scanner scanner;
    String[][] seats = new String [3][10];

    public SystemAssign() {
        for (int i = 0; i < 3; i++) {
            for(int j = 0; j < 10; j++) {
                seats[i][j] = " --- ";
            }
        }
    }

    public void printSeat(int seatChoice) {
        String SAB = null;

        switch (seatChoice) {
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
        System.out.print(SAB);

        for (int i = 0; i < 10; i++) {
            System.out.print(seats[seatChoice - 1][i]);
        }
        System.out.println();
    }

    public boolean already(int seatChoice, int seatNum, String name) {
        if(seats[seatChoice - 1][seatNum - 1].equals(" --- ")) {
            seats[seatChoice - 1][seatNum - 1] = (name + " ");
            return true;
        }
        else
            return false;
    }

    public void reserve() {
        scanner = new Scanner(System.in);

        while(true) {
            System.out.print("좌석 구분 : S(1), A(2), B(3)>>>");
            int choice = scanner.nextInt();

            try {
                if(choice < 1 || choice > 3)
                    throw new Exception();
            }catch(Exception e) {
                System.out.println("다시 선택해주세요.");
                continue;
            }

            printSeat(choice);

            boolean flag2 = true;
            System.out.print("이름>> ");
            String name = scanner.next();
            int seatNum = 0;

            while(flag2) {

                System.out.print("번호>> ");
                seatNum=scanner.nextInt();
                if(seatNum < 1 || seatNum > 10)
                    System.out.println("번호 범위에서 오류가 발생하였습니다. 다시 입력해주세요.");
                else
                    flag2 = false;
            }

            if(already(choice, seatNum, name)) {
                System.out.println("<<<예약을 완료하였습니다.>>>");
            }
            else {
                System.out.println("이미 예약된 좌석입니다.");
            }
            break;
        }
    }

    public void search() {
        for (int i = 0; i < 3; i++)
            printSeat(i + 1);
        System.out.println("<<<조회를 완료하였습니다.<>>");
    }

    public void cancel() {
        scanner = new Scanner (System.in);

        boolean miniflag1 = true;
        int choice = 0;
        while(miniflag1) {
            System.out.print("좌석구분 : S(1), A(2), B(3) >>> ");
            choice = scanner.nextInt();
            if(choice < 1 || choice > 3)
                System.out.println("좌석 범위에서 오류가 발생하였습니다. 다시 입력해주세요.");
            else
                miniflag1 = false;

        }

        printSeat(choice);

        boolean miniflag2 = true;
        int count = 0;
        while(miniflag2) {
            boolean miniflag3 = true;
            System.out.print("이름>> ");
            String name = scanner.next();

            while(miniflag3) {
                count = 0;
                for(int i = 0; i < 10; i++) {
                    if(seats[choice - 1][i].equals(name + " ")) {
                        seats[choice - 1][i] = " --- ";
                        count = 1;
                    }
                }
                if (count != 1){
                    System.out.println("잘못된 이름을 입력하셨습니다. 다시 선택해주세요");
                    miniflag3 = false;
                }else if(count == 1) {
                    System.out.print("<<<취소를 완료하였습니다.>>>"+"\n");
                    miniflag2 = false;
                    miniflag3 = false;
                }
            }
        }
    }
}

public class ReservationSystemAssign {

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        SystemAssign m = new SystemAssign();
        int menuNum;
        boolean flag = true;

        System.out.println("명품콘서트홀 예약 시스템입니다.");

        while(flag) {
            System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4>>");
            menuNum = scanner.nextInt();

            try {
                if (menuNum < 1 || menuNum > 4)
                    throw new Exception();
            }catch (Exception e) {
                System.out.println("다시 선택해주세요.");
                continue;
            }

            switch(menuNum) {
                case 1:
                    m.reserve();
                    break;
                case 2:
                    m.search();
                    break;
                case 3:
                    m.cancel();
                    break;
                case 4:

                    System.out.println("종료합니다.");
                    flag = false;
            }
        }
        scanner.close();
    }
}

