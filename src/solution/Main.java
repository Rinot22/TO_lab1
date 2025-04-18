package solution;


import solution.menu.Menu;
import solution.parser.Parser;

public class Main {
    private static final Menu m = new Menu();

    public static void main(String[] args) {
        try {
            Parser.parseTable();
        } catch (Exception e) {
            System.err.println("Parser error: " + e);
        }

        m.chooseAnOption();
    }
}
