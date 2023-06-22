package com.example.orderingSystem.model.entity;

import java.util.List;
import javax.validation.constraints.NotNull;

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
public class OrderEntity {

    @Id
    @JoinColumn(name = "id", columnDefinition = "long default 100")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @ManyToOne(cascade = CascadeType.PERSIST )
    @PrimaryKeyJoinColumn(name = "customerID", referencedColumnName = "Id")
    private CustomerEntity customer;

    @NotNull
    @OneToMany(mappedBy = "order", orphanRemoval = true, cascade = CascadeType.ALL)
    @Column(name = "Item_id")
    protected List<ItemEntity> items;

    @Column(name = "Order_Amount")
    private Double orderAmount;

}
