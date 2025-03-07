
import java.io.IOException;
import java.util.Scanner;

public class FileHandle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int ch = 0;
        try {
            System.out.println("Set file path");
            String path = in.nextLine() + '/';
            while (ch != 5) {
                System.out.println("----------------------");
                System.out.println("Current path:" + path);
                System.out.println("----------------------");
                dispmenu();
                ch = in.nextInt();
                in.nextLine();
                switch (ch) {
                    case 1: {

                        String path1 = FileCreation.createfolder(path);
                        for (int i = 0; i < 3; i++) {
                            FileCreation.createfile(path1);
                        }
                        break;
                    }
                    case 2: {
                        String path1 = FileCreation.createfolder(path);
                        for (int i = 0; i < 4; i++) {
                            FileCreation.createfile(path1);
                        }
                        break;
                    }
                    case 3: {
                        for (int i = 0; i < 3; i++) {
                            FileCreation.createfile(path);
                        }
                        break;
                    }
                    case 4: {
                        System.out.println("Set file path");
                        path = in.nextLine();
                        break;
                    }
                    case 5:
                        break;
                    default: {
                        System.out.println("Invalid choice");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            in.close();
        }
    }

    public static void dispmenu() {
        System.out.println("-------------------");
        System.out.println("       Menu        ");
        System.out.println("1. Create folder with 3 file");
        System.out.println("2. Create folder with 4 file");
        System.out.println("3. Create 3 files");
        System.out.println("4. Change Path");
        System.out.println("5. Exit");
    }
}
