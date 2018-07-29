package com.freesoft.wssintegration.model.response.login;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.freesoft.wssintegration.utils.CustomJsonSerializable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@Setter(AccessLevel.PROTECTED)
public class Lines<SubscriptionDto> extends CustomJsonSerializable {

    @JsonProperty("d.SubscriptionDto")
    private List<SubscriptionDto> subscriptionDtos;
}
