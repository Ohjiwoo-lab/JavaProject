/*
 * 과제 12-2번(사칙 연산을 입력받아 switch 문으로 계산하는 프로그램)
 * 연산자는 +, -, *, /의 네 가지로 하고 피연산자는 모두 실수로 한다. 피연산자와 연산자는 빈 칸으로 분리하여 입력한다.
 * 0으로 나눌 때에는 “0으로 나눌 수 없습니다.”를 출력하고 종료한다.
 */

package Chapter2;
import java.util.Scanner;

public class ArithmeticOperatorSwitchAssign {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("연산>>");
        double operand1 = scanner.nextDouble();
        String operator = scanner.next();
        double operand2 = scanner.nextDouble();

        double result = 0;
        switch(operator){
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                if(operand2 != 0)
                    result = operand1 / operand2;
                else
                    System.out.println("0으로 나눌 수 없습니다.");
                break;
            default:
                System.out.println("잘못된 연산자를 입력하셨습니다.");
        }

        if(result != 0)
            System.out.println(operand1 + operator + operand2 + "의 계산 결과는 " + result + "입니다.");

        scanner.close();
    }
}