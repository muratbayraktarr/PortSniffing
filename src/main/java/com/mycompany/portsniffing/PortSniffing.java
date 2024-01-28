/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.portsniffing;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author ByMazarat
 */
public class PortSniffing {

    public ArrayList runPortScan(String ip, int nbrPortMaxToScan) throws IOException {
        ConcurrentLinkedQueue openPorts = new ConcurrentLinkedQueue<>();
        int poolSize = 1000;
        ExecutorService executorService = Executors.newFixedThreadPool(poolSize);
        AtomicInteger port = new AtomicInteger(0);
        while (port.get() < nbrPortMaxToScan) {
            final int currentPort = port.getAndIncrement();
            executorService.submit(() -> {
                try {
                    Socket socket = new Socket();
                    socket.connect(new InetSocketAddress(ip, currentPort), 1000);
                    InputStream inputStream = socket.getInputStream();
                    

                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder responseData = new StringBuilder();

                    char[] buffer = new char[1024];
                    int bytesRead;

                    while ((bytesRead = reader.read(buffer)) != -1) {
                        responseData.append(buffer, 0, bytesRead);
                    }
                    
                    

                    String receivedData = responseData.toString();
                    socket.close();
                    inputStream.close();
                    openPorts.add(currentPort);
                    System.out.println(ip + " ,port open: " + currentPort);
                    System.out.println("Received data from port " + currentPort + ": " + receivedData);

                } catch (IOException e) {
                    System.out.println(e + " " + currentPort);     
                }
            });
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.MINUTES);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ArrayList openPortList = new ArrayList<>();
        System.out.println("openPortsQueue: " + openPorts.size());
        while (!openPorts.isEmpty()) {
            openPortList.add(openPorts.poll());
        }
        openPortList.forEach(p -> System.out.println("port " + p + " is open"));
        return openPortList;
    }

    public void PDFScanner(ArrayList openPortList) {
        String data = DataSet.data;

        // Port ve açıklamaları tutacak olan HashMap
        HashMap<String, String> portDescriptionMap = new HashMap<>();
        // Her bir satırı kontrol edin ve port ve description'ları ayıklayın
        Pattern pattern = Pattern.compile("(\\d+)\\s+\\w+\\s+(.+)");

        String[] lines = data.split("\n");
        for (String line : lines) {
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                try {
                    String port = matcher.group(1);
                    String description = matcher.group(2).trim();
                    portDescriptionMap.put(port, description);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid port number format: " + matcher.group(1));
                }
            }
        }
        // HashMap içeriğini yazdır
        for (String port : portDescriptionMap.keySet()) {
            String description = portDescriptionMap.get(port);
            int portNumber = Integer.parseInt(port);
            if (openPortList.contains(portNumber)) {
                System.out.println("Port " + portNumber + " default : " + description);
            }

        }
    }

    public static void main(String[] args) throws IOException {
        PortSniffing p1 = new PortSniffing();
        ArrayList openPortList = new ArrayList<>();

        // Kullanıcıdan IP adresini al
        Scanner scanner = new Scanner(System.in);
        System.out.println("Portları denetlenecek olan IP adresini girin:");
        String ipAddress = scanner.nextLine();
        scanner.close();

        // Diğer işlemleri gerçekleştir
        openPortList = p1.runPortScan(ipAddress, 9000);
        p1.PDFScanner(openPortList);

       
    }
}
