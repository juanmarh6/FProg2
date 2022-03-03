package ejercicios;

import java.io.Serializable;
import java.util.Scanner;

public class Coleccion implements Serializable {
    private int cantidad;
    private Libro []libros;
    private String genero;
    private int libroActual;

    //constructor a
    public Coleccion(int c, String genero){
        this.cantidad=c;
        this.genero=genero;
        libroActual = 0;
        libros=new Libro[cantidad];
    }

    //constructor b
    public Coleccion(){
        this.cantidad = 0;
        this.genero = null;
        libroActual = 0;
        this.libros = new Libro[1];
    }

    public void setCantidad(int c){
        this.cantidad=c;
    }
    public int getCantidad(){
        return cantidad;
    }
    public void setGenero(String x){
        genero=x;
    }
    public String getGenero(){
        return genero;
    }


    //añade un libro
    public void añadeLibro(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el título del libro: ");
        String titulo = sc.nextLine();
        System.out.println("Introduce el autor del libro: ");
        String autor = sc.nextLine();
        System.out.println("Introduce el número de páginas que tiene el libro: ");
        int paginas = sc.nextInt();
        System.out.println("Introduce el isbn del libro: ");
        double isbn = sc.nextDouble();
        libros[libroActual] = new Libro(paginas,autor,titulo,isbn);
    }

    public Libro devuelveAnterior(Libro lib1){
        for (int i=0; i<cantidad; i++)
            if (lib1.getIsbn()==libros[i].getIsbn())
                return libros[i-1];
        return null;
    }

}
