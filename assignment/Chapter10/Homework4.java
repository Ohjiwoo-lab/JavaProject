/*
 * [과제 4번] Key 리스너 작성과 포커스 연습
 * JLabel을 활용하여 "Love Java"를 출력하고 왼쪽 화살표 키(<Left> 키)를 입력할 때마다 "Ove JavaL", "ve JavaLo", "e JavaLov"와 같이 한 문자씩 왼쪽으로 회전하는 프로그램을 작성한다.
 * 문자열 회전은 String 클래스의 substring() 메소드를 이용한다. 참고로 String text = "Love Java"에서, text.substring(0,1)은 "L"을 리턴하고, text.substring(1)은 "ove Java"를 리턴한다.
 * JLabel에 포커스를 설정해야 키 입력을 받을 수 있다는 것을 잊지 않고 프로그램을 작성해야 한다.
 */

package Chapter10;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Homework4 extends JFrame{
    JLabel label;
    String text = "Love Java";

    public Homework4(){
        setTitle("Chapter10 - Homework4");  // 제목 지정
        setLayout(new FlowLayout());  // 레이아웃 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // 닫기 버튼을 눌렀을 시 화면 닫기

        label= new JLabel("Love Java");  // 레이블을 생성한다.
        label.addKeyListener(new MyKeyAdapter());  // KeyAdapter 객체를 생성한 뒤, 리스너를 설정한다.
        label.setSize(200,50);  // 레이블 사이즈 설정
        add(label);  // 레이블을 추가

        setSize(400,200);
        setVisible(true);
        label.requestFocus();// 컨텐트팬이 키 입력을 받을 수 있도록 포커스 강제 지정
    }

    class MyKeyAdapter extends KeyAdapter{
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()) {   // 입력받은 코드가
                case KeyEvent.VK_LEFT:   //<Left> 키 일때
                    label.setText(text);  // 레이블의 텍스트를 변경

                    /*
                     * 글자를 한 칸씩 앞으로 당길 때에는 String 클래스의 substring() 메소드를 이용하면 된다.
                     * 우선 text.substring(0, 1)로 text의 첫 번째 글자를 도출한 뒤, text.substring(1)로 첫 번째 글자를 제외한 나머지 문자열을 도출한다.
                     * 첫 번째 글자가 마지막으로 위치해야 하므로 나머지 문자열 뒤에 첫 번째 글자를 붙여서 새로운 문자열 text를 만든다.
                     */
                    text = text.substring(1)+text.substring(0, 1);   // text 글자를 한 칸씩 앞으로 당김
                    break;
                default:
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new Homework4();
    }
}
