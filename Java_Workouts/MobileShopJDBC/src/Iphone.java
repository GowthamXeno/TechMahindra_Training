
public class Iphone {
    private String model;
    private int rom;
    private int ram;
    private int price;
    private String battery;


    public Iphone(String model, int rom, int ram, int price, String battery) {
        this.model = model;
        this.rom = rom;
        this.ram = ram;
        this.price = price;
        this.battery = battery;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRom() {
        return rom;
    }

    public void setRom(int rom) {
        this.rom = rom;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }
}
