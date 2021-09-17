/*
 * [예제 3-1] for 문을 이용하여 1부터 10까지 합 출력
 */

package Chapter3;

public class ForSample {
    public static void main(String[] args){
        int sum = 0;  //sum에 1부터 10까지 수들을 더해나감

        for(int i = 1; i <= 10; i++){
            sum += i;
            System.out.print(i);  //더하는 수 출력

            if(i <= 9)
                System.out.print("+");  //1~9까지는 +를 출력하고 마지막에는 +를 출력하지 않음
            else{
                System.out.print("=");  //모든 더하는 수 출력한 뒤 = 출력한 뒤
                System.out.print(sum);  //덧셈 결과를 출력
            }
        }
    }
}
