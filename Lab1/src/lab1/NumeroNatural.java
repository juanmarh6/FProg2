package lab1;

public class NumeroNatural {
    int numero;


    public void setNumero(int n){
        if(n>=0)
            this.numero=n;
        else
            System.out.println("El numero debe ser mayor o igual que 0.");
    }

    public int getNumero(){
        return numero;
    }

    public void incrementar(){
        numero++;
    }

    public void decrementar(){
        if(numero>0)
            numero--;
        else
            System.out.println("El numero no puede ser menor que 0.");
    }

    public boolean esPar(){
        if(numero%2==0)
            return true;
        else
            return false;
    }

    public boolean esPrimo(){
        for(int i=2;i<=((int)Math.sqrt(numero));i++){
            if(numero%i==0)
                return false;
        }
        return true;
    }


    public boolean esPerfecto(){
        int suma=0;
        for(int i=1;i<numero;i++){
            if(numero%i==0)
                suma+=i;
        }
        if(suma==numero)
            return true;
        else
            return false;
    }

    public int pow(int n){
        int salida=numero;
        for(int i=0;i<n-1;i++){
            salida=salida*numero;
        }
        return salida;
    }

    public double half(){
        return ((double)numero/2);
    }

    public NumeroNatural distancia(NumeroNatural numero2){
        NumeroNatural salida = new NumeroNatural();
        salida.numero = Math.abs(this.numero-numero2.numero);
        return salida;
    }

    public void syncToMinor(NumeroNatural numero2){
        if(this.numero>numero2.numero)
            this.numero=numero2.numero;
        else
            numero2.numero=this.numero;
    }

    private int digitosNumero(int num){
        int digitos=0;
        do{
            num=num/10;
            digitos++;
        }while (num>0);
        return digitos;
    }

    public boolean esFeliz(){
        double auxiliar=this.numero;
        double suma;
        int digitos;
        do{
            suma=0;
            digitos = digitosNumero((int)auxiliar);
            for(int k=1;k<digitos+1;k++){
                suma += Math.pow((auxiliar%10),2);
                auxiliar=(int)auxiliar/10;
            }
            auxiliar=suma;
        }while (suma!=4 && suma!=1);
        if(suma==4)
            return false;
        else
            return true;
    }


}

