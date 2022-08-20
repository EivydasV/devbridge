package org.example;

import java.io.*;
import java.util.Arrays;

public class Main {
    private static final int MAX_NUMBER = 10;

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                int[] intFromString = getIntFromString(line);

                for (int num : intFromString) {
                    if (num >= MAX_NUMBER) System.out.println(line);
                }
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] getIntFromString(String text) {
        String numbersOnly = text.replaceAll("[^0-9]", " ");
        numbersOnly = numbersOnly.replaceAll(" +", " ").trim();
        int[] numbers = new int[0];
        if (!numbersOnly.isBlank())
            numbers = Arrays.stream(numbersOnly.split(" ")).mapToInt(Integer::parseInt).toArray();

        return numbers;
    }

}