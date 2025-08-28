package com.project.tejas.order_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsDTO {
    private int userId;
    private String userName;
    private String password;
    private String address;
    private String city;
}
