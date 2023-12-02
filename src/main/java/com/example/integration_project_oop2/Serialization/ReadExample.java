//package com.example.integration_project_oop2.Serialization;
//
//import com.example.integration_project_oop2.Classes.Client;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.util.ArrayList;
//
//public class ReadExample {
//    public static void main(String[] args) {
//        System.out.println("Reading objects...");
//
//        try {
//            FileInputStream fi = new FileInputStream("client.bin");
//
//            ObjectInputStream is = new ObjectInputStream(fi);
//
//            @SuppressWarnings("unchecked") // Suppress unchecked cast warning
//            ArrayList<Client> clients = (ArrayList<Client>) is.readObject();
//
//            // Now you can iterate over the ArrayList or access individual elements
//            for (Client client : clients) {
//                System.out.println(client);
//                System.out.println();
//            }
//
//            is.close();
//
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}