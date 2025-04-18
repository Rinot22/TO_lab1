package solution.parser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import solution.listofcurrency.Currency;
import solution.listofcurrency.ListOfCurrency;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;

public class Parser {
    private static final ListOfCurrency listOfCurrency = ListOfCurrency.getInstance();

    public static void parseTable() {
        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = db.parse(String.valueOf(new URL("https://www.nbp.pl/kursy/xml/lasta.xml")));
            document.getDocumentElement().normalize();
            NodeList nd = document.getElementsByTagName("pozycja");

            for (int i = 0; i < nd.getLength(); i++) {
                Node nNode = nd.item(i);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element el = (Element) nNode;

                    String nameOfCurrency = el.getElementsByTagName("nazwa_waluty")
                            .item(0).getTextContent();

                    float ratioOfCurrency = Float.parseFloat(el
                            .getElementsByTagName("przelicznik").item(0)
                            .getTextContent().replace(",", "."));

                    String codeOfCurrency = el.getElementsByTagName("kod_waluty")
                            .item(0).getTextContent();

                    float rateOfExchange = Float.parseFloat(el
                            .getElementsByTagName("kurs_sredni").item(0)
                            .getTextContent().replace(",", "."));

                    listOfCurrency.addCurrency(new Currency(nameOfCurrency,
                            ratioOfCurrency, codeOfCurrency, rateOfExchange));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}