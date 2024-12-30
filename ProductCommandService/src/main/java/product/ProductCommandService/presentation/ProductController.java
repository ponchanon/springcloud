package product.ProductCommandService.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import product.ProductCommandService.domain.Product;
import product.ProductCommandService.service.ProductService;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity<?> addProduct(Product newProduct){
        Product product =productService.addProduct(newProduct);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }
    @PutMapping("/updateProduct")
    public ResponseEntity<Product> updateProduct(Product newProduct){
        Product product =productService.updateProduct(newProduct);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable String  productNumber){
        productService.deleteProduct(productNumber);
    }

}
