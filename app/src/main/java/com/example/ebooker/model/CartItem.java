package com.example.ebooker.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

public class CartItem implements Serializable {
  private String createdAt;

  private Integer quantity;

  private Integer BookId;

  private Integer customerId;

  private Integer id;

  private String updatedAt;

  public String getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public Integer getQuantity() {
    return this.quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Integer getBookId() {
    return this.BookId;
  }

  public void setBookId(Integer BookId) {
    this.BookId = BookId;
  }

  public Integer getCustomerId() {
    return this.customerId;
  }

  public void setCustomerId(Integer customerId) {
    this.customerId = customerId;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUpdatedAt() {
    return this.updatedAt;
  }

  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }
}
