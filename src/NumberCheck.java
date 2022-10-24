import java.util.List;

public class NumberCheck {

    /**
     * Сравнивает введенное пользователем число со сгенерированным числом
     * @param generatedNumber Сгенерированное число
     * @param userNumber Введенное пользователем число
     * @return Результат сравнения в виде игрового шифра с количеством быков и коров
     */
    public String getCheckResult(List<Integer> generatedNumber, List<Integer> userNumber) {
        int bull=0;
        int cow=0;
        String checkResult ="";
        int i = 0;
        String bullWord;
        String cowWord;

        //Сравниваем каждый из элементов списков
        for (int item:userNumber) {

            if (generatedNumber.get(i) == item) {
                ++bull;}
            else if (generatedNumber.contains(item)) {
                ++cow;
            }
            ++i;
        }

        //В зависимости от количества, выбираем корректное использование слов
        if (bull == 0) {bullWord = "быков";} else if (bull == 1) {
           bullWord = "бык";
        } else {bullWord = "быка";}
        if (cow == 0) {cowWord = "коров";} else if (cow == 1) {
            cowWord = "корова";}
        else {cowWord = "коровы";}

        checkResult = bull + " " + bullWord + ", " + cow + " " +cowWord;
        return checkResult;
    }
}
