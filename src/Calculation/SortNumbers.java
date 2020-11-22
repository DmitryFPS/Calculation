package Calculation;

import java.util.ArrayList;
import java.util.Arrays;

public class SortNumbers {

    public static ArrayList<String> sortNum() {

        ArrayList<String> numStrTemp = CheckingForErrors.checkingForErr();

        if (numStrTemp.size() > 1) {
            String[] tempAllNumbers = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "+", "-", "*", "/"}; // Массив символов.
            ArrayList<String> listAllNumbers = new ArrayList<>(Arrays.asList(tempAllNumbers)); // Список символов.
            ArrayList<String> xNum = new ArrayList<>(); // Первое число Х
            ArrayList<String> sNum = new ArrayList<>(); // Математические оператор (+, -, /, *)
            ArrayList<String> yNum = new ArrayList<>(); // Второе число У

            // Ищем первое значение Х и записываем в первый список
            int count = 0;
            for (String value : numStrTemp) {                              // Исправил на фор ич!!!
                if (!value.equals("+") && !value.equals("-") && !value.equals("*") && !value.equals("/")) {
                    xNum.add(value);
                    count++;
                } else break;
            }

            // Определяем какой математический оператор ввел пользователь и записываем его во второй список
            for (int i = count; i < numStrTemp.size(); i++) {
                if (numStrTemp.get(i).equals("+") || numStrTemp.get(i).equals("-") || numStrTemp.get(i).equals("*") || numStrTemp.get(i).equals("/")) {
                    sNum.add(numStrTemp.get(i));
                    count++;
                } else break;
            }

            // Ищем второе значение У и записываем его в третий список
            for (int i = count; i < numStrTemp.size(); i++) {
                yNum.add(numStrTemp.get(i));
            }

            // Очищаем список, освобождаем память.
            //numStrTemp.clear();
            //numStrTemp = null;

            // Схлопываем числа и распределяем.
            StringBuilder xTemp = new StringBuilder();
            StringBuilder yTemp = new StringBuilder();
            StringBuilder sTemp = new StringBuilder();

            for (String x : xNum) {
                xTemp.append(x);
            }

            for (String y : yNum) {
                yTemp.append(y);
            }

            for (String s : sNum) {
                sTemp.append(s);
            }

            ArrayList<String> listNum = new ArrayList<>(); // Переносим значения в один список.
            listNum.add(xTemp.toString());
            listNum.add(yTemp.toString());
            listNum.add(sTemp.toString());

            //------------------------------------------
            for (int i = 0; i < numStrTemp.size()-1; i++) {
                String listStr = numStrTemp.get(i);

                if (listAllNumbers.contains(listStr)) {
                    String listX = listNum.get(0);
                    String listY = listNum.get(1);
                    if (!listAllNumbers.contains(listX)) {
                        listNum.clear();
                        listNum.add("Допустимый диапазон чисел от 1 до 10");
                        break;
                    }else if (!listAllNumbers.contains(listY)) {
                        listNum.clear();
                        listNum.add("Допустимый диапазон чисел от 1 до 10");
                        break;
                    }
                    //----------------------------------------------------------------------
                }
            }
            //------------------------------------------

            // Очищаем списки.
            numStrTemp.clear();
            listAllNumbers.clear();

            return listNum; // возвращаем список, если он не пуст.
        }
        return numStrTemp; // возвращаем пустой список.
    }
}
