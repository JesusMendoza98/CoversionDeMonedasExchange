    package com.exchange.conversor.calculos;

    import com.exchange.conversor.consultas.ConsultaApiExchange;
    import com.exchange.conversor.currencyvalues.CurrencyCode;
    import com.exchange.conversor.currencyvalues.CurrencyCodeObject;

    import java.util.Scanner;

    public class ManejoDatos {
        public static void convertirMoneda(String mensaje, String divisaSeleccionada, ValoresMonedas resultadoConversionn, int eleccioncase) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("┌──────────────────────────────────┐");
            System.out.println(mensaje);
            System.out.println("└──────────────────────────────────┘");

            ConsultaApiExchange consultaApiExchange = new ConsultaApiExchange();
            CurrencyCodeObject currencyCodeObject = consultaApiExchange.buscaTipoDivisa(divisaSeleccionada);
            if (currencyCodeObject != null) {
                CurrencyCode currencyCode = new CurrencyCode(currencyCodeObject);
                resultadoConversionn.mostrarMonedasObtenidas(currencyCode);
            } else {
                System.out.println("No se pudieron obtener las tasas de cambio.");
                return; // Salir del método en caso de error
            }

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
