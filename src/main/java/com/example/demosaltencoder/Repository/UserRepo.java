package com.example.demosaltencoder.Repository;

import com.example.demosaltencoder.Model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<MyUser,Long> {
    Optional<MyUser> findMyUserByName(String name);
}
