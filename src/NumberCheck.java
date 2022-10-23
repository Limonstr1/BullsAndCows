import java.util.List;

public class NumberCheck {
    public String getCheckResult(List<Integer> generatedNumber, List<Integer> userNumber) {
        int bull=0;
        int cow=0;
        String checkResult ="";
        int i = 0;
        String bullWord;
        String cowWord;
        for (int item:userNumber) {

            if (generatedNumber.get(i) == item) {
                ++bull;}
            else if (generatedNumber.contains(item)) {
                ++cow;
            }
            ++i;
        }

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
