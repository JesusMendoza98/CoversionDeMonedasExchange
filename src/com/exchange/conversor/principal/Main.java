package com.exchange.conversor.principal;

import com.exchange.conversor.historial.HistorialConsultas;
import com.exchange.conversor.textos.Textos;
import com.exchange.conversor.calculos.ValoresMonedas;


import java.util.Scanner;

import static com.exchange.conversor.calculos.ManejoDatos.convertirMoneda;

public class Main {
    public static void main(String[] args) {
        Scanner entradaEleccion = new Scanner(System.in);

        HistorialConsultas.TuClasePrincipal tuClasePrincipal = new HistorialConsultas.TuClasePrincipal();
        ValoresMonedas resultadoConversionn = new ValoresMonedas(tuClasePrincipal);
       //

        int eleccioncase;

        do {
            Textos.menuDeOpciones();
            System.out.print("Seleccione una opcion: ");
            if (entradaEleccion.hasNextInt()) {
                eleccioncase = entradaEleccion.nextInt();
                switch (eleccioncase) {
                    case 1:
                        convertirMoneda("\033[0;1m        Dolar a Peso Argentino\033[0m", "USD", resultadoConversionn, eleccioncase);

                        break;
                    case 2:
                        convertirMoneda("\033[0;1m        Pesos Argentino a Dolar\033[0m", "ARS", resultadoConversionn, eleccioncase);
                        break;
                    case 3:
                        convertirMoneda("\033[0;1m        Dolares a Real Brasileño\033[0m", "USD", resultadoConversionn, eleccioncase);
                        break;
                    case 4:
                        convertirMoneda("\033[0;1m        Real Brasileño a Dolar\033[0m", "BRL", resultadoConversionn, eleccioncase);
                        break;
                    case 5:
                        convertirMoneda("\033[0;1m        Dolar a Bolivares\033[0m", "USD", resultadoConversionn, eleccioncase);
                        break;
                    case 6:
                        convertirMoneda("\033[0;1m        Bolivares a Dolares\033[0m", "BOB", resultadoConversionn, eleccioncase);
                        break;
                    case 7:
                        //Llamamos al metodo para mostrar nuestro historial.
                        tuClasePrincipal.mostrarHistorialConsultas();
                        break;
                    case 8:
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
        } while (eleccioncase != 8);

        entradaEleccion.close();
    }



}