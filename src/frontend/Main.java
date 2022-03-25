package frontend;

import backEnd.TresEnRaya;

public class Main {

    public static void main(String[] args) {

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
            int x = (int) (Math.random() * (3 - 0)) + 0;
            int y = (int) (Math.random() * (3 - 0)) + 0;
            //boolean noMismoLugar = tresEnRaya.jugar(jugadas[i][0], jugadas[i][1]);
            boolean noMismoLugar = tresEnRaya.jugar(x, y);
            if (!noMismoLugar) {
                System.out.println("Jugador repitio, ya que dio al mismo lugar");
            }
            terminar = tresEnRaya.hayTresEnRaya() ||
                    tresEnRaya.tie();
            System.out.println(tresEnRaya.toString());
            i++;
        }
        if (terminar) {
            System.out.println("Termino por que hubo ganador");
            System.out.println("Gano el " + tresEnRaya.quienHaGanado());
        } else {
            System.out.println("Termino por que se lleno el tablero");
        }

    }
}
