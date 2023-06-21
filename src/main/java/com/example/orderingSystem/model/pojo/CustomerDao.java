package com.example.orderingSystem.model.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class CustomerDao {
	 private Long Id;
	 private String firstName;
	 private String lastName;
	 private String address;
	 private int phoneNo;
	 private String email;
	 private boolean Deleted;

}
