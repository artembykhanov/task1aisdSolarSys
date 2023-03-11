import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class FrameMain extends JFrame {
    private JPanel panelMain;
    private JButton saveValue;
    private JTable table;
    private JButton start;
    private JPanel panel;

    public ArrayList<Planet> listArr = new ArrayList<>();

    public FrameMain() {
        this.setTitle("Задайте характеристики");
        this.setContentPane(panelMain);
        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        JTableUtils.initJTableForArray(table, 100, true, true, true, true);
        table.setRowHeight(25);


        saveValue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    listArr.clear();
                    String[][] arr = JTableUtils.readStringMatrixFromJTable(table);
                    for (String[] arr1 : arr) {
                        int speed = Integer.parseInt(arr1[0]);
                        int radiusSun = Integer.parseInt(arr1[1]);
                        int diameter = Integer.parseInt(arr1[2]);
                        if (radiusSun < 0 || speed < 0 || diameter < 0) throw new IllegalArgumentException();
                        Planet planet = new Planet(speed, radiusSun, diameter);
                        listArr.add(planet);
                    }
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame frame = new JFrame("Solar System");
                frame.setSize(1000, 1000);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

                SolarSystem panel = new SolarSystem(listArr);

                frame.add(panel);
                frame.setVisible(true);
            }
        });

    }


    //    private void makeModal(JFrame jFrame) {
//        jFrame.setAlwaysOnTop(true);
//        jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//    }
    final int width = 1000;
    final int height = 1000;
}







