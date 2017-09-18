import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Search {
    Main main = new Main();
    Note note = new Note();

    public void setMap() throws IOException {
        note.readFiles(main.path);
        note.getNotesFromFiles();
    }
    public void searchBy(String keyword,String key, List<String> keywordArray) throws IOException {
        if (key.equalsIgnoreCase("a")) {
            //display all notes with mentions
            System.out.println("These files contain mentions: \n");
            note.iterateMap("@");
            note.iterateMap("#");
            note.iterateMap("!");
            note.iterateMap("^");
            note.printFilesToPrint();
        }

        if (key.equalsIgnoreCase("b")) {
            //display all notes organized by mention
            System.out.println("\nThese files contain @ mentions: \n");
            note.iterateMap("@");
            note.printFilesToPrint();
            note.filesToPrint.clear();

            System.out.println("\nThese files contain # mentions: \n");
            note.iterateMap("#");
            note.printFilesToPrint();
            note.filesToPrint.clear();

            System.out.println("\nThese files contain ! mentions: \n");
            note.iterateMap("!");
            note.printFilesToPrint();
            note.filesToPrint.clear();

            System.out.println("\nThese files contain ^ mentions: \n");
            note.iterateMap("^");
            note.printFilesToPrint();
            note.filesToPrint.clear();

            System.out.println("\nThese files contain URL mentions: \n");
            note.iterateMap(".com");
            note.iterateMap(".org");
            note.iterateMap(".net");
            note.iterateMap(".edu");
            note.printFilesToPrint();
            note.filesToPrint.clear();


            //display @ then # then ! then ^ then .com
        }
        if (key.equalsIgnoreCase("c")) {
            //display every item in keywordArray
            System.out.println("HELLo");
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

            main.options(keywordArray);
        }
}
