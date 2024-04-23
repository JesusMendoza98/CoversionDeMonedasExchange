package com.exchange.conversor.calculos;

import java.util.Scanner;

public class ManejoDatos {
    public static void convertirMoneda(String mensaje, String divisaSeleccionada, ValoresMonedas resultadoConversionn, int eleccioncase) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(mensaje);

        double cantidad = 0;
        boolean cantidadValida = false;

        do {
            System.out.println("Por favor, ingresa la cantidad:");
            System.out.print("Cantidad: ");

            if (scanner.hasNextDouble()) {
                cantidad = scanner.nextDouble();
                cantidadValida = true;
            } else {
                System.out.println("Por favor, ingresa un número válido.");
                scanner.next(); // Limpiar el buffer del scanner
                cantidadValida = false;
            }
        } while (!cantidadValida);

        resultadoConversionn.resultadoconversion(cantidad, divisaSeleccionada, eleccioncase);
    }
}
