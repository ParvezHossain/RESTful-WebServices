/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parvez.messenger.service;

import com.parvez.messenger.database.DatabaseClass;
import com.parvez.messenger.model.Message;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Parvez
 */
public class MessageService {

    private Map<Long, Message> messages = DatabaseClass.getMessages();

    public MessageService() {

        messages.put(1L, new Message(1L, "Hello WS", "Parvez"));
        messages.put(2L, new Message(2L, "Hello Jax-RS", "Parvez"));
        messages.put(3L, new Message(3L, "Hello JaxB", "Parvez"));
        messages.put(4L, new Message(4L, "Hello RESTful WS", "Parvez"));
        messages.put(5L, new Message(5L, "Admin 1", "User 1"));
    }

    public List<Message> getAllMessages() {

        return new ArrayList<>(messages.values());
    }

    public Message getMessage(long id) {
        return messages.get(id);
    }

    public Message addMessage(Message message) {
        message.setId(messages.size() + 1);
        messages.put(message.getId(), message);
        return message;
    }

    public List<Message> getAllMessagesForYear(int year) {

        List<Message> messagesForYear = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        messages.values().stream().filter((message) -> (calendar.get(Calendar.YEAR) == year)).forEachOrdered((message) -> {
            messagesForYear.add(message);
        });

        /*
        //Regular way
        for (Message message : messages.values()) {
            if (calendar.get(Calendar.YEAR) == year) {
                messagesForYear.add(message);
            }
        }
         */
        return messagesForYear;
    }

    public List<Message> getAllMessagesPaginated(int start, int size) {

        ArrayList<Message> list = new ArrayList<>(messages.values());
        if (start + size > list.size()) {
            return new ArrayList<>();
        } else {
            return list.subList(start, start + size);
        }
    }

    public Message updateMessage(Message message) {
        if (message.getId() <= 0) {
            return null;
        } else {
            messages.put(message.getId(), message);
        }
        return message;
    }

    public Message removeMessage(long id) {
        return messages.remove(id);
    }
}
