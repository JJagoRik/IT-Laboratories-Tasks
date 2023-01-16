package Laboratornaya4;

public class kompChisl {
    private double ReZ;
    private double ImZ;

    public kompChisl(double ReZ, double ImZ){
            this.ReZ = ReZ;
            this.ImZ = ImZ;
    }

    public double getReZ(){
        return this.ReZ;
    }

    public double getImZ(){
        return this.ImZ;
    }

    public kompChisl square(){
        double newReZ = ReZ * ReZ - ImZ * ImZ;
        double newImZ = 2 * this.ReZ * this.ImZ;
        return new kompChisl(newReZ, newImZ);
    }

    public kompChisl iteration(kompChisl chisl){
        this.ReZ += chisl.getReZ();
        this.ImZ += chisl.getImZ();
        return this;
    }

    /* Ниже представлены методы для 5 лабораторной работы */

    public kompChisl squareKompSopr(){
        double newRez = ReZ * ReZ - ImZ * ImZ;
        double newImZ = -2 * this.ReZ * this.ImZ;
        return new kompChisl(newRez, newImZ);
    }

    public kompChisl squareAbs(){
        double newRez = ReZ * ReZ - ImZ * ImZ;
        double newImZ = -2 * Math.abs(ReZ) * Math.abs(ImZ);
        return new kompChisl(newRez, newImZ);
    }
}
