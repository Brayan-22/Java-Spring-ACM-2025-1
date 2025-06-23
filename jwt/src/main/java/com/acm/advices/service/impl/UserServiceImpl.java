package com.acm.advices.service.impl;

import com.acm.advices.model.User;
import com.acm.advices.persistence.entity.UserEntity;
import com.acm.advices.persistence.repository.UserJpaRepository;
import com.acm.advices.service.IUserService;
import com.acm.advices.util.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements IUserService {

    private final UserJpaRepository repository;
    private final UserMapper mapper;

    @Override
    public User save(User model) {
        UserEntity entity = mapper.modelToEntity(model);
        return mapper.entityToModel(repository.save(entity));
    }

    @Override
    public User update(User model) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public User findById(String id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return repository.findAll().stream().map(mapper::entityToModel).toList();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email)
                .map(mapper::entityToModel)
                .or(Optional::empty);
    }
}
