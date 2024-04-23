package com.exchange.conversor.principal;

import com.exchange.conversor.textos.Textos;
import com.exchange.conversor.calculos.ValoresMonedas;

import java.util.NoSuchElementException;
import java.util.Scanner;

import static com.exchange.conversor.calculos.ManejoDatos.convertirMoneda;

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
                        convertirMoneda("\033[0;34mDolar a Peso Argentino\033[0m", "USD", resultadoConversionn, eleccioncase);
                        break;
                    case 2:
                        convertirMoneda("\033[0;34mPesos Argentino a Dolar\033[0m", "ARS", resultadoConversionn, eleccioncase);
                        break;
                    case 3:
                        convertirMoneda("\033[0;34mDolares a Real Brasileño\033[0m", "USD", resultadoConversionn, eleccioncase);
                        break;
                    case 4:
                        convertirMoneda("\033[0;34mReal Brasileño a Dolar\033[0m", "BRL", resultadoConversionn, eleccioncase);
                        break;
                    case 5:
                        convertirMoneda("\033[0;34mDolar a Bolivares\033[0m", "USD", resultadoConversionn, eleccioncase);
                        break;
                    case 6:
                        convertirMoneda("Bolivares a Dolares\033[0m", "BOB", resultadoConversionn, eleccioncase);
                        break;
                    case 7:

                        System.out.println("""
                           ┌────────────────────────────────────────────────┐
                                          ¡Hasta la Proxima!
                           └────────────────────────────────────────────────┘
                           
                           """);
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



}