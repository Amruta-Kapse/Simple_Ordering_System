package com.example.orderingSystem.model.entity;



import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="Items_info")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItemEntity {
	
	@Id
	@Column(name="Item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	@NotNull
	@Column(name="Item_Name")
	private String itemName;
	
	@Column(name="Item_pieces")
	private List<String> itemPieces;
	
	@NotNull
	@Column(name="Item_price")
	private Double item_Price;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private OrderEntity order;

}
