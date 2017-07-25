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

public class Todos {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/todos");
            try {
                URLConnection uRLConnection = url.openConnection();
                InputStreamReader isr = new InputStreamReader(uRLConnection.getInputStream());
                BufferedReader br = new BufferedReader(isr);
                StringBuilder jsonString = new StringBuilder();
                String lineString;

                while ((lineString = br.readLine()) != null) {
                    jsonString.append(lineString);
                }

                ObjectMapper objectMapper = new ObjectMapper();
                List<Todo> todos = objectMapper.readValue(jsonString.toString(), new TypeReference<List<Todo>>() {
                });

                todos.stream().forEach(comment -> {

                    System.out.println("Post ID : " + comment.getUserId());
                    System.out.println("ID : " + comment.getId());
                    System.out.println("Name : " + comment.getId());
                    System.out.println("Email : " + comment.getTitle());
                    System.out.println("Body : " + comment.getCompleted());
                    System.out.println("\n\n\n\n");
                });
            } catch (IOException ex) {
                Logger.getLogger(Todos.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (MalformedURLException ex) {
            Logger.getLogger(Todos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
