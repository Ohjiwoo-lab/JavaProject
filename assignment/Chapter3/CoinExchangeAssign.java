/*
 * [과제 6번] 키보드에서 정수로 된 돈의 액수를 입력받아 오만원권, 만원권, 천원권, 500원 동전, 100원 동전, 50원 동전, 10원 동전, 1원 동전이 각 몇 개로 변환되는지 출력하는 프로그램
 * 반드시 int[] unit = {50000, 10000, 1000, 500, 100, 50, 10, 1}; 배열을 이용하고 반복문으로 작성한다.
 */

package Chapter3;
import java.util.Scanner;

public class CoinExchangeAssign {
    public static void main(String[] args){
        int[] unit = {50000, 10000, 1000, 500, 100, 50, 10, 1};  //환산할 돈의 종류
        Scanner scanner = new Scanner(System.in);

        System.out.print("금액을 입력하시오>>");
        int coin = scanner.nextInt();  //입력받은 금액을 받아옴

        /*
         * <아이디어>
         * unit에 있는 돈의 가치를 이용하여 계산을 진행한다. 먼저 반복문은 unit에 있는 돈의 종류의 개수만큼 실행된다. 여기서는 8번이다.
         * 입력받은 금액을 가치가 높은 돈부터 나누기 시작한다. 가장 먼저 50000원으로 나누면 해당 금액이 몇 개의 50000원 지폐로 변환될 수 있는지 개수가 나올 것이다. 이를 count에 저장한다.
         * 그 count가 0이 아닌 경우만, 즉 변환이 가능한 돈의 경우만 출력을 한다. 그런 후 50000원을 그 개수(count)와 곱한 금액(즉, 변환된 금액)을 전체 coin 에서 빼주면서 다음 돈에 대해 계산을 진행한다.
         */
        for(int i = 0; i < unit.length; i++){  //돈의 종류만큼 실행
            int count = coin / unit[i];  //변환될 수 있는 지폐의 개수
            if(count != 0) {  //변환 가능한 경우만 출력한다.
                System.out.println(unit[i] + "원 짜리 : " + count + "개");
                coin -= unit[i] * count;  //다음 계산을 위해 변환된 금액을 제거함.
            }
        }
        scanner.close();
    }
}
