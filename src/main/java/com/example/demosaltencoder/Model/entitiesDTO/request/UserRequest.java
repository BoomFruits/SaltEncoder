package com.example.demosaltencoder.Model.entitiesDTO.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private Long id;
    private String name;
    private String password;
    private String role; //Example USER,ADMIN
    private String salt;
}
