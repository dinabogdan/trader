package com.freesoft.wssintegration.service;

import com.freesoft.wssintegration.model.request.LoginRequest;

public interface LoginService {

    void performLogin(LoginRequest loginRequest);
}
