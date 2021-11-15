/*
 * [예제 10-2] 내부 클래스로 Action 이벤트 리스너 만들기
 * 버튼의 글자가 바뀔 때 프레임의 타이틀도 함께 바뀌도록 하는 프로그램을 작성한다.
 */

package Chapter10;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class InnerClassListener extends JFrame {
    InnerClassListener() {
        setTitle("Action 이벤트 리스너 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JButton btn = new JButton("Action");  // 버튼 생성
        btn.addActionListener(new MyActionListener());
        c.add(btn);
        setSize(350, 150);
        setVisible(true);
    }

    /*
     * Action 리스너를 InnerClassListener 클래스의 내부 클래스로 작성하고, private으로 선언하여 InnerClassListener 외부에서 사용할 수 없게 하였다.
     * 내부 클래스로 작성함으로써 리스너에서 InnerClassListener 클래스의 멤버에 대한 접근이 용이하다.
     * 따라서 InnerClassListener 클래스에서 생성한 버튼에 접근하여 타이틀을 변경하는 코드를 추가적으로 작성함으로써 타이틀 명도 버튼 이름과 함게 바뀌도록 했다.
     */
    private class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton)e.getSource();
            if(b.getText().equals("Action"))
                b.setText("액션");
            else
                b.setText("Action");
            // InnerClassListener의 멤버나 JFrame의 멤버를 호출할 수 있음
            InnerClassListener.this.setTitle(b.getText());  // 프레임 타이틀에 버튼 문자열을 출력한다.
        }
    }

    public static void main(String [] args) {
        new InnerClassListener();
    }
}
