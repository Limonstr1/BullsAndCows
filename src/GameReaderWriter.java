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

    public long CountGames() throws IOException {
        Scanner fileScanner = new Scanner(internalFileReader);
        LineNumberReader lineNumberReader = new LineNumberReader(internalFileReader);
        long gameNumber = fileScanner.findAll("Game №").count();
        return gameNumber;
    }

    public void writeGameTitle(List<Integer> generatedNumber, long gameNumber) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        String dateTimeNow = LocalDateTime.now().format(formatter);
        String numberForWrite = "";
        for (int number:generatedNumber) {
            numberForWrite += Integer.toString(number);
        }
        internalFileWriter.write("Game №" + gameNumber + " " + dateTimeNow +
                " загаданное число " + numberForWrite +"\n");

    }


}
