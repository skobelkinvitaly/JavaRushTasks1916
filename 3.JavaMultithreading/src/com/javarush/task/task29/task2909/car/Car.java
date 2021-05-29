package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public static Car create(int type, int numberOfPassengers) {
        if (type == 0) return new Truck(numberOfPassengers);
        if (type == 1) return new Sedan(numberOfPassengers);
        if (type == 2) return new Cabriolet(numberOfPassengers);

        return null;
    }

    public void fill(double numberOfLiters) throws Exception {
        if (numberOfLiters < 0) throw new Exception();
//            return -1;
        fuel += numberOfLiters;
//        return 0;
    }

    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
        double consumption;
//        if (date.before(SummerStart) || date.after(SummerEnd)) {
//            consumption = length * winterFuelConsumption + winterWarmingUp;
//        } else {
//            consumption = length * summerFuelConsumption;
//        }
        if (isSummer(date, SummerStart, SummerEnd) == false) {
            consumption = getWinterConsumption(length);
        } else {
            consumption = getSummerConsumption(length);
        }
        return consumption;
    }

    public int getNumberOfPassengersCanBeTransferred() {
//        if (!isDriverAvailable())
//            return 0;
//        if (fuel <= 0)
//            return 0;
        if (canPassengersBeTransferred() == true) return numberOfPassengers;
        else return 0;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        if (numberOfPassengers > 0) {
            fastenPassengersBelts();
//            fastenDriverBelt();
        } else {
//            fastenDriverBelt();
        }
        fastenDriverBelt();
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    public abstract int getMaxSpeed();

    public boolean isSummer(Date date, Date summerStart, Date summerEnd) {
        if (date.before(summerStart) || date.after(summerEnd)) return false;
        else return true;
    }

    public double getWinterConsumption(int length) {
        return length * winterFuelConsumption + winterWarmingUp;
    }

    public double getSummerConsumption(int length) {
        return length * summerFuelConsumption;
    }

    private boolean canPassengersBeTransferred() {
        if (isDriverAvailable() == true && fuel > 0) return true;
        else return false;
    }
}