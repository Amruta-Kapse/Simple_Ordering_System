package com.example.orderingSystem.model.entity;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Customer_Info")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerEntity {

	@Id
    @Column(name = "Id",insertable=false, updatable=false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @NotNull
    @Column(name = "First_name")
    private String firstName;
    
    @NotNull
    @Column(name = "Last_name")
    private String lastName;

	@Column(name = "Address")
    protected String address;
    
    @NotNull
    @Column(name = "Email")
    private int phoneNo;

	@NotNull
	@Column(name = "Phone_No")
	private String email;


	@Column(name = "Delete_status")
	private boolean Deleted;

}
