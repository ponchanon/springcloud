package query.ProductQueryService.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import query.ProductQueryService.domain.ProductDTO;

@Repository
public interface ProductDTORepositoryQuery extends MongoRepository<ProductDTO,String> {
}
