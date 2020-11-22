package Calculation;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeral {

    public static String rNum(int x){

        //---------------------------------------------------------------------------------

        // Получаем ответ в Арабском значении. Переводим число в Строку и делим его если оно двоичное или троичное и
        // записываем в массив как число.
        String num = String.valueOf(x);
        String[] numString = num.trim().replaceAll("\\s+", "").split("");
        int[] numInt = new int[numString.length];
        String[] numRom = new String[numInt.length];
        for (int i = 0; i < numInt.length; i++) {
                String z = numString[i];
                if (!z.equals("-")) {
                    numInt[i] = Integer.parseInt(z);
                }
        }

        // Создаем карту и ключу присваиваем Арабское число, а значению присваиваем Римском исполнении.
        Map<Integer, String> mapRomanNumber = new HashMap<>();
        mapRomanNumber.put(0, "-");
        mapRomanNumber.put(1, "I");
        mapRomanNumber.put(2, "II");
        mapRomanNumber.put(3, "III");
        mapRomanNumber.put(4, "IV");
        mapRomanNumber.put(5, "V");
        mapRomanNumber.put(6, "VI");
        mapRomanNumber.put(7, "VII");
        mapRomanNumber.put(8, "VIII");
        mapRomanNumber.put(9, "IX");

        mapRomanNumber.put(10, "X");
        mapRomanNumber.put(20, "XX");
        mapRomanNumber.put(30, "XXX");
        mapRomanNumber.put(40, "XL");
        mapRomanNumber.put(50, "L");
        mapRomanNumber.put(60, "LX");
        mapRomanNumber.put(70, "LXX");
        mapRomanNumber.put(80, "LXXX");
        mapRomanNumber.put(90, "XC");
        mapRomanNumber.put(100, "C");

        // Определяем какое число, двоичное или троичное.
        if (numInt.length == 3){
            numInt[0] = numInt[0] * 100;
            numInt[1] = numInt[1] * 10;
        } else if (numInt.length == 2){
            numInt[0] = numInt[0] * 10;
        }

        Integer key;
        String volume;
        int i = 0;
        int numMap;

            // Переводим Арабское число в Римское.
        while (numInt.length > i) {
            for (Map.Entry<Integer, String> pair : mapRomanNumber.entrySet()) {        //while исправил на фор ич!!!
                key = pair.getKey();
                volume = pair.getValue();
                numMap = numInt[i];
                if (numMap == key) {
                    numRom[i] = volume;
                    i++;
                    break;
                }
            }
        }

        // Убираем лишние символы.
        if (numInt.length == 3){
            for (int j = 1; j < numRom.length; j++) {
                String z = numRom[j];
                if (z.equals("-")){
                    numRom[j] = "";
                }
            }
        }

        StringBuilder sRoman = new StringBuilder();
        for (String s : numRom){
            sRoman.append(s);
        }

        return sRoman.toString();
    }
}
