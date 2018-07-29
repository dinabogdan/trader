package com.freesoft.wssintegration.service.impl;

import com.freesoft.wssintegration.websocket.WssClient;
import com.freesoft.wssintegration.factory.JsonObjectFactory;
import com.freesoft.wssintegration.model.request.LoginRequest;
import com.freesoft.wssintegration.model.wss.WssBaseRequest;
import com.freesoft.wssintegration.model.wss.WssLoginRequest;
import com.freesoft.wssintegration.service.LoginService;
import com.freesoft.wssintegration.utils.WssLoginRequestAssembler;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class LoginServiceImpl implements LoginService {

    private final JsonObjectFactory jsonLoginFactory;
    private final WssClient wssClient;

    public LoginServiceImpl(JsonObjectFactory jsonLoginFactory, WssClient wssClient) {
        this.jsonLoginFactory = jsonLoginFactory;
        this.wssClient = wssClient;
    }

    @Override
    public void performLogin(LoginRequest loginRequest) {
        WssLoginRequest wssLoginRequest = WssLoginRequestAssembler.assemble(loginRequest);
        WssBaseRequest<WssLoginRequest> wssBaseRequest = new WssBaseRequest<>(101, 1, wssLoginRequest);
        JSONObject jsonObject = jsonLoginFactory.assembleJsonObject(wssBaseRequest);
        wssClient.sendMessage(jsonObject);
    }
}
