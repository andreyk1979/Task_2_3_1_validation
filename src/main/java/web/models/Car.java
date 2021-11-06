package web.models;

public class Car {

    String modelName;
    String color;
    Double engineVolume;

    public Car() {
    }

    public Car(String modelName, String color, Double engineVolume) {
        this.modelName = modelName;
        this.color = color;
        this.engineVolume = engineVolume;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(Double engineVolume) {
        this.engineVolume = engineVolume;
    }

    @Override
    public String toString() {
        return "Car{" +
                "modelName='" + modelName + '\'' +
                ", color='" + color + '\'' +
                ", engineVolume=" + engineVolume +
                '}';
    }
}
