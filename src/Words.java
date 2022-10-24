public class Words {

    /**
     * Возвращает слово Попыток в корректной форме для заданного количества
     * @param attemptsNumber Количество попыток
     * @return Форма слова Попыток в корректной форме
     */
    public String getAttemptWord (int attemptsNumber) {
        String word = "попыток";
        if ((attemptsNumber%100) == 11) {
            return word;
        } else if ((attemptsNumber % 10) == 1) {
            word = "попытки";
            return word;
        } else {
            return word;
        }
    }

}
