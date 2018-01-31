package seleniumTest.utils;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


///*
// *  That class provides static methods for getting values from UIMapping.properties and uiMapping MAP
// */
public class UiMappingSingleton {

    private volatile static UiMappingSingleton uniqueInstance;
    private static Properties properties = new Properties();
    private volatile static Map<String, String> uiMapping;

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());


    private UiMappingSingleton() {

        uiMapping = new HashMap<>();

        long start = System.nanoTime();
        loadDataFromUIMappingFile();
        for (final Map.Entry<Object, Object> entry : properties.entrySet()) {
            uiMapping.put((String) entry.getKey(), (String) entry.getValue());
        }
        log.info("\t** UiMappingSingleton creation time - " + (System.nanoTime() - start) + "nanoseconds **");
    }


    public static synchronized UiMappingSingleton getInstance() {
        if (uiMapping == null) {
            log.info("\t** UiMappingSingleton getInstance() class A **");
            uniqueInstance = new UiMappingSingleton();
            log.info("\t** Object - " + uniqueInstance + " **");
            return uniqueInstance;
        }
        log.info("\t** UiMappingSingleton getInstance() class B **");
        log.info("\t** Object - " + uniqueInstance + " **");
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
                properties.load(new InputStreamReader(new FileInputStream(file), "UTF-8"));
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

        if (locatorType.equals("xpath")){
            return By.xpath(locatorValue);
        } else {
            if (locatorType.equals("cssSelector")){
                return By.cssSelector(locatorValue);
            } else {
                if (locatorType.equals("id")){
                    return By.id(locatorValue);
                } else {
                    if (locatorType.equals("className")){
                        return By.className(locatorValue);
                    } else {
                        return By.name(locatorValue);
                    }
                }
            }
        }
    }

    public static String uiStr(String key) {
        String[] partsOfLocators = uiMapping.get(key).split("\"");
        String locatorValue = partsOfLocators[1];

        return locatorValue;
    }

}

//public class UiMappingSingleton {
//
//    private static UiMappingSingleton instance = null;
//
//    private  UiMappingSingleton() {
//    }
//
//    public static UiMappingSingleton getInstance(){
//        if (instance == null){
//            instance = new UiMappingSingleton();
//        }
//        return instance;
//    }
//
//    public static String uiMappingFile = "src/seleniumTest/utils/UiMapping.properties";
//
//    public static String getValueFromFile(String key, String fileName) {
//        Properties p = new Properties();
//
//        try {
//            p.load(new FileInputStream(fileName));
//        } catch (IOException e) {
//            throw new IllegalStateException("Can't read file" + e.getMessage());
//        }
//        return (p.getProperty(key));
//    }
//
//
//    public static By ui(String key) {
//        String[] partsOfLocators = getValueFromFile(key, uiMappingFile).split("\"");
//        String locatorType = partsOfLocators[0];
//        String locatorValue = partsOfLocators[1];
//
//
//        //refactor with switch case & ADD hash map & refactor with singleton
//    /*    switch (locatorType){
//            case "id": By.id(locatorValue);
//                        break;
//            case "xpath": By.xpath(locatorValue);
//
//        }
//        */
//
//
//        // Return By class with appropriate method and locatorValue
//        if (locatorType.equals("id")) {
//            return By.id(locatorValue);
//        } else {
//            if (locatorType.equals("xpath")) {
//                return By.xpath(locatorValue);
//            } else {
//                if (locatorType.equals("name")) {
//                    return By.name(locatorValue);
//                } else {
//                    if (locatorType.equals("linkText")) {
//                        return By.linkText(locatorValue);
//                    } else {
//                        if (locatorType.equals("tagName")) {
//                            return By.tagName(locatorValue);
//                        } else {
//                            if (locatorType.equals("className")) {
//                                return By.className(locatorValue);
//                            } else {
//                                if (locatorType.equals("cssSelector")) {
//                                    return By.cssSelector(locatorValue);
//                                } else {
//                                    return By.partialLinkText(locatorValue);
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//  }}
