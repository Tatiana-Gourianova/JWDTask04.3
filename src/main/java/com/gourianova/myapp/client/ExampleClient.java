package com.gourianova.myapp.client;

import com.gourianova.myapp.dto.TextDto;
import com.gourianova.myapp.dto.UserInputDto;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

@Slf4j
public class ExampleClient {

    private Socket clientSocket;
    ObjectOutputStream out = null;
    ObjectInputStream in = null;

    public void startConnection(String ip, int port) {
        try {
            clientSocket = new Socket(ip, port);
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            in = new ObjectInputStream(clientSocket.getInputStream());
        } catch (IOException e) {
            log.error("Client can't start for reason: {}", e.getMessage());
        }
    }

    public TextDto sendMessage(UserInputDto dto) {
        TextDto response = null;
        try {
            out.writeObject(dto);
            out.flush();
            response = (TextDto) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            log.warn("Can't send message to server for reason: {}", e.getMessage());
        }
        return response;
    }

    public void stopConnection() {
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            log.error("Client can't stop for reason: {}", e.getMessage());
        }
    }
}
