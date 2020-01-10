package org.fis.test.util;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;

public class ConfigReader {

    /**
     * Looks for a YAML file inside the "src/main/config" directory with the name specified in the
     * configFileName parameter and loads its key:values into a hash map <String, Object>.
     * <p>
     * It returns an empty hash map in case of any exception.
     *
     * @param configFileName is the name of the configuration file without the "yml" extension.
     * @return a hash map with all the key:values from the configuration file.
     */
    public static HashMap<String, String> load(String configDirPath, String configFileName) {
        try {
            String configFileCanonicalPath = FileReader.getFileCanonicalPath(configDirPath,
                    configFileName + ".yml");
            InputStream inputStream = new FileInputStream(configFileCanonicalPath);
            return new Yaml().load(inputStream);
        } catch (Exception e) {
            System.out.println("Cause: " + e.getCause());
            System.out.println("Message: " + e.getMessage());
            e.printStackTrace();
            return new HashMap<>();
        }
    }
}