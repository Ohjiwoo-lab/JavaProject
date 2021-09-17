/*
 * [예제 3-13] main()에서 명령행 인자의 합 계산
 */

package Chapter3;

public class Calc {
    public static void main(String[] args){
        double sum = 0.0;

        for(int i = 0; i < args.length; i++)  //인자 개수만큼 반복
            sum += Double.parseDouble(args[i]);  //문자열 타입의 args 배열의 요소를 doble 타입으로 변환한 뒤 더한다.

        System.out.println("합계 : " + sum);
    }
}
