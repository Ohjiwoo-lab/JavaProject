/*
 * [과제 8번] 정수를 몇 개 저장할 지 키보드로부터 개수를 입력받아(100보다 작은 개수) 정수 배열을 생성하고, 이곳에 1에서 100까지 범위의 정수를 랜덤하게 삽입하는 프로그램
 * 배열에는 같은 수가 없도록 하고, 배열에 저장된 수들을 모두 출력한다.
 */

package Chapter3;
import java.util.Scanner;
import java.util.Random;

public class RandomIntArrayAssign {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("정수 몇개? ");
        int count = scanner.nextInt();  //몇 개의 정수를 저장할 지에 대한 개수를 받아옴

        Random random = new Random();  //수를 랜덤하게 뽑기 위해 Random 클래스 객체 생성
        int num[] = new int[count];  //count 개수 만큼 배열 선언

        /*
         * <아이디어>
         * 입력받을 정수의 개수 count로 배열 num을 생성하였으므로, num의 크기로 반복문 조건을 설정하였다. 입력받을 정수의 개수만큼 실행될 것이다.
         * Random 클래스의 nextInt 함수를 이용하여 랜덤하게 수를 뽑았다. bound는 100으로 하였고, 원래 설정상 0부터 99까지의 수 중에 뽑기 때문에 이를 1부터 100까지의 수로 바꾸기 위해 1을 더하였다.
         * 중복을 제거하기 위해 수를 뽑은 뒤, 이전에 뽑았던 수들과 같은지 비교를 한다. 만약 같다면 중복인 수가 뽑힌 것이므로 i를 1감소시켜 같은 자리에 새롭게 뽑은 수가 들어가도록 하였다.
         */
        for(int i = 0; i < num.length; i++)  //정수의 개수만큼 실행
        {
            num[i] = random.nextInt(100) + 1;  //1부터 100 사이의 수 중 랜덤하게 뽑는다.

            //중복 제거
            for(int j = 0; j < i; j++){
                if(num[i] == num[j]){  //중복이면, i번째 수를 다시 뽑도록 한다.
                    i--;
                    break;
                }
            }
        }

        for(int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");  //배열에 저장된 수를 출력한다.
            if((i+1) % 10 == 0)  //만약 10개의 수가 출력되면 줄을 바꾼다. i가 0부터 시작하는데, 0은 무엇으로 나누더라도 0이기 때문에 문제가 발생하였다. 따라서 i+1을 하여 문제를 해결하였다.
                System.out.println();
        }
        scanner.close();
    }
}
