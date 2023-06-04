package Repositories;

import Models.Vehicle;
import commons.RandomCharGenerator;
import enums.VehicleTypeEnum;

import java.util.Arrays;
import java.util.List;

public class VehiclesRepository {

    public List<Vehicle> vehicles;

    VehiclesRepository() {
        Integer[] totalVehicles = new Integer[15];
        Arrays.setAll(totalVehicles, i -> i + 1);
        for(int i: totalVehicles) {
          Vehicle vehicle = new Vehicle();
          vehicle.setModel(VehicleTypeEnum.LIGHT_FOUR_WHEELER);
          vehicle.setNumber(RandomCharGenerator.getAlphaNumericString());
          vehicles.add(vehicle);
        }
    }

    public Vehicle create(Vehicle vehicle) {
        vehicles.add(vehicle);
        return vehicle;
    }

    public Vehicle getVehicleByNumber(String number) {
        for(Vehicle v: vehicles) {
            if(v.getNumber() == number) {
                return v;
            }
        }
        return null;
    }

}
