import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    public List<Person> readFromFile (String fileName)
    {
        List<Person> personList = new ArrayList<>();
        String returnPersonString = "";
        String firstName, lastName;
        Scanner fileReader = null;
        try{
            File personFile = new File(fileName);
            fileReader = new Scanner(personFile);
            while (fileReader.hasNextLine()) {
                returnPersonString = fileReader.nextLine();
                String[] name = returnPersonString.split(",");
                firstName = name[0];
                lastName = name [1];
                Person p = new Person(firstName,lastName);
                personList.add(p);
            }
        }catch (Exception e)
        {
            Logger.getInstance().log("File Error");
        }
        return personList;
    }
}
