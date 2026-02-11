import java.util.List;
import java.util.Scanner;

public class MathOperationsService {

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        List<Character> operations = List.of('+', '-', '*', '/', '%', '^');

        while (true) {

            double firstNumber;
            double secondNumber;
            char operator;

            System.out.println("Podaj liczbę:");
            if (!scanner.hasNextDouble()) {
                System.out.println("Nieprawidłowy format");
                scanner.next();
                continue;
            }
            firstNumber = scanner.nextDouble();

            System.out.println("Jakie działanie chcesz wykonać? +, -, *, /, %, ^");
            operator = scanner.next().charAt(0);

            if (!operations.contains(operator)) {
                System.out.println("Nie ma takiego działania!");
                continue;
            }

            System.out.println("Podaj drugą liczbę:");
            if (!scanner.hasNextDouble()) {
                System.out.println("Nieprawidłowy format");
                scanner.next();
                continue;
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
                        continue;
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
                    continue;
            }

            System.out.println("Wynik: " + result);

            System.out.println("Czy chcesz wykonać kolejną operację? (t/n)");
            char decision = scanner.next().charAt(0);

            if (decision == 'n') {
                System.out.println(((int) result % 2 == 0)
                        ? "Wynik jest parzysty"
                        : "Wynik jest nieparzysty");
                break;
            }
        }
    }
}