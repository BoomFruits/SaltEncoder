package com.example.demosaltencoder.Service;

import com.example.demosaltencoder.Model.MyUser;
import com.example.demosaltencoder.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserDetailService implements UserDetailsService {
    public final UserRepo userRepo;

    public UserDetailService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findMyUserByName(username).orElseThrow();
//        Optional<MyUser> userObj =userRepo.findMyUserByName(username);
//        if(userObj.isPresent()){
//            MyUser user = userObj.get();
//            return User.builder()
//                    .username(user.getName())
//                    .password(user.getPassword())
//                    .roles(user.getRole())
//                    .build();
//        }
//        else{
//            throw new UsernameNotFoundException(username);
//        }
    }
}
