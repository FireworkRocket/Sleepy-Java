package top.fireworkrocket.sleepyjava.default_config;

import top.fireworkrocket.sleepyjava.exception.ExceptionHandler;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class ConfigReader {

    private static File file = new File("Config/ServerConfig.properties"); // Config file path
    private static Properties prop = new Properties();


    public static void initProp() {
        try {
            if (!file.exists() || !file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
                ExceptionHandler.handleWarning("Config file not found, creating new file at " + file.getAbsolutePath());
                if (file.createNewFile()) {
                    Field[] fields = CopyWriting.class.getDeclaredFields();
                    for (Field field : fields) { // Set default values
                        try {
                            String key = field.getName();
                            String value = String.valueOf(field.get(null));
                            ExceptionHandler.handleInfo("Setting " + key + " to " + value);
                            prop.setProperty(key, value);
                        } catch (IllegalAccessException e) {
                            ExceptionHandler.handleException(e);
                        }
                    }
                    try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8)) {
                        prop.store(writer, null);
                    }
                } else {
                    ExceptionHandler.handleFatal("Failed to create config file, exiting!", new IOException());
                }
            } else {
                ExceptionHandler.handleInfo("Loading properties from " + file.getAbsolutePath());
                try (InputStreamReader reader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)) {
                    prop.load(reader);
                }
                for (String key : prop.stringPropertyNames()) { // Set values from file
                    String value = prop.getProperty(key);
                    ExceptionHandler.handleInfo("Setting " + key + " to " + value);
                    try {
                        Field field = CopyWriting.class.getDeclaredField(key);
                        field.setAccessible(true); // Set private field
                        field.set(null, value);
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        ExceptionHandler.handleException(e);
                    }
                }
            }
        } catch (IOException e) {
            ExceptionHandler.handleException(e);
        }
    }
}