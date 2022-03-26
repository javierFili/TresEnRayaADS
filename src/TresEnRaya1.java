
public class TresEnRaya1 {
    private final int fila = 3;
    private final int colm = 3;
    private char jugador1 = 'X';
    private char jugador2 = '0';
    private boolean turnoJug1 = true;
    private boolean turnoJug2 = false;
    private char tabla[][];

    public TresEnRaya1() {
        this.tabla = new char[fila][colm];
    }

    public void crearTablero() {
        this.tabla = new char[fila][colm];
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < colm; j++) {
                tabla[i][j] = ' ';
            }
        }
    }

    public boolean hayTresEnRaya() {
        if (quienHaGanado() != 'N') {
            return true;
        }
        return false;
    }

    public boolean jugar(int fila, int colm) {
        boolean jug1Dio, jug2Dio;
        boolean res = false;
        if (turnoJug1) {
            jug1Dio = jugar(jugador1, fila, colm);
            res = jug1Dio;
            if (jug1Dio) {
                turnoJug1 = false;
                turnoJug2 = true;
                res = true;
            }
        }
        if (turnoJug2) {
            jug2Dio = jugar(jugador2, fila, colm);
            if (jug2Dio) {
                turnoJug2 = false;
                turnoJug1 = true;
                res = true;
            }
        }
        return res;
    }

    // se debe cambiar a private en produccion.
    public boolean jugar(char valor, int fila, int colm) {
        if (fila < 0 || fila >= 3 || colm < 0 || colm >= 3) {
            return false;
        }
        if (tabla[fila][colm] != ' ') {
            return false;
        }
        tabla[fila][colm] = valor;
        return true;
    }

    private char verificarVertical() {
        for (int i = 0; i < fila; i++) {
            char a = tabla[i][0];
            boolean sera = true;
            if (a != ' ') {
                for (int j = 0; j < colm && sera; j++) {
                    if (a != tabla[i][j]) {
                        sera = false;
                    }
                }
                if (sera) {
                    return a;
                }
            }
        }
        return 'N';
    }

    private char verificarHorrizontal() {
        for (int i = 0; i < colm; i++) {
            char a = tabla[0][i];
            boolean sera = true;
            if (a != ' ') {
                for (int j = 0; j < fila && sera; j++) {
                    if (a != tabla[j][i]) {
                        sera = false;
                    }
                }
                if (sera) {
                    return a;
                }
            }
        }
        return 'N';
    }

    private char verificarDiagonales() {
        if (tabla[1][1] != ' ') {
            int j = 0;
            boolean sera = true;
            for (int i = 0; i < fila && j < colm; i++, j++) {
                if (tabla[1][1] != tabla[i][j]) {
                    sera = false;
                    break;
                }
            }
            if (sera) {
                return tabla[1][1];
            }
            int i = 0;
            int k = colm - 1;
            boolean esIgual = true;
            while (i < fila && k >= 0 && esIgual) {
                if (tabla[i][k] != tabla[1][1]) {
                    esIgual = false;
                }
                i++;
                k--;
            }
            if (esIgual) {
                return tabla[1][1];
            }
        }
        return 'N';
    }

    public char quienHaGanado() {
        char res = 'N';
        char res1 = verificarVertical();
        char res2 = verificarHorrizontal();
        char res3 = verificarDiagonales();
        if (res1 != 'N') {
            res = res1;
        } else {
            if (res2 != 'N') {
                res = res2;
            } else {
                if (res3 != 'N') {
                    res = res3;
                }
            }
        }
        return res;
    }

    public boolean estaLleno() {
        boolean res = true;
        for (int i = 0; i < fila && res; i++) {
            for (int j = 0; j < colm && res; j++) {
                if (tabla[i][j] == ' ') {
                    res = false;
                }
            }
        }
        return res;
    }

}
