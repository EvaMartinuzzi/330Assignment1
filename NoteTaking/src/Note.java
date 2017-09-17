import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

public class Note {
    Vector<File> filesForRead = new Vector<>();

    public void readFiles(String path){
        /*stores file names in vector. Only allows for .txt files*/
        File folder = new File(path);

        for(File file :folder.listFiles()){
            String fileName = file.toString();
            if(fileName.contains(".txt")&& file.isFile()){
                filesForRead.add(file);
            }
        }
        //for testing purposes
        /*for(File file : filesForRead){
            if(file.isFile()){
                System.out.println(file.getName());
            }
        }*/
    }

    public void getNotesFromFiles() throws IOException {//open files and read them
        Map<String,String> map = new HashMap<>();
        String[] fileNames= new String[filesForRead.size()];

        for (int i = 0; i<filesForRead.size();i++) {
            String fileName = filesForRead.get(i).getName();
            String filePath = filesForRead.get(i).getPath();
            fileNames[i] = filesForRead.get(i).getName();

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
}

