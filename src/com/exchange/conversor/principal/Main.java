package com.exchange.conversor.principal;

import com.exchange.conversor.textos.Textos;
import com.exchange.conversor.calculos.ValoresMonedas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entradaEleccion = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        ValoresMonedas resultadoConversionn = new ValoresMonedas();

        boolean volverMenu = true;
        int eleccioncase;
        do {

            Textos.menuDeOpciones();
            System.out.print("Seleccione una opcion: \r");
            if (entradaEleccion.hasNextInt()) {
                eleccioncase = entradaEleccion.nextInt();

                Scanner entrada = new Scanner(System.in);

                String divisaSeleccionada;

                switch (eleccioncase) {
                    case 1:
                        System.out.println("Seleccionaste Dolar a Peso Argentino");
                        System.out.print("Digite la Cantidad de dolares: ");
                        divisaSeleccionada = "USD";
                        resultadoConversionn.resultadoconversion(Double.parseDouble(entrada.nextLine()), divisaSeleccionada, eleccioncase);
                        break;
                    case 2:
                        System.out.println("Pesos Argentino a Dolar");
                        System.out.print("Digite la Cantidad de Pesos Argentino: ");
                        divisaSeleccionada = "ARS";
                        resultadoConversionn.resultadoconversion(Double.parseDouble(entrada.nextLine()), divisaSeleccionada, eleccioncase);

                        break;
                    case 3:
                        System.out.println("Dolares a Real Brasileño");
                        System.out.print("Digite la Cantidad de dolares: ");
                        divisaSeleccionada = "USD";
                        resultadoConversionn.resultadoconversion(Double.parseDouble(entrada.nextLine()), divisaSeleccionada, eleccioncase);

                        break;
                    case 4:
                        System.out.println("Real Brasileño a Dolar");
                        System.out.print("Digite la Cantidad de Reales: ");
                        divisaSeleccionada = "BRL";
                        resultadoConversionn.resultadoconversion(Double.parseDouble(entrada.nextLine()), divisaSeleccionada, eleccioncase);
                        break;
                    case 5:
                        System.out.println("Dolar a Bolivares");
                        divisaSeleccionada = "USD";
                        System.out.print("Digite la Cantidad de dolares: ");
                        resultadoConversionn.resultadoconversion(Double.parseDouble(entrada.nextLine()), divisaSeleccionada, eleccioncase);
                        break;
                    case 6:
                        System.out.println("Bolivares a Dolares");
                        divisaSeleccionada = "BOB";
                        System.out.print("Digite la Cantidad de Bolivares: ");
                        resultadoConversionn.resultadoconversion(Double.parseDouble(entrada.nextLine()), divisaSeleccionada, eleccioncase);
                        break;
                    case 7:
                        System.out.println("¡Hasta la Proxima!");
                        break;
                    default:
                        System.out.println("Selecciona una opcion del menu:");
                        break;
                }
            }
            else {
                    System.out.println("Por favor, ingresa un número válido.");
                    entradaEleccion.next(); // Limpiar el buffer del scanner
                    eleccioncase = -1; // Asignar un valor no válido para continuar el bucle
                }
            if (volverMenu ) {
                System.out.print("Presione Enter para volver al menú...");
                scanner.nextLine(); // Esperar hasta que el usuario presione Enter
            }
        } while (eleccioncase != 7);
        {
        entradaEleccion.close();
        }


    }
}