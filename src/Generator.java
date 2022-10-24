import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {
    /**
     * Генерирует случайное число из 4 чисел, причем первой цифрой может быть ноль
     * @return Сгенерированное число в виде целочисленного списка
     */
    public List<Integer> generateNewNumber() {
        List<Integer> numberList = new ArrayList<Integer>();
        Random random = new Random();
        while (numberList.size()<4) {
            int a = random.nextInt(10);
            if (!numberList.contains(a)) {
                numberList.add(a);
            }
        }
        return numberList;
    }
}
