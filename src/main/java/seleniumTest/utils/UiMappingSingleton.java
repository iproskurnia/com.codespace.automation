package seleniumTest.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
  That class provides static methods for getting values from UIMapping.properties and uiMapping MAP
*/
public class UiMappingSingleton {

    private volatile static UiMappingSingleton uniqueInstance;
    private static Properties properties = new Properties();
    private volatile static Map<String, String> uiMapping;

    private static final Logger LOG = Logger.getLogger(ClassNameUtil.getCurrentClassName());



    private UiMappingSingleton() {
        uiMapping = new HashMap <>();
        long start = System.nanoTime();
        loadDataFromUIMappingFile();
        for (final Map.Entry<Object, Object> entry : properties.entrySet()) {
            uiMapping.put((String) entry.getKey(), (String) entry.getValue());
        }
        LOG.info("\t** UiMappingSingleton creation time - " + (System.nanoTime() - start) + "nanoseconds **");
    }

    public static synchronized UiMappingSingleton getInstance() {
        if (uiMapping == null) {
            LOG.info("\t** UiMappingSingleton getInstance() class A **");
            uniqueInstance = new UiMappingSingleton();
            LOG.info("\t** Object - " + uniqueInstance + " **");
            return uniqueInstance;
        }
        LOG.info("\t** UiMappingSingleton getInstance() class B **");
        LOG.info("\t** Object - " + uniqueInstance + " **");
        return uniqueInstance;
    }


    /**
     *  This method Load locators data from uiMapping.properties which
     *  path is specified in application.properties with key: #uiMappingFile.
     *  Return value from .properties file
     *
     *  @return properties
     */
    public static Properties loadDataFromUIMappingFile() {
        File file = new File(PropertyLoader.loadProperty("uiMappingFile"));

        if (file.exists()) {
            try {
                properties.load(new FileInputStream(file));
            } catch (IOException e) {
                Assert.fail("Can not find UIMappingFile in class path!");
            }
        }

        return properties;
    }

    /**
     *  This method parses data from UIMapping HashMap
     *
     *  @return By class data type with locatorType and locatorValue
     */
    public static By ui(String key) {
        String[] partsOfLocators = uiMapping.get(key).split("\"");
        String locatorType = partsOfLocators[0];
        String locatorValue = partsOfLocators[1];

        switch(locatorType){
            case "xpath":
                return By.xpath(locatorValue);
            case "cssSelector":
                return By.cssSelector(locatorValue);
            case "id": return By.id(locatorValue);
            case "className": return By.className(locatorValue);
            default: return By.name(locatorValue);
        }
    }

    public static String uiStr(String key) {
        String[] partsOfLocators = uiMapping.get(key).split("\"");
        String locatorValue = partsOfLocators[1];
        return locatorValue;
    }
}