package com.freesoft.wssintegration.websocket;

import com.freesoft.wssintegration.repository.LoginRepository;
import com.freesoft.wssintegration.service.dao.LoginDao;
import lombok.extern.java.Log;
import org.glassfish.tyrus.client.ClientManager;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import javax.websocket.DeploymentException;
import javax.websocket.Session;
import java.io.IOException;
import java.net.URI;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Log
@Component
public class WssClient {

    final static CountDownLatch messageLatch = new CountDownLatch(1);
    final static String uri = "wss://demo.arenaxt.ro/ws/channel/";

    private final ClientManager clientManager;
    private final WssEndpoint wssEndpoint;
    private final LoginDao loginDao;
    private Session session = null;

    private WssClient(LoginDao loginDao) {
        this.clientManager = new ClientManager();
        this.wssEndpoint = new WssEndpoint(loginDao);
        this.loginDao = loginDao;
        try {
            this.session = this.clientManager.connectToServer(wssEndpoint, URI.create(uri));
        } catch (DeploymentException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(JSONObject jsonObject) {
        log.info("### Connecting to URI: " + uri);
        try {
            wssEndpoint.sendMessage(jsonObject.toString().length() + ":" + jsonObject);
            messageLatch.await(15, TimeUnit.SECONDS);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
