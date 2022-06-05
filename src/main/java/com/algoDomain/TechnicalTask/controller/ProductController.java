package com.algoDomain.TechnicalTask.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.algoDomain.TechnicalTask.entity.Product;
import com.algoDomain.TechnicalTask.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;


@RestController
@Controller
@RequestMapping("/user")
@Api(value = "/user", tags = "Product Management")

public class ProductController {
	 @Autowired
	    private ProductService productService;
	 @GetMapping("/allProduct")
		@ApiOperation(value = "Get Product", notes = "Get Product Details", tags = { "Product Management" }, response = Iterable.class)
		@ApiResponses(value = { 
				@ApiResponse(code = 200, message = "Successfully Display All product List"),
				@ApiResponse(code = 404, message = "Invalid data"),
				@ApiResponse(code = 500, message = "Internal server error") })
		@RequestMapping(value="allProduct/",method = RequestMethod.GET,produces = "application/json")
		
		public List<Product> getProduct(){
			return this.productService.getProduct();
			
		}
	 @PostMapping("/product")
	 @ApiOperation(value = "Post Product", notes = "Add Product Details", tags = { "Product Management" }, response = Iterable.class)
		@ApiResponses(value = { 
				@ApiResponse(code = 200, message = "Successfully Display All product List"),
				@ApiResponse(code = 404, message = "Invalid data"),
				@ApiResponse(code = 500, message = "Internal server error") })
		@RequestMapping(value="product/",method = RequestMethod.POST,produces = "application/json")
		
		public Product addProduct(@RequestBody Product product) {
			return this.productService.addProduct(product);
		}
	 @GetMapping("/product/{productId}")
		@ApiOperation(value = "Get Product", notes = "Get Product Details", tags = { "Product Management" }, response = Iterable.class)
		@ApiResponses(value = { 
				@ApiResponse(code = 200, message = "Successfully Display All product List"),
				@ApiResponse(code = 404, message = "Invalid data"),
				@ApiResponse(code = 500, message = "Internal server error") })
		@RequestMapping(value="/product/{productId}",method = RequestMethod.GET,produces = "application/json")
		
		public Object getProduct(@PathVariable int productId) {
			return productService.getProduct(productId);
		}
		
		//update student using put request
		
		  @PutMapping("/product/{productId}")
			@ApiOperation(value = "Update Product", notes = "Update Product Details", tags = { "Product Management" }, response = Iterable.class)
			@ApiResponses(value = { 
					@ApiResponse(code = 200, message = "Successfully Display All product List"),
					@ApiResponse(code = 404, message = "Invalid data"),
					@ApiResponse(code = 500, message = "Internal server error") })
			@RequestMapping(value="product/{productId}",method = RequestMethod.PUT,produces = "application/json")
			
		  public ResponseEntity<HttpStatus> updateProduct(@RequestBody Product productId) {
				try {
					this.productService.updateProduct(productId);
					return new ResponseEntity<>(HttpStatus.OK);
							
				}
				catch (Exception e) {
					return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
		  }
		 	
		//delete the student 
		@DeleteMapping("/product/{productId}")
		@ApiOperation(value = "Delete Product", notes = "Delete Product Details", tags = { "Product Management" }, response = Iterable.class)
		@ApiResponses(value = { 
				@ApiResponse(code = 200, message = "Successfully Display All product List"),
				@ApiResponse(code = 404, message = "Invalid data"),
				@ApiResponse(code = 500, message = "Internal server error") })
		@RequestMapping(value="product/{productId}",method = RequestMethod.DELETE,produces = "application/json")
		
		public ResponseEntity<HttpStatus> deleteProduct(@PathVariable int productId) {
			try {
				this.productService.deleteProduct(productId);
				return new ResponseEntity<>(HttpStatus.OK);
						
			}
			catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

}
