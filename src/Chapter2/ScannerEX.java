/*
* Scanner를 이용한 키 입력 연습
* Scanner를 이용하여 이름, 도시, 나이, 체중, 독신 여부를 입력 받고 다시 출력하는 프로그램
* Scanner는 입력된는 키 값을 공백으로 구분되는 아이템 단위로 읽어들여 원하는 타입의 값으로 바꾸어 리턴할 수 있는 클래스이다.
*/

package Chapter2;
import java.util.Scanner;

public class ScannerEX {
    public static void main(String args[]){
        System.out.println("이름, 도시, 나이, 체중, 독신 여부를 빈칸으로 분리하여 입력하세요.");
        Scanner scanner = new Scanner(System.in);

        String name = scanner.next();  //문자열 읽기
        System.out.print("이름은 " + name + ", ");

        String city = scanner.next();
        System.out.print("도시는 " + city + ", ");

        int age = scanner.nextInt(); //정수 읽기
        System.out.print("나이는 " + age + ", ");

        double weight = scanner.nextDouble();  //실수 읽기
        System.out.print("체중은 " + weight + ", ");

        boolean single  = scanner.nextBoolean(); //논리값 읽기
        System.out.println("독신 여부는 " + single + "입니다.");

        scanner.close();  //scanner 닫기
    }
}
