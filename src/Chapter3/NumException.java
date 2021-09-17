/*
 * [예제 3-18] 정수가 아닌 문자열을 정수로 변환할 때 예외 발생(NumberFormatException)
 * 문자열을 정수로 변환할 때 발생하는 NumberFormatException을 처리하는 프로그램을 작성
 */

package Chapter3;

public class NumException {
    public static void main(String[] args){
        String[] stringNumber = {"23", "12", "3.141592", "998"};

        int i = 0;
        try {
            for (i = 0; i < stringNumber.length; i++) {
                int j = Integer.parseInt(stringNumber[i]);
                System.out.println("숫자로 변환된 값은 " + j + "입니다.");  //나머지는 수로 표현했을 때 정수지만, 3.141592는 실수이므로 예외가 발생한다.
            }
        }
        catch(NumberFormatException e) {
            System.out.println(stringNumber[i] + "는 정수로 변환할 수 없습니다.");  //실수인 3.141592만 변환할 수 없다.
        }
    }
}
