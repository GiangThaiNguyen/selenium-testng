package com.guru99.commonLibs.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtils {

    public static Properties readProperty(String fileName) throws IOException {
        FileInputStream fileReader = new FileInputStream(fileName);
        Properties property = new Properties();
        property.load(fileReader);
        return property;
    }
}
