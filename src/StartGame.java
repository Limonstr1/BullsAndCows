import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StartGame {
    private List<Integer> computerNumber;
    private NumberCheck numberCheck = new NumberCheck();
    private FileWriter internalFileWriter;
    public StartGame(List<Integer> generatedNumber, FileWriter fileWriter) {

        computerNumber = generatedNumber;
        internalFileWriter = fileWriter;
    }

    private String getGameResult(String userNumber) {
        List<Integer> userNumberList = new ArrayList<Integer>();

        for (int i = 0; i < 4; i++) {
            char charDigit = userNumber.charAt(i);
            int intDigit = Character.digit(charDigit, 10);
            userNumberList.add(intDigit);
        }

        String checkResult = numberCheck.getCheckResult(computerNumber, userNumberList);
        return checkResult;
    }

    public void writeGame() throws IOException {
        int attemptsNumber = 0;
        Words words = new Words();
        while (true) {
            UserInput userInput = new UserInput();
            String userNumber = userInput.getUserInput();
            String checkResult = getGameResult(userNumber);
            System.out.println(checkResult);
            internalFileWriter.write("Попытка " + userNumber + "\n");
            ++attemptsNumber;

            if (checkResult.equals("4 быка, 0 коров")) {
                System.out.println("Поздравляем! Вы отгадали число!");
                String attemptsWord = words.getAttemptWord(attemptsNumber);
                {internalFileWriter.write("Число было угадано с " + attemptsNumber + " " + attemptsWord + "\n");
                    break;}
            } else {
                System.out.println("Попробуйте еще раз");
            }
        }
    }

    public String askAboutRepeat() {
        String answer = null;
        while (true) {
            System.out.print("Хотите сыграть еще раз? (y/n) ");
            Scanner lineScanner = new Scanner(System.in);
            answer = lineScanner.nextLine();
            if (answer.equals("y")||answer.equals("n"))
            {break;}
            System.out.print("Введен некорректный ответ. ");
        }
        return answer;
    }


}
