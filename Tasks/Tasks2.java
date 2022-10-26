package Tasks;

import java.util.Arrays;

public class Tasks2{
    public static String repeat(String word, int n){                                                                    // 2.1 Функция, которая повторяет каждый символ в строке n раз
        String res = "";
        for (int i = 0; i < word.length(); i++){
            for (int j = 0; j < n; j++){
                res += word.charAt(i);
            }
        }
        return res;
    }

    public static int differenceMaxMin(int[] mass){                                                                     // 2.2 Функция нахождения разности между самым большим и маленьким числом в массиве
        Arrays.sort(mass);
        return mass[mass.length - 1] - mass[0];
    }

    public static boolean isAvgWhole(double[] mass){                                                                    // 2.3 Функция нахождения среднего арифметического и его проверка на целостность
        double summary = 0;
        for (int i = 0; i < mass.length; i++){
            summary += mass[i];
        }
        if (summary % mass.length == 0){
            return true;
        }
        return false;
    }

    public static int[] cumulativeSum(int mass[]){                                                                      // 2.4 Функция создания массива, в котором каждое целое число является суммой всех предыдущих чисел
        int summary = 0;
        int resMass[] = new int[mass.length];
        for (int i = 0; i < mass.length; i++){
            summary += mass[i];
            resMass[i] = summary;
            System.out.println(resMass[i]);
        }
        return resMass;
    }

    public static String getDecimalPlaces(String number){                                                               // 2.5 Функция, которая возвращает число десятичных знаков, которое имеет число
        String res = "";
        String[] word = number.split("\\.");
        if (word.length == 1){
            return "0";
        }
        for (int i = 0; i < word[1].length(); i++){
            if (word[1].substring(i, i + 1).equals("0")){
                return res;
            }
            res += word[1].substring(i, i + 1);
        }
        return res;
    }

    public static int Fibonacci(int n){                                                                                 // 2.6 Функция, которая при заданном числе возвращает соответствующее число Фибоначчи
        int[] mass = new int[n + 2];
        mass[0] = 0;
        mass[1] = 1;
        for (int i = 2; i < mass.length; i++){
            mass[i] = mass[i - 1] + mass[i - 2];
        }
        return mass[mass.length - 1];
    }

    public static boolean isValid(String number){                                                                       // 2.7 Функция, чтобы определить, является ли вход действительным почтовым индексом
        if (number.length() > 5){
            return false;
        } else if (number.split(" ")[0].length() != number.length()){
            return false;
        }
        String regex = "\\d+";
        return number.matches(regex);
    }

    public static boolean isStrangePair(String str1, String str2){                                                      // 2.8 Функция, которая возвращает true, если пара строк представляет собой странную пару, и false в противном случае
        if (str1.length() == 0 && str2.length() == 0){
            return true;
        } else if (str1.substring(0, 1).equals(str2.substring(str2.length() - 1, str2.length())) &&
                str1.substring(str1.length() - 1, str1.length()).equals(str2.substring(0, 1))){
            return true;
        }
        return false;
    }

    public static boolean isPrefix(String str1, String str2){                                                           // 2.9 Функция isPrefix должна возвращать true, если аргумент начинается с префиксного аргумента.
        String[] str1Mass = str1.split("");
        String[] str2Mass = str2.split("");
        boolean flag = true;
        for (int i = 0; i < str2Mass.length - 1; i++){
            if (!str1Mass[i].equals(str2Mass[i])){
                return false;
            }
        }
        return flag;
    }

    public static boolean isSuffix(String str1, String str2){                                                           // 2.9 Функция isSuffix должна возвращать true, если аргумент заканчивается аргументом суффикса.
        String[] str1Mass = str1.split("");
        String[] str2Mass = str2.split("");
        boolean flag = true;
        int n = 1;
        for (int i = str1Mass.length - str2Mass.length + 1; i < str1Mass.length - 1; i++){
            if (!str1Mass[i].equals(str2Mass[n])){
                return false;
            }
            n += 1;
        }
        return flag;
    }

    public static int boxSeq(int n){                                                                                    // 2.10 Функция, которая принимает число (шаг) в качестве аргумента и возвращает количество полей на этом шаге последовательности.
        int num = 0;
        if (n == 0) {
            return num;
        }
        for (int i = 1; i <= n; i++){
            if (i % 2 == 0){
                num -= 1;
            } else {
                num += 3;
            }
        }
        return num;
    }

    public static void main(String args[]){
        System.out.println(repeat("mice", 5));
        int mass[] = {10, 4, 1, 4, -10, -50, 32, 21};
        System.out.println(differenceMaxMin(mass));
        double mass2[] = {1, 2, 3, 7};
        System.out.println(isAvgWhole(mass2));
        int mass3[] = {1, 2, 3};
        int resMass[] = cumulativeSum(mass3);
        System.out.println(Arrays.toString(resMass));
        System.out.println(getDecimalPlaces("3.1"));
        System.out.println(Fibonacci(12));
        System.out.println(isValid("1122b"));
        System.out.println(isStrangePair("sparkling", "groups"));
        System.out.println(isPrefix("automation", "auto-"));
        System.out.println(isSuffix("automation", "-tion"));
        System.out.println(boxSeq(9));
    }
}