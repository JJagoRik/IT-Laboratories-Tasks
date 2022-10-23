package Laboratornaya2;

public class Lab1{
    /** метод для нахождения площади треугольника **/
    public static double computeArea(Point3d obj1, Point3d obj2, Point3d obj3){                                         // метод для одного из пунктов третьего задания
        double vecAB = obj1.distanceTo(obj2);
        double vecBC = obj2.distanceTo(obj3);
        double vecAC = obj1.distanceTo(obj3);
        double perim = (vecAB + vecBC + vecAC) / 2;
        return Math.pow((perim * (perim - vecAB) * (perim - vecBC) * (perim - vecAC)), 0.5);
    }

    public static boolean isRight(Point3d obj1, Point3d obj2, Point3d obj3) {
        return !((obj1.comparisonOfTwo(obj2)) || (obj2.comparisonOfTwo(obj3)) || (obj1.comparisonOfTwo(obj3)));
    }

    public static void main(String args[]){
        Point3d obj1 = new Point3d(1, 1, 0);
        Point3d obj2 = new Point3d(1, 1, 0);
        Point3d obj3 = new Point3d(-2, -2, 0);
        if (!isRight(obj1, obj2, obj3)){
            System.out.println("Точки совпадают");
        } else {
            System.out.println(computeArea(obj1, obj2, obj3));
        }
    }
}