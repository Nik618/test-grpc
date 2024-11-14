package com.example.testgrpc.repository;

import com.example.testgrpc.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    UserEntity findByUsername(String username);

    UserEntity findById(int id);

    List<UserEntity> findAllByUsername(String username);
}
