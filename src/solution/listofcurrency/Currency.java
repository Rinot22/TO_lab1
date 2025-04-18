package solution.listofcurrency;

public class Currency {
    private final String currencyName;
    private final float ratio;
    private final String currencyCode;
    private final float rate;

    public Currency(String currencyName, float ratio, String currencyCode, float rate)  {
        this.currencyName = currencyName;
        this.ratio = ratio;
        this.currencyCode = currencyCode;
        this.rate = rate;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public float getRatio() {
        return ratio;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public float getRate() {
        return rate;
    }
}
