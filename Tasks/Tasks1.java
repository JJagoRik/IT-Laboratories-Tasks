package Tasks;

public class Tasks1 {
    public static int remainder(int a, int b){                                                                          // 1.1 Функция нахождения остатка от делания для первого Таска
        return a % b;
    }

    public static int triArea(int a, int h){                                                                            // 1.2 Функция нахождения площади треугольника через выссоту и основание для второго Таска
        return a * h / 2;
    }

    public static int animals(int chickens, int cows, int pigs){                                                        // 1.3 Функция нахождения общего кол-ва ног жиотнвых для третьего Таска
        return chickens * 2 + cows * 4 + pigs * 4;
    }

    public static boolean profitableGamble(double prob, int prize, int pay){                                            // 1.4 Функция нахождения true или false для четвёртого Таска
        return prob * prize > pay;
    }

    public static String operation(int N, int a, int b){                                                                // 1.5 Функция нахождения нужной операции для пятого Таска
        String res;
        if (N == (a + b)){
            res = "summ";
        } else if (N == (a - b)){
            res = "subtraction";
        } else if (N == (a / b)){
            res = "division";
        } else if (N == (a * b)){
            res = "multiplication";
        } else {
            res = "none";
        }
        return res;
    }

    public static int ctoa(char a){                                                                                     // 1.6 Функция, которая возвращает значение ASCII переданного символа для шестого Таска
        return a;
    }

    public static int addUpTo(int n){                                                                                   // 1.7 Функция, которая возвращает сумму всех чисел до введённого для седьмого Таска
        int res = 0;
        for (int i = 0; i < (n + 1) ; i++){
            res += i;
        }
        return res;
    }

    public static int nextEdge(int a, int b){                                                                           // 1.8 Функция нахождения максимального значения третьего ребра треугольника для восьмого Таска
        return a + b - 1;
    }

    public static int sumOfCubes(int array[]){                                                                          // 1.9 Функция, которая принимает массив чисел и возвращает сумму кубов для седьмого Таска
        int res = 0;
        for (int i = 0; i < array.length; i++){
            res += Math.pow(array[i], 3);
        }
        return res;
    }

    public static boolean abcmath(int a, int b, int c){                                                                 // 1.10 Функция выполнения действий для десятого Таска
        int res = a;
        for (int i = 0; i < b; i++){
            res *= 2;
        }
        return res % c == 0;
    }
    public static void main(String[] args){
        System.out.println("1. " + remainder(1, 2));
        System.out.println("2. " + triArea(10, 10));
        System.out.println("3. " + animals(2, 3, 5));
        System.out.println("4. " + profitableGamble(0.2, 50, 9));
        System.out.println("5. " + operation(24, 15, 9));
        System.out.println("6. " + ctoa('A'));
        System.out.println("7. " + addUpTo(10));
        System.out.println("8. " + nextEdge(8, 10));
        int mass[] = {3, 4, 5};
        System.out.println("9. " + sumOfCubes(mass));
        System.out.println("10. " + abcmath(1, 2,3));
    }
}