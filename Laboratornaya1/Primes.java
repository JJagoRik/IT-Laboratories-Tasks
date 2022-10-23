public class Primes {
    public static boolean isPrime(int n){                           // Метод проверки на простое число
        for (int  i = 2;i < (int) Math.pow(n, 0.5) + 1;i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        for (int i = 2;i <= 100;i++) {
            if (isPrime(i)) {
                System.out.println(i + " - простое");
            } else {
                System.out.println(i + " - не простое");
            }
        }
    }
}
