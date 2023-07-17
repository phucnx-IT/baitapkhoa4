package com.cybersoft.baitapkhoa4.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String fullName;
    private String password;
    private String avatar;
    private String phone;
    private String address;
    private String website;
    private String facebook;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

}
