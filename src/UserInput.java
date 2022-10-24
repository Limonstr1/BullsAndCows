import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInput {

    /**
     * Принимает введенное пользователем число
     * @return Введенное пользователем число
     */
    public String getUserInput() {
        List<Integer> userNumberList = new ArrayList<>();
        String input = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите число из 4 цифр: ");
            input = scanner.nextLine();
            if (input.length() != 4) {
                System.out.println("Введено некорректное количество цифр");
            } else break;
        }
        return input;
    }
}
