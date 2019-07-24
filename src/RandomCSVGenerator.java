import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RandomCSVGenerator {

    private final String [] LIST_OF_COUNTRIES = {"United States", "Canada", "Mexico", "Brazil", "Great Britain", "Germany",
            "China", "India", "South Africa", "Russia", "Mongolia", "Chile", "France", "Spain", "Argentina", "Australia"};

    private Random rand;
    private File file;
    private FileWriter writer;


    /**
     * Constructor for RandomCSVGenerator
     * @param fileName - fileName of the file to be rewritten / created
     * @throws IOException - exception if the the file is not correctly opened
     */
    public RandomCSVGenerator(String fileName) throws IOException {
        rand = new Random();
        file = new File(fileName);
        writer = new FileWriter(file);
    }

    /**
     * Creates a file with a random number of countries
     * @param indicatorType - type of data that is stored in the file
     * @param startYear - starting year for the data
     * @param numYears - number of years to be generated
     * @throws IOException - exception if the the file is not correctly opened
     */
    public void createFile(String indicatorType, int startYear, int numYears) throws IOException {
        String type;
        int randomCap = 0;
        int numCountries = rand.nextInt(12) + 3;
        int currYear = startYear;

        if(indicatorType.equals("primary")){
            type = "School Enrollment In Primary (% net)";
            randomCap = 100;
        }
        else if(indicatorType.equals("secondary")){
            type = "School Enrollment In Secondary (% net)";
            randomCap = 100;
        }
        else if(indicatorType.equals("gdp")){
            type = "GDP per capita (current US$)";
            randomCap = 50000;
        }
        else{
            type = "Invalid Indicator";
        }

        writer.write("Data Source,World Development Indicators,,,,,,,,,,,\n");
        writer.write("Indicator," + type + ",,,,,,,,,,,\n");
        writer.write("Last Updated Date,7/25/18,,,,,,,,,,,\n");
        writer.write("Number of Countries," + numCountries + ",,,,,,,,,,,\n");
        writer.write("Country Name");
        for(int i = 0; i < numYears; i++){
            writer.write("," + Integer.toString(currYear));
            currYear++;
        }
        writer.write("\n");
        for(int i = 0; i < numCountries; i++){
            String currCountry = LIST_OF_COUNTRIES[i];
            writer.write(currCountry);
            for(int j = 0; j < numYears; j++){
                double randomData = rand.nextDouble() * randomCap;
                // add chance for missing data if the random data is generated under 25
                if(randomData < randomCap / 4)
                {
                    randomData = -1;
                }
                if(randomData == -1){
                    writer.write(",");
                }
                else {
                    writer.write("," + randomData);
                }
            }
            writer.write("\n");
        }
            writer.close();
    }

    /**
     * Creates a file with a set number of countries
     * @param indicatorType - type of data that is stored in the file
     * @param startYear - starting year for the data
     * @param numYears - number of years to be generated
     * @param numCountries - number of countries to be added to the file
     * @throws IOException - exception if the the file is not correctly opened
     */
    public void createFile(String indicatorType, int startYear, int numYears, int numCountries) throws IOException {
        String type;
        int randomCap = 0;;
        int currYear = startYear;

        if(indicatorType.equals("primary")){
            type = "School Enrollment In Primary (% net)";
            randomCap = 100;
        }
        else if(indicatorType.equals("secondary")){
            type = "School Enrollment In Secondary (% net)";
            randomCap = 100;
        }
        else if(indicatorType.equals("gdp")){
            type = "GDP per capita (current US$)";
            randomCap = 50000;
        }
        else{
            type = "Invalid Indicator";
        }

        writer.write("Data Source,World Development Indicators,,,,,,,,,,,\n");
        writer.write("Indicator," + type + ",,,,,,,,,,,\n");
        writer.write("Last Updated Date,7/25/18,,,,,,,,,,,\n");
        writer.write("Number of Countries," + numCountries + ",,,,,,,,,,,\n");
        writer.write("Country Name");
        for(int i = 0; i < numYears; i++){
            writer.write("," + Integer.toString(currYear));
            currYear++;
        }
        writer.write("\n");
        for(int i = 0; i < numCountries; i++){
            String currCountry = LIST_OF_COUNTRIES[i];
            writer.write(currCountry);
            for(int j = 0; j < numYears; j++){
                double randomData = rand.nextDouble() * randomCap;
                // add chance for missing data if the random data is generated under 25
                if(randomData < randomCap / 4)
                {
                    randomData = -1;
                }
                if(randomData == -1){
                    writer.write(",");
                }
                else {
                    writer.write("," + randomData);
                }
            }
            writer.write("\n");
        }
        writer.close();
    }


}
