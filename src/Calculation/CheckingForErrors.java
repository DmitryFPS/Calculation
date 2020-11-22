package Calculation;
import java.util.ArrayList;
import java.util.Arrays;

public class CheckingForErrors {

    public static ArrayList<String> checkingForErr() {
        ArrayList<String> numErr = (ReaderNum.readNum()); // Список символов, которые ввел пользователь.
        ArrayList<String> errors = new ArrayList<>();

        if (numErr.size() != 0) {
            String[] temp = {"+", "-", "*", "/"}; // Массив математических операторов, допущенных к использованию в ПО.
            String[] tempAll = {"+", "-", "*", "/", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "I", "II", "III", "IV",
                    "V", "VI", "VII", "VIII", "IX", "X"}; // Массив символов, допущенных к использованию в ПО.
            ArrayList<String> listMass = new ArrayList<>(Arrays.asList(temp)); // Список математических операторов допущенных к использованию в ПО.
            ArrayList<String> listMassAll = new ArrayList<>(Arrays.asList(tempAll)); // Список из Массива, допущенных символов.

            // Проверка на первое значение (Отрицательное или нет)
            if (numErr.get(0).equals("-")) {
                errors.add("Вы ввели отрицательное число");
                numErr.clear();
            }

            // Проверяем какие символы ввел пользователь.
            for (int i = 0; i < numErr.size(); i++) {
                String stringTemp = numErr.get(i);
                boolean v = listMassAll.contains(stringTemp);
                if (!v) {
                    errors.add("Недопустимое сочетание символов");
                    numErr.clear();
                }
            }

            // Проверка на количество математических операторов (Если больше одного, то при вводе была допущена ошибка).
            if (errors.size() == 0) {
                int count = 0;
                if (numErr.size() != 0) {
                    for (String stringTemp : numErr) {                                           // Исправил на фор ич!!!
                        boolean v = listMass.contains(stringTemp);
                        if (v) {
                            count++;
                        }
                    }
                }
                if (count != 1) {
                    errors.add("Ошибка при вводе математического оператора");
                    numErr.clear();
                }
            }

            // Очищаем Массивы и списки, объявляем их ссылки null для сборщика мусора.
            listMass.clear();
            listMassAll.clear();
        }
        if (errors.size() != 0){
            return errors;
        } else return numErr;
    }
}
