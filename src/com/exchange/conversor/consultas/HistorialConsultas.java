package com.exchange.conversor.consultas;

import java.util.ArrayList;
import java.util.List;

public class HistorialConsultas {

    public static class Consulta {
        private double cantidad;
        private String siglaDivisa;

        public String getEleccionDivisa() {
            return eleccionDivisa;
        }



        public double getResultado() {
            return resultado;
        }

        public void setResultado(double resultado) {
            this.resultado = resultado;
        }

        public String getSiglaDivisa() {
            return siglaDivisa;
        }



        public double getCantidad() {
            return cantidad;
        }



        private String eleccionDivisa;
        private double resultado;

        // Constructor, getters y setters

        public Consulta(double cantidad, String siglaDivisa,String eleccionDivisa, double resultado) {
            this.cantidad = cantidad;
            this.eleccionDivisa = eleccionDivisa;
            this.siglaDivisa = siglaDivisa;
            this.resultado = resultado;
        }

        // Getters y setters
    }

    public static class TuClasePrincipal {
        private List<Consulta> historialConsultas = new ArrayList<>();

        // Otros métodos de la clase...

        public void agregarConsultaAlHistorial(double cantidad, String siglaDivisa, String eleccionDivisa, double resultado) {
            Consulta consulta = new Consulta(cantidad, siglaDivisa, eleccionDivisa,resultado); // Ajustar el constructor de Consulta
            historialConsultas.add(consulta);
        }

        public void mostrarHistorialConsultas() {
            //Mostramos la tabla de historial al Usuario
            System.out.println("Historial de Consultas:");
            System.out.println("┌───────────────────────────────────────────────────────────────────────┐");
            System.out.printf("| %-10s | %-10s | %-20s | %-20s |\n", "Cantidad", "Divisa", "Resultado", "Divisa");
            System.out.println("├───────────────────────────────────────────────────────────────────────┤");

            for (Consulta consulta : historialConsultas) {
                System.out.printf("| %-10.2f | %-10s = %-20f | %-20s |\n", consulta.getCantidad(), consulta.getSiglaDivisa(), consulta.getResultado(),consulta.getEleccionDivisa() );
            }

            System.out.println("└───────────────────────────────────────────────────────────────────────┘");
        }
    }
}