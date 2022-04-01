package backend;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TresEnRayaTest1 {

    @Test
    void ganador0() {
        int[][] jugadas = new int[9][2];

        jugadas[0][0] = 2;  //f //X
        jugadas[0][1] = 2;  //c
        jugadas[1][0] = 1;
        jugadas[1][1] = 1;// 0
        jugadas[2][0] = 0; //X
        jugadas[2][1] = 0;
        jugadas[3][0] = 0;//0
        jugadas[3][1] = 2;
        jugadas[4][0] = 2;
        jugadas[4][1] = 1;//X
        jugadas[5][0] = 2;//O
        jugadas[5][1] = 0;
        TresEnRaya tresEnRaya = new TresEnRaya();
        boolean terminar = false;
        int i = 0;
        while (!terminar) {
            tresEnRaya.jugar(jugadas[i][0], jugadas[i][1]);
            terminar = tresEnRaya.hayTresEnRaya() ||
                    tresEnRaya.tie();
            i++;
        }
        String res = tresEnRaya.obtenerResultado();
        assertEquals(res, "ganador jugador 2");
    }

    @Test
    void gandorX() {
        int[][] jugadas = new int[9][2];
        jugadas[0][0] = 1;
        jugadas[0][1] = 0;

        jugadas[1][0] = 0;
        jugadas[1][1] = 0;

        jugadas[2][0] = 1;
        jugadas[2][1] = 1;

        jugadas[3][0] = 0;
        jugadas[3][1] = 2;

        jugadas[4][0] = 1;
        jugadas[4][1] = 2;

        jugadas[5][0] = 2;
        jugadas[5][1] = 2;
        TresEnRaya tresEnRaya = new TresEnRaya();
        boolean terminar = false;
        int i = 0;
        while (!terminar) {
            tresEnRaya.jugar(jugadas[i][0], jugadas[i][1]);
            terminar = tresEnRaya.hayTresEnRaya() ||
                    tresEnRaya.tie();
            i++;
        }
        String res = tresEnRaya.obtenerResultado();
        assertEquals(res, "ganador jugador 1");

    }

    @Test
    void gandorXDiagonal() {
        TresEnRaya tresEnRaya = new TresEnRaya();
        tresEnRaya.jugar(0, 0);//X
        tresEnRaya.jugar(2, 0);//0
        tresEnRaya.jugar(1, 1);//X
        tresEnRaya.jugar(1, 2);//0
        tresEnRaya.jugar(2, 2);//X
        tresEnRaya.jugar(0, 2);//0
        String res = tresEnRaya.obtenerResultado();
        assertEquals(res, "ganador jugador 1");

    }

    @Test
    void empate() {
        int[][] jugadas = new int[9][2];
        jugadas[0][0] = 0;
        jugadas[0][1] = 0;

        jugadas[1][0] = 1;
        jugadas[1][1] = 1;

        jugadas[2][0] = 2;
        jugadas[2][1] = 2;

        jugadas[3][0] = 0;
        jugadas[3][1] = 2;

        jugadas[4][0] = 2;
        jugadas[4][1] = 0;

        jugadas[5][0] = 1;
        jugadas[5][1] = 0;

        jugadas[6][0] = 1;
        jugadas[6][1] = 2;

        jugadas[7][0] = 2;
        jugadas[7][1] = 1;

        jugadas[8][0] = 0;
        jugadas[8][1] = 1;


        TresEnRaya tresEnRaya = new TresEnRaya();
        boolean terminar = false;
        int i = 0;
        while (!terminar) {
            tresEnRaya.jugar(jugadas[i][0], jugadas[i][1]);
            terminar = tresEnRaya.hayTresEnRaya() ||
                    tresEnRaya.tie();
            i++;
        }
        String res = tresEnRaya.obtenerResultado();
        assertEquals(res, "Empate");
    }

}