package sample.controllers.controllersList.actions;

public class Action {
    private String name;
    private String desription;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesription() {
        return desription;
    }

    public void setDesription(String desription) {
        this.desription = desription;
    }

    public Action(String name, String desription) {
        this.name = name;
        this.desription = desription;
    }

    @Override
    public String toString() {
        return "Action{" +
                "name='" + name + '\'' +
                ", desription='" + desription + '\'' +
                '}';
    }
}
