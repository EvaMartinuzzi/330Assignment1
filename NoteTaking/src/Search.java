import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Search {
    Main main = new Main();
    public void searchBy(String keyword,String key, List<String> keywordArray) throws IOException {
        if (key.equalsIgnoreCase("a")) {
            //display all notes with mentions
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

        if (key.equalsIgnoreCase("b")) {
            //display all notes organized by mention
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
            //display @ then # then ! then ^ then .com
        }
        if (key.equalsIgnoreCase("c")) {
            //display every item in keywordArray
        }

        if (key.equalsIgnoreCase("d")) {
            //search all notes for keyword as both keyword and mention
        }

        if (key.equalsIgnoreCase("e")) {
                //search all notes for keyword
        }

        if (key.equalsIgnoreCase("f")) {
                //search all notes for keyword as mention
        }

        if (key.equalsIgnoreCase("g")) {
                //topological sort
        }

            Main.options(keywordArray);
        }
}
