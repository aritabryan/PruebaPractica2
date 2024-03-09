/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebapractica.pkg2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PruebaPractica2 {

    static Scanner duki = new Scanner(System.in);
    static Random rndm = new Random();
    static ArrayList<Libro> ListaLibros = new ArrayList<>();
    static ArrayList<Libro> librosDisponibles = new ArrayList<>();
    static ArrayList<Libro> librosPrestados = new ArrayList<>();

    static String NameBook;
    static String AutorBook;
    static int IDbook;
    static String EstadoBook;
    static String DuenoBook;

    public static void Newbook() {
        duki.nextLine();
        System.out.print("Nombre del libro: ");
        NameBook = duki.nextLine();
        System.out.print("Autor: ");
        AutorBook = duki.nextLine();
        Libro nuevoLibro = new Libro(NameBook, AutorBook);
        ListaLibros.add(nuevoLibro);
        librosDisponibles.add(nuevoLibro);
    }

    public static void Solicitarbook() {
        duki.nextLine();
        System.out.print("Nombre: ");
        String NamePersona = duki.nextLine();
        System.out.print("Posicion del libro que desea agarrar: ");
        int Posbookrequest = duki.nextInt();
        if (Posbookrequest < ListaLibros.size()) {
            librosDisponibles.get(Posbookrequest).Prestar(NamePersona);
            librosPrestados.add(librosDisponibles.remove(Posbookrequest));
        } else {
            System.out.println("posicion de libro no encontrado");
        }
    }

    public static void RegresarLibro() {
        System.out.print("Posicion del libro que desea regresar: ");
        int PosBookReturn = duki.nextInt();
        if (PosBookReturn < ListaLibros.size()) {
            librosPrestados.get(PosBookReturn).Regresar();
            librosDisponibles.add(librosPrestados.remove(PosBookReturn));
        } else {
            System.out.println("posicion de libro no encontrado");
        }
    }

    public static void BuscarLibro() {
                duki.nextLine();
        System.out.print("Nombre del libro: ");
        String NombreLibro = duki.nextLine();
        boolean found = false;
        for (Libro ListaLibro : ListaLibros) {
            if (ListaLibro.getNombre().equalsIgnoreCase(NombreLibro)) {
                found = true;
                System.out.println(ListaLibro);
            } else {
                found = false;
            }
        }
        if (!found) {
            System.out.println("No se encontro ese libro");
        }
    }

    public static void ListarLibrosDisponibles() {
        System.out.println("***Libros disponibles***");
        for (Libro libro : librosDisponibles) {
            System.out.println(libro);
        }
    }

    public static void ListarLibrosPrestados() {
        System.out.println("***Libros prestados***");
        for (Libro libro : librosPrestados) {
            System.out.println(libro);
        }
    }

    public static void main(String[] args) {
        System.out.println("1) Agregar Nuevo libro a la biblioteca\n2) Solicitar libro\n3) Regresar libro\n4) Buscar libro por nombre\n"
                + "5) Listar libros disponibles\n6) Listar libros prestados");
        int opcionMenu = duki.nextInt();
        while (opcionMenu != 7) {
            switch (opcionMenu) {
                case 1:
                    Newbook();
                    break;

                case 2:
                    Solicitarbook();
                    break;

                case 3:
                    RegresarLibro();
                    break;

                case 4:
                    BuscarLibro();
                    break;

                case 5:
                    ListarLibrosDisponibles();
                    break;

                case 6:
                    ListarLibrosPrestados();
                    break;

                default:
                    System.out.println("opcion no disponible");
                    break;

            }
            System.out.println("1) Agregar Nuevo libro a la biblioteca\n2) Solicitar libro\n3) Regresar libro\n4) Buscar libro por nombre\n"
                    + "5) Listar libros disponibles\n6) Listar libros prestados");
            opcionMenu = duki.nextInt();
        }
        System.out.println("Saliendo del programa...");
    }

}
