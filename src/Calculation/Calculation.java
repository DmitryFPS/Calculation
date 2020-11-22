package Calculation;
import java.util.ArrayList;

public class Calculation {

    public static String decision() {

        ArrayList<String> decisionNum = ArabicAndRomanNumerals.arabicAndRoman();
        String answerError = "";
        int answer = 0;

        if (decisionNum.size() > 1) {

            String m = decisionNum.get(3);
            int x = Integer.parseInt(decisionNum.get(1));
            int y = Integer.parseInt(decisionNum.get(2));

            // Вычисление.
            if ((x >= 1 && x <= 10) && (y >= 1 && y <= 10)) {
                switch (m) {
                    case "+":
                        answer = x + y;
                        break;
                    case "-":
                        answer = x - y;
                        break;
                    case "*":
                        answer = x * y;
                        break;
                    case "/":
                        try {
                            answer = x / y;
                        } catch (ArithmeticException e) {
                            e.getStackTrace();
                        }
                        break;
                }
            } else answerError = "Допустимый диапазон чисел от 1 до 10";
        } else answerError = decisionNum.get(0);

        // Определяем какие числа были на входе, Римские или Арабские.
        String answerNum = "";
        if (decisionNum.size() > 1) {
            if (decisionNum.get(0).equals("A")) {
                answerNum = Integer.toString(answer);
            } else answerNum = RomanNumeral.rNum(answer);
        }
        decisionNum.clear();

        if (answerError.length() != 0){
            return answerError;
        }
        return answerNum;
    }
}
