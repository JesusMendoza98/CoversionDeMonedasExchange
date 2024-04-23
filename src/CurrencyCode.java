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
        return String.valueOf((dolar)+peso_argentino+peso_boliviano+ real_brasileño+peso_chileno+peso_colombiano);

}
}
