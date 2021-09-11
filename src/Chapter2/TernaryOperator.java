/*
* 조건 연산자 사용하기
* 조건 연산자는 ?으로, 세 개의 피연산자로 구성된 삼항(ternary) 연산자, if-else를 간결하게 표현할 수 있다.
*/

package Chapter2;

public class TernaryOperator {
    public static void main(String[] args){
        int a= 3, b = 5;

        //차이를 항상 양수로 유지하기 위한 조건 연산자
        System.out.println("두 수의 차는 " + ((a > b) ? (a - b) : (b - a)));
    }
}
