
import java.util.Locale;


@SuppressWarnings({"RedundantThrows", "Convert2Lambda"})
public class Main {

    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.ROOT);
        //SwingUtils.setLookAndFeelByName("Windows");
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);

        java.awt.EventQueue.invokeLater(() -> {
            try {
                new FrameMain().setVisible(true);
            } catch (Exception ex) {
                SwingUtils.showErrorMessageBox(ex);
            }
        });
    }
}