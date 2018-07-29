package com.freesoft.wssintegration;

import com.freesoft.wssintegration.model.wss.WssBaseRequest;
import com.freesoft.wssintegration.model.wss.WssLoginRequest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WssIntegrationApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void testBaseRequestAndLoginCommand() {
        WssLoginRequest wssLoginRequest = WssLoginRequest.builder()
                .classCommandName("p.Login")
                .username("dinabogdan")
                .password("*******")
                .build();

        WssBaseRequest<WssLoginRequest> wssBaseRequest = new WssBaseRequest(101, 1, wssLoginRequest);
        Assert.assertNotNull(wssBaseRequest);
        System.out.println(wssBaseRequest.toString());
    }
}
