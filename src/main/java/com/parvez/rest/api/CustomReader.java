/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parvez.rest.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author parvez
 */
public class CustomReader {
    
    public static void main(String[] args) {
        
        try {
            
            System.out.println("Starting...");
            System.out.println("Connecting...");
            URL url = new URL("http://localhost:8084/WebServices/students.htm");
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
