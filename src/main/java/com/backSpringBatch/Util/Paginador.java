package com.backSpringBatch.Util;

import java.util.ArrayList;
import java.util.List;

public class Paginador<T> {
    private List<T> lista;
    private int elementosPorPagina;

    public Paginador(List<T> lista, int elementosPorPagina) {
        this.lista = lista;
        this.elementosPorPagina = elementosPorPagina;
    }

    public List<T> obtenerPagina(int numeroPagina) {
        int indiceInicio = (numeroPagina - 1) * elementosPorPagina;
        int indiceFin = Math.min(indiceInicio + elementosPorPagina, lista.size());

        if (indiceInicio < indiceFin) {
            return lista.subList(indiceInicio, indiceFin);
        } else {
            return new ArrayList<>();
        }
    }

    public int obtenerNumeroTotalPaginas() {
        return (int) Math.ceil((double) lista.size() / elementosPorPagina);
    }

   /* public static void main(String[] args) {
        // Ejemplo de uso
        List<String> datos = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            datos.add("Elemento " + i);
        }

        int elementosPorPagina = 5;
        Paginador<String> paginador = new Paginador<>(datos, elementosPorPagina);

        // Obtener la primera página
        List<String> pagina1 = paginador.obtenerPagina(1);
        System.out.println("Página 1: " + pagina1);

        // Obtener la segunda página
        List<String> pagina2 = paginador.obtenerPagina(2);
        System.out.println("Página 2: " + pagina2);

        // Obtener el número total de páginas
        int totalPaginas = paginador.obtenerNumeroTotalPaginas();
        System.out.println("Número total de páginas: " + totalPaginas);
    }*/
}