package ua.opnu.practice1_template.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}
