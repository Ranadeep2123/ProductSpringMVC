package com.example.springbootmvc.modelclass;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data

@AllArgsConstructor
@NoArgsConstructor

public class ProductModel {
	private String name;
	private String brand;
	private String madein;
	private double price;
	private int quantity;
	private int discountrate;
	

}
