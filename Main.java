/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema.calificaciones;
import java.util.Scanner;

/**
 *
 * @author Madison
 */
public class Main {
    
      public static void main(String[] args) {

       Scanner teclado = new Scanner(System.in);
        ListaEnlazada lista = new ListaEnlazada();

        int opcion, calificacion, posicion, nueva;

        do {
            System.out.println("\n===== SISTEMA DE CALIFICACIONES =====");
            System.out.println("1. Registrar calificacion");
            System.out.println("2. Mostrar calificaciones ordenadas");
            System.out.println("3. Consultar calificacion por posicion");
            System.out.println("4. Ver calificacion minima");
            System.out.println("5. Ver calificacion maxima");
            System.out.println("6. Ver mediana");
            System.out.println("7. Corregir calificacion");
            System.out.println("8. Eliminar calificacion");
            System.out.println("9. Buscar calificacion");
            System.out.println("10. Total de estudiantes");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("Ingrese la calificacion: ");
                    calificacion = teclado.nextInt();

                    if (calificacion >= 0 && calificacion <= 100) {
                        lista.insertarOrdenado(calificacion);
                        System.out.println("Calificacion registrada.");
                    } else {
                        System.out.println("La calificacion debe estar entre 0 y 100.");
                    }
                    break;

                case 2:
                    lista.mostrarLista();
                    break;

                case 3:
                    System.out.print("Ingrese la posicion: ");
                    posicion = teclado.nextInt();

                    Integer dato = lista.obtenerEnPosicion(posicion);

                    if (dato != null) {
                        System.out.println("Calificacion: " + dato);
                    } else {
                        System.out.println("Posicion invalida.");
                    }
                    break;

                case 4:
                    if (!lista.estaVacia()) {
                        System.out.println("Minima: " + lista.obtenerMinima());
                    } else {
                        System.out.println("La lista esta vacia.");
                    }
                    break;

                case 5:
                    if (!lista.estaVacia()) {
                        System.out.println("Maxima: " + lista.obtenerMaxima());
                    } else {
                        System.out.println("La lista esta vacia.");
                    }
                    break;

                case 6:
                    if (!lista.estaVacia()) {
                        System.out.println("Mediana: " + lista.obtenerMediana());
                    } else {
                        System.out.println("La lista esta vacia.");
                    }
                    break;

                case 7:
                    lista.mostrarLista();

                    if (lista.estaVacia()) {
                        break;
                    }

                    System.out.print("Posicion a corregir: ");
                    posicion = teclado.nextInt();

                    System.out.print("Nueva calificacion: ");
                    nueva = teclado.nextInt();

                    if (lista.corregirCalificacion(posicion, nueva)) {
                        System.out.println("Calificacion corregida.");
                        lista.mostrarLista();
                    } else {
                        System.out.println("Posicion o calificacion invalida.");
                    }
                    break;

                case 8:
                    lista.mostrarLista();

                    if (lista.estaVacia()) {
                        break;
                    }

                    System.out.print("Posicion a eliminar: ");
                    posicion = teclado.nextInt();

                    if (lista.eliminarPosicion(posicion)) {
                        System.out.println("Calificacion eliminada.");
                    } else {
                        System.out.println("Posicion invalida.");
                    }
                    break;

                case 9:
                    System.out.print("Calificacion a buscar: ");
                    calificacion = teclado.nextInt();

                    if (lista.buscar(calificacion)) {
                        System.out.println("La calificacion existe.");
                    } else {
                        System.out.println("La calificacion no existe.");
                    }
                    break;

                case 10:
                    System.out.println("Total de estudiantes: "
                            + lista.getTamanio());
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 0);

        teclado.close();
    }
    
}
