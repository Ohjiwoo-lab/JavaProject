/*
 * [예제 10-8] 상(UP), 하(DOWN), 좌(LEFT), 우(RIGHT) 키로 "HELLO" 문자열을 마음대로 움직이기
 * 상, 하, 좌, 우 키를 이용하여 "HELLO" 문자열을 움직이는 응용프로그램을 작성한다.
 * "HELLO" 문자열은 JLabel 컴포넌트로 만들어 컨텐트팬에 부착하고 상, 하, 좌, 우 키를 움직이면 키 방향으로 한 번에 10 픽셀씩 움직이다.
 * 이를 위해서 컨텐트팬의 배치관리자를 삭제하여야 한다. "HELLO" 문자열을 초기에 (50, 50) 위치에 출력한다. 텍스트는 프레임의 영역을 벗어나서 움직일 수 있다.
 */

package Chapter10;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class FlyingTextEx extends JFrame {
    private final int FLYING_UNIT = 10;  // 문자열이 움직이는 픽셀 단위(10 픽셀 씩 움직인다)
    private JLabel la = new JLabel("HELLO");  // 문자열 "HELLO"

    public FlyingTextEx() {
        setTitle("상,하,좌,우 키를 이용하여 텍스트 움직이기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();  // 컨텐트팬 생성
        c.setLayout(null);  // 컨텐트팬의 배치관리자 삭제

        c.addKeyListener(new MyKeyListener());
        la.setLocation(50,50);  // 문자열의 초기위치 (50, 50)
        la.setSize(100,20);  // 문자열의 사이즈 설정
        c.add(la);  // 컨텐트팬에 문자열 부착

        setSize(300,300);
        setVisible(true);
        c.setFocusable(true);
        c.requestFocus();

        c.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Component com = (Component)e.getSource();
                com.setFocusable(true);
                com.requestFocus();
            }
        });
    }

    class MyKeyListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch(keyCode) {
                case KeyEvent.VK_UP:  // 상 키 입력
                    la.setLocation(la.getX(), la.getY()-FLYING_UNIT);  // 현재 위치에서 y축 아래로 이동
                    break;
                case KeyEvent.VK_DOWN:  // 하 키 입력
                    la.setLocation(la.getX(), la.getY()+FLYING_UNIT);  // 현재 위치에서 y축 위로 이동
                    break;
                case KeyEvent.VK_LEFT:  // 좌 키 입력
                    la.setLocation(la.getX()-FLYING_UNIT, la.getY());  // 현재 위치에서 x축 왼쪽으로 이동
                    break;
                case KeyEvent.VK_RIGHT:  // 우 키 입력
                    la.setLocation(la.getX()+FLYING_UNIT, la.getY());  // 현재 위치에서 x축 오른쪽으로 이동
                    break;
            }
        }
    }

    public static void main(String [] args) {
        new FlyingTextEx();
    }
}
