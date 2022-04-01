package frontend;

import javax.swing.*;

public class AvisoDeGanador extends JFrame {
    private JPanel areaDeInfo;
    private JLabel aviso;

    public JPanel getAreaDeInfo() {
        return areaDeInfo;
    }

    public void setAviso(String ganador) {
        aviso.setText(ganador);
    }
}
