package com.freesoft.wssintegration.model.wss;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class WssBaseRequest<P> {

    private Integer pid;
    private Integer csq;
    private P payload;
}
