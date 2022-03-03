package ejercicios;

import java.io.Serializable;

public class Libro implements Serializable {
    private int paginas;
    private int paginaActual;
    private double isbn;
    private String autor;
    private String titulo;
    private String [] contenido;


    //constructor a
    public Libro(int paginas, String autor, String titulo, double isbn){
        this.paginas=paginas;
        this.paginaActual=0;
        this.autor=autor;
        this.titulo=titulo;
        this.isbn=isbn;
        this.contenido=new String[paginas];
    }
    //constructor b
    public Libro(){
        this.paginas=0;
        this.paginaActual=0;
        this.autor=null;
        this.titulo=null;
        this.isbn=0;
        this.contenido= new String[1];
    }

    //getters getters
    public void setNombre(String nombre){
        this.titulo=nombre;
    }
    public String getNombre(){
        return this.titulo;
    }
    public void setAutor(String autor){
        this.autor=autor;
    }
    public String getAutor(){
        return this.autor;
    }
    public void setPaginas(int paginas){
        this.paginas=paginas;
    }
    public int getPaginas(){
        return this.paginas;
    }
    public void setIsbn(double isbn){
        this.isbn=isbn;
    }
    public double getIsbn(){
        return this.isbn;
    }
    public void setContenido(int pagina, String contenido){
        this.contenido[pagina]=contenido;
    }
    public String getContenido(int pagina){
        return this.contenido[pagina];
    }


    //añade una pagina
    public void añadePagina(String contenido){
        if(paginaActual>=paginas)
            System.out.println("Has sobrepasado el numero de paginas");
        else{
            this.contenido[paginaActual]=contenido;
            paginaActual++;
        }


    }

    //metodo contenido
    public String primerosCaracteres(int pagina){
        if(this.contenido[pagina].length()<=10)
            return this.contenido[pagina];
        else {
            String salida = new String();
            for(int i=0;i<10;i++){
                salida+=this.contenido[pagina].charAt(i);
            }
            return salida;
        }
    }

    public String estaPalabra(String palabra){
        String salida = new String("La palabra "+palabra+" está en las páginas ");
        int paginasPalabra[] = new int [paginaActual];
        int contador = 0;
        for(int i=0; i<paginaActual;i++) {
            if (this.contenido[i].indexOf(palabra) != -1) {
                paginasPalabra[i] = 1;
                contador++;
            }
            else
                paginasPalabra[i]=-1;
        }
        if (contador==0)
            return "La palabra "+palabra+" no está en el libro.";
        for(int k=0;k<paginaActual;k++){
            if(paginasPalabra[k]==1) {
                salida += k+1;
                salida += ", ";
            }
        }
        salida += "\b\b.";
        return salida;
    }

}
