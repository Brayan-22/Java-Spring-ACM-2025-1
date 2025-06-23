package com.acm.advices.service;


import com.acm.advices.model.User;

import java.util.Optional;

public interface IUserService extends BaseService<User> {
    Optional<User> findByEmail(String email);
}
