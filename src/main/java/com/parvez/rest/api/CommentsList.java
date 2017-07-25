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

public class CommentsList {

    public static void main(String[] args) {

        try {

            System.out.println("Starting...");
            System.out.println("Connecting...");
            URL url = new URL("https://jsonplaceholder.typicode.com/comments");
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

            ObjectMapper objectMapper = new ObjectMapper();
            List<Comment> comments = objectMapper.readValue(jsonString.toString(), new TypeReference<List<Comment>>() {
            });

            comments.stream().forEach(comment -> {

                System.out.println("Post ID : " + comment.getPostId());
                System.out.println("ID : " + comment.getId());
                System.out.println("Name : " + comment.getName());
                System.out.println("Email : " + comment.getEmail());
                System.out.println("Body : " + comment.getBody());
                System.out.println("\n\n\n\n");
            });

        } catch (MalformedURLException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

    }
}
