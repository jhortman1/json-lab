import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

public class EventHandler {
//        Adding a person to the list:
//        Ask the user for the person's information.
//        Add the new person to your person's list.
//        Return the user to the 3 options from before.
    public Person createPerson (Scanner sc)
    {
        String firstName, lastName;
        int age = 0;
        firstName = responseHandler(sc,"Enter First name: ");
        lastName = responseHandler(sc,"Enter Last name: ");

        Person p = new Person(firstName, lastName);
        return p;
    }
    public String responseHandler(Scanner sc, String prompt)
    {
        System.out.println(prompt);
        if(!sc.hasNextLine()){
            responseHandler(sc,prompt);
        }
        String returnString = sc.nextLine();
        return returnString;
    }
//        Printing a list of current persons:
//        Print the person information for each person on your current list.
//        Return the user to the 3 options from before.
    public void printListOfCurrentPersons(List<Person> personList)
    {
        for (Person p : personList ) {
            Logger.getInstance().log(p.toString());
        }
    }
//        Exit the program:
//        On program exit, save all the persons on your list to your file.
    public void writePeopleToFileCSV(List<Person> personList)
    {
        try(FileWriter fileWriter = new FileWriter("PersonList.csv"))
        {
            for (Person p : personList) {
                fileWriter.write(p.toString());
            }
        }catch(Exception e)
        {
            Logger.getInstance().log("File Error");
        }
    }
    public void writePeopleToFileJSON(List<Person> personList) throws JsonProcessingException {
        String json = new ObjectMapper().writeValueAsString(personList);
        try(FileWriter fileWriter = new FileWriter("PersonList.json"))
        {
            fileWriter.write(json);
        }catch(Exception e)
        {
            Logger.getInstance().log("File Error");
        }
    }
    public int handleInput(Scanner sc, String prompt) {
        int choice = 0;
        System.out.println(prompt);
        if (!sc.hasNextLine()) {
            handleInput(sc, prompt);
        }
        try {
            choice = Integer.parseInt(sc.nextLine());
            if(choice>3 || choice<1)
            {
                handleInput(sc, prompt);
            }
        } catch (Exception e) {
            System.out.println("Invalid Input...");
            handleInput(sc, prompt);
        }
        return choice;
    }

}
