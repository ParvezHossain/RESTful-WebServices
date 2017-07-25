/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parvez.rest.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Parvez
 */
public class MessageViewer {

    public static void main(String[] args) {
        System.out.println("\n\n\n");
        System.out.println("Message parsing started...");
        try {
            URL url = new URL("http://localhost:8080/messenger/webapi/messages");
            System.out.println("Connection Established");
            try {
                URLConnection connection = url.openConnection();
                System.out.println("URLConnection Created...");
                InputStreamReader isr = new InputStreamReader(connection.getInputStream());
                BufferedReader br = new BufferedReader(isr);
                System.out.println("Buffer Reader Created...");
                StringBuilder jsonString = new StringBuilder();
                String lineString;
                while ((lineString = br.readLine()) != null) {
                    System.out.println(lineString);
                    jsonString.append(lineString);
                }

                ObjectMapper objectMapper = new ObjectMapper();
                List<MessagePojo> messagePojos = objectMapper.readValue(jsonString.toString(), new TypeReference<List<MessagePojo>>() {
                });

                messagePojos.stream().forEach((MessagePojo message) -> {
                    System.out.println("Author: " + message.getAuthor());
                    System.out.println("Created: " + message.getCreated());
                    System.out.println("I'd: " + message.getId());
                    System.out.println("Message: " + message.getMessage());
                    System.out.println("\n\n");
                });

            } catch (IOException ex) {
                Logger.getLogger(MessageViewer.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (MalformedURLException ex) {
            Logger.getLogger(MessageViewer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
