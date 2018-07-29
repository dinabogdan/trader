package com.freesoft.wssintegration;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.freesoft.wssintegration.model.response.login.LoginResponse;
import com.freesoft.wssintegration.model.response.login.UserEnvDto;
import com.freesoft.wssintegration.model.wss.WssBaseRequest;
import com.freesoft.wssintegration.model.wss.WssLoginRequest;
import com.freesoft.wssintegration.websocket.WssClient;
import lombok.extern.java.Log;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@Log
@SpringBootTest
@RunWith(SpringRunner.class)
public class WssIntegrationApplicationTests {

    @Autowired
    private WssClient wssClient;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testWssClientSendMessage() {
        try {
            JSONObject jsonObject = new JSONObject()
                    .put("bm", new JSONObject()
                            .put("pid", 101)
                            .put("csq", 1)
                            .put("payload", new JSONObject()
                                    .put("@class", "p.Login")
                                    .put("username", "dinabogdan")
                                    .put("password", "*****")));
            wssClient.sendMessage(jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
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

    @Test
    public void testStringToLoginResponse() {
        String message = "{\"bm\":{\"pid\":101,\"user\":\"dinabogdan\",\"ktime\":1532884851982,\"longid\":0,\"csq\":1,\"payload\":{\"@class\":\"d.UserEnvDto\",\"user\":{\"code\":\"dinabogdan\",\"status\":1,\"name\":\"Bogdan Dina\",\"grp\":\"SIGNUP\",\"pwd\":\"\",\"pgl\":100,\"ipa\":\"\",\"lsi\":\"\",\"lec\":0,\"cst\":1,\"mxs\":500,\"flts\":false,\"lst\":\"2018-07-29 20:20:51.966\",\"com\":\"\",\"efc\":\"\",\"lpc\":\"2018-07-13 14:59:12.814\",\"sid\":\"7198244FDF63B2B21B84B9219AFA7EACEFDD615C\",\"prf\":\"CLIENT\",\"ref\":\"\",\"uty\":1,\"uti\":\"2018-07-29 20:20:51.966\",\"uui\":\"dinabogdan\",\"uws\":\"109.97.155.93\",\"role\":3,\"ckpn\":false,\"pin\":\"\",\"pet\":\"2028-07-20 16:39:12.792\",\"pnet\":\"2028-07-20 16:39:12.792\",\"hec\":0,\"pnec\":0,\"pec\":0,\"dropcpy\":false,\"sco\":0,\"lco\":\"\"},\"symbols\":{\"d.SubscriptionDto\":[{\"exchange\":\"BVB\",\"symbol\":\"BRD\"},{\"exchange\":\"BVB\",\"symbol\":\"BRK\"},{\"exchange\":\"BVB\",\"symbol\":\"BVB\"},{\"exchange\":\"BVB\",\"symbol\":\"COTE\"},{\"exchange\":\"BVB\",\"symbol\":\"EBS\"},{\"exchange\":\"BVB\",\"symbol\":\"EL\"},{\"exchange\":\"BVB\",\"symbol\":\"FP\"},{\"exchange\":\"BVB\",\"symbol\":\"IMP\"},{\"exchange\":\"BVB\",\"symbol\":\"SIF1\"},{\"exchange\":\"BVB\",\"symbol\":\"SIF2\"},{\"exchange\":\"BVB\",\"symbol\":\"SIF3\"},{\"exchange\":\"BVB\",\"symbol\":\"SIF4\"},{\"exchange\":\"BVB\",\"symbol\":\"SIF5\"},{\"exchange\":\"BVB\",\"symbol\":\"SNG\"},{\"exchange\":\"BVB\",\"symbol\":\"SNN\"},{\"exchange\":\"BVB\",\"symbol\":\"SNP\"},{\"exchange\":\"BVB\",\"symbol\":\"TEL\"},{\"exchange\":\"BVB\",\"symbol\":\"TGN\"},{\"exchange\":\"BVB\",\"symbol\":\"TLV\"},{\"exchange\":\"BVB\",\"symbol\":\"TVBETETF\"}]},\"tksType\":\"Arena-XT.DEMO 2.1.0\"}}}";
        try {
            JSONObject jsonObject = new JSONObject(message).getJSONObject("bm");
            byte[] jsonData = jsonObject.toString().getBytes();
            ObjectMapper objectMapper = new ObjectMapper();
            LoginResponse loginResponse = objectMapper.readValue(jsonData, LoginResponse.class);
            Assert.assertNotNull(loginResponse);
            log.info("##### LoginResponse: " + loginResponse.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
