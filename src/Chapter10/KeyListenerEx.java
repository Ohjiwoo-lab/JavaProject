/*
 * [예제 10-6] 다양한 KeyEvent와 KeyListener 활용
 * 키가 입력되면 키 정보를 가진 이벤트 객체(KeyEvent 객체)를 생성한다. 이 KeyEvent 객체가 리스너에 전달되면서 이벤트를 수행한다.
 * 이벤트로는 키의 유니코드를 알아내는 것, 입력된 키의 가상 키 값을 알아내는 것, 키 이름 문자열을 리턴하는 것이 있다.
 * 특정 키가 입력되면 해당 키의 유니코드, 가상 키 값, 키 이름 문자열을 화면에 출력하는 프로그램을 작성한다.
 */

package Chapter10;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyListenerEx extends JFrame {
    private JLabel [] keyMessage;

    public KeyListenerEx() {
        setTitle("keyListener 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();  // 컨텐트팬 생성
        c.setLayout(new FlowLayout());

        c.addKeyListener(new MyKeyListener());  // 리스너 생성

        keyMessage = new JLabel [3];
        keyMessage[0] = new JLabel(" getKeyCode() ");  // 키의 유니코드
        keyMessage[1] = new JLabel(" getKeyChar() ");  // 키의 가상 키 값
        keyMessage[2] = new JLabel(" getKeyText() ");  // 키 이름 문자열

        for(int i=0; i<keyMessage.length; i++) {
            c.add(keyMessage[i]);
            keyMessage[i].setOpaque(true);  // 컴포넌트의 바탕색이 보이도록 하기 위해서는 컴포넌트가 불투명하게 지정될 필요가 있다.
            keyMessage[i].setBackground(Color.YELLOW);
        }

        setSize(300,150);
        setVisible(true);
        c.setFocusable(true);
        c.requestFocus();
    }

    class MyKeyListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            char keyChar = e.getKeyChar();
            keyMessage[0].setText(Integer.toString(keyCode));  // 유니코드로 변환
            keyMessage[1].setText(Character.toString(keyChar));  // 가상 키 값으로 변환
            keyMessage[2].setText(e.getKeyText(keyCode));  // 키 이름 문자열로 변환
        }
    }

    public static void main(String [] args) {
        new KeyListenerEx();
    }
}
