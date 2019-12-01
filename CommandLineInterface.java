import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;

public class CommandLineInterface {

    private ArrayList<String> nameList;

    public void buildList() throws IOException {

        if (csvProvided()) {

            nameList = new ArrayList<>(extractFromCSV());

        } else {

            nameList = new ArrayList<>(buildFromEntries());

        }
    }

    public  void output(Hashtable<String, String> matchTable) {

        String name;
        int numNames = nameList.size();

        Scanner reader = new Scanner(System.in);

        for (int i = 0; i < numNames; i++) {

            name = nameList.get(i);

            System.out.println("Hello " + name + ", press enter.");

            reader.nextLine();

            System.out.println(".");
            System.out.println("..");
            System.out.println("...");
            System.out.println("Congratulations, your secret Santa is " + matchTable.get(name));

            if (i == numNames - 1) {
                System.out.println("Now press Enter, selection is finished.");

                reader.nextLine();

                for (int j = 0; j < 1000; j++) {

                    System.out.println("Tis the season to be Jolly");

                }
            } else {
                System.out.println("Now press Enter and call " + nameList.get(i + 1) + " in.");

                reader.nextLine();

                for (int j = 0; j < 1000; j++) {

                    System.out.println("Tis the season to be Jolly");

                }
            }
        }
    }

    private boolean csvProvided() {

        while (true) {

            System.out.println("Do you have a CSV file for input? y/n");

            Scanner reader = new Scanner(System.in);
            String input = reader.nextLine();

            if (input.equals("y") | input.equals("Y")) {

                return true;

            } else if (input.equals("n") | input.equals("N")) {

                return false;

            }
        }
    }

    private ArrayList extractFromCSV() throws IOException {

        String fileName = "SantasList.csv";
        BufferedReader bufferedReader = null;
        String csvSplitBy = ",";

        bufferedReader = new BufferedReader(new FileReader(fileName));

        String line = bufferedReader.readLine();

        return new ArrayList<>(Arrays.asList(line.split(csvSplitBy)));

    }

    private ArrayList<String> buildFromEntries() {

        ArrayList<String> result = new ArrayList<>();
        int numNames;

        System.out.println("How many people are participating?");

        Scanner reader = new Scanner(System.in);
        String input = reader.nextLine();

        try {

            numNames = Integer.parseInt(input);

        } catch (NumberFormatException nfe) {

            System.out.println("Input was not a number");
            throw nfe;

        }

        for (int i = 1; i <= numNames; i++) {

            System.out.println("Please enter name " + i + ":");

            reader = new Scanner(System.in);
            input = reader.nextLine();

            result.add(input);

        }

        return result;

    }

    public ArrayList<String> getList() {

        return nameList;

    }
}
