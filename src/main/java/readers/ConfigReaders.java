package readers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReaders {


    public static Properties getAllProperties() {
        Properties fileProperties = null;
        try {
            FileReader fileReader = new FileReader( "./src/test/resources/config/config.properties") ;
            fileProperties=new Properties();
            fileProperties.load(fileReader);
        }
        catch (IOException ioException)
        {
            System.out.println("There is io exception happened");
        }
        return fileProperties;
    }
    public static String getPropertyByKey( String propertyKey) {
        Properties fileProperties = getAllProperties ();
        return fileProperties.getProperty(propertyKey);
    }


}
