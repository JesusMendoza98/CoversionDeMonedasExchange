package com.exchange.conversor.calculos;

import com.exchange.conversor.currencyvalues.CurrencyCode;
import com.exchange.conversor.currencyvalues.CurrencyCodeObject;
import com.exchange.conversor.consultas.ConsultaApiExchange;
import com.exchange.conversor.textos.Textos;

public class ValoresMonedas {
    public void resultadoconversion(double cantidad, String siglaDivisa, int eleccionDivisa) {
        double dolar = 0;
        double pesoArgentino = 0;
        double realBrasileño = 0;
        double boliviano = 0;
        double operacionDivisa;


        ConsultaApiExchange consultaApiExchange = new ConsultaApiExchange();

        // Realizar una consulta para obtener las tasas de cambio
        CurrencyCodeObject currencyCodeObject = consultaApiExchange.buscaTipoDivisa(siglaDivisa); // Por ejemplo, consulta para obtener tasas de cambio de dólar

        // Verificar si las tasas de cambio se obtuvieron correctamente
        if (currencyCodeObject != null) {
            // Crear una instancia de com.exchange.conversor.currencyvalues.CurrencyCode utilizando las tasas de cambio obtenidas
            CurrencyCode currencyCode = new CurrencyCode(currencyCodeObject);
            dolar = currencyCode.getDolar();
            pesoArgentino = currencyCode.getPeso_argentino();
            realBrasileño = currencyCode.getReal_brasileño();
            boliviano = currencyCode.getPeso_boliviano();
        } else {
            System.out.println("No se pudieron obtener las tasas de cambio.");
        }


        switch (eleccionDivisa) {
            case 1:
                //Dolar a Peso Argentino
                operacionDivisa = cantidad * pesoArgentino;
                Textos.lineaFinal();
                System.out.println(":::::Tu cantidad: "+ cantidad +" " +siglaDivisa+"::::::");
                System.out.println(":::Tu resultado: " + operacionDivisa +" ARS::::");
                Textos.lineaFinal();
                break;
            case 2:
                operacionDivisa = cantidad * dolar;
                Textos.lineaFinal();
                System.out.println(":::::Tu cantidad: "+ cantidad +" " +siglaDivisa+"::::::");
                System.out.println(":::Tu resultado: " + operacionDivisa +" USD::::");
                Textos.lineaFinal();
                break;
            case 3:
                operacionDivisa = cantidad * realBrasileño;
                Textos.lineaFinal();
                System.out.println(":::::Tu cantidad: "+ cantidad +" " +siglaDivisa+"::::::");
                System.out.println(":::Tu resultado: " + operacionDivisa +" BRL::::");
                Textos.lineaFinal();
                break;
            case 4:
                Textos.lineaFinal();
                operacionDivisa = cantidad * dolar;
                Textos.lineaFinal();
                System.out.println(":::::Tu cantidad: "+ cantidad +" " +siglaDivisa+"::::::");
                System.out.println(":::Tu resultado: " + operacionDivisa +" USD::::");
                Textos.lineaFinal();
                break;
            case 5:
                Textos.lineaFinal();
                operacionDivisa = cantidad * boliviano;
                System.out.println(":::::Tu cantidad: "+ cantidad +" " +siglaDivisa+"::::::");
                System.out.println(":::Tu resultado: " + operacionDivisa +" BOB::::");
                Textos.lineaFinal();
                break;
            case 6:
                Textos.lineaFinal();
                operacionDivisa = cantidad * dolar;
                System.out.println(":::::Tu cantidad: "+ cantidad +" " +siglaDivisa+"::::::");
                System.out.println(":::Tu resultado: " + operacionDivisa +" USD::::");
                Textos.lineaFinal();
                break;
            default:
                break;

        }

    }
}

