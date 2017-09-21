import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Note {
    Vector<File> filesForRead = new Vector<>();
    Vector<String> filesToPrint = new Vector<>();
    Vector<String> keywords = new Vector<>();
    Map<String,String> map = new HashMap<>();
    Vector<String> mentionList = new Vector<>();

    public void readFiles(String path){
        /*stores file names in vector. Only allows for .txt files*/
        File folder = new File(path);

        for(File file :folder.listFiles()){
            String fileName = file.toString();
            if(fileName.contains(".txt")&& file.isFile()){
                filesForRead.add(file);
            }
        }
    }

    public void getNotesFromFiles() throws IOException {//open files and read them


        String[] fileNames= new String[filesForRead.size()];

        for (int i = 0; i<filesForRead.size();i++) {
            String fileName = filesForRead.get(i).getName();
            String filePath = filesForRead.get(i).getPath();

            StringBuffer contents = new StringBuffer();
            BufferedReader reader = new BufferedReader(
                    new FileReader(filePath));
            char[] ch = new char[9000000];
            int n = 0;
            while ((n = reader.read(ch)) != -1) {
                contents.append(ch, 0, n);
            }
            reader.close();
            String fileContent = contents.toString();

            map.put(fileName,fileContent);

        }


    }

    public void iterateMapSearch(String searchValue){//goes through map with search value

        for(Map.Entry<String,String> entry : map.entrySet()){
            String value = entry.getValue();
            String key = entry.getKey();
            String mentionedWord = "";
            if(value.contains(searchValue)){
                int prevIndex = value.indexOf(searchValue)-1;
                char prevChar = value.charAt(prevIndex);
                int currentIndex = value.indexOf(searchValue);
                char currentChar = value.charAt(currentIndex);
                while(currentChar != ' ' && currentChar !='\n'){//looks for end of word or end of line
                    mentionedWord += value.charAt(currentIndex);
                    currentIndex++;
                    currentChar = value.charAt(currentIndex);
                }
                if(prevChar == ' ' || prevIndex == -1){//prevents emails from being included
                    if(filesToPrint.contains(key)){
                        continue;
                    }else{
                        filesToPrint.add(key + ": " + mentionedWord);
                    }
                }
            }
        }
    }
    public void printFilesToPrint(){ //prints files containing mentions
        for(String key : filesToPrint){
            System.out.println(key);
        }
    }

    public void printFilesToPrintSorted(){ //prints files containing mentions in alphabetical order
        for(String key : filesToPrint){
            mentionList.add(key);
        }
        java.util.Collections.sort(mentionList, String.CASE_INSENSITIVE_ORDER);
        for(String key : mentionList){
            System.out.println(key);
        }
    }

    public void generateKeywords() throws IOException{ //generates a unique list of keywords for a file
        //these are just a test

        for(String key : filesToPrint) {
            int totalWordCount = 0;
            int threshold;
            int wordAppearance = 0;
            String word = "hello";
            //words into a map:  key is word, value is wordAppearance
            //get word count of file
            //get appearance of each word

            threshold = (totalWordCount/4);
            if (wordAppearance>=threshold){
                keywords.add(word);
            }
            System.out.println("FILE:   " + key + "     KEYWORDS:   " + keywords);
            System.out.println();
            keywords.clear();
        }
    }

    public void generateKeywordsSorted() throws IOException{ //generates a unique list of keywords for a file
        //these are just a test

        for(String key : filesToPrint) {
            int totalWordCount = 0;
            int threshold;
            int wordAppearance = 0;
            String word = "hello";

            keywords.add("apple");
            keywords.add("crab");
            keywords.add("banana");

            //words into a map:  key is word, value is wordAppearance
            //get word count of file
            //get appearance of each word

//            threshold = (totalWordCount/4);
//            if (wordAppearance>=threshold){
//                keywords.add(word);
//            }
            java.util.Collections.sort(keywords, String.CASE_INSENSITIVE_ORDER);

            System.out.println("FILE:   " + key + "     KEYWORDS:   " + keywords);
            System.out.println();
            keywords.clear();
        }
    }
}
