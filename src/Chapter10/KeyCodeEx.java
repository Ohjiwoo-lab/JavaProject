/*
 * [예제 10-7] <F1> 키를 입력받으면 컨텐트팬의 배경을 초록색으로, % 키를 입력받으면 노란색으로 변경하는 프로그램
 * F1 키와 % 키를 판별하기 위한 함수 getKeyChar()를 호출하여 프로그램을 작성한다.
 */

package Chapter10;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class KeyCodeEx extends JFrame {
    private JLabel la = new JLabel();
    Container c = getContentPane();  // 컨텐트팬 생성

    public KeyCodeEx() {  // 생성자
        setTitle("Key Code 예제 : F1키:초록색, % 키 노란색");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        c.addKeyListener(new MyKeyListener());
        c.add(la);
        setSize(300,150);
        setVisible(true);
        c.setFocusable(true);  // 키 입력을 받을 수 있도록 포커스를 줌
        c.requestFocus();
    }

    class MyKeyListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            la.setText(" " + e.getKeyText(e.getKeyCode()) + "키가 입력되었음");  // 화면에 글자 출력(% 키는 Shift키 + 5키이므로 키 5에 대한 문자열이 출력될 것이다)

            // % 키나 5키는 키보드에서 동일한 키이지만 if(e.getKeyChar() == '%')로 비교를 하였기 때문에 그냥 키 5를 누르면 노란색으로 배경이 변하지 않음
            if(e.getKeyChar() == '%')  // % 키를 판별하기 위해 e.getKeyChar() 함수를 호출한다.
                c.setBackground(Color.YELLOW);  // 배경을 노란색으로 설정
            else if(e.getKeyCode() == KeyEvent.VK_F1) // F1 키를 판별하기 위해 e.getKeyCode() 함수를 호출한다.
                c.setBackground(Color.GREEN);  // 배경을 초록색으로 설정
        }
    }

    public static void main(String [] args) {
        new KeyCodeEx();
    }
}
