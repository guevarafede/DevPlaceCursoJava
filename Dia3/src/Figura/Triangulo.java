package Figura;

public class Triangulo extends Figura {
    private int lado1;
    private int lado2;
    private int lado3;
    private int base;
    private double altura;

    public Triangulo(int lado1, int lado2, int lado3, int base, double altura) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
        this.base = base;
        this.altura = altura;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return (this.base * this.altura)/2;
    }

    @Override
    public double calcularPerimetro() {
        return (this.lado1 + this.lado2 + this.lado3);
    }
}
