package backend;

public class TresEnRaya {

    private final int fila = 3;
    private final int colm = 3;
    private char jugador1 = 'X';
    private char jugador2 = '0';
    private boolean turnoJug1 = true;
    private boolean turnoJug2 = false;
    private char tabla[][];

    public TresEnRaya() {
        this.tabla = new char[fila][colm];
        crearTablero();
    }

    public String obtenerResultado() {
        String res = "Empate";
        char res1 = verificarVertical();
        char res2 = verificarHorrizontal();
        char res3 = verificarDiagonales();
        if (res1 != 'N') {
            res = "ganador jugador ";
            if (res1 == 'X') {
                res += "1";
            } else {
                res += "2";
            }
        } else {
            if (res2 != 'N') {
                res = "ganador jugador ";
                if (res2 == 'X') {
                    res += "1";
                } else {
                    res += "2";
                }
            } else {
                if (res3 != 'N') {
                    res = "ganador jugador ";
                    if (res3 == 'X') {
                        res += "1";
                    } else {
                        res += "2";
                    }
                }
            }
        }
        return res;
    }

    public String toString() {
        String res = "";
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < colm; j++) {
                res += tabla[i][j];
            }
            res += "\n";
        }
        return res;
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
            }
        } else {
            jug2Dio = jugar(jugador2, fila, colm);
            if (jug2Dio) {
                turnoJug2 = false;
                turnoJug1 = true;
                res = true;
            }
        }
        return res;
    }

    public boolean tie() {
        if (estaLleno() || hayTresEnRaya()) {
            return true;
        }
        return false;
    }

    public boolean hayTresEnRaya() {
        if (obtenerResultado() != "Empate") {
            return true;
        }
        return false;
    }

    private boolean jugar(char valor, int fila, int colm) {
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

    private void crearTablero() {
        this.tabla = new char[fila][colm];
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < colm; j++) {
                tabla[i][j] = ' ';
            }
        }
    }

    private boolean estaLleno() {
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
