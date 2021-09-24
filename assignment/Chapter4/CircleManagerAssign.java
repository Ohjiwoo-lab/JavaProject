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
        System.out.print("(" + x + "," + y + ")" + radius);
    }

    //원의 면적을 리턴하는 메소드(이걸로 가장 면적이 큰 원을 선택할 것이다)
    public double square(){
        return 3.14 * radius * radius;
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

        double max = c[0].square();  //가장 처음 원의 면적을 max로 설정
        int num = 0;  //max에 해당하는 인덱스 저장

        //for문을 돌며 max보다 크다면 max에 해당하는 인덱스 num에 새로운 인덱스로 업데이트함(for문을 전부 돌고나면 num에는 max에 해당하는 객체의 인덱스가 있을 것이다)
        for(int i = 1; i < c.length; i++){
            if(c[i].square() > max)
                num = i;
        }

        System.out.print("가장 면적이 큰 원은 ");
        c[num].show();  //max에 해당하는 객체의 인덱스 num을 이용하여 show 메소드를 이용해 원의 정보를 출력한다.
        System.out.println(" 입니다.");

        scanner.close();
    }
}
