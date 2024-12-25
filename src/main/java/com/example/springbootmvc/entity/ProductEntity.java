package com.example.springbootmvc.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="product")
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String brand;
	private String madein;
	private double price;
	private int quantity;
	private int discountrate;
	private double discountPrice;
	private double taxPrice;
	private double offerPrice;
	private double finalPrice;
	private double stockPrice;

}
