
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import org.w3c.dom.Document;
import java.util.regex.*;
import java.util.*;
import javax.swing.*;
import java.net.*;

/**
 * Represents a virtual weather station.
 * Informationen is retrieved from Yahoo Weather.
 *
 * @author Thomas Karp
 * @version 26.4.2008. Jetzt mit Proxy und Array der Städtenamen. Groß/Kleinschreibung bei
 * Namen der Städte ist nun egal.
 */
public class WeatherStation {

    private HashMap<String, String> cityCodes;
    private boolean searchByName;
    private Document xmlData;
    private String cityName;
    private String yahooCityName;
    private String cityCode;
    private int temperature;
    private int humidity;
    private String sunrise;
    private String sunset;
    private String imgURL;
    private ImageIcon icon;
    private boolean online;
    // Defaultwerte für FMSG passend
    private String proxyHost = "192.168.0.254";
    private int proxyPort = 3128;

    /**
     * Create a new WeatherStation. Default location is berlin.
     * Station is set online.
     */
    public WeatherStation() {
        cityCodes = new HashMap<String, String>();
        fillCityCodes();
        setCityName("Berlin");
        online = true;
    }

    /**
     * Set some cities that can be accessed by their names.
     */
    private void fillCityCodes() {
        // all cities lowercase!
        cityCodes.put("Speyer", "GMXX4638");
        cityCodes.put("Mannheim", "GMXX0081");
        cityCodes.put("Berlin", "GMXX1273");
        cityCodes.put("München", "GMXX0087");
        cityCodes.put("Frankfurt", "GMXX0040");
        cityCodes.put("Hamburg", "GMXX0049");
        cityCodes.put("Karlsruhe", "GMXX0063");
        cityCodes.put("Köln", "GMXX0018");
        cityCodes.put("Rom", "ITXX0067");
        cityCodes.put("Kapstadt", "SFXX0010");
        cityCodes.put("Rio de Janeiro", "BRXX0201");
    }

    /**
     * @return Name of the choosen city.
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * @return Names of all available cities.
     */
    public String[] getCityNames() {
        Set<String> namen = cityCodes.keySet();
        return namen.toArray(new String[0]);
    }

    /**
     * @return Name returned by Yahoo weather service.
     */
    public String getYahooCityName() {
        return yahooCityName;
    }

    /**
     * Set code of the city. Code should be like: GMXX0018.
     * You can visit the yahoo weather page to look for existing codes.
     * @param The code of the city.
     */
    public void setCityCode(String code) {
        cityCode = code;
        searchByName = false;
    }

    /**
     * @return Code of the city.
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * Set the location of the WeaterStation. City is only changed when found in the list.
     * @param name of the city.
     * @return true, if city exists, false if city was not found.
     */
    public boolean setCityName(String city) {
        for (String key : cityCodes.keySet()) {
            if (key.equalsIgnoreCase(city)) {
                cityName = city;
                searchByName = true;
                cityCode = cityCodes.get(key);
                return true;
            }
        }
        return false;
    }

    /**
     * Get the temperature at the city.
     */
    public int getTemperature() {
        return temperature;
    }

    /**
     * Get the humidity at the city.
     */
    public int getHumidity() {
        return humidity;
    }

    /**
     * Get the sunrise at the city.
     */
    public String getSunrise() {
        return sunrise;
    }

    /**
     * Get the sunset at the city.
     */
    public String getSunset() {
        return sunset;
    }

    /**
     * Get an url of an icon that represents the weather.
     * @return URL of image representing the actual weather.
     */
    public String getImgURL() {
        return imgURL;
    }

    /**
     * Get an ImageIcon representing the weather.
     */
    public ImageIcon getIcon() {
        return icon;
    }

    /**
     * Set online for real data. Set Offline for testing purposes without internet connection.
     * When offline random values are generated.
     * @param New online status: true if online, false if offline
     */
    public void setOnline(boolean isOnline) {
        online = isOnline;
        if (!online) {
            setDummyValues();
        }
    }

    /**
     * Get the status of the station.
     * @return true if online. false if offline.
     */
    public boolean isOnline() {
        return online;
    }

    /**
     * Download the XML-Document from Yahoo weather.
     */
    private void loadXMLDocument() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            xmlData = builder.parse("http://xml.weather.yahoo.com/forecastrss?p=" + cityCode + "&u=c");
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    /**
     * Parse the XML-Document, that contains the information.
     */
    private void scanXMLDocument() {
        XPath xpath = XPathFactory.newInstance().newXPath();
        try {
            // Check, if document seems to be valid
            if (xpath.evaluate("/rss/channel/description", xmlData).equals("Yahoo! Weather Error")) {
                // Throw a RuntimeException, because students should not be forced to handle it,
                // if they don't know Exceptions yet
                throw new RuntimeException("Error while reading weather data. Perhaps the code of the city was incorrect...");
            }

            // get content by XPath
            yahooCityName = xpath.evaluate("/rss/channel/location/@city", xmlData);
            humidity = Integer.valueOf(xpath.evaluate("/rss/channel/atmosphere/@humidity", xmlData));
            sunrise = xpath.evaluate("/rss/channel/astronomy/@sunrise", xmlData);
            sunset = xpath.evaluate("/rss/channel/astronomy/@sunset", xmlData);

            if (!searchByName) {
                cityName = yahooCityName;
            }
            temperature = Integer.valueOf(xpath.evaluate("/rss/channel/item/condition/@temp", xmlData));
            // Since the description is not XML, the content has to be searched by hand
            String description = xpath.evaluate("/rss/channel/item/description", xmlData);
            imgURL = find("<img src=\".*\"/>", description); // search first img-tag
            imgURL = imgURL.substring(10, imgURL.length() - 3); // get src
            icon = new ImageIcon(new URL(imgURL));
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    /**
     * Update weather data. If not online, dummy values are set for testing purposes.
     */
    public void update() {
        if (online) {
            loadXMLDocument();
            scanXMLDocument();
        } else {
            setDummyValues();
        }
    }

    // Returns the first substring in input that matches the pattern.
    // Returns null if no match found.
    // Source: http://exampledepot.com/egs/java.util.regex/Greedy.html
    private String find(String patternStr, CharSequence input) {
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    /**
     * Set random values for testing.
     */
    private void setDummyValues() {
        Random random = new Random();
        cityName = "Offlinecity" + Math.abs(random.nextInt(1000));
        yahooCityName = cityName;
        cityCode = "TheCityCode";
        temperature = random.nextInt(40);
        humidity = random.nextInt(101);
        sunrise = "morning";
        sunset = "evening";
        imgURL = null;
    }

    /**
     * Schaltet die Benutzung des Proxy-Servers an oder aus.
     * 
     * @param state true für an, false für aus.
     */
    public void setProxy(boolean state) {
        if (state == false) {
            System.clearProperty("proxySet");
            System.clearProperty("proxyHost");
            System.clearProperty("proxyPort");
        } else {
            System.setProperty("proxySet", "true");
            System.setProperty("proxyHost", proxyHost);
            System.setProperty("proxyPort", ((Integer) proxyPort).toString());
        }
    }

    public void setProxyHost(String host) {
        proxyHost = host;
        setProxy(false);
        setProxy(true);
    }

    public void setProxyPort(int port) {
        proxyPort = port;
        setProxy(false);
        setProxy(true);
    }
}