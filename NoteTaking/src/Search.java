import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Search {

    public static void searchBy(String x){
        System.out.println("Please enter the keyword you would like to search: ");
        Scanner scanner2 = new Scanner(System.in);
        String keyword = scanner2.nextLine();
        if (x=="e"){
            //search just as keyword
        }
        else if (x=="f"){
            //search as a mention
        }
        else if (x=="g"){
            //sort by occurence of search word
        }
    }


}
