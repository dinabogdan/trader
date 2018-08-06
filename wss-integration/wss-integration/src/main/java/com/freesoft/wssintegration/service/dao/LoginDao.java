package com.freesoft.wssintegration.service.dao;

import com.freesoft.wssintegration.entity.LoginEntity;
import com.freesoft.wssintegration.model.response.login.LoginResponse;
import com.freesoft.wssintegration.repository.LoginRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class LoginDao {

    private final LoginRepository loginRepository;

    public void save(LoginResponse loginResponse) {
        LoginEntity loginEntity = LoginEntity.builder()
                .sessionId(loginResponse.getPayload().getUser().getSid())
                .occurredAt(System.currentTimeMillis())
                .build();
        loginRepository.save(loginEntity);
    }
}
