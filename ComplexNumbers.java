import java.util.Scanner;

public class Complex {
    private double real;
    private double img;

    public Complex(double real, double img) {
        this.real = real;
        this.img = img;
    }

    public Complex addition(Complex y) {
        return new Complex(this.real + y.real, this.img + y.img);
    }

    public Complex subtraction(Complex y) {
        return new Complex(this.real - y.real, this.img - y.img);
    }

    public Complex multiplication(Complex y) {
        double newReal = this.real * y.real - this.img * y.img;
        double newimg = this.real * y.img + this.img * y.real;
        return new Complex(newReal, newimg);
    }

    @Override
    public String toString() {
        return "(" + real + " + " + img + "i)";
    }
    /*  */
    
}
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa el primer numero real:");
        double real1 = scanner.nextDouble();
        System.out.println("Ingresa el primer numero imaginario:");
        double imag1 = scanner.nextDouble();

        System.out.println("Ingresa el primer numero imaginario:");
        double real2 = scanner.nextDouble();
        System.out.println("Ingresa el segundo numero imaginario:");
        double imag2 = scanner.nextDouble();

        Complex num1 = new Complex(real1, imag1);
        Complex num2 = new Complex(real2, imag2);

        Complex addition = num1.addition(num2);
        Complex subtraction = num1.subtraction(num2);
        Complex multiplication = num1.multiplication(num2);

        System.out.println("Operacion con numeros complejos:");
        System.out.println("Arancibia Aguilar Daniel Andree");
        System.out.println("Laboratorio 2 Ing Software");

        System.out.println("suma: " + addition.toString());
        System.out.println("resta: " + subtraction.toString());
        System.out.println("Multiplicacion: " + multiplication.toString());

        scanner.close();
    }