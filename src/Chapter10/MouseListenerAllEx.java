/*
 * [예제 10-9] 마우스와 마우스 모션 이벤트 활용
 * 마우스가 프레임 내에 있으면 배경이 파란색으로, 마우스가 프레임을 벗어나면 노란색으로 변경된다.
 * 또한 마우스를 클릭하고 떼어내고, 이동하고 드레그하는 것을 모두 파악하여 글자로 표시하는 프로그램을 작성한다.
 */

package Chapter10;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MouseListenerAllEx extends JFrame {
    private JLabel la = new JLabel("No Mouse Event");

    public MouseListenerAllEx() {
        setTitle("MouseListener와 MouseMotionListener 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();  // 컨텐트팬 생성
        c.setLayout(new FlowLayout());

        MyMouseListener listener = new MyMouseListener();
        c.addMouseListener(listener);
        c.addMouseMotionListener(listener);
        c.add(la);  // 문자열 출력
        setSize(300,200);
        setVisible(true);
    }

    class MyMouseListener implements MouseListener, MouseMotionListener {
        // 각 이벤트가 일어났을 때 getX, getY를 이용해서 현재 좌표를 불러와 출력한다.
        public void mousePressed(MouseEvent e) {  // 마우스를 클릭했을 때 좌표값 변경
            la.setText("mousePressed ("+e.getX()+", "+e.getY ()+")");
        }
        public void mouseReleased(MouseEvent e) {  // 마우스를 떼었을 때 좌표값 변경
            la.setText("MouseReleased("+e.getX()+", "+e.getY()+")");
        }
        public void mouseClicked(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {  // 마우스를 클릭했을 때 배경색을 변경
            Component c = (Component)e.getSource();
            c.setBackground(Color.CYAN);
        }
        public void mouseExited(MouseEvent e) {  // 마우스가 패널 바깥으로 나가면 배경색 변경
            Component c = (Component)e.getSource();
            c.setBackground(Color.YELLOW);
        }
        public void mouseDragged(MouseEvent e) {  // 마우스를 패널 위에서 드래그할 때 좌표값 변경
            la.setText("MouseDragged ("+e.getX()+","+e.getY()+")");
        }
        public void mouseMoved(MouseEvent e) {  // 마우스를 클릭하지 않은 채로 움직일 때 좌표값 변경
            la.setText("MouseMoved ("+e.getX()+","+e.getY()+")");
        }
    }

    public static void main(String [] args) {
        new MouseListenerAllEx();
    }
}
