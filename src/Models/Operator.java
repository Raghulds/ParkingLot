package Models;

public class Operator extends BaseModel  {

    public String name;

    public Operator(Operator operator) {
        this.name = operator.name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
