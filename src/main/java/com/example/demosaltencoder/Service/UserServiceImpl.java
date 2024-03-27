package com.example.demosaltencoder.Service;

import com.example.demosaltencoder.Model.MyUser;
import com.example.demosaltencoder.Model.ResponseAPI;
import com.example.demosaltencoder.Repository.UserRepo;
import com.example.demosaltencoder.config.CustomPasswordEncoder;
import com.example.demosaltencoder.Util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    public final UserRepo userRepo;
    private final CustomPasswordEncoder customPasswordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    public UserServiceImpl(UserRepo userRepo,CustomPasswordEncoder customPasswordEncoder) {
        this.userRepo = userRepo;
        this.customPasswordEncoder = customPasswordEncoder;
    }
    @Override
    public ResponseAPI registerUser(MyUser user) {
        if(user.getName().isEmpty() || user.getPassword().isEmpty()) {
            return new ResponseAPI("404", "Bad Request");
        }
        MyUser newUser = new MyUser();
        newUser.setId(user.getId());
        newUser.setName(user.getName());
        newUser.setRole(user.getRole());
        newUser.setPassword(customPasswordEncoder.encode(user.getPassword()));
        userRepo.save(newUser);
        return new ResponseAPI("200","OK");
    }
}
