package org.fis.framework.util;

import java.io.File;
import java.io.IOException;

public class FileReader {

    public static String getFileCanonicalPath(String parentDirPath, String fileName) throws IOException {
        File classpathRoot = new File(System.getProperty("user.dir"));
        String configDirCanonicalPath = new File(classpathRoot, parentDirPath).getCanonicalPath();
        return String.format("%s/%s", configDirCanonicalPath, fileName);
    }

    public static File getFile(String parentDirPath, String fileName) throws IOException {
        File classpathRoot = new File(System.getProperty("user.dir"));
        String configDirCanonicalPath = new File(classpathRoot, parentDirPath).getCanonicalPath();
        return new File(configDirCanonicalPath, fileName);
    }
}
