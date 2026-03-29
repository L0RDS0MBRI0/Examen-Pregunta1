package ExamenPrimeraPregunta;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Pregunta1Test {
    @Test
    void testCodigoInvalido() {
        String resultado = Pregunta1.validarPedido("A123", "test@gmail.com", "2", "2030-01-01");
        assertEquals("Ingrese un código de pedido válido", resultado);
    }

    @Test
    void testCorreoInvalido() {
        String resultado = Pregunta1.validarPedido("AB123", "test", "2", "2030-01-01");
        assertEquals("Ingrese un correo electrónico válido", resultado);
    }

    @Test
    void testCantidadInvalida() {
        String resultado = Pregunta1.validarPedido("AB123", "test@gmail.com", "0", "2030-01-01");
        assertEquals("La cantidad debe ser mayor a cero", resultado);
    }

    @Test
    void testFechaInvalida() {
        String resultado = Pregunta1.validarPedido("AB123", "test@gmail.com", "2", "2020-01-01");
        assertEquals("Ingrese una fecha de entrega válida", resultado);
    }

    @Test
    void testCamposVacios() {
        String resultado = Pregunta1.validarPedido("", "", "", "");
        assertEquals("Debe ingresar todos los datos requeridos", resultado);
    }

    @Test
    void testTodoCorrecto() {
        String resultado = Pregunta1.validarPedido("AB123", "test@gmail.com", "2", "2030-01-01");
        assertEquals("El pedido ha sido registrado correctamente", resultado);
    }
}