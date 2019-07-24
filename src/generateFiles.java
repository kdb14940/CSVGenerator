import java.io.IOException;
import java.util.Scanner;

public class generateFiles {

    public static void main(String[] args) throws IOException {

        Scanner keyboard = new Scanner(System.in);
        int startingYear = 0;
        int numYears = 0;
        int numCountries = 0;
        String indicatorType = "";
        System.out.println("Enter the full directory of the file: ");
        String filename = keyboard.nextLine();

        // TODO exception handling
        System.out.println("Enter the starting year for the data: ");
        startingYear = keyboard.nextInt();
        System.out.println("Enter the number of years to be generated: ");
        numYears = keyboard.nextInt();
        System.out.println("Enter the number of countries to be generated ( 1 - 16): ");
        numCountries = keyboard.nextInt();
        System.out.println("Which indicator type would you like to generate?");
        System.out.println("Enter 1 for \"Primary Enrollment\"");
        System.out.println("Enter 2 for \"Secondary Enrollment\"");
        System.out.println("Enter 3 for \"GDP per Capita\"");

        int choice = keyboard.nextInt();
        switch(choice)
        {
            case 1: indicatorType = "primary";
                    break;
            case 2: indicatorType = "secondary";
                    break;
            case 3: indicatorType = "gdp";
                    break;
            default: indicatorType = "";
        }

        RandomCSVGenerator generator = new RandomCSVGenerator(filename);
        generator.createFile(indicatorType, startingYear, numYears, numCountries);

        System.out.println("File successfully created.");
    }
}
