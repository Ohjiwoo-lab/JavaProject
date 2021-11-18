/*
 * [예제 10-10] 더블클릭 시 컨텐트팬의 배경색 변경
 * 더블클릭할 때마다 컨텐트팬의 배경색을 랜덤하게 변경하는 프로그램을 작성한다.
 */

package Chapter10;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ClickAndDoubleClickEx extends JFrame {
    public ClickAndDoubleClickEx() {  // 생성자
        setTitle("Click and DoubleClick 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();  // 컨텐트팬 생성
        c.addMouseListener(new MyMouseListener());
        setSize(300,200);
        setVisible(true);
    }

    class MyMouseListener extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            if(e.getClickCount() == 2) {  // 마우스클릭이 2번이면(더블클릭이면)
                // Math의 random() 함수를 이용하여 rgb 값을 각각 랜덤하게 설정한다(이 rgb값이 색을 결정한다)
                int r = (int)(Math.random()*256);
                int g = (int)(Math.random()*256);
                int b = (int)(Math.random()*256);

                Component c = (Component)e.getSource();
                c.setBackground(new Color(r,b,g));  // 설정한 rgb 값으로 배경색을 변경한다.
            }
        }
    }

    public static void main(String [] args) {
        new ClickAndDoubleClickEx();
    }
}
