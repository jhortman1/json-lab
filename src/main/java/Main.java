import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EventHandler eventHandler = new EventHandler();
        List<Person>personList=new ArrayList<Person>();
        FileReader fileReader = new FileReader();
        //Ask the user if they want to restore the list of people from file.
        // If yes, restore from the file you might have saved from a previous run of your program.
        // If no, start a brand-new list.
        String prompt = "Would you like to restore person list from backup?";
        String yORn="";
        do{
            yORn = eventHandler.responseHandler(sc,prompt);
        }while(!yORn.equals("y") && !yORn.equals("n"));
        if(yORn.equalsIgnoreCase("y"))
        {
            personList = fileReader.readFromFile("PersonList.csv");
        }
        //Ask user to do one of the following
        //Add a person to the list.
        //Print a list of current persons.
        //Exit the program.
        int choice = 0;
        do {
            prompt = "Please choose one of the following options:\n" +
                    "Enter 1 to add a person to the list\n" +
                    "Enter 2 to Print a list of current persons\n" +
                    "Enter 3 to exit the program";
            choice = eventHandler.handleInput(sc, prompt);

            switch (choice) {
                case 1:
                    Person p = eventHandler.createPerson(sc);
                    personList.add(p);
                    break;
                case 2:
                    eventHandler.printListOfCurrentPersons(personList);
                    break;
                case 3:
                    System.out.println("Exiting Program...Saving all persons to file");
                    eventHandler.writePeopleToFileCSV(personList);
                    System.exit(0);
                    break;
            }
        }while(choice!=3);
    }
}
