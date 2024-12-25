package com.example.springbootmvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootmvc.entity.ProductEntity;
import com.example.springbootmvc.modelclass.ProductModel;
import com.example.springbootmvc.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	public void saveProductDetails(ProductModel productModel) {
		double discountPrice;
		discountPrice=productModel.getPrice()*productModel.getDiscountrate()/100;
		double offerPrice;
		offerPrice=productModel.getPrice()-discountPrice;
		double taxPrice;
		taxPrice=offerPrice*0.18;
		double finalPrice;
		finalPrice=offerPrice+taxPrice;
		double stockPrice;
		stockPrice=finalPrice*productModel.getQuantity();
		ProductEntity productEntity=new ProductEntity();
		productEntity.setName(productModel.getName());
		productEntity.setBrand(productModel.getBrand());
		productEntity.setMadein(productModel.getMadein());
		productEntity.setPrice(productModel.getPrice());
		productEntity.setQuantity(productModel.getQuantity());
		productEntity.setDiscountrate(productModel.getDiscountrate());
		productEntity.setDiscountPrice(discountPrice);
		productEntity.setOfferPrice(offerPrice);
		productEntity.setTaxPrice(taxPrice);
		productEntity.setFinalPrice(finalPrice);
		productEntity.setStockPrice(stockPrice);
		productRepository.save(productEntity);
	}
	
	
	public List<ProductEntity>  getAllProducts() {
		List<ProductEntity> products= productRepository.findAll();
		return products;
	}
	
	
	public ProductEntity getByProductId(Long id) {
		Optional<ProductEntity> optionalData=productRepository.findById(id);
		if(optionalData.isPresent())
		{
			ProductEntity product=optionalData.get();
			return product;
		}
		else {
			return null;
		}
	}
	
	
	public void deleteByProductId(Long id) {
		productRepository.deleteById(id);
	}
	
	//edit
	public ProductModel editProductById( Long id) {
		Optional<ProductEntity> optionalData=productRepository.findById(id);
		if(optionalData.isPresent()) {
			ProductEntity productEntity=optionalData.get();
			ProductModel productModel=new ProductModel();
			productModel.setName(productEntity.getName());
			productModel.setBrand(productEntity.getBrand());
			productModel.setMadein(productEntity.getMadein());
			productModel.setPrice(productEntity.getPrice());
			productModel.setQuantity(productEntity.getQuantity());
			productModel.setDiscountrate(productEntity.getDiscountrate());
			return productModel;
		}
		else {
			return null;
		}
	}
// updateing the form

	public void updateProductById(Long id,ProductModel productModel) {
		Optional<ProductEntity> optionalData=productRepository.findById(id);
		if(optionalData.isPresent())
		{
			ProductEntity entity=optionalData.get();
			entity.setName(productModel.getName());
			entity.setBrand(productModel.getBrand());
			entity.setMadein(productModel.getMadein());
			entity.setPrice(productModel.getPrice());
			entity.setQuantity(productModel.getQuantity());
			entity.setDiscountrate(productModel.getDiscountrate());
			double discountPrice;
			discountPrice=productModel.getPrice()*productModel.getDiscountrate()/100;
			double offerPrice;
			offerPrice=productModel.getPrice()-discountPrice;
			double taxPrice;
			taxPrice=offerPrice*0.18;
			double finalPrice;
			finalPrice=offerPrice+taxPrice;
			double stockPrice;
			stockPrice=finalPrice*productModel.getQuantity();
			entity.setDiscountPrice(discountPrice);
			entity.setOfferPrice(offerPrice);
			entity.setTaxPrice(taxPrice);
			entity.setFinalPrice(finalPrice);
			entity.setStockPrice(stockPrice);
			productRepository.save(entity);
		}
		
	}



}

