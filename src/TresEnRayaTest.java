import org.junit.jupiter.api.Test;
//en los signos de los jugares se puede poner cualquier letra, excepto la 'N' ya que esta
//esta siendo usada para notificar que no hay ganador aun.
import static org.junit.jupiter.api.Assertions.*;

class TresEnRayaTest {

    @Test
    void marcarDentroDelLimite() {
        TresEnRaya tresEnRaya = new TresEnRaya();
        tresEnRaya.crearTablero();
        boolean res = tresEnRaya.jugar('X', 0, 1);
        assertEquals(res, true);
    }

    @Test
    void marcarFueraDelLimite() {
        TresEnRaya tresEnRaya = new TresEnRaya();
        tresEnRaya.crearTablero();
        boolean res = tresEnRaya.jugar('O', 4, 2);
        assertEquals(res, false);
    }

    @Test
    void marcarSobreUnoYaMarcado() {
        TresEnRaya tresEnRaya = new TresEnRaya();
        tresEnRaya.crearTablero();
        boolean res = tresEnRaya.jugar('X', 2, 2);
        boolean res1 = tresEnRaya.jugar('0', 2, 2);
        assertEquals(res1, false);
    }

    @Test
    void ningunGanador() {
        TresEnRaya tresEnRaya = new TresEnRaya();
        tresEnRaya.crearTablero();
        tresEnRaya.jugar('0', 1, 1);
        tresEnRaya.jugar('X', 1, 2);
        tresEnRaya.jugar('0', 0, 0);
        tresEnRaya.jugar('X', 2, 2);
        char res = tresEnRaya.quienHaGanado();
        assertEquals(res, 'N');

    }

    @Test
    void ganador0Horrizontal() {
        TresEnRaya tresEnRaya = new TresEnRaya();
        tresEnRaya.crearTablero();
        tresEnRaya.jugar(0, 1);
        tresEnRaya.jugar(1, 2);
        tresEnRaya.jugar(2, 0);
        tresEnRaya.jugar(2, 2);
        tresEnRaya.jugar(1, 0);
        tresEnRaya.jugar(0, 2);
        char res = tresEnRaya.quienHaGanado();
        assertEquals(res, '0');
    }

    @Test
    void gandorXVertical() {
        TresEnRaya tresEnRaya = new TresEnRaya();
        tresEnRaya.crearTablero();
        tresEnRaya.jugar(1, 1);
        tresEnRaya.jugar(2, 0);
        tresEnRaya.jugar(1, 0);
        tresEnRaya.jugar(2, 2);
        tresEnRaya.jugar(1, 2);
        tresEnRaya.jugar(0, 2);
        char res = tresEnRaya.quienHaGanado();
        assertEquals(res, 'X');
    }

    @Test
    void ganadorXDiagonal1() {
        TresEnRaya tresEnRaya = new TresEnRaya();
        tresEnRaya.crearTablero();
        tresEnRaya.jugar(0, 0);
        tresEnRaya.jugar(2, 0);
        tresEnRaya.jugar(1, 1);
        tresEnRaya.jugar(1, 2);
        tresEnRaya.jugar(2, 2);
        tresEnRaya.jugar(0, 2);
        char res = tresEnRaya.quienHaGanado();
        assertEquals(res, 'X');

    }

    @Test
    void ganador0Diagonal2() {
        TresEnRaya tresEnRaya = new TresEnRaya();
        tresEnRaya.crearTablero();
        tresEnRaya.jugar(0, 1);
        tresEnRaya.jugar(2, 0);
        tresEnRaya.jugar(1, 0);
        tresEnRaya.jugar(1, 1);
        tresEnRaya.jugar(1, 2);
        tresEnRaya.jugar(0, 2);
        char res = tresEnRaya.quienHaGanado();
        assertEquals(res, '0');
    }

    @Test
    void crearTablero() {
        TresEnRaya tresEnRaya = new TresEnRaya();
        tresEnRaya.crearTablero();
        tresEnRaya.jugar(2, 1);
        tresEnRaya.jugar(1, 2);
        tresEnRaya.jugar(2, 2);
        tresEnRaya.crearTablero();
        tresEnRaya.jugar(0, 1);
        tresEnRaya.jugar(2, 0);
        tresEnRaya.jugar(1, 0);
        tresEnRaya.jugar(1, 1);
        tresEnRaya.jugar(1, 2);
        tresEnRaya.jugar(0, 2);
        char res = tresEnRaya.quienHaGanado();
        assertEquals(res, 'X');
    }

    @Test
    void hayTresEnRayaPositivo() {
        TresEnRaya tresEnRaya = new TresEnRaya();
        tresEnRaya.crearTablero();
        tresEnRaya.jugar(0, 2);
        tresEnRaya.jugar(1, 2);
        tresEnRaya.jugar(0, 1);
        tresEnRaya.jugar(2, 2);
        tresEnRaya.jugar(0, 0);
        boolean es = tresEnRaya.hayTresEnRaya();
        assertEquals(es, true);
    }

    @Test
    void hayTresEnRataNegativo() {
        TresEnRaya tresEnRaya = new TresEnRaya();
        tresEnRaya.crearTablero();
        tresEnRaya.jugar(2, 1);
        tresEnRaya.jugar(1, 2);
        tresEnRaya.jugar(2, 2);
        boolean es = tresEnRaya.hayTresEnRaya();
        assertEquals(es, false);
    }

    @Test
    void revisarLlenadoPositivo() {
        TresEnRaya tresEnRaya = new TresEnRaya();
        tresEnRaya.crearTablero();
        tresEnRaya.jugar(0, 1);
        tresEnRaya.jugar(2, 0);
        tresEnRaya.jugar(1, 0);
        tresEnRaya.jugar(1, 1);
        tresEnRaya.jugar(1, 2);
        tresEnRaya.jugar(0, 2);
        tresEnRaya.jugar(2, 2);
        tresEnRaya.jugar(2, 1);
        tresEnRaya.jugar(0, 0);

        boolean res = tresEnRaya.estaLleno();
        assertEquals(res, true);
    }

    @Test
    void revisarLlenadoNegativo() {
        TresEnRaya tresEnRaya = new TresEnRaya();
        tresEnRaya.crearTablero();
        tresEnRaya.jugar(0, 1);
        tresEnRaya.jugar(2, 0);
        tresEnRaya.jugar(1, 0);
        tresEnRaya.jugar(1, 1);
        tresEnRaya.jugar(1, 2);
        tresEnRaya.jugar(0, 2);

        boolean res = tresEnRaya.estaLleno();
        assertEquals(res, false);
    }
}