package solution.printer;

import solution.listofcurrency.Currency;
import solution.listofcurrency.ListOfCurrency;

public class PrintInfo {
    private final ListOfCurrency listOfCurrency = ListOfCurrency.getInstance();

    public void printListOfCurrencies() {
        for (Currency currency : listOfCurrency.getListOfCurrency()) {
            System.out.println("Nazwa waluty: " + currency.getCurrencyName());
            System.out.println("Przelicznik: " + currency.getRatio());
            System.out.println("Kod waluty: " + currency.getCurrencyCode());
            System.out.println("Kurs sredni: " + currency.getRate());
            System.out.println("<--------------------------------------------->\n");
        }
    }

    public void printOneCurrency(String code) {
        for (Currency currency : listOfCurrency.getListOfCurrency())
            if (currency.getCurrencyCode().equals(code)) {
                System.out.println("\nNazwa waluty: " + currency.getCurrencyName());
                System.out.println("Przelicznik: " + currency.getRatio());
                System.out.println("Kod waluty: " + currency.getCurrencyCode());
                System.out.println("Kurs sredni: " + currency.getRate());
                System.out.println("<--------------------------------------------->\n");
            }
    }

    public void printResultOfExchange(float quote, String code) {
        System.out.printf("After exchange you have %.2f%s\n", quote, code);
    }
}