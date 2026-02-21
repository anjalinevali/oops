// Engine class
class Engine {
    String engineType;
    int horsepower;

    Engine(String engineType, int horsepower) {
        this.engineType = engineType;
        this.horsepower = horsepower;
    }

    void displayEngineDetails() {
        System.out.println("Engine Type: " + engineType);
        System.out.println("Horsepower: " + horsepower);
    }
}

// Car class (HAS-A Engine)
class Car {
    String carName;
    Engine engine;   // Composition

    Car(String carName, String engineType, int horsepower) {
        this.carName = carName;
        this.engine = new Engine(engineType, horsepower);
    }

    void displayCarDetails() {
        System.out.println("Car Name: " + carName);
        engine.displayEngineDetails();
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("BMW", "Petrol", 300);
        car1.displayCarDetails();
    }
}



