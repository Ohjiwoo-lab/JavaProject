/*
* 과제 10번
* 원의 정보를 받기 위해 키보드로부터 원의 중심을 나타내는 한 점과 반지름을 입력받는다.
* 두 개의 원을 입력받고 두 원이 겹치는지 판단하여 출력하는 프로그램을 작성.
*/

package Chapter2;
import java.util.Scanner;

public class CircleConflictAssign {
    public static void main(String[] args){
        Scanner scanner1 = new Scanner(System.in);  //첫 번째 원에 대한 정보를 받을 객체
        System.out.print("첫 번째 원의 중심과 반지름 입력>>");
        int dotx1 = scanner1.nextInt();
        int doty1 = scanner1.nextInt();
        int radius1 = scanner1.nextInt();

        Scanner scanner2 = new Scanner(System.in);  //두 번째 원에 대한 정보를 받을 객체
        System.out.print("두 번째 원의 중심과 반지름 입력>>");
        int dotx2 = scanner2.nextInt();
        int doty2 = scanner2.nextInt();
        int radius2 = scanner2.nextInt();

        /*
        * 메인 아이디어:
        * 두 원의 중심 사이의 거리가 두 원의 반지름의 합보다 크면 원은 겹치지 않고, 작거나 같으면 원은 겹친다.
        * 중심 사이의 거리 dist와 반지름의 합이 같으면 정확하게 두 원의 곡선이 닿을 것이고, 이보다 크다면 겹치는 부분이 아예 존재하지 않기 때문이다.
        */
        double dist = Math.sqrt(Math.pow(Math.abs(dotx1 - dotx2), 2) + Math.pow(Math.abs(doty1 - doty2), 2)); //두 원의 중심 사이의 거리

        if(dist > (radius1 + radius2))  //반지름의 합보다 거리가 큰 경우 겹치지 않는다.
            System.out.println("두 원은 서로 겹치지 않는다.");
        else  //반지름의 합보다 거리가 작거나 같으면 겹친다.
            System.out.println("두 원은 서로 겹친다.");

        scanner1.close();
        scanner2.close();
    }
}
