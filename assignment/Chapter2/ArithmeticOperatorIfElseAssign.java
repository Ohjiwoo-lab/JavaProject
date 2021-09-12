/*
* 과제 12-1번(사칙 연산을 입력받아 if-else 문으로 계산하는 프로그램)
* 연산자는 +, -, *, /의 네 가지로 하고 피연산자는 모두 실수로 한다. 피연산자와 연산자는 빈 칸으로 분리하여 입력한다.
* 0으로 나눌 때에는 “0으로 나눌 수 없습니다.”를 출력하고 종료한다.
*/

package Chapter2;
import java.util.Scanner;

public class ArithmeticOperatorIfElseAssign {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("연산>>");
        double operand1 = scanner.nextDouble();
        String operator = scanner.next();  //연산자는 next를 통해 문자열 String으로 받는다.
        double operand2 = scanner.nextDouble();

        double result = 0;  //연산자를 잘못 입력했을 때를 대비한 예외처리

        //operator.equals(x)는 operator와 x를 비교하는 연산으로, 만약 같다면 true를 리턴한다.
        if(operator.equals("+")){
            result = operand1 + operand2;  //operator와 +가 같다면 true를 리턴하여 해당 문장이 실행된다.
        }
        else if(operator.equals("-")){
            result = operand1 - operand2;
        }
        else if(operator.equals("*")){
            result = operand1 * operand2;
        }
        else if(operator.equals("/")){
            if(operand2 != 0)  //나눗셈의 경우 두 번재 피연산자가 0이 아닌 경우에만 계산을 진행한다.
                result = operand1 / operand2;
            else
                System.out.println("0으로 나눌 수 없습니다.");
        }
        else
            System.out.println("잘못된 연산자를 입력하셨습니다.");

        if(result != 0)  //result가 초기에 설정한 0이 아닐때에만 계산 결과를 출력한다.
            System.out.println(operand1 + operator + operand2 + "의 계산 결과는 " + result + "입니다.");

        scanner.close();
    }
}
