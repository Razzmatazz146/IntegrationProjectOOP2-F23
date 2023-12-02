//package com.example.integration_project_oop2.Serialization;
//import com.example.integration_project_oop2.Classes.*;
//
//import java.io.*;
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//
//public class ReadCSV implements Serializable{
//    public static void main(String[] args) {
//        String ticketCsvFilePath = "ticket.csv";
//        String ticketBinFilePath = "ticket.bin";
//        ArrayList<Showtime> showtimes = BinReader.deserialize("showtime.bin");
//
//// Ensure showtimes are not null
//        if (showtimes == null) {
//            System.out.println("Failed to load showtimes from showtime.bin.");
//            return;
//        }
//
//        ArrayList<Ticket> tickets = new ArrayList<>();
//
//        try (BufferedReader br = new BufferedReader(new FileReader(ticketCsvFilePath))) {
//            String line;
//            br.readLine(); // Skip the header line
//            while ((line = br.readLine()) != null) {
//                if (line.trim().isEmpty()) {
//                    continue; // Skip empty lines
//                }
//
//                String[] values = line.split(",");
//                Showtime showtime = showtimes.get(Integer.parseInt(values[0])); // Get Showtime by index
//                boolean isAdult = "TRUE".equalsIgnoreCase(values[1].trim());
//                int ticketNumber = Integer.parseInt(values[2]);
//                LocalDate purchaseDate = LocalDate.parse(values[3]);
//
//                Ticket ticket = new Ticket(showtime, isAdult, ticketNumber, purchaseDate);
//                tickets.add(ticket);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//            return;
//        }
//
//        // Serialize the ArrayList<Ticket> to a .bin file
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ticketBinFilePath))) {
//            oos.writeObject(tickets);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
