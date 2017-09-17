import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws IOException {
        List<String> keywordArray = new ArrayList<String>();
        options(keywordArray);
    }

    public static void options(List<String> keywordArray) throws IOException{
        Note note = new Note();
        Search search = new Search();

        /*Asks for path to folder that contains file*/
        System.out.println("Please enter path to folder containing .txt files:");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        note.readFiles(path);
        note.getNotesFromFiles();

        System.out.println("\nPlease select how you want to view your notes: ");
        System.out.println("A. Display all notes with mentions (ex: @, #)" +
                "\nB. Display all notes, organized by mention (ex @, #" +
                "\nC. Display all searched keywords" +
                "\nD. Search notes for a keyword as plaintext and mention" +
                "\nE. Search all notes for keyword" +
                "\nF. Search all notes for keyword as a mention" +
                "\nG. Dispaly all notes by occurence of search word"+
                "\nH. Exit");
        String sortChoice = scanner.nextLine();
        sortChoice = sortChoice.toLowerCase();

        //ask for search terms
        if (sortChoice.equals("a") || sortChoice.equals("b") || sortChoice.equals("c")) {
            String keyword = scanner.nextLine();
            search.searchBy(keyword, sortChoice, keywordArray);
        }
        else if (sortChoice.equals("h")){
            System.exit(1);
        }
        else {
            System.out.println("What are you searching for?");
            String keyword = scanner.nextLine();
            keywordArray.add(keyword);
            search.searchBy(keyword, sortChoice, keywordArray);
        }
    }
}

