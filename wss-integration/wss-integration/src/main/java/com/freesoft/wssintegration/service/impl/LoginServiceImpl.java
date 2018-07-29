package com.freesoft.wssintegration.service.impl;

import com.freesoft.wssintegration.JsonObjectFactory;
import com.freesoft.wssintegration.model.request.LoginRequest;
import com.freesoft.wssintegration.model.wss.WssBaseRequest;
import com.freesoft.wssintegration.model.wss.WssLoginRequest;
import com.freesoft.wssintegration.service.LoginService;
import com.freesoft.wssintegration.utils.WssLoginRequestAssembler;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class LoginServiceImpl implements LoginService {

    @Override
    public void performLogin(LoginRequest loginRequest) {
        WssLoginRequest wssLoginRequest = WssLoginRequestAssembler.assemble(loginRequest);
        WssBaseRequest<WssLoginRequest> wssBaseRequest = new WssBaseRequest<>(101, 1, wssLoginRequest);
        JSONObject jsonObject = JsonObjectFactory.convertToJsonObject(wssBaseRequest);
    }
}
