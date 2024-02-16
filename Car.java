package com.vehicle;

public class Car extends Vehicle {
    private boolean powerSteering;
    private String fuelType;

    public Car(int vehicleNo, boolean powerSteering, String fuelType) {
        super(vehicleNo);
        this.powerSteering = powerSteering;
        this.fuelType = fuelType;
    }

    @Override
    public void ignite() {
        engineStatus = "on";
        currentGear = 1;
    }

    @Override
    public int changeGear(int flag) {
        if (flag == 1) {
            currentGear = Math.min(currentGear + 1, 6);
        } else if (flag == -1) {
            currentGear = Math.max(currentGear - 1, 1);
        }
        return currentGear;
    }

    @Override
    public void stop() {
        engineStatus = "off";
        currentGear = 0;
    }

    public void showCarDetails() {
        System.out.println("Vehicle No: " + vehicleNo);
        System.out.println("Engine Status: " + engineStatus);
        System.out.println("Current Gear: " + currentGear);
        System.out.println("Power Steering: " + powerSteering);
        System.out.println("Fuel Type: " + fuelType);
    }
}
