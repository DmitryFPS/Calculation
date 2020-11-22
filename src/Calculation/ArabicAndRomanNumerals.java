package Calculation;

import java.util.ArrayList;
import java.util.Arrays;

public class ArabicAndRomanNumerals {

    public static ArrayList<String> arabicAndRoman() {
        ArrayList<String> listCalkMass = SortNumbers.sortNum(); // Отсортированный массив.
        ArrayList<String> listTemp = null;

        if (listCalkMass.size() > 1) {
            listTemp = new ArrayList<>(); // Итог на выход.
            String[] rimMass = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"}; // Массив Римских цифр.
            ArrayList<String> listRimMass = new ArrayList<>(Arrays.asList(rimMass)); // Список Римских цифр.

            String xNum;
            String yNum;

            // Определяем чем является число X.
                String simMassX = listCalkMass.get(0);
                boolean v = listRimMass.contains(simMassX);
                if (v) {
                    xNum = "R";
                } else xNum = "A";

            // Определяем чем является число Y.
                String simMassY = listCalkMass.get(1);
                boolean w = listRimMass.contains(simMassY);
                if (w) {
                    yNum = "R";
                } else yNum = "A";

            // Временно Римским цифрам присваиваем Арабские, для расчета.
            if (xNum.equals("R") && yNum.equals("R")) {
                listTemp.add("R");
                for (String calkMass : listCalkMass) {            // Исправил на фор ич
                    switch (calkMass) {
                        case "I":
                            listTemp.add("1");
                            break;
                        case "II":
                            listTemp.add("2");
                            break;
                        case "III":
                            listTemp.add("3");
                            break;
                        case "IV":
                            listTemp.add("4");
                            break;
                        case "V":
                            listTemp.add("5");
                            break;
                        case "VI":
                            listTemp.add("6");
                            break;
                        case "VII":
                            listTemp.add("7");
                            break;
                        case "VIII":
                            listTemp.add("8");
                            break;
                        case "IX":
                            listTemp.add("9");
                            break;
                        case "X":
                            listTemp.add("10");
                            break;
                    }
                }
                listTemp.add(listCalkMass.get(2));

                // Если на входе числа Арабские то записываем их в список.
            } else if (xNum.equals("A") && yNum.equals("A")) {
                listTemp.add("A");
                listTemp.add(listCalkMass.get(0));
                listTemp.add(listCalkMass.get(1));
                listTemp.add(listCalkMass.get(2));
            } else listTemp.add("Неверное сочетание символов");
            listCalkMass.clear();
            listRimMass.clear();
        }

        if (listTemp == null){
        return listCalkMass;
        } return listTemp;
    }
}
