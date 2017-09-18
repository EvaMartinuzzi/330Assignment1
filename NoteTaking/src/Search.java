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



    public void setMap() throws IOException {
        note.readFiles(main.path);
        note.getNotesFromFiles();
    }
    public void searchBy(String keyword,String key, List<String> keywordArray) throws IOException {
        if (key.equalsIgnoreCase("a")) {
            //display all notes with mentions
            System.out.println("These files contain mentions: \n");
            note.iterateMapSearch("@");
            note.iterateMapSearch("#");
            note.iterateMapSearch("!");
            note.iterateMapSearch("^");
            note.printFilesToPrint();
        }

        if (key.equalsIgnoreCase("b")) {
            //display all notes organized by mention
            System.out.println("\nThese files contain @ mentions: \n");
            note.iterateMapSearch("@");
            note.printFilesToPrint();
            note.filesToPrint.clear();

            System.out.println("\nThese files contain # mentions: \n");
            note.iterateMapSearch("#");
            note.printFilesToPrint();
            note.filesToPrint.clear();

            System.out.println("\nThese files contain ! mentions: \n");
            note.iterateMapSearch("!");
            note.printFilesToPrint();
            note.filesToPrint.clear();

            System.out.println("\nThese files contain ^ mentions: \n");
            note.iterateMapSearch("^");
            note.printFilesToPrint();
            note.filesToPrint.clear();

            System.out.println("\nThese files contain URL mentions: \n");
            note.iterateMapSearch(".com");
            note.iterateMapSearch(".org");
            note.iterateMapSearch(".net");
            note.iterateMapSearch(".edu");
            note.printFilesToPrint();
            note.filesToPrint.clear();


            //display @ then # then ! then ^ then .com
        }
        if (key.equalsIgnoreCase("c")) {
            //display every item in keywordArray
            System.out.println("These are the keywords you have searched for: ");
            for(String keywords : keywordArray){
                System.out.println(keywords);
            }
        }

        if (key.equalsIgnoreCase("d")) {
            //search all notes for keyword as both keyword and mention
        }

        if (key.equalsIgnoreCase("e")) {
                //search all notes for keyword
                //search if it contains keyword
        }

        if (key.equalsIgnoreCase("f")) {
                //search all notes for keyword as mention
                //search for exactly what you type
            Pattern p = Pattern.compile(".*\\b"+keyword+"\\b.*");//searches for whole word
            for(Map.Entry<String,String> entry :note.map.entrySet()) {
                String input = entry.getValue();
                Matcher m = p.matcher(input);
                if(m.find()){
                    note.filesToPrint.add(entry.getKey());
                }
            }
            note.printFilesToPrint();
        }

        if (key.equalsIgnoreCase("g")) {
                //topological sort
        }

            main.options(keywordArray);
        }
}
