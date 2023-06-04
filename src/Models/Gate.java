package Models;

import enums.GateTypeEnum;

public class Gate extends BaseModel {

    public GateTypeEnum type;
    public ParkingFloor floor;
    public Operator operator;
    public Integer number;
    public Gate() {}
    public Gate(Gate gate) {
        this.type = gate.type;
        this.floor = gate.floor;
        this.operator = gate.operator;
        this.number = gate.number;
    }

    public GateTypeEnum getType() {
        return type;
    }

    public void setType(GateTypeEnum type) {
        this.type = type;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
