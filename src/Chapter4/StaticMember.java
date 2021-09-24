/*
 * [예제 4-12] static을 이용한 환율 계산기
 * static 멤버를 이용하여 달러와 원화를 변환해주는 환율 계산기를 만들어보자.
 * static 멤소드에는 몇 가지 제약 조건이 있는데, non-static 멤버에 접근할 수 없다는 것과 this를 사용할 수 없다는 것이다.
 * 반대로 non-static 메소드는 static 멤버를 사용할 수 있다.
 */

package Chapter4;
import java.util.Scanner;

class CurrencyConverter {
    private static double rate;  //한국 원화에 대한 환율(이 변수는 CurrencyConverter 내에서만 사용되는 변수이므로 private으로 설정해줌)
    public static double toDollar(double won){
        return won / rate; //한국 원화를 달러로 변환
    }
    public static double toKWR(double dollar){
        return dollar * rate;  //달러를 한국 원화로 변환
    }
    public static void setRate(Double r){
        rate = r;  //환율을 설정(KWR/$1)
    }
}

public class StaticMember {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("환욜(1달러) >> ");
        double rate = scanner.nextDouble();  //환율 입력받음

        CurrencyConverter.setRate(rate);  //CurrencyConverter의 static 멤버함수를 이용하여 환율을 결정한다.

        System.out.println("백만원은 $" + CurrencyConverter.toDollar(1000000) + "입니다.");
        System.out.println("&100은 " + CurrencyConverter.toKWR(100) + "원입니다.");

        scanner.close();
    }
}
