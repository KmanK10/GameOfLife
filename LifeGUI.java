import javax.swing.*;
import java.awt.*;

// Runs the Simulation in a Swing GUI
public class LifeGUI {
    private LifeModel model;    // The grid data
    private JFrame window;      // The window
    private JPanel gridPanel;   // The drawing area

    // Set up the GUI
    public LifeGUI(LifeModel model) {
        this.model = model;
        window = new JFrame("Game of Life");
        gridPanel = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g); // Clear the panel

                // Create the "pixels" of the GUI
                for (int i = 0; i < model.getRows(); i++) {
                    for (int j = 0; j < model.getCols(); j++) {
                        if (model.isAlive(i, j)) {
                            g.setColor(Color.YELLOW);
                        } else {
                            g.setColor(Color.BLUE);
                        }
                        g.fillRect(j * 10, i * 10, 10, 10);
                    }
                }
            }
        };

        gridPanel.setPreferredSize(new Dimension(model.getCols() * 10, model.getRows() * 10));
        window.add(gridPanel);
        window.pack();
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setVisible(true);
        new Timer(500, e -> update()).start(); // Update every 0.5s
    }

    // Update the model and repaint the grid
    public void update() {
        model.update();
        gridPanel.repaint();
    }
}