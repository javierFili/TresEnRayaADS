import backend.TresEnRaya;
import frontend.GUITresEnRaya;

public class Main {

    public static void main(String[] args) {
        TresEnRaya juego = new TresEnRaya();
        GUITresEnRaya front = new GUITresEnRaya(juego);
        front.play();
    }
}


