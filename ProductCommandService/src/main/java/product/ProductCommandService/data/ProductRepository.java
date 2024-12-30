package product.ProductCommandService.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import product.ProductCommandService.domain.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product,String> {
}
