/*
 * [과제 6번] 5번 문제의 Circle 클래스와 CircleManager 클래스를 수정하여 실행 결과가 나오도록 한다.
 * 이름을 바꾸어 CircleAssign과 CircleManagerAssign 클래스로 만들어서 프로그램을 작성하였다.
 */

package Chapter4;
import java.util.Scanner;

class CircleAssign {
    private double x, y;
    private int radius;

    //매개변수로 필드를 초기화하는 생성자
    public CircleAssign(double x, double y, int radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    //객체 정보를 출력하는 메소드
    public void show(){
        System.out.println("(" + x + "," + y + ")" + radius);
    }
}

public class CircleManagerAssign {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        CircleAssign c[] = new CircleAssign[3];  //3개의 CircleAssign 배열 선언
        for(int i = 0; i < c.length; i++){
            System.out.print("x, y, radius >> ");

            double x = scanner.nextDouble();  //x값 읽기
            double y = scanner.nextDouble();  //y값 읽기
            int radius = scanner.nextInt();  //반지름 읽기

            c[i] = new CircleAssign(x, y, radius);  //CircleAssign 객체 생성
        }

        for(int i = 0; i < c.length; i++){
            c[i].show();
        }

        scanner.close();
    }
}
