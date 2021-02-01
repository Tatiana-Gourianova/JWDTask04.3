package com.gourianova.myapp;

import com.gourianova.myapp.client.ExampleClient;
import com.gourianova.myapp.constants.ClientConstants;
import com.gourianova.myapp.dto.TextDto;
import com.gourianova.myapp.dto.UserInputDto;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Slf4j
public class AppClient {

    private static final String CLIENT_IP = "127.0.0.1";
    private static final Integer SERVER_PORT = 8888;

    public static void main(String[] args) throws IOException {
        log.info("Client starting...");
        ExampleClient client = new ExampleClient();
        client.startConnection(CLIENT_IP, SERVER_PORT);

        System.out.println(ClientConstants.USER_CHOOSE);
        BufferedReader inputUser = new BufferedReader(new InputStreamReader(System.in));
        Integer taskNumber = Integer.valueOf(inputUser.readLine());

        UserInputDto request = new UserInputDto(taskNumber);
        TextDto response = client.sendMessage(request);
        log.info("Result is: {}", response.getText());
    }
}
