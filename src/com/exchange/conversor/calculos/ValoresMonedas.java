package com.exchange.conversor.calculos;

import com.exchange.conversor.currencyvalues.CurrencyCode;
import com.exchange.conversor.currencyvalues.CurrencyCodeObject;
import com.exchange.conversor.consultas.ConsultaApiExchange;
import com.exchange.conversor.textos.Textos;

public class ValoresMonedas {
    public void resultadoconversion(double cantidad, String siglaDivisa, int eleccionDivisa) {
        double operacionDivisa = 0;
        double tipoCambio = 0;

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
        Textos.lineaFinal();
        System.out.println(":::::Tu cantidad: " + cantidad + " " + siglaDivisa + "::::::");
        System.out.println(":::Tu resultado: " + operacionDivisa + " " + obtenerMonedaDestino(eleccionDivisa) + "::::");
        Textos.lineaFinal();
    }

    // Método auxiliar para obtener el tipo de cambio según la elección de divisa
    private double obtenerTipoCambio(int eleccionDivisa, CurrencyCode currencyCode) {
        switch (eleccionDivisa) {
            case 1: // Dólar a Peso Argentino
                return currencyCode.getPeso_argentino();
            case 2: // Peso Argentino a Dólar
                return currencyCode.getDolar();
            case 3: // Dólar a Real Brasileño
                return currencyCode.getReal_brasileño();
            case 4: // Real Brasileño a Dólar
            case 6: // Bolivianos a Dólar
                return currencyCode.getDolar();
            case 5: // Dólar a Bolivianos
                return currencyCode.getPeso_boliviano();
            default:
                return 0; // Valor predeterminado en caso de elección inválida
        }
    }

    // Método auxiliar para obtener la moneda de destino según la elección de divisa
    private String obtenerMonedaDestino(int eleccionDivisa) {
        switch (eleccionDivisa) {
            case 1:
                return "ARS"; // Peso Argentino
            case 2:
            case 4:
            case 6:
                return "USD"; // Dólar
            case 3:
                return "BRL"; // Real Brasileño
            case 5:
                return "BOB"; // Bolivianos
            default:
                return "";
        }
    }

}

