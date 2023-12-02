package com.example.integration_project_oop2.Serialization;

import java.io.*;

public class BinReader {

    public static <T> T deserialize(String filePath, Class<T> clazz) {
        T object = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            object = (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }
}
