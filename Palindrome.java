public class Palindrome{
    public static String reverseString(String s){    // Метод для переворота слова
        String res = "";
        for (int i = 0;i < s.length();i++){
            res += s.charAt(s.length() - i - 1);
        }
        return res;
    }

    public static boolean isPalindrome(String s){   // Метод для определния является ли слово палиндромом
        if (reverseString(s).equals(s)){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        for (int i = 0;i < args.length;i++){
            String s = args[i];
            if (isPalindrome(s) == true) {
                System.out.println(s + " - палиндром");
            } else {
                System.out.println(s + " - не палиндром");
            }
        }
    }
}