package FuelControl;

import java.util.ArrayList;

public class Cars {
    private String model;
    private int year;
    private float motorVolume;
    private int mileageStart;

    private ArrayList<Integer> money;
    private ArrayList<Integer> liter;
    private ArrayList<Integer> mileage;


    public Cars(String model, int year, float motorVolume, int mileage) {
        this.model = model;
        this.year = year;
        this.motorVolume = motorVolume;

        this.money = new ArrayList<Integer>();
        this.liter = new ArrayList<Integer>();
        this.mileage = new ArrayList<Integer>();
    }

    public void addFuel(int money, int liter, int mileage) {
        this.money.add(money);
        this.liter.add(liter);
        this.mileage.add(mileage);
    }

    private int sum( ArrayList<Integer> arr) {
        int sum = 0;
        for (int i : arr)
            sum += i;
        return sum;
    }

    public double calcFuelСonsumption() {
        double mileage = this.mileage.get( this.mileage.size() ) - this.mileageStart;
        double fuel = this.sum(this.liter);
        return (fuel / mileage) * 100;
    }

    public int sumMoney() {
        return this.sum(this.money);
    }
}
