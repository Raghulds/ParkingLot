package Models;

import enums.VehicleTypeEnum;

public class Vehicle extends BaseModel {
    public String number;
    public VehicleTypeEnum model;
    public Vehicle() {}
    public Vehicle(Vehicle vehicle) {
        this.number = vehicle.number;
        this.model = vehicle.model;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public VehicleTypeEnum getModel() {
        return model;
    }

    public void setModel(VehicleTypeEnum model) {
        this.model = model;
    }
}
