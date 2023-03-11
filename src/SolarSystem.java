import javax.swing.Timer;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class SolarSystem extends JPanel {

    private static final long serialVersionUID = 1L;
    private ArrayList<Planet> list;


    public SolarSystem(ArrayList<Planet> listArr) {
        list = listArr;
        setBackground(Color.BLACK);
            Timer t = new Timer(100, new MoveListener());
            t.start();


    }

    public class MoveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            for (Planet planet : list) {
                planet.updatePosition();
            }
            repaint();
        }

    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.YELLOW);
        g.fillOval(500, 500, 130, 130);


        for (Planet planet : list) {
            planet.draw(g);
        }


    }

}
