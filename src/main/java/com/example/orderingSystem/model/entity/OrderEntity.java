package com.example.orderingSystem.model.entity;

import java.util.List;
import javax.validation.constraints.NotNull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="Order_Info")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderEntity{
	    
		@Id
	    @JoinColumn(name = "id",columnDefinition = "long default 100")
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long Id;
	     
		@ManyToOne(cascade = CascadeType.ALL)
	    @PrimaryKeyJoinColumn(name="customerID",referencedColumnName = "Id")
	    private CustomerEntity customerId;
	    
	    @NotNull
	    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "order")
	    @Column(name = "Item_id")
	    protected List<ItemEntity> items;
	    
	    @Column(name = "Order_Amount")
	    private Double orderAmount;
    
}
