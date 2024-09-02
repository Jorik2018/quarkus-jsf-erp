package com.titanic.ventapasajes.socket;

import io.quarkus.vertx.ConsumeEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.websocket.OnMessage;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;

@ApplicationScoped
@ServerEndpoint("/notify")
public class NotifyResource {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @OnMessage
    public void onMessage(String message, Session session) {
        // Create JSON message
        ObjectNode jsonMessage = objectMapper.createObjectNode()
                .put("summary", "Notification")
                .put("detail", message);

        try {
            session.getAsyncRemote().sendText(objectMapper.writeValueAsString(jsonMessage));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ConsumeEvent("notify")
    public void sendNotification(String detail, Session session) {
        // Create JSON message
        ObjectNode jsonMessage = objectMapper.createObjectNode()
                .put("summary", "Notification")
                .put("detail", detail);

        // Broadcast the message to all open WebSocket sessions
        session.getOpenSessions().forEach(s -> {
            if (s.isOpen()) {
                try {
                    s.getAsyncRemote().sendText(objectMapper.writeValueAsString(jsonMessage));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}