package query.ProductQueryService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import query.ProductQueryService.data.ProductDTORepositoryQuery;
import query.ProductQueryService.domain.ProductDTO;

import java.util.List;
import java.util.Optional;

@Service
public class QueryService {
    @Autowired
    ProductDTORepositoryQuery productDTORepoQuery;

    public List<ProductDTO> getAllProduct(){
        return productDTORepoQuery.findAll();
    }

    public Optional<ProductDTO> getProduct(String id){
        return productDTORepoQuery.findById(id);
    }
}
