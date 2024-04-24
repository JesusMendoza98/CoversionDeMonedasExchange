package com.exchange.conversor.currencyvalues;

public class CurrencyCode implements Comparable<CurrencyCode> {
    private double dolar;
    private double peso_argentino;
    private double peso_boliviano;
    private double real_brasileño;
    private double peso_chileno;
    private double peso_colombiano;



    public double getDolar() {
        return dolar;
    }


    public double getReal_brasileño() {
        return real_brasileño;
    }

    public double getPeso_boliviano() {
        return peso_boliviano;
    }


    public double getPeso_argentino() {
        return peso_argentino;
    }


    public CurrencyCode(CurrencyCodeObject CurrencyCodeObject){
this.dolar = CurrencyCodeObject.USD();
this.peso_argentino = CurrencyCodeObject.ARS();
this.peso_boliviano = CurrencyCodeObject.BOB();
this.peso_colombiano = CurrencyCodeObject.COP();
this.real_brasileño = CurrencyCodeObject.BRL();
this.peso_chileno = CurrencyCodeObject.CLP();



}





    @Override
    public int compareTo(CurrencyCode o) {
        return Double.compare(this.getDolar(), o.getDolar());
    }
    @Override
    public String toString() {

        String format = "| %-15s | %-15s |\n";

        String stringBuilder = "┌───────────────────────────────────┐\n" +
                                String.format(format, "Divisa", "Valor") +
                "├───────────────────────────────────┤\n" +
                String.format(format, "Dólar", String.format("%.5f", dolar)) +
                String.format(format, "Peso Argentino", String.format("%.5f", peso_argentino)) +
                String.format(format, "Peso Boliviano", String.format("%.5f", peso_boliviano)) +
                String.format(format, "Real Brasileño", String.format("%.5f", real_brasileño)) +
                String.format(format, "Peso Chileno", String.format("%.5f", peso_chileno)) +
                String.format(format, "Peso Colombiano", String.format("%.5f", peso_colombiano)) +
                "└───────────────────────────────────┘\n";

        return stringBuilder;

}
}
