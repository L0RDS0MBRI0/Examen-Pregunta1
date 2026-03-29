package ExamenPrimeraPregunta;

import java.time.LocalDate;

public class Pregunta1 {
    public static String validarPedido(String codigo, String correo, String cantidadStr, String fechaStr) {


        if (codigo.isEmpty() || correo.isEmpty() || cantidadStr.isEmpty() || fechaStr.isEmpty()) {
            return "Debe ingresar todos los datos requeridos";
        }


        if (!codigo.matches("[A-Z]{2}[0-9]{3}")) {
            return "Ingrese un código de pedido válido";
        }


        if (correo.length() < 6 || !correo.contains("@")) {
            return "Ingrese un correo electrónico válido";
        }


        int cantidad;
        try {
            cantidad = Integer.parseInt(cantidadStr);
            if (cantidad <= 0) {
                return "La cantidad debe ser mayor a cero";
            }
        } catch (Exception e) {
            return "La cantidad debe ser mayor a cero";
        }


        try {
            LocalDate fecha = LocalDate.parse(fechaStr);
            if (fecha.isBefore(LocalDate.now())) {
                return "Ingrese una fecha de entrega válida";
            }
        } catch (Exception e) {
            return "Ingrese una fecha de entrega válida";
        }


        return "El pedido ha sido registrado correctamente";
    }
}
