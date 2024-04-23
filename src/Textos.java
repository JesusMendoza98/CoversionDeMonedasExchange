public class Textos {
    public static void textoBienvenida(){
        System.out.println("""
                \033[1;34m============================
                === Conversor de Divisas ===
                ============================\033[0m""");
    }

    public static void DolarAPesoArgentinoTexto() {
        System.out.println("""
              :::::::::::::::::::::::::::::::
              :::Dolares a Pesos argentino:::
              :::::::::::::::::::::::::::::::""");

    }
    public static void lineaFinal() {
        System.out.println("::::::::::::::::::::::::::::::::");
    }
    public static void menuDeOpciones() {
        System.out.println("""
   ┌────────────────────────────────────────────────┐
   │\033[0;1m             CONVERSOR DE DIVISAS\033[0;0m               │
   ├────────────────────────────────────────────────┤
   │   Opción   │             Conversión            │
   ├────────────────────────────────────────────────┤
   │     1      │   Dolares a Peso Argentino        │
   │     2      │   Peso Argentino a Dolar          │
   │     3      │   Dolares a Real Brasileño        │
   │     4      │   Real Brasileño a Dolar          │
   │     5      │   Dolares a Bolivares             │
   │     6      │   Bolivares a Dolares             │
   └────────────────────────────────────────────────┘""");
    }
    }


