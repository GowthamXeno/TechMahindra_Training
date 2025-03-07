
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class FileCreation {
        static Scanner in=new Scanner(System.in);
        public static  String createfolder(String path) {
            System.out.println("Enter the folder name");
            String folder=in.nextLine();
            File f= new File(path+folder);
            f.mkdir();
            System.out.println(folder +" is created Successfully");
            return path+folder;
        }

        public static void createfile(String path) throws IOException{
            System.out.println("Enter the File name");
            String file=in.nextLine();
            File f= new File(path+ file);
            f.createNewFile();
            System.out.println(file+"is Created Successfully");
        }
}
