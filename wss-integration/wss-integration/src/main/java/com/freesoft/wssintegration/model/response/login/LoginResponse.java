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
public class LoginResponse extends CustomJsonSerializable {

    @JsonProperty("pid")
    private Integer pid;
    @JsonProperty("user")
    private String user;
    @JsonProperty("ktime")
    private Long ktime;
    @JsonProperty("longid")
    private Integer longid;
    @JsonProperty("csq")
    private Integer csq;
    @JsonProperty("payload")
    private UserEnvDto payload;
}
