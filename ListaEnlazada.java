/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema.calificaciones;

/**
 *
 * @author Madison
 */
public class ListaEnlazada {
    
    private Nodo cabeza;
    private int tamanio;

    public ListaEnlazada() {
        this.cabeza = null;
        this.tamanio = 0;
    }

    // Verificar si la lista está vacía
    public boolean estaVacia() {
        return cabeza == null;
    }

    // Obtener cantidad de estudiantes
    public int getTamanio() {
        return tamanio;
    }

    // Insertar al inicio
    public void insertarInicio(int dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
        tamanio++;
    }

    // Insertar una calificación de forma ordenada
    public void insertarOrdenado(int dato) {

        if (estaVacia() || dato <= cabeza.dato) {
            insertarInicio(dato);
            return;
        }

        Nodo nuevo = new Nodo(dato);
        Nodo actual = cabeza;

        while (actual.siguiente != null &&
               actual.siguiente.dato < dato) {

            actual = actual.siguiente;
        }

        nuevo.siguiente = actual.siguiente;
        actual.siguiente = nuevo;
        tamanio++;
    }

    // Mostrar calificaciones ordenadas
    public void mostrarLista() {

        if (estaVacia()) {
            System.out.println("No hay calificaciones registradas.");
            return;
        }

        Nodo actual = cabeza;
        int posicion = 1;

        System.out.println("\n=== CALIFICACIONES ORDENADAS ===");

        while (actual != null) {
            System.out.println(posicion + ". " + actual.dato);
            actual = actual.siguiente;
            posicion++;
        }
    }

    // Buscar una calificación específica
    public boolean buscar(int dato) {

        Nodo actual = cabeza;

        while (actual != null) {

            if (actual.dato == dato) {
                return true;
            }

            if (actual.dato > dato) {
                return false;
            }

            actual = actual.siguiente;
        }

        return false;
    }

    // Consultar calificación por posición (desde 1)
    public Integer obtenerEnPosicion(int posicion) {

        if (posicion < 1 || posicion > tamanio) {
            return null;
        }

        Nodo actual = cabeza;

        for (int i = 1; i < posicion; i++) {
            actual = actual.siguiente;
        }

        return actual.dato;
    }

    // Obtener calificación mínima
    public Integer obtenerMinima() {

        if (estaVacia()) {
            return null;
        }

        return cabeza.dato;
    }

    // Obtener calificación máxima
    public Integer obtenerMaxima() {

        if (estaVacia()) {
            return null;
        }

        Nodo actual = cabeza;

        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }

        return actual.dato;
    }

    // Calcular la mediana
    public Double obtenerMediana() {

        if (estaVacia()) {
            return null;
        }

        if (tamanio % 2 != 0) {
            return (double) obtenerEnPosicion(tamanio / 2 + 1);
        }

        int valor1 = obtenerEnPosicion(tamanio / 2);
        int valor2 = obtenerEnPosicion(tamanio / 2 + 1);

        return (valor1 + valor2) / 2.0;
    }

    // Eliminar una calificación por posición
    public boolean eliminarPosicion(int posicion) {

        if (posicion < 1 || posicion > tamanio) {
            return false;
        }

        if (posicion == 1) {
            cabeza = cabeza.siguiente;
        } else {

            Nodo actual = cabeza;

            for (int i = 1; i < posicion - 1; i++) {
                actual = actual.siguiente;
            }

            actual.siguiente = actual.siguiente.siguiente;
        }

        tamanio--;
        return true;
    }

    // Corregir una calificación manteniendo el orden
    public boolean corregirCalificacion(int posicion, int nueva) {

        if (posicion < 1 || posicion > tamanio) {
            return false;
        }

        if (nueva < 0 || nueva > 100) {
            return false;
        }

        eliminarPosicion(posicion);
        insertarOrdenado(nueva);

        return true;
    }
    
}
