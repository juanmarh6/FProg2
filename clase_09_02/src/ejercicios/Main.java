package ejercicios;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Coleccion col2 = leeColeccion("coleccion.dat");




   }

   public static  void escribeColeccion(Coleccion colec, String nombre) throws IOException {
        FileOutputStream fos = null;
        ObjectOutputStream salida = null;
        fos = new FileOutputStream(nombre);
        salida = new ObjectOutputStream(fos);
        salida.writeObject(colec);
        fos.close();
        salida.close();
   }

   public static Coleccion leeColeccion(String nombre) throws IOException, ClassNotFoundException {
        FileInputStream fis = null;
        ObjectInputStream entrada = null;
        Coleccion colec;
        fis = new FileInputStream(nombre);
        entrada = new ObjectInputStream(fis);
        colec = (Coleccion) entrada.readObject();
        fis.close();
        entrada.close();
        return colec;
   }
}

