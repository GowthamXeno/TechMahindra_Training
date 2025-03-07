public class Driver {
    public static void main(String[] args) {
        Car cars[] = new Car[5];
        cars[0] = new Car("Toyota", "Corolla", 2020);
        cars[1] = new ElectricCar("Tesla", "Model S", 2023, 400);
        cars[2] = new Car("Honda", "Civic", 2022);
        cars[3] = new ElectricCar("Nissan", "Leaf", 2021, 300);
        cars[4] = new Car("Ford", "Mustang", 2019);

        for (Car car : cars) {
            car.startEngine();
        }
    }
}
