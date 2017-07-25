package com.parvez.rest.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class PhotoViewer {

    public static void main(String[] args) {

        try {

            System.out.println("Starting...");
            System.out.println("Connecting...");
            URL url = new URL("https://jsonplaceholder.typicode.com/photos");
            System.out.println("Conneted...");
            URLConnection connection = url.openConnection();
            connection.setConnectTimeout(10000);
            System.out.println("URLConnection Created...");
            InputStreamReader isr = new InputStreamReader(connection.getInputStream());
            System.out.println("Input Stream Reader Created...");
            BufferedReader br = new BufferedReader(isr);
            System.out.println("Buffer Reader Created...");

            StringBuilder jsonString = new StringBuilder();
            String lineString;

            while ((lineString = br.readLine()) != null) {

                System.out.println(lineString);
                jsonString.append(lineString);
            }
        } catch (IOException e) {

            System.err.println(e.toString());
        }
    }
}
