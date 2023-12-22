import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Main extends JFrame {

    private static final int WIDTH = 200;
    private static final int HEIGHT = 200;
    private static final int LAMP_SIZE = 50;

    private boolean isLampOn = false;
    private Color lampColor = Color.YELLOW;

    public Main() {
        setTitle("Blinking Lamp");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleLamp();
                repaint();
            }
        });

        timer.start();

        add(new LampPanel());
    }

    private void toggleLamp() {
        isLampOn = !isLampOn;
        if (isLampOn) {
            lampColor = Color.RED;
        } else {
            lampColor = Color.YELLOW;
        }
    }

    private class LampPanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int x = (getWidth() - LAMP_SIZE) / 2;
            int y = (getHeight() - LAMP_SIZE) / 2;

            g.setColor(lampColor);
            g.fillOval(x, y, LAMP_SIZE, LAMP_SIZE);
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
}
