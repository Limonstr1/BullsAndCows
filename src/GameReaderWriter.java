import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class GameReaderWriter {
    private FileWriter internalFileWriter;
    private FileReader internalFileReader;
    public GameReaderWriter(FileReader fileReader, FileWriter filewriter) throws IOException {
       internalFileWriter = filewriter;
       internalFileReader = fileReader;
    }

    /**
     * Считает количество игр в файле по количеству строчек, содержащих Game №
     * @return Количество сыгранных игр, зафиксированных в файле
     * @throws IOException
     */
    public long CountGames() throws IOException {
        Scanner fileScanner = new Scanner(internalFileReader);
        LineNumberReader lineNumberReader = new LineNumberReader(internalFileReader);
        long gameNumber = fileScanner.findAll("Game №").count();
        return gameNumber;
    }

    /**
     * Записывает заголовок игры в файл
     * @param generatedNumber Сгенерированное число
     * @param gameNumber Номер текущей игры
     * @throws IOException
     */
    public void writeGameTitle(List<Integer> generatedNumber, long gameNumber) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        String dateTimeNow = LocalDateTime.now().format(formatter);
        String numberForWrite = "";
        //Преобразуем сгенерированное число из списка в строку
        for (int number:generatedNumber) {
            numberForWrite += Integer.toString(number);
        }
        internalFileWriter.write("Game №" + gameNumber + " " + dateTimeNow +
                " загаданное число " + numberForWrite +"\n");

    }


}
