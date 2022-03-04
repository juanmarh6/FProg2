package PaqC07;

import java.io.*;
import java.util.Scanner;


public class Prueba  {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Registro r1 = Leer();

        Scanner sc = new Scanner(System.in);
        System.out.println("¿De qué tipo es la habitación? (1-Estándar, 2-Balcón, 3-Suite)");
        int res = sc.nextInt();
        int [] coordenadas = r1.encuentraHab(res);
        if (coordenadas[0] == -1) {     //Si no hay hueco disponible para ese tipo de habitación, la función búsquedaHab devuelve un vector {-1,-1}
            System.out.println("No hay habitaciones disponibles.");
        }
        else {
            System.out.println("NOMBRE: ");
            sc.nextLine();
            String nombre = sc.nextLine();
            System.out.println("APELLIDOS: ");
            String apellidos = sc.nextLine();
            System.out.println("DNI/NIF: ");
            int dni = sc.nextInt();
            System.out.println("TELÉFONO: ");
            int tel = sc.nextInt();
            System.out.println("Tarjeta de Pago: ");
            int card = sc.nextInt();
            System.out.println("\nFECHA DE ALTA:");
            sc.nextLine();
            String alta = sc.nextLine();
            System.out.println("FECHA DE BAJA:");
            String baja = sc.nextLine();
            System.out.println("Régimen: ");
            String Régimen = sc.nextLine();
            r1.habitaciones[coordenadas[0]][coordenadas[1]] = new Cliente();
            r1.almacenaReserva(coordenadas, nombre, apellidos, dni, tel, card, alta, baja, Régimen);
        }
        System.out.println(r1.muestraPantalla());
        System.out.println("Deseas anular reserva? (1 en caso afirmativo)");
        res = sc.nextInt();
        if(res == 1) {
            r1.anulaReserva(coordenadas);
        }
        System.out.println(r1.muestraPantalla());

        Serializar(r1);
    }

    private static void Serializar(Registro r) throws IOException{
        FileOutputStream fos = new FileOutputStream("reg.dat");
        ObjectOutputStream salida = new ObjectOutputStream(fos);
        salida.writeObject(r);
        fos.close();
        salida.close();
    }

    private static Registro Leer() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("reg.dat");
        ObjectInputStream entrada = new ObjectInputStream(fis);
        Registro salida = (Registro) entrada.readObject();
        fis.close();
        entrada.close();
        return salida;
    }
}


