package com.freesoft.wssintegration.factory;

import com.freesoft.wssintegration.model.wss.WssBaseRequest;
import org.json.JSONObject;

public interface JsonObjectFactory {

    JSONObject assembleJsonObject(WssBaseRequest wssBaseRequest);

}
