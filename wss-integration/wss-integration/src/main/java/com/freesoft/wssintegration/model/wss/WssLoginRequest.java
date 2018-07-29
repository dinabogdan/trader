package com.freesoft.wssintegration.model.wss;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WssLoginRequest {

    private String classCommandName;
    private String username;
    private String password;

}
