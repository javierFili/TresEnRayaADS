package frontend;

import backend.TresEnRaya;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Aun no se toma en cuenta que pasa si el jugador pulsa mal ..
 */
public class GUITresEnRaya extends JFrame {

    private JButton dosDos;
    private JButton dosUno;
    private JButton ceroCero;
    private JButton unoCero;
    private JButton ceroUno;
    private JButton ceroDos;
    private JButton dosCero;
    private JButton unoUno;
    private JButton unoDos;
    private JButton reiniciarJuego;
    private JPanel TresEnRayaFrontend;
    private Color colores = new Color(73, 34, 34);
    private boolean jugo = false;
    private boolean jug1Turno = true;
    private boolean jug2Turno = false;
    private TresEnRaya backend;
    public GUITresEnRaya(TresEnRaya backend) {
        TresEnRayaFrontend.setBackground(new Color(194, 108, 108));
        setContentPane(TresEnRayaFrontend);
        setBounds(200, 200, 0, 0);
        setTitle("Juego de tres en raya");
        setSize(500, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        this.backend = backend;
        this.reiniciar();
        this.inicioDeBotones();
        ceroCero.setBackground(colores);
        ceroUno.setBackground(colores);
        ceroDos.setBackground(colores);

        unoCero.setBackground(colores);
        unoUno.setBackground(colores);
        unoDos.setBackground(colores);

        dosCero.setBackground(colores);
        dosUno.setBackground(colores);
        dosDos.setBackground(colores);

    }

    public void play() {

    }

    private void sacarResultado() {
        AvisoDeGanador aviso = new AvisoDeGanador();
        aviso.setContentPane(aviso.getAreaDeInfo());
        aviso.setBounds(200, 200, 0, 0);
        aviso.setSize(200, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        aviso.setAviso(backend.obtenerResultado());
        aviso.setVisible(true);
        dispose();

    }

    private void reiniciar() {
        reiniciarJuego.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
                TresEnRaya newBackend = new TresEnRaya();
                GUITresEnRaya tres = new GUITresEnRaya(newBackend);

            }
        });
    }

    private boolean validar(int x, int y) {
        boolean respuesta = false;
        backend.jugar(x, y);

        if (backend.hayTresEnRaya()) {
            sacarResultado();
        } else {
            if (backend.tie()) {
                sacarResultado();
            }
        }
        return respuesta;
    }

    private void inicioDeBotones() {
        ceroCero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jugo = validar(0, 0);
                if (jug1Turno) {
                    ceroCero.setText("X");
                    jug1Turno = false;
                    jug2Turno = true;
                } else {
                    ceroCero.setText("0");
                    jug2Turno = false;
                    jug1Turno = true;
                }
                ceroCero.setEnabled(false);
            }
        });
        unoCero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jugo = validar(1, 0);
                if (jug1Turno) {
                    unoCero.setText("X");
                    jug1Turno = false;
                    jug2Turno = true;
                } else {
                    unoCero.setText("0");
                    jug2Turno = false;
                    jug1Turno = true;
                }
                unoCero.setEnabled(false);

            }
        });

        dosCero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jugo = validar(2, 0);
                if (jug1Turno) {
                    dosCero.setText("X");
                    jug1Turno = false;
                    jug2Turno = true;
                } else {
                    dosCero.setText("0");
                    jug2Turno = false;
                    jug1Turno = true;
                }
                dosCero.setEnabled(false);
            }
        });
        ceroUno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jugo = validar(0, 1);
                if (jug1Turno) {
                    ceroUno.setText("X");
                    jug1Turno = false;
                    jug2Turno = true;
                } else {
                    ceroUno.setText("0");
                    jug2Turno = false;
                    jug1Turno = true;
                }
                ceroUno.setEnabled(false);
            }
        });
        unoUno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jugo = validar(1, 1);
                if (jug1Turno) {
                    unoUno.setText("X");
                    jug1Turno = false;
                    jug2Turno = true;
                } else {
                    unoUno.setText("0");
                    jug2Turno = false;
                    jug1Turno = true;
                }
                unoUno.setEnabled(false);
            }
        });
        dosUno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jugo = validar(2, 1);
                if (jug1Turno) {
                    dosUno.setText("X");
                    jug1Turno = false;
                    jug2Turno = true;
                } else {
                    dosUno.setText("0");
                    jug2Turno = false;
                    jug1Turno = true;
                }
                dosUno.setEnabled(false);
            }
        });
        ceroDos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jugo = validar(0, 2);
                if (jug1Turno) {
                    ceroDos.setText("X");
                    jug1Turno = false;
                    jug2Turno = true;
                } else {
                    ceroDos.setText("0");
                    jug2Turno = false;
                    jug1Turno = true;
                }
                ceroDos.setEnabled(false);
            }
        });
        unoDos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jugo = validar(1, 2);
                if (jug1Turno) {
                    unoDos.setText("X");
                    jug1Turno = false;
                    jug2Turno = true;
                } else {
                    unoDos.setText("0");
                    jug2Turno = false;
                    jug1Turno = true;
                }
                unoDos.setEnabled(false);
            }
        });
        dosDos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jugo = validar(2, 2);
                if (jug1Turno) {
                    dosDos.setText("X");
                    jug1Turno = false;
                    jug2Turno = true;
                } else {
                    dosDos.setText("0");
                    jug2Turno = false;
                    jug1Turno = true;
                }
                dosDos.setEnabled(false);
            }
        });
    }
}
