package Models;

import java.util.List;

public class ParkingLot extends BaseModel {
    public String city;
    public String name;
    public List<ParkingFloor> floors;
    public List<Gate> gates;
    public ParkingLot() {}
    public ParkingLot(ParkingLot lot) {
        this.city = lot.city;
        this.name = lot.name;
        this.floors = lot.floors;
        this.gates = lot.gates;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ParkingFloor> getFloors() {
        return floors;
    }

    public void setFloors(List<ParkingFloor> floors) {
        this.floors = floors;
    }
}
