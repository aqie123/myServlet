package listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

// GUI事件编程回顾
public class MyGUI {
    public static void main(String[] args) {
        Test test = new Test();
        test.method2();
    }
}
class Test{
    void method(){
        JFrame frame = new JFrame("新建窗体JFrame");
        frame.setSize(300,300);
        frame.setVisible(true);
    }
    void method2(){
        Frame frame = new Frame("新建窗体Frame");
        frame.setSize(300,300);
        frame.setVisible(true);
        // 把监听器注册到事件源上
        frame.addWindowListener(new MyWindowListener());
    }
}

/**
 * 窗口的事件监听器
 */
class MyWindowListener implements WindowListener{

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("closing");
        System.out.println("closed");
        // 1.窗体消失
        Frame frame = (Frame)e.getSource();
        frame.setVisible(false);
        // 2.程序停止
        System.exit(0);
    }

    // WindowEvent 就是事件对象,包含了事件源对象
    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
