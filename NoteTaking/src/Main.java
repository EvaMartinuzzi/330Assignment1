import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws IOException {
        Note note = new Note();

        /*Asks for path to folder that contains file*/
        System.out.println("Please enter path to folder containing .txt files:");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        scanner.close();
        note.readFiles(path);
        note.getNotesFromFiles();

        System.out.println("Please select how you want to view your notes: ");
        System.out.println(  "A. Display all notes with mentions (ex: @, #)" +
                           "\nB. Display all notes, organized by mention (ex @, #" +
                           "\nC. Display all searched keywords" +
                           "\nD. Search notes for a keyword as plaintext and mention" +
                           "\nE. Search all notes for keyword" +
                           "\nF. Search all notes for keyword as a mention" +
                           "\nG. Dispaly all notes by occurence of search word");
        Scanner scanner = new Scanner(System.in);
        scanner.toLowerCase();
        String sortChoice = scanner.nextLine();
        scanner.close();

        if (sortChoice=="a"){
            //show all notes with mentions
        }
        if (sortChoice=="b"){
            //show all notes organized by mention
        }
        if (sortChoice=="c"){
            //show all searched keywords
        }

        switch (sortChoice){
            case 2:  sortChoice = "d";
                search(sortChoice);
                break;
            case 3:  sortChoice = "e";
                search(sortChoice);
                break;
            case 4:  sortChoice = "f";
                search(sortChoice);
                break;
            case 5:  sortChoice = "g";
                search(sortChoice);
                break;
        }

        String search(String x){
            System.out.println("Please enter the keyword you would like to search: ");
            Scanner scanner = new Scanner(System.in);
            String keyword = scanner.nextLine();
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
}
