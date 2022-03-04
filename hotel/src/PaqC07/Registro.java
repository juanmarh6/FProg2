package PaqC07;

import java.io.Serializable;
import java.util.Arrays;

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
        /*En esta parte, si no pones el coordenadas = búsqeudaHab las coordenadas no van a cambiar, antes lo hacían porque si una habitación estaba libre
        *en el == null, retornabas el int coordenadas y, para eso, las modificabas antes. En realidad daba igual lo que retornaras, pero las coordenadas
        * se modificaban correctamente porque al pasar el array como parámetro le pasas la dirección a memoria, y todos los cambios se van a hacer a esa memoria.
        * Si no encontraba habitaciones, no iba a devolver nada y las coordenadas serían 0,0.
        */
        if(tipo == 1) coordenadas = búsquedaHab(0,5,coordenadas);
        else if (tipo == 2) coordenadas = búsquedaHab(5,7,coordenadas);
        else if (tipo == 3) coordenadas =  búsquedaHab(7,8,coordenadas);
        return coordenadas;
    }

    public int [] búsquedaHab(int indInf, int indSup, int [] coordenadas){
        for(int i = indInf; i < indSup; i++){
            for(int j = 0; j < numHab; j++){
                if(this.habitaciones[i][j] == null){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
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



