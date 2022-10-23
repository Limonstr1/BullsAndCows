import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MainGame {
    public void playGame() throws IOException {
        String gameRepeat = "y";
        long gameNumber;

        while (gameRepeat.equals("y")){
            //Создаем экземпляры ридера и райтера для каждой игры, т.к. в конце они должны быть закрыты
            FileWriter fileWriter = new FileWriter("result.txt", true);
            FileReader fileReader = new FileReader("result.txt");
            GameReaderWriter gameReaderWriter = new GameReaderWriter(fileReader,fileWriter);

            //Считываем количество игр и прибавляем 1
            gameNumber = gameReaderWriter.CountGames();
            ++gameNumber;

            //компьютер загадывает число
            Generator generator = new Generator();
            List<Integer> generatedNumber = generator.generateNewNumber();

            System.out.println("Загадано четырехзначное число. Попробуйте угадать его");
            System.out.println("З.ы. это число (нужно для отладки) " + generatedNumber.toString());

            //Записываем начало новой игры в файл
            gameReaderWriter.writeGameTitle(generatedNumber, gameNumber);

            //Начинаем новую игру и записываем ее в файл
            StartGame startGame = new StartGame(generatedNumber, fileWriter);
            startGame.writeGame();

            //Спрашиваем пользователя, хочет ли он сыграть еще
            gameRepeat = startGame.askAboutRepeat();

            //Закрываем райтер
            fileWriter.flush();
            fileWriter.close();
        }
    }
}
