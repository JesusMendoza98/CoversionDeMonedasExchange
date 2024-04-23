package com.exchange.conversor.principal;

import com.exchange.conversor.textos.Textos;
import com.exchange.conversor.calculos.ValoresMonedas;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entradaEleccion = new Scanner(System.in);
        ValoresMonedas resultadoConversionn = new ValoresMonedas();

        int eleccioncase;

        do {
            Textos.menuDeOpciones();
            System.out.print("Seleccione una opcion: ");
            if (entradaEleccion.hasNextInt()) {
                eleccioncase = entradaEleccion.nextInt();
                switch (eleccioncase) {
                    case 1:
                        convertirMoneda("Dolar a Peso Argentino", "USD", resultadoConversionn, eleccioncase);
                        break;
                    case 2:
                        convertirMoneda("Pesos Argentino a Dolar", "ARS", resultadoConversionn, eleccioncase);
                        break;
                    case 3:
                        convertirMoneda("Dolares a Real Brasileño", "USD", resultadoConversionn, eleccioncase);
                        break;
                    case 4:
                        convertirMoneda("Real Brasileño a Dolar", "BRL", resultadoConversionn, eleccioncase);
                        break;
                    case 5:
                        convertirMoneda("Dolar a Bolivares", "USD", resultadoConversionn, eleccioncase);
                        break;
                    case 6:
                        convertirMoneda("Bolivares a Dolares", "BOB", resultadoConversionn, eleccioncase);
                        break;
                    case 7:
                        System.out.println("¡Hasta la Proxima!");
                        break;
                    default:
                        System.out.println("Selecciona una opcion del menu:");
                        break;
                }
            } else {
                System.out.println("Por favor, ingresa un número válido.");
                entradaEleccion.nextLine(); // Consumir la línea completa para avanzar
                eleccioncase = -1; // Reiniciar la eleccion
            }
        } while (eleccioncase != 7);

        entradaEleccion.close();
    }

    private static void convertirMoneda(String mensaje, String divisaSeleccionada, ValoresMonedas resultadoConversionn, int eleccioncase) {
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