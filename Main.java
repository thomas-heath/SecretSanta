import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        CommandLineInterface commandLineInterface = new CommandLineInterface();
        commandLineInterface.buildList();

        NameManipulator santaPicker = new NameManipulator(commandLineInterface.getList());
        santaPicker.match();

        commandLineInterface.output(santaPicker.getMatches());

    }
}
