public class Main {

    public static void main(String[] args) {
        int capacidad = 5;
        Pilas pila = new Pilas(capacidad);

        Object objeto = new Object();

        //Insertar un objeto en la pila (push).
        while (!pila.Full()) {
            pila.push(objeto);
        }

        //Recuperar un objeto de la pila (pop).


        //Obtener el objeto de la cima (top) de la pila, sin extraerlo.
        if (!pila.Empty()){
            pila.top();
        }

        //Averiguar si hay algún objeto almacenado en la pila.
        if (pila.Empty()){
            System.out.println("LA PILA ESTA VACIA.");
        }

        //Devolver el número de objetos almacenados en la pila.


        //EJERCICIOS RECURSIVIDAD
        int validos = 3;
        int[] enteros = new int[validos];
        enteros[0] = 5;
        enteros[1] = 2;
        enteros[2] = 9;

        //Ejercicio Recursividad 1
        System.out.println("Las suma de los enteros del arreglos es = " + sumaRecursiva(enteros, validos,0));

        //Ejercicio Recursividad 2
        System.out.println("Muestro arreglo invertido:\n");
        muestraArregloInvertido(enteros, validos,0);

    }

    /** Crear un programa que sume los elementos de una lista de enteros recursivamente.*/
    public static int sumaRecursiva(int[] enteros, int validos, int ini){
        int rta = 0;
        if (ini == validos){
            rta = 0;
        }else{
            rta = enteros[ini] + sumaRecursiva(enteros, validos, ini+1);
        }
        return rta;
    }

    /**Construir una función que imprima los elementos de una lista enlazada de enteros en orden inverso a partir de
     * una posición p */
    public static void muestraArregloInvertido(int[] enteros, int validos, int ini){
        if (ini == validos-1){
            System.out.println(enteros[ini]);
        }else{
            muestraArregloInvertido(enteros, validos, ini+1);
            System.out.println(enteros[ini]);
        }

    }


}
