import javax.swing.*;
import java.awt.*;

public class GUI implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Netflix Statistix");
        frame.setPreferredSize(new Dimension(1280, 720));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        container.add(new Panels.MainPanel(), BorderLayout.CENTER);
    }

    public JFrame getFrame() {
        return frame;
    }
}
