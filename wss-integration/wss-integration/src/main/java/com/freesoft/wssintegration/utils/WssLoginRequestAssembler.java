package com.freesoft.wssintegration.utils;

import com.freesoft.wssintegration.model.request.LoginRequest;
import com.freesoft.wssintegration.model.wss.WssLoginRequest;

public final class WssLoginRequestAssembler {
    public static WssLoginRequest assemble(LoginRequest loginRequest) {
        return WssLoginRequest.builder()
                .classCommandName("p.Login")
                .username(loginRequest.getUsername())
                .password(loginRequest.getPassword())
                .build();
    }
}
