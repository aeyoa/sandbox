import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by arsenykogan on 14/04/14.
 */
public class GuesserUI extends JFrame {

    public GuesserUI() {

        setTitle("Simple Java 2D example");

        add(new Surface());

        setSize(300, 200);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);
    }


    class Surface extends JPanel {

        private void doDrawing(final Graphics2D graphics2D) {
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            graphics2D.setColor(new Color(41, 176, 200));
            graphics2D.fillRoundRect(0, 0, 50, 50, 50, 50);
            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(final MouseEvent e) {
                    super.mouseClicked(e);
                    System.out.println("clicked");
                    graphics2D.fillRoundRect(e.getX(), e.getY(), 50, 50, 50, 50);
                }
            });
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            doDrawing((Graphics2D) g);
        }
    }


}
