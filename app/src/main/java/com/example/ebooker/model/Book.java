package com.example.ebooker.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

public class Book implements Serializable {
  private Integer store_id;

  private String createdAt;

  private Integer price;

  private String name;

  private String publication_date;

  private Integer id;

  private Integer sales_number;

  private Integer author_id;

  private String desc;

  private String updatedAt;

  public Integer getStore_id() {
    return this.store_id;
  }

  public void setStore_id(Integer store_id) {
    this.store_id = store_id;
  }

  public String getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public Integer getPrice() {
    return this.price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPublication_date() {
    return this.publication_date;
  }

  public void setPublication_date(String publication_date) {
    this.publication_date = publication_date;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getSales_number() {
    return this.sales_number;
  }

  public void setSales_number(Integer sales_number) {
    this.sales_number = sales_number;
  }

  public Integer getAuthor_id() {
    return this.author_id;
  }

  public void setAuthor_id(Integer author_id) {
    this.author_id = author_id;
  }

  public String getDesc() {
    return this.desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public String getUpdatedAt() {
    return this.updatedAt;
  }

  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }
}
