import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    public List<Person> readFromFileJSON(String fileName) throws IOException {
        List<Person> personList = Arrays.asList(new ObjectMapper().readValue(new File(fileName), Person[].class));
        return personList;
    }
}
