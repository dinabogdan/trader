package com.freesoft.wssintegration.model.response.login;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.freesoft.wssintegration.utils.CustomJsonSerializable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Setter(AccessLevel.PROTECTED)
public class SubscriptionDto extends CustomJsonSerializable {

    @JsonProperty("exchange")
    private String exchange;
    @JsonProperty("symbol")
    private String symbol;
}
