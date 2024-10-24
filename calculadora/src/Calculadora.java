import java.util.ArrayList;
import java.util.Scanner;

public class Calculadora {

    private ArrayList<String> historial;

    public Calculadora() {
        historial = new ArrayList<>();
    }

    public int sumar(int a, int b) {
        int resultado = a + b;
        historial.add("Suma: " + a + " + " + b + " = " + resultado);
        return resultado;
    }

    public int restar(int a, int b) {
        int resultado = a - b;
        historial.add("Resta: " + a + " - " + b + " = " + resultado);
        return resultado;
    }

    public int multiplicar(int a, int b) {
        int resultado = a * b;
        historial.add("Multiplicación: " + a + " * " + b + " = " + resultado);
        return resultado;
    }

    public double dividir(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir por cero.");
        }
        double resultado = (double) a / b;
        historial.add("División: " + a + " / " + b + " = " + resultado);
        return resultado;
    }

    public double potencia(int base, int exponente) throws IllegalArgumentException {
        if (exponente < 0) {
            throw new IllegalArgumentException("El exponente no puede ser negativo.");
        }
        double resultado = Math.pow(base, exponente);
        historial.add("Potencia: " + base + " ^ " + exponente + " = " + resultado);
        return resultado;
    }

    public ArrayList<String> verHistorial() {
        return historial;
    }

    public void limpiarHistorial() {
        historial.clear();
        System.out.println("El historial ha sido limpiado.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculadora calculadora = new Calculadora();

        boolean salir = false;

        while (!salir) {
            System.out.println("=== Calculadora Avanzada ===");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Potencia");
            System.out.println("6. Ver historial");
            System.out.println("7. Limpiar historial");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el primer número: ");
                    int a = scanner.nextInt();
                    System.out.print("Ingrese el segundo número: ");
                    int b = scanner.nextInt();
                    System.out.println("Resultado: " + calculadora.sumar(a, b));
                    break;
                case 2:
                    System.out.print("Ingrese el primer número: ");
                    a = scanner.nextInt();
                    System.out.print("Ingrese el segundo número: ");
                    b = scanner.nextInt();
                    System.out.println("Resultado: " + calculadora.restar(a, b));
                    break;
                case 3:
                    System.out.print("Ingrese el primer número: ");
                    a = scanner.nextInt();
                    System.out.print("Ingrese el segundo número: ");
                    b = scanner.nextInt();
                    System.out.println("Resultado: " + calculadora.multiplicar(a, b));
                    break;
                case 4:
                    System.out.print("Ingrese el primer número: ");
                    a = scanner.nextInt();
                    System.out.print("Ingrese el segundo número: ");
                    b = scanner.nextInt();
                    try {
                        System.out.println("Resultado: " + calculadora.dividir(a, b));
                    } catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.print("Ingrese la base: ");
                    int base = scanner.nextInt();
                    System.out.print("Ingrese el exponente: ");
                    int exponente = scanner.nextInt();
                    try {
                        System.out.println("Resultado: " + calculadora.potencia(base, exponente));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("Historial de operaciones:");
                    for (String operacion : calculadora.verHistorial()) {
                        System.out.println(operacion);
                    }
                    break;
                case 7:
                    calculadora.limpiarHistorial();
                    break;
                case 8:
                    salir = true;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }

        scanner.close();
    }
}
