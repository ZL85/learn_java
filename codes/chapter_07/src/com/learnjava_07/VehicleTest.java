package com.learnjava_07;

public class VehicleTest {
    public static void main(String[] args) {
        Vehicle[] v = new Vehicle[3];
        v[0] = new Bicycle("捷安特", "red");
        v[2] = new ElectricVehicle("雅迪", "blue");
        v[1] = new Car("奥迪", "black", "京A8888");
        Developer d = new Developer();
        for (Vehicle vehicle : v) {
            d.takingVehicle(vehicle);
            if (vehicle instanceof Power) {
                ((Power) vehicle).power();
            }
        }
    }
}
