package com.freesoft.wssintegration.websocket;


import com.freesoft.wssintegration.entity.LoginEntity;
import com.freesoft.wssintegration.repository.LoginRepository;
import lombok.extern.java.Log;
import org.json.JSONObject;

import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;
import java.io.IOException;

@Log
public class WssEndpoint extends Endpoint {

    private Session session;

    private final LoginRepository loginRepository;

    public WssEndpoint(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

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
                    LoginEntity login = new LoginEntity();
                    String sidValue = message.getJSONObject("bm").getJSONObject("payload").getJSONObject("user").getString("sid");
                    login.setSessionId(sidValue);
                    loginRepository.save(login);
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
