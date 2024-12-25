package com.example.springbootmvc.controller;

import java.security.PublicKey;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springbootmvc.entity.ProductEntity;
import com.example.springbootmvc.modelclass.ProductModel;
import com.example.springbootmvc.service.ProductService;

import jakarta.validation.Valid;
@Controller
public class ProductController {
	@Autowired 
	ProductService productService;
	
//@GetMapping("/productfrom")
//public String getproductFrom() {
//	return "add-product";
//	}
//@PostMapping("/saveproduct")
//public String saveproduct(ProductModel productModel) {
//	productService.saveProductDetails(productModel);
//	return "success";
//}
@GetMapping("/productform")
public String getproductForm(Model model) {
	ProductModel productModel=new ProductModel();
	productModel.setMadein("India");
	productModel.setQuantity(3);
	productModel.setDiscountrate(13);
	model.addAttribute("productModel", productModel);
	return "add-product";
}

@GetMapping("getallproducts")
public String getAllProducts(Model model) {
	List<ProductEntity> products=productService.getAllProducts();
	model.addAttribute("products", products);
	return "Get-Products";
}
@GetMapping("/search")
public String getSearchForm() {
	return "Search-Product";
}
// get by product id
@PostMapping("/searchbyid")
public String getByProductId(@RequestParam Long id,Model model) {
	ProductEntity product=productService.getByProductId(id);
	model.addAttribute("product", product);
	return "Search-Product";
}
// Delete Product Details
@GetMapping("/delete/{id}")
public String deleteByProductId(@PathVariable Long id) {
	productService.deleteByProductId(id);
	return "redirect:/getallproducts";
}
// Edit Product deatils
@GetMapping("/edit/{id}")
public String editProductById(@PathVariable Long id,Model model) {
	ProductModel product=productService.editProductById(id);
	model.addAttribute("product",product);
	model.addAttribute("id", id);
	return "Edit-Form";
}
@PostMapping("/editproductsave/{id}")
public String updateProductById(@PathVariable Long id,ProductModel productModel) {
	productService.updateProductById(id,productModel);
	return "redirect:/getallproducts";
}

}
