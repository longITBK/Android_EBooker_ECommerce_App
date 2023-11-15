package com.example.ebooker.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;

public class User implements Serializable {
  private String firstName;

  private String lastName;

  private String createdAt;

  private String address;

  private Object phone;

  private Integer id;

  private String avatar;

  private Integer RoleId;

  private String email;

  private Integer age;

  private String username;

  private String updatedAt;

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Object getPhone() {
    return this.phone;
  }

  public void setPhone(Object phone) {
    this.phone = phone;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getAvatar() {
    return this.avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public Integer getRoleId() {
    return this.RoleId;
  }

  public void setRoleId(Integer RoleId) {
    this.RoleId = RoleId;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getAge() {
    return this.age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getUpdatedAt() {
    return this.updatedAt;
  }

  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }
}
