/*
 * [예제 10-5] MouseAdapter 사용하기
 * MouseAdapter를 이용하여 예제 10-4를 수정하는 코드를 작성한다.
 * Adapter 클래스는 이벤트 리스너를 구현할 때 추상 메소드들을 모두 구현해야하는 부담을 해소하기 위해 만들어졌다.
 * 해당 클래스는 리스너의 모든 메소드가 단순 리턴하도록 구현해놓은 클래스이다.
 */

package Chapter10;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseAdapterEx extends JFrame {
    private JLabel la = new JLabel("Hello");  // Hello 문자열을 출력할 라벨

    public MouseAdapterEx() {
        setTitle("Mouse 이벤트 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();  // 컨텐트팬 생성
        c.addMouseListener(new MyMouseAdapter());  // MouseAdapter를 이용한 리스너 생성
        c.setLayout(null);
        la.setSize(50, 20);  // 문자열 크기 설정
        la.setLocation(30, 30);  // 문자열 위치 설정
        c.add(la);  // 문자열을 컨텐트팬에 추가
        setSize(250, 250);
        setVisible(true);
    }

    /*
     * MouseAdapter 클래스
     * 예제 10-4에서는 존재했던 mouseReleased, mouseClicked, mouseEntered, mouseExited 메소드는 구현하지 않고 mousePressed 메소드만 구현한 모습을 확인가능
     * 모든 추상 메소드들을 구현할 필요 없이 필요한 메소드만 구현할 수 있다.
     */
    class MyMouseAdapter extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            la.setLocation(x, y);
        }
    }

    public static void main(String [] args) {
        new MouseAdapterEx();
    }
}
