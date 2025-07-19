package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Setter
public class User {
    @Id
    @GeneratedValue
    int id;
    @Column(name = "name")
    String name;
    @Column
    String email;
    @Column
    String phone;
    @Column
    String passwd;
    @Column
    int age;
    @Column
    String nation;
    @Column
    String address;


}
