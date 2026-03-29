package ExamenPrimeraPregunta;

import java.time.LocalDate;
import java.util.Scanner;

class Pregunta1Test {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String codigo;
        String correo;
        int cantidad = 0;
        LocalDate fechaEntrega;

        // 🔹 VALIDAR CÓDIGO
        while (true) {
            System.out.print("Ingrese código de pedido: ");
            codigo = sc.nextLine();

            if (codigo.isEmpty()) {
                System.out.println("❌ Debe ingresar todos los datos requeridos");
            } else if (!codigo.matches("[A-Z]{2}[0-9]{3}")) {
                System.out.println("❌ Código inválido, ingrese un código válido (Ej: AB123)");
            } else {
                break;
            }
        }

        // 🔹 VALIDAR CORREO
        while (true) {
            System.out.print("Ingrese correo: ");
            correo = sc.nextLine();

            if (correo.isEmpty()) {
                System.out.println("❌ Debe ingresar todos los datos requeridos");
            } else if (correo.length() < 6 || !correo.contains("@")) {
                System.out.println("❌ Correo inválido, ingrese un correo válido");
            } else {
                break;
            }
        }

        // 🔹 VALIDAR CANTIDAD
        while (true) {
            System.out.print("Ingrese cantidad: ");
            String cantidadStr = sc.nextLine();

            if (cantidadStr.isEmpty()) {
                System.out.println("❌ Debe ingresar todos los datos requeridos");
                continue;
            }

            try {
                cantidad = Integer.parseInt(cantidadStr);

                if (cantidad <= 0) {
                    System.out.println("❌ Cantidad inválida, debe ser mayor a cero");
                } else {
                    break;
                }

            } catch (NumberFormatException e) {
                System.out.println("❌ Ingrese un número válido");
            }
        }

        // 🔹 VALIDAR FECHA
        while (true) {
            System.out.print("Ingrese fecha de entrega (YYYY-MM-DD): ");
            String fechaStr = sc.nextLine();

            if (fechaStr.isEmpty()) {
                System.out.println("❌ Debe ingresar todos los datos requeridos");
                continue;
            }

            try {
                fechaEntrega = LocalDate.parse(fechaStr);
                LocalDate hoy = LocalDate.now();

                if (fechaEntrega.isBefore(hoy)) {
                    System.out.println("❌ Fecha inválida, debe ser hoy o futura");
                } else {
                    break;
                }

            } catch (Exception e) {
                System.out.println("❌ Formato inválido, use YYYY-MM-DD");
            }
        }

        // ✅ FINAL
        System.out.println("✅ El pedido ha sido registrado correctamente");
    }
}