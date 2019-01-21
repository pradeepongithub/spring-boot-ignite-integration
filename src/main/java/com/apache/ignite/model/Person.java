package com.apache.ignite.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.ignite.cache.query.annotations.QueryGroupIndex;
import org.apache.ignite.cache.query.annotations.QuerySqlField;
import lombok.Data;

@Data
@QueryGroupIndex.List(@QueryGroupIndex(name = "idx1"))
public class Person implements Serializable {

  private static final long serialVersionUID = 7398372909927768000L;

  private static final AtomicLong ID_GEN = new AtomicLong();

  @QuerySqlField(index = true)
  private Long id;
  @QuerySqlField(index = true)
  @QuerySqlField.Group(name = "idx1", order = 0)
  private String firstName;
  @QuerySqlField(index = true)
  @QuerySqlField.Group(name = "idx1", order = 1)
  private String lastName;
  private Gender gender;
  private Date birthDate;
  private String country;
  private String city;
  private String address;
  private List<Contact> contacts = new ArrayList<>();

  public void init() {
    this.id = ID_GEN.incrementAndGet();
  }



}
