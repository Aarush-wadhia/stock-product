package com.yash.stockapp.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO {
	private int id;
	private String product_name;
	private int product_price;
	private String product_brand;
}
