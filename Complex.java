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
        if (img > 0) {
            return "(" + real + " + " + img + "i)";
        } else {
            return "(" + real + " - " + Math.abs(img) + "i)";
        }

    }

    /* Parte de Pablo Lopez Chavez */
    /* Division / Conjugate */
    public Complex Division(Complex y) {
        double denominador = Math.pow(y.real, 2) + Math.pow(y.img, 2);
        if (denominador == 0) {
            throw new Error("Division por cero");
        }
        double newReal = (this.real * y.real + this.img * y.img) / denominador;
        double newImg = (this.img * y.real - this.real * y.img) / denominador;
        return new Complex(newReal, newImg);
    }

    public Complex Conjugate(Complex y) {
        return new Complex(y.real, -y.img);
    }
    /* Parte de Bruno Monzon */
    /* Module / SquareRoot */
    public Complex module() {
        double r = Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.img, 2));
        return new Complex(r, 0);
    }

    public Complex squareRoot() {
        double r = Math.sqrt(Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.img, 2)));
        double theta = Math.atan2(this.img, this.real);
        double newReal = r * Math.cos(theta / 2);
        double newImg = r * Math.sin(theta / 2);
        return new Complex(newReal, newImg);
    }

    /* Parte de Jhamil Rejas */
    /* Phase / ToComplex */
    public double phase() {
        return Math.atan2(this.img, this.real);
    }

    public static Complex toComplex(String cpx) {
        String[] parts = cpx.split("\\+");
        if (parts.length != 2) {
            parts = cpx.split("-");
            if (parts.length != 2) {
                throw new IllegalArgumentException("Formato de numero complejo incorrecto");
            }
            parts[1] = "-" + parts[1];
        }
        double real = Double.parseDouble(parts[0]);
        double img = Double.parseDouble(parts[1].replace("i", ""));
        return new Complex(real, img);
    }

    /* Parte de Daniel Arancibia */
    /* Power / Logarithm */
    public Complex power(int n) {
        double r = Math.pow(Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.img, 2)), n);
        double theta = Math.atan2(this.img, this.real);
        double newReal = r * Math.cos(n * theta);
        double newImg = r * Math.sin(n * theta);
        return new Complex(newReal, newImg);
    }

    public Complex logarithm() {
        double r = Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.img, 2));
        double theta = Math.atan2(this.img, this.real);
        double newReal = Math.log(r);
        double newImg = theta;
        return new Complex(newReal, newImg);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa el primer numero real:");
        double real1 = scanner.nextDouble();
        System.out.println("Ingresa el primer numero imaginario:");
        double imag1 = scanner.nextDouble();

        System.out.println("Ingresa el segundo numero real:");
        double real2 = scanner.nextDouble();
        System.out.println("Ingresa el segundo numero imaginario:");
        double imag2 = scanner.nextDouble();
        System.out.println("Ingresa la potencia a elevar:");
        Integer pot = scanner.nextInt();

        Complex num1 = new Complex(real1, imag1);
        Complex num2 = new Complex(real2, imag2);

        /* Agregar el codigo para usar y mostrar la función */

        Complex addition = num1.addition(num2);
        Complex subtraction = num1.subtraction(num2);
        Complex multiplication = num1.multiplication(num2);
        /* Parte de Pablo Lopez Chavez */
        Complex ConjugateNum1 = num1.Conjugate(num1);
        Complex ConjugateNum2 = num2.Conjugate(num2);
        Complex Division = num1.Division(num2);
        /* Parte de Daniel Arancibia */
        Complex powerNum1 = num1.power(pot);
        Complex logarithmNum1 = num1.logarithm();
        Complex powerNum2 = num2.power(pot);
        Complex logarithmNum2 = num2.logarithm();
        /* Parte de Bruno Monzon */
        Complex moduleNum1 = num1.module();
        Complex moduleNum2 = num2.module();
        Complex squareRootNum1 = num1.squareRoot();
        Complex squareRootNum2 = num2.squareRoot();

        System.out.println("suma: " + addition.toString());
        System.out.println("resta: " + subtraction.toString());
        System.out.println("Multiplicacion: " + multiplication.toString());
        /* Parte de Pablo Lopez Chavez */
        System.out.println("Conjugado del numero 1: " + ConjugateNum1.toString());
        System.out.println("Conjugado del numero 2: " + ConjugateNum2.toString());
        System.out.println("Division: " + Division.toString());
        /* Parte de Daniel Arancibia */
        System.out.println("Potencia Num1: " + powerNum1.toString());
        System.out.println("Logaritmo Num1: " + logarithmNum1.toString());
        System.out.println("Potencia Num2: " + powerNum2.toString());
        System.out.println("Logaritmo Num2: " + logarithmNum2.toString());
        /* Parte de Bruno Monzon */
        System.out.println("Modulo Num1: " + moduleNum1.toString());
        System.out.println("Modulo Num2: " + moduleNum2.toString());
        System.out.println("Raiz Cuadrada Num1: " + squareRootNum1.toString());
        System.out.println("Raiz Cuadrada Num2: " + squareRootNum2.toString());
        scanner.close();
    }
}
