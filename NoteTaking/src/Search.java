import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Search {
    Main main = new Main();
    Note note = new Note();
    Scanner scanner = new Scanner(System.in);


    //reads files into map
    public void setMap() throws IOException {
        note.readFiles(main.path);
        note.getNotesFromFiles();
    }

    public void searchBy(String key) throws IOException {
        if (key.equalsIgnoreCase("a")) {
            //display all notes with mentions
            System.out.println("These files contain mentions: \n");
            note.iterateMapSearch("@");
            note.printFilesToPrint();
            System.out.println();
        }

        if (key.equalsIgnoreCase("b")) {
            //display all notes organized by mention

            System.out.println("\nThese files contain mentions: \n");
            note.iterateMapSearch("@");
            note.printFilesToPrintSorted();
            note.filesToPrint.clear();
            System.out.println();
        }

        if (key.equalsIgnoreCase("c")) {
            //display all important words within all notes
            note.iterateMapSearch("");
            note.generateKeywords();
        }

        if (key.equalsIgnoreCase("d")) {
            //report all notes organized by frequently used words
            note.iterateMapSearch("");
            note.generateKeywordsSorted();
        }

        if (key.equalsIgnoreCase("e")) {
            //report all notes that contain a searched frequently used word or @
            System.out.println("Please enter a person or keyword you would like to search for: ");
            String searchValue = scanner.nextLine();
            Pattern p = Pattern.compile(searchValue,Pattern.CASE_INSENSITIVE);
            for(Map.Entry<String,String> entry :note.map.entrySet()) {
                String input = entry.getValue();
                Matcher m = p.matcher(input);
                if(m.find()){
                    note.filesToPrint.add(entry.getKey());
                }
            }
            note.printFilesToPrint();
            System.out.println();
        }


        if (key.equalsIgnoreCase("f")) {
                //topological sort
            System.out.println();

        }
    }
}
