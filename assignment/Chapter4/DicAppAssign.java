/*
 * [과제 10번] DictionaryAssign 클래스가 실행 결과와 같이 동작하도록 DictionaryAssign 클래스에 kor2Eng() 메소드를 추가하고, dicAppAssign 클래스를 작성하라.
 * 사용자가 한글을 입력하였을 때 영어로 변환하여 출력해주는 한영 단어 검색 프로그램이다.
 */

package Chapter4;
import java.util.Scanner;

class DictionaryAssign {
    private static String[] kor = {"사랑", "아기", "돈", "미래", "희망"};
    private static String[] eng = {"love", "baby", "money", "future", "hope"};

    public static String kor2Eng(String word){
        for(int i = 0; i < kor.length; i++){  //kor의 길이만큼 반복하면서 kor와 word가 일치하는 값이 있는지 확인한다.
            if(kor[i].equals(word)){  //만약 일치하는 값이 있다면
                return eng[i];  //kor와 같은 위치에 존재하는 eng 단어(영어단어)를 리턴한다.
            }
        }
        return word;
        /*
         * NullPointerExceoption:
         * 한글 배열 kor와 word에 일치하는 값이 없을 경우 null을 리턴하도록 할려고 하였으나, 예외가 발생하였다.
         * 따라서 찾지 못한 경우 매개변수로 받았던 word를 그대로 리턴함으로써 변한 점이 없음을 이용해 일치하는 값이 없다는 사실을 인지하도록 하였다.
         */
    }
}

public class DicAppAssign {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("한영 단어 검색 프로그램입니다.");

        System.out.print("한글 단어? ");
        String word = scanner.next();  //한글 단어 입력받음

        while(!word.equals("그만")){
            String eng_word = DictionaryAssign.kor2Eng(word);  //DictionaryAssign의 kro2Eng는 static 메소드이기 때문에 이렇게 클래스 바깥에서도 객체의 생성 없이 사용가능하다.

            if(!eng_word.equals(word)) { //정상적이라면 eng_word는 word의 영어표현이 들어있어야 한다. 하지만 word와 그대로 똑같은 값을 가진다면 이는 일치하는 값이 없어서 그렇다(kor2Eng에서 그렇게 설정함)
                                         //따라서 eng_word가 word와 같은 경우를 제외(!)한 나머지는 한글에 일치하는 값이 있는 것이므로 그 한글에 대한 영어 표현을 출력한다.
                System.out.println(word + "은 " + eng_word + "입니다.");
            }
            else{  //eng_word와 word가 같은 경우이므로 이는 일치하는 값이 없음을 의미한다.
                System.out.println(word + "은 저의 사전에 없습니다.");
            }

            System.out.print("한글 단어? ");
            word = scanner.next(); //한글 단어를 그만이 입력될때까지 계속 입력받음
        }

        scanner.close();
    }
}
