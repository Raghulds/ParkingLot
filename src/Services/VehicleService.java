package Services;

import Models.Vehicle;
import Repositories.VehiclesRepository;

public class VehicleService {

    VehiclesRepository vehiclesRepository;

    public VehicleService(VehiclesRepository vehiclesRepository) {
        this.vehiclesRepository = vehiclesRepository;
    }
    public Vehicle getVehicleByNumber(String number) {
        return vehiclesRepository.getVehicleByNumber(number);
    }

    public Vehicle create(Vehicle vehicle) {
        return vehiclesRepository.create(vehicle);
    }
}
