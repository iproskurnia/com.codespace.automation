package seleniumTest.utils;

import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UiMappingSingleton {

    private static UiMappingSingleton instance = null;

    private  UiMappingSingleton() {
    }

    public static UiMappingSingleton getInstance(){
        if (instance == null){
            instance = new UiMappingSingleton();
        }
        return instance;
    }

    public static String uiMappingFile = "src/seleniumTest/utils/UiMapping.properties";

    public static String getValueFromFile(String key, String fileName) {
        Properties p = new Properties();

        try {
            p.load(new FileInputStream(fileName));
        } catch (IOException e) {
            throw new IllegalStateException("Can't read file" + e.getMessage());
        }
        return (p.getProperty(key));
    }


    public static By ui(String key) {
        String[] partsOfLocators = getValueFromFile(key, uiMappingFile).split("\"");
        String locatorType = partsOfLocators[0];
        String locatorValue = partsOfLocators[1];


        //refactor with switch case & ADD hash map & refactor with singleton
    /*    switch (locatorType){
            case "id": By.id(locatorValue);
                        break;
            case "xpath": By.xpath(locatorValue);

        }
        */


        // Return By class with appropriate method and locatorValue
        if (locatorType.equals("id")) {
            return By.id(locatorValue);
        } else {
            if (locatorType.equals("xpath")) {
                return By.xpath(locatorValue);
            } else {
                if (locatorType.equals("name")) {
                    return By.name(locatorValue);
                } else {
                    if (locatorType.equals("linkText")) {
                        return By.linkText(locatorValue);
                    } else {
                        if (locatorType.equals("tagName")) {
                            return By.tagName(locatorValue);
                        } else {
                            if (locatorType.equals("className")) {
                                return By.className(locatorValue);
                            } else {
                                if (locatorType.equals("cssSelector")) {
                                    return By.cssSelector(locatorValue);
                                } else {
                                    return By.partialLinkText(locatorValue);
                                }
                            }
                        }
                    }
                }
            }
        }


    }
}