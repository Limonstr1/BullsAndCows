import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MainGame {

    /**
     * Запускает игру
     * @throws IOException
     */
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

            System.out.println( (char)27 + "[33m" + "Добро пожаловать в игру Быки и Коровы\n" +
                    "Краткая инструкция: Необходимо отгадать загаданное число,\n" +
                    "вводя свой вариант в виде четырех цифр без пробелов. После ввода нужно нажать Enter.\n" +
                    "Если цифра в введенном числе есть в загаданном и их места совпадают, то это 1 бык.\n" +
                    "Если таких цифр две, то это 2 быка и т.д.\n" +
                    "Если цифра в веденном числе есть в загаданном, но их места не совпадают, то это 1 корова.\n" +
                    "Если таких цифр две, то это 2 коровы и т.д.\n" +
                    "Например, загаданное число 0123, введенное 0245. Совпадает 0 и их места совпадают - это 1 бык,\n" +
                    "совпадает 2, но их места не совпадают - это 1 корова. Остальные цифры не совпадают.\n" +
                    "Итак, начинаем! \n");
            System.out.println((char)27 + "[0m" + "Загадано четырехзначное число. Попробуйте угадать его");
            System.out.println("З.ы. это число (нужно для отладки) " + generatedNumber.toString());

            //Записываем начало новой игры в файл
            gameReaderWriter.writeGameTitle(generatedNumber, gameNumber);

            //Начинаем новую игру и записываем ее в файл
            StartGame startGame = new StartGame(generatedNumber, fileWriter);
            startGame.playSingleGame();

            //Спрашиваем пользователя, хочет ли он сыграть еще
            gameRepeat = startGame.askAboutRepeat();

            //Закрываем райтер
            fileWriter.flush();
            fileWriter.close();
        }
    }
}
