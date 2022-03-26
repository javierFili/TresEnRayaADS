
public class Main1 {
    public static void main(String args[]) {
        TresEnRaya1 tresEnRaya = new TresEnRaya1();
        tresEnRaya.crearTablero();
        boolean terminar = false;
        while (!terminar && !tresEnRaya.estaLleno()) {
            int x = (int) (Math.random() * (3 - 0)) + 0;
            int y = (int) (Math.random() * (3 - 0)) + 0;
            System.out.println("X : " + x + " Y : " + y);
            boolean noMismoLugar = tresEnRaya.jugar(x, y);
            if (!noMismoLugar) {
                System.out.println("Jugador repitio, ya que dio al mismo lugar");
            }
            terminar = tresEnRaya.hayTresEnRaya();
        }
        if (terminar) {
            System.out.println("Termino por que hubo ganador");
            System.out.println("Gano el " + tresEnRaya.quienHaGanado());
        } else {
            System.out.println("Termino por que se lleno el tablero");
        }
    }
}
