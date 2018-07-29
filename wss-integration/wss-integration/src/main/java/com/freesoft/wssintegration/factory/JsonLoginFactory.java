package com.freesoft.wssintegration.factory;

import com.freesoft.wssintegration.model.wss.WssBaseRequest;
import com.freesoft.wssintegration.model.wss.WssLoginRequest;
import lombok.Builder;
import org.json.JSONObject;

@Builder
public class JsonLoginFactory implements JsonObjectFactory {

    @Override
    public JSONObject assembleJsonObject(WssBaseRequest wssBaseRequest) {
        return new JSONObject()
                .put("bm", new JSONObject()
                        .put("pid", wssBaseRequest.getPid())
                        .put("csq", wssBaseRequest.getCsq())
                        .put("payload", new JSONObject()
                                .put("@class", ((WssLoginRequest) wssBaseRequest.getPayload()).getClassCommandName())
                                .put("username", ((WssLoginRequest) wssBaseRequest.getPayload()).getUsername())
                                .put("password", ((WssLoginRequest) wssBaseRequest.getPayload()).getPassword())));
    }
}
