package com.ludus.tutapp.repository;

import com.ludus.tutapp.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity,Long> {
    UserEntity findByEmail(String email);
    UserEntity findByUserId(String id);

}
