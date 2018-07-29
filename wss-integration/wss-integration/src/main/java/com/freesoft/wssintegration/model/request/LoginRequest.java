package com.freesoft.wssintegration.model.request;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder
public class LoginRequest implements Serializable {
    private String username;
    private String password;
}
