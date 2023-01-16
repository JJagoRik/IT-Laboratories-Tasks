package Tasks;

import javax.swing.*;
import java.util.Arrays;
import java.util.HashSet;

public class Tasks3{
    public static int solutions(int a, int b, int c){                                                                   // Task 1
        int Diskr = b * b - 4 * a * c;
        if (Diskr < 0) return 0;
        else if (Diskr == 0) return 1;
        else return 2;
    }

    public static int findZip(String str){                                                                              // Task 2
        return str.indexOf("zip", str.indexOf("zip") + 1);
    }

    public static boolean checkPerfect(int chisl){                                                                      // Task 3
        int n = 0;
        for (int i = 1; i <= chisl / 2; i++){
            if (chisl % i == 0) n += i;
        }
        if (n == chisl) return true;
        else return false;
    }

    public static String flipEndChars(String str){                                                                      // Task 4
        if (str.length() < 2) return "несовместимо";
        else if (str.charAt(0) == str.charAt(str.length() - 1)) return "два-это пара";
        else return str.charAt(str.length() - 1) + str.substring(1, str.length() - 2) + str.charAt(0);
    }

    public static boolean isValidHexCode(String str){                                                                   // Task 5
        if (str.charAt(0) != '#') return false;
        else if (str.length() != 7) return false;
        else {
            for (int i = 1; i < str.length(); i++){
                if (!(Character.isDigit(str.charAt(i)) || String.valueOf(str.charAt(i)).matches("[a-fA-F]")))
                    return false;
            }
        }
        return true;
    }

    public static boolean same(int[] mass1, int[] mass2){                                                               // Task 6
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < mass1.length; i++){
            set.add(mass1[i]);
        }
        int n1 = set.size();
        set.clear();
        for (int i = 0; i < mass2.length; i++){
            set.add(mass1[i]);
        }
        if (n1 == set.size()) return true;
        else return false;
    }

    public static boolean isKaprekar(int chisl){                                                                        // Task 7
        if (chisl <= 3) return false;
        int n = chisl * chisl;
        int startIndex = (String.valueOf(n).length() / 2);
        int firstHalf = Integer.parseInt(String.valueOf(n).substring(0, startIndex));
        int secondHalf = Integer.parseInt(String.valueOf(n).substring(startIndex));
        if (firstHalf + secondHalf == chisl) return true;
        else return false;
    }

    public static String longestZero(String str){                                                                       // Task 8
        int maxLength = 0;
        int n = 1;
        for (int i = 0; i < str.length() - 1; i++){
            if (str.charAt(i) == str.charAt(i + 1) && str.charAt(i) == '0') n += 1;
            else if (maxLength < n){
                maxLength = n;
                n = 1;
            }
        }
        return "0".repeat(maxLength);
    }

    public static int nextPrime(int chisl){                                                                             // Task 9
        boolean flag = true;
        for (int i = 2; i <= Math.sqrt(chisl); i++){
            if (chisl % i == 0){
                flag = false;
                break;
            }
        }
        if (flag) return chisl;
        else {
            int n = chisl;
            while (true){
                n++;
                flag = true;
                for (int i = 2; i <= Math.sqrt(n); i++){
                    if (n % i == 0){
                        flag = false;
                        break;
                    }
                }
                if (flag) return n;
            }
        }
    }

    public static boolean rightTriangle(int x, int y, int z){                                                           // Task 10
        if (!(x + y > z && x + z > y && y + z > x)) return false;
        int[] mass = new int[]{x, y, z};
        int[] mass1 = Arrays.stream(mass).sorted().toArray();
        if (mass1[0] * mass1[0] + mass1[1] * mass1[1] == mass1[2] * mass1[2]) return true;
        else return false;
    }

    public static void main(String args[]){
        System.out.println("1. " + solutions(1, 0, 1));
        System.out.println("2. " + findZip("all zip files are compressed"));
        System.out.println("3. " + checkPerfect(28));
        System.out.println("4. " + flipEndChars("Cat, dog, and mouse."));
        System.out.println("5. " + isValidHexCode("#CD5C5C"));
        System.out.println("6. " + same(new int[]{1, 3, 4, 4, 4}, new int[]{2, 5, 7}));
        System.out.println("7. " + isKaprekar(297));
        System.out.println("8. " + longestZero("1111111111111"));
        System.out.println("9. " + nextPrime(24));
        System.out.println("10. " + rightTriangle(5, 4, 4));
    }
}