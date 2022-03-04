package PaqC07;

import java.io.Serializable;
import java.util.Scanner;

public class Registro implements Serializable {
    int numHab, numPisos;
    Cliente [][] habitaciones;

    public Registro() {
        numPisos = 8;
        numHab = 6;
        habitaciones = new Cliente[numPisos][numHab];
    }

    public String muestraPantalla(){
        String str = "";
        for(int i = 0; i < this.numPisos; i++){
            for(int j = 0; j< this.numHab; j++){
                if(this.habitaciones[i][j] == null){
                    str += " L ";
                }else str += " R ";
            }
            str += "\n";
        }
        return str;
    }

    public int [] encuentraHab(int tipo){
        int [] coordenadas = new int [2];

        if(tipo == 1) búsquedaHab(0,5,coordenadas);
        else if (tipo == 2) búsquedaHab(5,7,coordenadas);
        else if (tipo == 3) búsquedaHab(7,8,coordenadas);
        return coordenadas;
    }

    public int [] búsquedaHab(int indInf, int indSup, int [] coordenadas){
        for(int i = indInf; i < indSup; i++){
            for(int j = 0; j < numHab; j++){
                if(this.habitaciones[i][j] == null){
                    coordenadas[0] = i;
                    coordenadas[1] = j;
                    return coordenadas;
                }
            }
        }
        return new int[]{-1, -1};       //Devuelve -1,-1 si no hay hueco en la zona del hotel requerida
    }

    public void almacenaReserva(int [] coordenadas, String nombre, String apellidos, int dni, int teléfono, int numTarjeta, String alta, String baja, String régimen){
        habitaciones[coordenadas[0]][coordenadas[1]].setNombre(nombre);
        habitaciones[coordenadas[0]][coordenadas[1]].setBaja(baja);
        habitaciones[coordenadas[0]][coordenadas[1]].setAlta(alta);
        habitaciones[coordenadas[0]][coordenadas[1]].setApellidos(apellidos);
        habitaciones[coordenadas[0]][coordenadas[1]].setTeléfono(teléfono);
        habitaciones[coordenadas[0]][coordenadas[1]].setRégimen(régimen);
        habitaciones[coordenadas[0]][coordenadas[1]].setNumTarjeta(numTarjeta);
        habitaciones[coordenadas[0]][coordenadas[1]].setDni(dni);
    }

    public void anulaReserva(int [] coordenadas){
        habitaciones[coordenadas[0]][coordenadas[1]]=null;
    }
}

