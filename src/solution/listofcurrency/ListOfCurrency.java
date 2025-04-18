package solution.listofcurrency;

import java.util.ArrayList;
import java.util.List;

public class ListOfCurrency {
    private static ListOfCurrency instance = null;
    private final List<Currency> listOfCurrency = new ArrayList<>();

    private ListOfCurrency() {}

    public void addCurrency(Currency currency) {
        listOfCurrency.add(currency);
    }

    public List<Currency> getListOfCurrency() {
        return listOfCurrency;
    }

    public static ListOfCurrency getInstance() {
        if (instance == null) {
            instance = new ListOfCurrency();
        }

        return instance;
    }
}
