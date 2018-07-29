package com.freesoft.wssintegration.controller;

import com.freesoft.wssintegration.model.request.LoginRequest;
import com.freesoft.wssintegration.model.wss.WssBaseRequest;
import com.freesoft.wssintegration.JsonObjectFactory;
import com.freesoft.wssintegration.model.wss.WssLoginRequest;
import com.freesoft.wssintegration.entity.LoginEntity;
import com.freesoft.wssintegration.repository.LoginRepository;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WssController {

    private final WssClient wssClient;
    private final LoginRepository loginRepository;

    private WssController(WssClient wssClient, LoginRepository loginRepository) {
        this.wssClient = wssClient;
        this.loginRepository = loginRepository;
    }

    @PostMapping("/login")
    public void login(@RequestBody LoginRequest loginRequest) {
    }

    @PostMapping("/symbols")
    public void getSymbols() {
        LoginEntity login = loginRepository.findById(1L).get();
        JSONObject jsonObject = new JSONObject()
                .put("bm", new JSONObject()
                        .put("pid", 105)
                        .put("user", "dinabogdan")
                        .put("sessionId", login.getSessionId())
                        .put("csq", 1)
                        .put("payload", new JSONObject()
                                .put("@class", "p.GenericIoPayload")
                                .put("content", new JSONObject()
                                        .put("@class", "string")
                                        .put("$", "BVB"))));

        wssClient.sendMessage(jsonObject);
    }
}
