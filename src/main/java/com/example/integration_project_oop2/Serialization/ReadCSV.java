//package com.example.integration_project_oop2.Serialization;
//
//import com.example.integration_project_oop2.Classes.Client;
//
//import java.io.*;
//import java.time.LocalDate;
//import java.util.ArrayList;
//
//public class ReadCSV {
//    public static void main(String[] args) {
//        String clientCsvFilePath = "client.csv";
//        String clientBinFilePath = "client.bin";
//
//        ArrayList<Client> clients = new ArrayList<>();
//
//        try (BufferedReader br = new BufferedReader(new FileReader(clientCsvFilePath))) {
//            String line;
//            br.readLine(); // Skip the header line
//            while ((line = br.readLine()) != null) {
//                if (line.trim().isEmpty()) {
//                    continue; // Skip empty lines
//                }
//
//                String[] values = line.split(",");
//                String username = values[0].trim();
//                String password = values[1].trim();
//                String firstName = values[2].trim();
//                String lastName = values[3].trim();
//                String email = values[4].trim();
//                String phoneNumber = values[5].trim();
//                LocalDate signUpDate = LocalDate.parse(values[6].trim());
//                int purchaseHistory = Integer.parseInt(values[7].trim());
//                String paymentInfo = values[8].trim();
//                boolean isManager = Boolean.parseBoolean(values[9].trim());
//
//                Client client = new Client(username, password, firstName, lastName, email, phoneNumber, signUpDate, purchaseHistory, paymentInfo, isManager);
//                clients.add(client);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//            return;
//        }
//
//        // Serialize the ArrayList<Client> to a .bin file
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(clientBinFilePath))) {
//            oos.writeObject(clients);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
