import java.util.Scanner;

public class MathOperationsService {

    public static void run() {
        Scanner scanner = new Scanner(System.in);

        double firstNumber;
        double secondNumber;
        char operator;

        System.out.println("Podaj liczbę:");
        if (!scanner.hasNextDouble()) {
            System.out.println("Nieprawidłowy format");
            return;
        }
        firstNumber = scanner.nextDouble();

        System.out.println("Jakie działanie chcesz wykonać? (+, -, *, /, %, ^)");
        operator = scanner.next().charAt(0);

        System.out.println("Podaj drugą liczbę:");
        if (!scanner.hasNextDouble()) {
            System.out.println("Nieprawidłowy format");
            return;
        }
        secondNumber = scanner.nextDouble();

        double result;

        switch (operator) {
            case '+':
                result = firstNumber + secondNumber;
                break;
            case '-':
                result = firstNumber - secondNumber;
                break;
            case '*':
                result = firstNumber * secondNumber;
                break;
            case '/':
                if (secondNumber == 0) {
                    System.out.println("Nie można dzielić przez 0");
                    return;
                }
                result = firstNumber / secondNumber;
                break;
            case '%':
                result = firstNumber % secondNumber;
                break;
            case '^':
                result = Math.pow(firstNumber, secondNumber);
                break;
            default:
                System.out.println("Nieznany operator");
                return;
        }

        System.out.println("Wynik: " + result);

        System.out.println("Czy chcesz wykonać kolejną operację? (t/n)");
        char decision = scanner.next().charAt(0);

        if (decision == 't' || decision == 'T') {
            run();
        } else {

            int modulo = ((int) result) % 2;

            if (modulo == 0) {
                System.out.println("Wynik jest parzysty");
            } else {
                System.out.println("Wynik jest nieparzysty");
            }
        }
    }
}
