public class ElectricCar extends Car{
    private int batteryPercentage;

    ElectricCar(String make, String model, int year,int batteryPercentage) {
        super(make,model,year);
        this.batteryPercentage = batteryPercentage;
    }

    public int getBatteryPercentage() {
        return this.batteryPercentage;
    }

    public void setBatteryPercentage(int batteryPercentage) {
        this.batteryPercentage = batteryPercentage;
    }

    public void chargeBattery(){
        System.out.println("The Battery is Charging...");
    }

    @Override
    public void startEngine(){
        System.out.println("The engine of the Electric car has started...");
    }
}
