import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
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
        for (int i = 0; i<filesForRead.size();i++) {
            String filePath = filesForRead.get(i).toString();
            String fileName = filesForRead.get(i).getName();
            String content = new String(Files.readAllBytes(Paths.get(filePath)));//throws IOException

            map.put(fileName,content);
        }
        System.out.println(map.size());
    }

}

