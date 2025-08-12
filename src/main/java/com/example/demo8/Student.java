package com.example.demo8;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Student {
  @Id

  private String indexNo;
  private String name;
  private double gpa;
  private Date dob;

}
