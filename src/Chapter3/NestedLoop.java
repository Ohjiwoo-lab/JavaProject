/*
 * [예제 3-4] 2중 중첩을 이용한 구구단
 * 2중 중첩 for문을 사용하여 구구단을 출력하는 프로그램을 작성, 한 줄에 한 단씩 출력한다.
 */

package Chapter3;

public class NestedLoop {
    public static void main(String[] args){
        for(int i = 1; i < 10; i++)  //1단에서 9단까지 출력
        {
            for(int j = 1; j< 10; j++)  //각 단에서 구구셈 출력
            {
                System.out.print(i + "*" + j + "=" + i*j);
                System.out.print("\t");  //구구셈 사이에 탭으로 구분
            }
            System.out.println();  //한 단이 끝나면 다음 줄로 커서 이동
        }
    }
}
