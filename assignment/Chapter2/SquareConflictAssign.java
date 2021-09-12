/*
* 8번 과제
* 2차원 평면에서 직사각형은 두 점으로 표현되는데, 키보드로부터 직사각형을 구성하는 두 점 (x1, y1), (x2, y2)를 입력받아
* (100, 100), (200, 200)의 두 점으로 이루어진 직사각형과 충돌하는지 판별하는 프로그램
*/

package Chapter2;
import java.util.Scanner;

public class SquareConflictAssign {
    //점 (x, y)가 (rectx1, recty1), (rectx2, recty2)의 사각형 안에 있으면 true를 리턴하는 메소드
    public static boolean inRect(int x, int y, int rectx1, int recty1, int rectx2, int recty2){
        if((x >= rectx1 && x <= rectx2) && (y >= recty1 && y <= recty2))
            return true;
        else
            return false;
    }

    //메인 메소드(이것이 실행됨)
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("사각형을 구성할 두 점을 입력하세요: ");
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        if(inRect(x1, y1, 100, 100, 200, 200)
              || inRect(x1, y2, 100, 100, 200, 200)
              || inRect(x2, y1, 100, 100, 200, 200)
              || inRect(x2, y2, 100, 100, 200, 200))
            System.out.println("해당 직사각형은 (100, 100), (200, 200) 직사각형과 충돌합니다.");
        else
            System.out.println("직사각형이 충돌하지 않습니다!");

        scanner.close();
    }
}
