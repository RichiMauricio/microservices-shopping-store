/**
 * 
 */
package io.rquimbiulco.shoppingservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.rquimbiulco.shoppingservice.model.Product;

/**
 * @author Richard
 *
 */
@FeignClient(name = "product-service")
@RequestMapping(value = "/product")
public interface ProductClient {
	
	@GetMapping(value = "/findProduct/{productId}")
	public ResponseEntity<Product> getProduct(@PathVariable("productId") Long productId);

	@GetMapping(value = "/updateStockProduct/{idProduct}/stock")
	public ResponseEntity<Product> updateStockProduct(@PathVariable("idProduct") Long idProduct,
			@RequestParam(name = "quantity", required = true) Double quantity);

}
