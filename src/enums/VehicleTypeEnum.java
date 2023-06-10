package enums;

import java.util.stream.Stream;

public enum VehicleTypeEnum {
    HEAVY_FOUR_WHEELER,
    TWO_WHEELER,
    LIGHT_FOUR_WHEELER;

    public static Stream<VehicleTypeEnum> stream() {
        return Stream.of(VehicleTypeEnum.values());
    }

    public static VehicleTypeEnum findByName(String name) {
        VehicleTypeEnum result = null;
        for (VehicleTypeEnum vehicleType : values()) {
            if (vehicleType.name().equalsIgnoreCase(name)) {
                result = vehicleType;
                break;
            }
        }
        return result;
    }
}
