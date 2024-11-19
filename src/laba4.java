import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class laba4 {
    public static void main(String[] args) {
        JFrame fr = new JFrame("Приближение/Удаление шара");
        fr.setPreferredSize(new Dimension(300, 300));
        final JPanel pan = new JPanel();
        fr.add(pan);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.pack();

        final int x = fr.getWidth() / 2;
        final int y = fr.getHeight() / 2;
        int radius = 10;
        boolean zoom = true;
        final int speed = 1; // final

        Timer tm = new Timer(5, new ActionListener() {
            int cur_radius = radius;
            boolean cur_zoom = zoom;


            @Override
            public void actionPerformed(ActionEvent arg0) {
                Graphics2D gr = (Graphics2D) pan.getGraphics();
                pan.update(gr);
                gr.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                gr.clearRect(0, 0, pan.getWidth(), pan.getHeight());

                if (cur_zoom) {
                    cur_radius += speed;
                    if (cur_radius > 100) {
                        cur_zoom = false;
                    }
                } else {
                    cur_radius -= speed;
                    if (cur_radius < 10) {
                        cur_zoom = true;
                    }
                }

                Ellipse2D.Double circle = new Ellipse2D.Double(x - cur_radius, y - cur_radius, 2 * cur_radius, 2 * cur_radius);
                gr.setColor(Color.RED);
                gr.fill(circle);
            }
        });
        tm.start();
    }
}

