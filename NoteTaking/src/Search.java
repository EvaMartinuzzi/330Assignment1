import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Search {

    public void searchBy(String keyword,String key){
        if(key.equalsIgnoreCase("a")){
            Pattern p = Pattern.compile("[^a-z]");
            Matcher m = p.matcher(keyword);
            if (m.find()) {
                switch (m.group(0)) {
                    case "@":
                        System.out.println("IT WORKS");
                        break;
                    case "!":
                        break;
                    case "#":
                        break;
                }
            }
        }
    }
}
