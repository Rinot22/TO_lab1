package solution.menu;

import solution.converter.Convert;
import solution.getdata.GetDataFromUser;
import solution.printer.PrintInfo;
import solution.printer.PrintMenu;

import static java.lang.System.exit;

public class Menu {
    private final GetDataFromUser gdfu = new GetDataFromUser();
    private final PrintInfo pi = new PrintInfo();
    private final Convert c = new Convert();

    public void chooseAnOption() {
        PrintMenu.printMenu();

        System.out.print("\nWybiez opcje: ");

        int op = gdfu.inputOption();

        switch (op) {
            case 1:
                pi.printListOfCurrencies();
                chooseAnOption();
            case 2:
                System.out.print("Podaj kod interesującej waluty: ");
                pi.printOneCurrency(gdfu.inputCode());
                chooseAnOption();
            case 3:
                c.convert();
                pi.printResultOfExchange(c.getQuoteAfterExchange(), c.getCode2());
                chooseAnOption();
            case 4:
                System.out.println("Wyjscie...");
                exit(0);
            default:
                try {
                    System.out.println("Cos poszlo nie tak. Sproboj jeszcze raz.");
                    chooseAnOption();
                } catch (Exception e) {}
        }
    }
}
