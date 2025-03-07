import java.util.*;

public class MobileShopApp {
        static Scanner scanner = new Scanner(System.in);
    public void start() {
        System.out.println();
        System.out.println();
        System.out.println("Welcome to MobileShop - Your one-stop destination for the latest smartphones at competitive prices!");
        System.out.println("Explore a wide range of mobile phones, accessories, and exclusive deals for every need and budget.\n");
        while (true) {
            System.out.println("------MobileShop Menu-------");
            System.out.println("1. Add Iphone");
            System.out.println("2. View all Iphones");
            System.out.println("3. Exit");

            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    addIphone();
                    break;
                case 2:
                    Crud.DisplayPhone();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option, try again.");
            }
        }
    }
    private void addIphone() {
        System.out.print("Enter Model: ");
        String model = scanner.nextLine();
        System.out.print("Enter ROM: ");
        int rom = scanner.nextInt();
        System.out.print("Enter RAM: ");
        int ram = scanner.nextInt();
        System.out.print("Enter Price: ");
        int price = scanner.nextInt();
        System.out.print("Enter Battery: ");
        scanner.nextLine();
        String battery = scanner.nextLine();

        Iphone iphone = new Iphone(model, rom, ram, price, battery);
        Crud.insertIphone(iphone);
    }
}
