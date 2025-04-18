package solution.converter;


import solution.listofcurrency.Currency;
import solution.listofcurrency.ListOfCurrency;
import solution.getdata.GetDataFromUser;

public class Convert {
    private final ListOfCurrency listOfCurrency = ListOfCurrency.getInstance();
    private GetDataFromUser gdfu = new GetDataFromUser();

    private String code1 = "";
    private String code2 = "";
    private float quote = 0;
    private float quoteAfterExchange = 0;

    private float ratio1 = 0;
    private float ratio2 = 0;
    private float rate1 = 0;
    private float rate2 = 0;

    public float getQuoteAfterExchange() {
        return quoteAfterExchange;
    }

    public String getCode2() {
        return code2;
    }

    private void input() {
        System.out.println("Podaj kod waluty 1: ");
        code1 = gdfu.inputCode();
        System.out.println("Podaj kod waluty 2: ");
        code2 = gdfu.inputCode();
        System.out.println("Podaj ilosc srodków dla transfera: ");
        quote = gdfu.inputQuote();
    }

    private void setRateAndRatio() {
        input();

        for (Currency currency : listOfCurrency.getListOfCurrency()) {
            if (currency.getCurrencyCode().equals(code1)) {
                ratio1 = currency.getRatio();
                rate1 = currency.getRate();
            }

            if (currency.getCurrencyCode().equals(code2)) {
                ratio2 = currency.getRatio();
                rate2 = currency.getRate();
            }
        }
    }

    public void convert() {
        setRateAndRatio();

        quoteAfterExchange = quote * ((rate1 * ratio2) / (rate2 * ratio1));
    }
}
