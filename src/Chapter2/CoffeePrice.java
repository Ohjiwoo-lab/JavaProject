/*
* switch 문 활용하기
* switch 문을 이용하여 커피 메뉴의 가격을 알려주는 프로그램. 에스프레소, 카푸치노, 카페라떼는 3500원이고, 아메리카노는 2000원이다.
*/

package Chapter2;
import java.util.Scanner;

public class CoffeePrice {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("무슨 커피를 드릴까요? ");
        String order = scanner.next();
        int price = 0;

        switch(order){
            case "에스프레소":
            case "카푸치노":
            case "카페라떼":
                price = 3500;
                break;
            case "아메리카노":
                price = 2000;
                break;
            default:
                System.out.println("메뉴에 없습니다.");  //예외처리(메뉴에 없는 걸 입력했을 때)
        }
        if(price != 0)  //price가 0이 아니면 메뉴에 있는 것을 잘 입력한 것이고, 0이라면 default로 메뉴에 없는 것을 입력한 것.
            System.out.println(order + "는 " + price + "원입니다.");  //제대로 입력했을 때만 출력(예외처리)
        scanner.close();
    }
}
