package com.example.demosaltencoder.config.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse  implements Serializable {
    private static final long serialVersionUID = 5926468583005150707L;
    private String jwttoken;
}
