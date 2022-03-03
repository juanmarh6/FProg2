package lab1;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {
        NumeroNatural numero1 = new NumeroNatural();
        numero1.setNumero(28);
        System.out.println(numero1.esPrimo());
        System.out.println(numero1.esPerfecto());
        numero1.setNumero(5);
        System.out.println(numero1.pow(3));
        System.out.println(numero1.half());
        NumeroNatural numero2 = new NumeroNatural();
        numero2.setNumero(3);
        System.out.println(numero1.distancia(numero2).numero);
        numero1.syncToMinor(numero2);
        System.out.println(numero1.numero);
        System.out.println(numero2.numero);
        numero1.setNumero(31);
        if(numero1.esPrimo()) {
            if (numero1.esFeliz())
                System.out.println("El número " + numero1.numero + " es un primo feliz :)");
            else
                System.out.println("El número " + numero1.numero + " es un primo infeliz :(");
        }

        else{
                if (numero1.esFeliz())
                    System.out.println("El número " + numero1.numero + " es un número feliz :)");
                else
                    System.out.println("El número " + numero1.numero + " es un número infeliz :(");
            }
    }
}
