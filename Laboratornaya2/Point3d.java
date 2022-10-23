package Laboratornaya2;

public class Point3d extends Point2d{                                                                                   // выполнение первого задания

    /** координата Z **/
    private double zCord;

    /** Конструктор инициализации **/
    public Point3d(double x, double y, double z){
        super(x, y);
        zCord = z;
    }

    /** Конструктор по умолчанию **/
    public Point3d(){
        //Вызовите конструктор с двумя параматрами и определите источник.
        this(0, 0, 0);
    }

    /** Возвращение координаты Z **/
    public double getZ(){
        return zCord;
    }

    /** Установка значения координаты Z **/
    public void setZ(double val){
        zCord = val;
    }

    /** метод для сравнения значений двух объектов **/                                                                  // метод для первого задания
    public boolean comparisonOfTwo(Object obj){
        if (this == obj){
            return true;
        }
        if (obj == null){
            return false;
        }
        if (!(obj instanceof Point3d)){
            return false;
        }
        Point3d compObj = (Point3d) obj;
        return this.getX() == compObj.getX() && this.getY() == compObj.getY() && this.getZ() == compObj.getZ();
    }

    /** метод для нахождения расстояния между двумя точками **/                                                         // метод для второго задания
    public double distanceTo(Point3d obj){
        return Double.parseDouble(String.format("%.2f", Math.pow((Math.pow((obj.getX() - this.getX()), 2)
                + Math.pow((obj.getY() - this.getY()), 2) + Math.pow((obj.getZ() - this.getZ()), 2)), 0.5)));
    }

    public static void main(String args[]){
        Point3d firstObj = new Point3d(1, 2, 3);
        Point3d secondObj = new Point3d(-6, -2, 4);
        System.out.println(firstObj.comparisonOfTwo(secondObj));                                                        // вывод расстояния с точностью до 2-х знаков для второго задания
        System.out.println(firstObj.distanceTo(secondObj));
        System.out.println();
    }
}