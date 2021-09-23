/*
 * [예제 4-2] Rectangle 클래스의 객체 생성 및 활용
 * 너비와 높이를 입력받아 사각형의 면적을 출력하는 프로그램을 작성한다.
 * 너비(width)와 높이(height) 필드, 그리고 면적 값을 제공하는 getArea() 메소드를 가진 Rectangle 클래스를 만들어 활용한다.
 */

package Chapter4;
import java.util.Scanner;

public class Rectangle {
    int width;  //사각형의 너비
    int height;  //사각형의 높이

    //사각형의 면적을 구하는 메소드
    public int getArea(){
        return width * height;
    }

    public static void main(String[] args){
        Rectangle rect = new Rectangle();  //rectangle 객체 rect 생성

        Scanner scanner = new Scanner(System.in);  //Scanner 객체 생성
        System.out.print(">> ");

        rect.width = scanner.nextInt();  //너비 입력
        rect.height = scanner.nextInt();  //높이 입력

        System.out.println("사각형의 면적은 " + rect.getArea());
        scanner.close();
    }
}
