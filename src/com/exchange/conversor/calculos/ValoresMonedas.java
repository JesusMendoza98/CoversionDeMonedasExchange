package com.exchange.conversor.calculos;

import com.exchange.conversor.currencyvalues.CurrencyCode;
import com.exchange.conversor.currencyvalues.CurrencyCodeObject;
import com.exchange.conversor.consultas.ConsultaApiExchange;
import com.exchange.conversor.textos.Textos;

public class ValoresMonedas {
    public void resultadoconversion(double cantidad, String siglaDivisa, int eleccionDivisa) {
        double operacionDivisa;
        double tipoCambio;

        ConsultaApiExchange consultaApiExchange = new ConsultaApiExchange();

        // Realizar una consulta para obtener las tasas de cambio
        CurrencyCodeObject currencyCodeObject = consultaApiExchange.buscaTipoDivisa(siglaDivisa);

        // Verificar si las tasas de cambio se obtuvieron correctamente
        if (currencyCodeObject != null) {
            // Crear una instancia de com.exchange.conversor.currencyvalues.CurrencyCode utilizando las tasas de cambio obtenidas
            CurrencyCode currencyCode = new CurrencyCode(currencyCodeObject);
            tipoCambio = obtenerTipoCambio(eleccionDivisa, currencyCode);
        } else {
            System.out.println("No se pudieron obtener las tasas de cambio.");
            return; // Salir del método en caso de error
        }

        // Calcular la operación de conversión según la elección de divisa
        operacionDivisa = cantidad * tipoCambio;

        // Mostrar el resultado

        System.out.println("┌────────────────────────────────────────────────┐");
        System.out.println("    Tu cantidad:  " + cantidad + " " + siglaDivisa);
        System.out.println("    Tu resultado: " + operacionDivisa + " " + obtenerMonedaDestino(eleccionDivisa) );
        System.out.println("└────────────────────────────────────────────────┘");
    }

    // Método auxiliar para obtener el tipo de cambio según la elección de divisa
    private double obtenerTipoCambio(int eleccionDivisa, CurrencyCode currencyCode) {
        return switch (eleccionDivisa) {
            case 1 -> // Dólar a Peso Argentino
                    currencyCode.getPeso_argentino();
            case 2 -> // Peso Argentino a Dólar
                    currencyCode.getDolar();
            case 3 -> // Dólar a Real Brasileño
                    currencyCode.getReal_brasileño(); // Real Brasileño a Dólar
            case 4, 6 -> // Bolivianos a Dólar
                    currencyCode.getDolar();
            case 5 -> // Dólar a Bolivianos
                    currencyCode.getPeso_boliviano();
            default -> 0; // Valor predeterminado en caso de elección inválida
        };
    }

    // Método auxiliar para obtener la moneda de destino según la elección de divisa
    private String obtenerMonedaDestino(int eleccionDivisa) {
        return switch (eleccionDivisa) {
            case 1 -> "ARS"; // Peso Argentino
            case 2, 4, 6 -> "USD"; // Dólar
            case 3 -> "BRL"; // Real Brasileño
            case 5 -> "BOB"; // Bolivianos
            default -> "";
        };
    }

}

