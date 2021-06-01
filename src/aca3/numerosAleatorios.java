
package aca3;

/**
 *
 * @author Sergio Antonio Trujillo
 */
public class numerosAleatorios {
    
    /**
     * Atributos
     */
    private final Integer[][] cuadroNumeros;
    private int menorDiez, menorVeinte, mayorVeinte;
    
    public numerosAleatorios() {
        this.cuadroNumeros = new Integer[6][6];
        this.menorDiez = 0;
        this.menorVeinte = 0;
        this.mayorVeinte = 0;
    }
    
    
    /**
     * Metodo que otorga un número aleatorio entre 1 y 100
     * @return numero
     */
    public int numero(){
        int numero = (int)(Math.random() *100+1);
        return numero;
    }
    
    /**
     * Metodo para darle valores aleatorios a la matriz de numeros
     */
    public void valoresAleatorios() {
        for (Integer[] numeros : this.cuadroNumeros) {
            for (int j = 0; j < numeros.length; j++) {
                numeros[j] = numero();
            }
        }        
    }
    
    /**
     * Metodo para contar los numeros que tiene la matriz
     */
    public void validarNumeros() {
        for (Integer[] numeros : this.cuadroNumeros) {
            for (int j = 0; j < numeros.length; j++) {
                if (numeros[j] <= 10){
                    this.menorDiez += 1;                    
                }
                if (numeros[j] >= 11 && numeros[j] <=20 ){
                    this.menorVeinte += 1;                    
                }
                if (numeros[j] > 20) {
                    this.mayorVeinte += 1;                    
                }
            }
        }        
    }
    
    /**
     * Metodo para mostrar la matriz de numeros
     * @return 
     */
    public String mostrarValores() {
        String valores = "";
        for (Integer[] numeros : this.cuadroNumeros) {
            for (Integer numero : numeros) {
                valores += numero + "   ";
            }
            valores += "\n\n";
        }
        return valores;
    }

    public Integer[][] getCuadroNumeros() {
        return cuadroNumeros;
    }

    public int getMenorDiez() {
        return menorDiez;
    }

    public int getMenorVeinte() {
        return menorVeinte;
    }

    public int getMayorVeinte() {
        return mayorVeinte;
    }

    public void setMenorDiez(int menorDiez) {
        this.menorDiez = menorDiez;
    }

    public void setMenorVeinte(int menorVeinte) {
        this.menorVeinte = menorVeinte;
    }

    public void setMayorVeinte(int mayorVeinte) {
        this.mayorVeinte = mayorVeinte;
    }
    
    
    
}
