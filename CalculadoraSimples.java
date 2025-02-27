import java.util.Scanner;

class Calculator {
    private double num1;
    private double num2;

    public Calculator(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public double sum() {
        return num1 + num2;
    }

    public double subtract() {
        return num1 - num2;
    }

    public double multiply() {
        return num1 * num2;
    }

    public double divide() {
        if (num2 == 0) {
            System.out.println("Erro: Não é possível dividir por zero.");
            return 0;
        }
        return num1 / num2;
    }
}

public class CalculadoraSimples {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite o primeiro número: ");
            double num1 = scanner.nextDouble();

            System.out.print("Digite o segundo número: ");
            double num2 = scanner.nextDouble();

            Calculator calc = new Calculator(num1, num2);

            System.out.println("\nResultados:");
            System.out.println("Soma: " + calc.sum() + " ➕");
            System.out.println("Subtração: " + calc.subtract() + " ➖");
            System.out.println("Multiplicação: " + calc.multiply() + " ✖️");
            System.out.println("Divisão: " + calc.divide() + " ➗");
        }
    }
}
