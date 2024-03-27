package com.example.demosaltencoder.Service;

import com.example.demosaltencoder.Model.MyUser;
import com.example.demosaltencoder.Model.ResponseAPI;

public interface UserService {
    ResponseAPI registerUser(MyUser user);
}
