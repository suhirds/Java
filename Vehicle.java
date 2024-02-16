package com.vehicle;

public abstract class Vehicle {
    protected int vehicleNo;
    protected String engineStatus;
    protected int currentGear;

    public Vehicle(int vehicleNo) {
        this.vehicleNo = vehicleNo;
        this.engineStatus = "off";
        this.currentGear = 0;
    }

    public abstract void ignite();

    public abstract int changeGear(int flag);

    public abstract void stop();
}
