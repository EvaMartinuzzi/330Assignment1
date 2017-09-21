import static com.sun.jmx.snmp.ThreadContext.contains;
import static javafx.beans.binding.Bindings.when;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Tests {
    Search search = new Search();
    Note note = new Note();
    Main main = new Main();

    @Test
    public void testOptionAOutput() throws IOException{
        //option A should have a .txt and @ output
        search.searchBy("a");
    }

    @Test
    public void testOptionBOutput()throws IOException{
        //option B should have a .txt and @ output alphabetized
        search.searchBy("b");
    }

    @Test
    public void testOptionCOutput()throws IOException{
        //option C should have a .txt file and a list of keywords
        search.searchBy("c");
    }


    @Test
    public void testOptionDOutput()throws IOException{
        //option D should have a .txt and list of keywords alphabetized
        search.searchBy("d");
    }


    @Test
    public void testOptionEOutput()throws IOException{
        //option E should have a .txt output from a search
        search.searchBy("e");
    }


    @Test
    public void testOptionFOutput()throws IOException{
        //Option F should list all .txt files
        search.searchBy("f");
    }


}