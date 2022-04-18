package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static boolean check_arab(String str) { //проверка является ли символ арабским числом
        boolean x = false;
        String[] arabicArray = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        for (int i = 0; i < arabicArray.length; i++) {
            if (str.equals(arabicArray[i])) {
                x = Boolean.TRUE;
                break;
            } else
                x = Boolean.FALSE;
        }
        return x;
    }

    public static boolean check_rome(String str) {  // проверка римских чисел
        String[] romeArray = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        boolean x = false;
        for (int i = 0; i < romeArray.length; i++) {
            if (str.equals(romeArray[i])) {
                x = Boolean.TRUE;
                break;
            } else
                x = Boolean.FALSE;
        }
        return x;
    }

    public static boolean check_action(String str){
        String[] action = {"+", "-", "*", "/"};
        boolean x = false;
        for (int i = 0; i < action.length; i++) {
            if (str.equals(action[i])) {
                x = Boolean.TRUE;
                break;
            } else
                x = Boolean.FALSE;
        }
        return x;
    }



    public static int arab_math(int a, int b, String c){ // математика с арабскими числами

        int result = 0;
        try {
            if (c.equals("+"))
                result = a + b;
            else if (c.equals("-"))
                result = a - b;
            else if (c.equals("*"))
                result = a * b;
            else if (c.equals("/"))
                result = a / b;

        } catch (ArithmeticException e) {
            System.out.println("Division by zero");
        }
        return result;
    }

    public static String IntToRoman(int input) { // Выдрал из Интернета с overcoder.net :-)
        if (input < 1 || input > 3999)
            return "Negative result";
        String s = "";
//        while (input >= 1000) {
//            s += "M";
//            input -= 1000;        }
//        while (input >= 900) {
//            s += "CM";
//            input -= 900;
//        }
//        while (input >= 500) {
//            s += "D";
//            input -= 500;
//        }
//        while (input >= 400) {
//            s += "CD";
//            input -= 400;
//        }
        while (input >= 100) {
            s += "C";
            input -= 100;
        }
        while (input >= 90) {
            s += "XC";
            input -= 90;
        }
        while (input >= 50) {
            s += "L";
            input -= 50;
        }
        while (input >= 40) {
            s += "XL";
            input -= 40;
        }
        while (input >= 10) {
            s += "X";
            input -= 10;
        }
        while (input >= 9) {
            s += "IX";
            input -= 9;
        }
        while (input >= 5) {
            s += "V";
            input -= 5;
        }
        while (input >= 4) {
            s += "IV";
            input -= 4;
        }
        while (input >= 1) {
            s += "I";
            input -= 1;
        }
        return s;
    }


    public static String rome_math(String a, String b, String c) { // математика с римскими числами
        int x = 0;
        int y = 0;
        int result = 0;
        Integer[] arabicArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] romeArray = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        for (int i = 0; i < romeArray.length; i++) {
            if (a.equals(romeArray[i])) {
                x = arabicArray[i];
            }
        }
        for (int i = 0; i < romeArray.length; i++) {
            if (b.equals(romeArray[i])) {
                y = arabicArray[i];
            }
        }
            if (c.equals("+"))
                result = x + y;
            else if (c.equals("-"))
                result = x - y;
            else if (c.equals("*"))
                result = x * y;
            else if (c.equals("/"))
                result = x / y;

        return IntToRoman(result);
    }

    public static void main(String[] args) {
        enum Rome {I, II, III, IV, V, VI, VII, VIII, IX, X}
//        enum Arabic {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
//        enum action {ADD, SUB, MULT, DIVISION}
        Integer[] arabic = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayList intList = new ArrayList(Arrays.asList(arabic));


        Scanner in = new Scanner(System.in);
        System.out.print("Калькулятор: ");

        String input_str = in.nextLine();
        String[] strToArray;
        String delimiter = " ";
        strToArray = input_str.split(delimiter);

        int a = 0;
        String s = "";
        if (check_action(strToArray[1])) {
            if (check_rome(strToArray[0])) {
                try {
                    Rome.valueOf(strToArray[2]);
                    System.out.println(rome_math(strToArray[0], strToArray[2], strToArray[1]));
                } catch (IllegalArgumentException e) {
                    System.out.println("Wrong rome input");
                }
            } else if (check_arab(strToArray[0])) {
                try {
                    intList.contains(Integer.parseInt(strToArray[2]));
                    System.out.println(arab_math(Integer.parseInt(String.valueOf(strToArray[0])), Integer.parseInt(String.valueOf(strToArray[2])), strToArray[1]));
                } catch (IllegalArgumentException e) {
                    System.out.println("Wrong arabic input");
                }
            } else System.out.println("Wrong input");
        }
        else {
            System.out.println("Wrong action");
        }
    }
}


