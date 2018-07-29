package com.freesoft.wssintegration;

import com.freesoft.wssintegration.model.wss.WssBaseRequest;
import com.freesoft.wssintegration.model.wss.WssLoginRequest;
import org.json.JSONObject;

public class JsonObjectFactory {

    public static JSONObject convertToJsonObject(WssBaseRequest<WssLoginRequest> loginRequest) {
        return new JSONObject()
                .put("bm", new JSONObject()
                        .put("pid", loginRequest.getPid())
                        .put("csq", loginRequest.getCsq())
                        .put("payload", new JSONObject()
                                .put("@class", loginRequest.getPayload().getClassCommandName())
                                .put("username", loginRequest.getPayload().getUsername())
                                .put("password", loginRequest.getPayload().getPassword())));
    }
}
