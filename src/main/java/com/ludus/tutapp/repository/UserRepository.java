package com.ludus.tutapp.repository;

import com.ludus.tutapp.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<UserEntity,Long> {
}
