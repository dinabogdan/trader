package com.freesoft.wssintegration.service.dao;

import com.freesoft.wssintegration.entity.LoginEntity;
import com.freesoft.wssintegration.repository.LoginRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class LoginDao {

    private final LoginRepository loginRepository;

    public void save(LoginEntity loginEntity) {
        loginRepository.save(loginEntity);
    }
}
