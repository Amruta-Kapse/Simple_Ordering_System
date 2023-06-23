package com.example.orderingSystem.model.entity;

import java.util.List;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Order_Info")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private CustomerEntity customer;

    @NotNull
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "Id")
    protected List<ItemEntity> items;

    @Column(name = "Order_Amount")
    private Double orderAmount;

}
