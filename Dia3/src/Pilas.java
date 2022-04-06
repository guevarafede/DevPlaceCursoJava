import java.util.EmptyStackException;
public class Pilas {
    private int size;
    private Object[] array;
    private int tope =-1;

    //CONSTRUCTOR
    public Pilas(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("La capacidad");
        }
        this.size=size;
        array = new Object[size];
    }

    public int getSize() {
        return this.size;
    }

    //INSERTAR UN ELEMENTO
    public void push(Object obj){
        array[++this.tope] = obj;
    }

    //VER SI LA PILA ESTA VACIA
    public boolean Empty(){
        return this.tope < 0;
    }

    //QUITAR ELEMENTO
    public void top(){
        System.out.println(array[this.tope--]);
    }

    //VER SI LA PILA ESTA LLENA
    public boolean Full(){
        return (this.tope == size);
    }



}
