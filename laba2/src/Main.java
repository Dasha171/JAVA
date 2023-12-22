import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame fr = new JFrame("Движение фигуры");
        fr.setPreferredSize(new Dimension(300, 300));
        final JPanel pan = new JPanel() {
            Okruzhnost applet = new Okruzhnost();

            {
                setLayout(new BorderLayout());
                add(applet);
                applet.init();

                Timer tm2 = new Timer(20, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        applet.moveBall();
                        applet.repaint();
                    }
                });
                tm2.start();
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D gr = (Graphics2D) g.create();
                gr.setColor(Color.BLACK);
                gr.fillRect(0, 0, getWidth(), getHeight());

                GeneralPath path = new GeneralPath();
                path.append(new Polygon(new int[]{60, -80, 50}, new int[]{-60, -50, 40}, 3), true);
                int x = (60 - 80 + 50) / 3, y = (-60 - 50 + 40) / 3;
                gr.translate(150, 150);
                AffineTransform tranforms = AffineTransform.getRotateInstance(applet.getRotation(), x, y);
                gr.transform(tranforms);
                gr.setColor(Color.GREEN);
                gr.fill(path);
                gr.dispose();
            }
        };

        fr.add(pan);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.pack();

        Timer tm = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                pan.repaint();
            }
        });
        tm.start();
    }
}

// Окружность
class Okruzhnost extends JApplet {
    private int ballRadius = 10;
    private int ballX = 200;
    private int ballY = 200;
    private int xSpeed = 2;
    private int ySpeed = 2;

    public void init() {
        Timer timer = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                moveBall();
                repaint();
            }
        });
        timer.start();
    }

    public double getRotation() {
        return Math.toRadians((xSpeed + ySpeed) * 0.07);
    }

    public void moveBall() {
        ballX += xSpeed;
        ballY += ySpeed;

        // столкновение с границами
        if (ballX - ballRadius < 0 || ballX + ballRadius > getWidth()) {
            xSpeed = -xSpeed;
        }
        if (ballY - ballRadius < 0 || ballY + ballRadius > getHeight()) {
            ySpeed = -ySpeed;
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        // рисование окружность
        g2d.setColor(Color.GREEN);
        g2d.fillOval(ballX - ballRadius, ballY - ballRadius, 2 * ballRadius, 2 * ballRadius);
    }
}
