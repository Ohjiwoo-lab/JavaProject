/*
 * [예제 4-8] 인자로 배열이 전달되는 예시
 * char[] 배열을 전달받아 출력하는 printCharArray() 메소드와 배열 속의 공백(' ') 문자를 ','로 대치하는 replaceSpace() 메소드를 작성한다.
 * 기본타입(int, float, ...)은 값이 복사되어 전달된다. 따라서 메소드의 매개변수가 변경되어도 호출한 실인자 값은 변경되지 않는다.
 * 하지만, 여기서는 배열을 인자로 전달하는 것이기 때문에 레퍼런스(주소)만 전달된다. 따라서 메소드의 매개변수와 호출한 실인자 객체가 배열을 공유한다.
 * 객체나 배열을 전달할 경우 레퍼런스(주소) 전달 방식이 사용된다.
 */

package Chapter4;

public class ArrayParameterEx {
    //공백을 , 로 변경해주는 메소드(매개변수 a는 c의 주소를 전달받았기 때문에 a의 원소값을 변경하면 c의 원소값도 변경된다)
    static void replaceSpace(char a[]){
        for(int i = 0; i < a.length; i++){
            if(a[i] == ' ')  //만약 a 배열의 원소가 공백이라면 ,로 변경(c도 변경됨)
                a[i] = ',';
        }
    }

    //배열의 원소를 출력하는 메소드(a의 원소는 c의 원소와 완벽히 동일, 주소를 공유하므로)
    static void printCharArray(char a[]){
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i]);
        }
        System.out.println();
    }

    public static void main(String[] args){
        char c[] = {'T', 'h', 'i', 's', ' ', 'i', 's', ' ', 'a', ' ', 'p', 'e', 'n', 'c', 'i', 'l', '.'};

        printCharArray(c);  //c의 주소를 보내어 c를 출력함
        replaceSpace(c);  //c의 주소를 보내어 공백을 , 로 바꿈
        printCharArray(c);  //c의 주소를 보내어 바뀐 c를 출력함
    }
}
