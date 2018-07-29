package com.freesoft.wssintegration.websocket;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.freesoft.wssintegration.model.response.login.LoginResponse;
import com.freesoft.wssintegration.service.dao.LoginDao;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;

import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;
import java.io.IOException;

@Slf4j
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class WssEndpoint extends Endpoint {

    private Session session;

    private final LoginDao loginDao;

    @Override
    public void onOpen(Session session, EndpointConfig endpointConfig) {
        log.info("### Opening WebSocket ...");
        this.session = session;
        this.session.addMessageHandler(new MessageHandler.Whole<String>() {
            @Override
            public void onMessage(String messageReceived) {
                log.info("### MessageReceived: " + messageReceived);
                JSONObject message = new JSONObject(messageReceived);
                Integer pid = (Integer) ((JSONObject) message.get("bm")).get("pid");
                if (pid == 101) {
                    byte[] jsonData = message.toString().getBytes();
                    ObjectMapper objectMapper = new ObjectMapper();
                    try {
                        LoginResponse loginResponse = objectMapper.readValue(jsonData, LoginResponse.class);
                        log.info("### LoginResponse: {}", loginResponse);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                WssClient.messageLatch.countDown();
            }
        });
        log.info("### Closing WebSocket ...");
    }

    public void sendMessage(String messageToSend) throws IOException {
        this.session.getBasicRemote().sendText(messageToSend);
    }
}
