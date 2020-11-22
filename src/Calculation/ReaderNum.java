package Calculation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class ReaderNum {
    public static ArrayList<String> readNum() {

        InputStreamReader isr = null;
        BufferedReader reader = null;
        ArrayList<String> temp = null;

        try {
            isr = new InputStreamReader(System.in);
            reader = new BufferedReader(isr);
            String[] readerStr = reader.readLine().trim().replaceAll("\\s+", "").split("");
            temp = new ArrayList<>(Arrays.asList(readerStr));

        } catch (IOException e){
            e.getStackTrace();
        } finally {

            try {
                if (isr != null){
                    isr.close(); // Закрываем поток
                }
            } catch (IOException e){
                e.getStackTrace();
            }

            try {
                if (reader != null){
                    reader.close(); // Закрываем поток
                }
            } catch (IOException e){
                e.getStackTrace();
            }

        }

        return temp;

    }
}
