/*
 * [과제 12번] main 함수의 명령행 인자 중에서 정수만을 골라 합을 구하는 AddAssign.java 파일을 만든다.
 * AddAssignclass 파일을 c:\Temp 디렉터리에 복사한 뒤 실행하여 캡쳐한다.
 */

package Chapter3;

public class AddAssign {
    public static void main(String[] args){
        int sum = 0;

        /*
         * <아이디어>
         * main 메소드는 명령행 인자로 args 문자열 배열을 받는다. 따라서 이 배열의 개수만큼 반복문을 수행하면서 정수를 골라 더해나가는 과정을 반복한다.
         * 이때 명령행 인자로 정수가 아닌 값이 있을 수 있기 때문에 이를 대비하여 NumberFormatException 예외처리를 한다.
         * for 문의 try 문을 통해 args 배열의 요소들을 정수로 바꿔서 sum에 더해나간다.
         * 그런데, 문자열을 정수로 바꿨을 때 정수가 아닌 값이 있다면 catch 문이 실행되면서 sum에 더하지 않고 다시 for 문으로 돌아간다.
         * 이를 통해 정수인 값들만 sum에 더할 수 있다.
         * 일단 .java 파일을 실행하면 .class 파일이 생성된다. 그러면 이 .class 파일을 커맨드 환경에서 실행하면서 매개변수를 넘길 수 있다.
         * 자바는 하이브리드형 언어이기 때문에 .java 파일을 컴파일러에 의해 .class 파일로 만들면, 이 .class 파일은 인터프리터에 의해 실행된다. 따라서 이러한 일이 가능한 것이다.
         */
        for(int i = 0; i < args.length; i++) {  //매개변수 개수만큼 실행
            try{

                int num = Integer.parseInt(args[i]);  //정수로 바꿈
                sum += num;
            }
            catch (NumberFormatException e){  //예외처리
                continue;  //아무일도 하지않음(더하지 않음)
            }
        }
        System.out.println(sum);
    }
}
