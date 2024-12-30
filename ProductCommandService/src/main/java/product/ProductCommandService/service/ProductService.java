package product.ProductCommandService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import product.ProductCommandService.data.ProductRepository;
import product.ProductCommandService.domain.Product;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

//    @Autowired
    private ProductQueryFeignClient productQueryFeignClient;

    //add Product
    public Product addProduct(Product product){
        productQueryFeignClient.addProduct(product);
        return productRepository.save(product);
    }
    //update Product
    public Product updateProduct(Product product){
        productQueryFeignClient.updateProduct(product);
        return productRepository.save(product);
    }
    //Delete Product
    public void deleteProduct(String productNumber){
        productQueryFeignClient.deleteProduct(productNumber);
        productRepository.deleteById(productNumber);
    }






    @FeignClient(name= "ProductQueryService",url = "http://localhost:8902")
    interface ProductQueryFeignClient{
        @PostMapping("/add")
        public  void addProduct(Product product);
        @PutMapping("/update")
        public  Product updateProduct(Product product);
        @DeleteMapping("/delete/{productNumber}")
        public void deleteProduct(@PathVariable String productNumber);
    }
}
