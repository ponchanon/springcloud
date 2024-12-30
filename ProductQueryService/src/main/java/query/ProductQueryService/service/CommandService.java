package query.ProductQueryService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import query.ProductQueryService.data.ProductDTORepository;
import query.ProductQueryService.domain.Product;
import query.ProductQueryService.domain.ProductDTO;
import query.ProductQueryService.domain.Stock;

import java.util.Optional;

@Service
public class CommandService {

    @Autowired
    ProductDTORepository productDTORepository;

    public void addProduct(Product product){
        ProductDTO productDTO = new ProductDTO(product.getProductNumber(),product.getName(),product.getPrice());
        productDTORepository.save(productDTO);
    }
    public void deleteProduct(String  id){
        productDTORepository.deleteById(id);
    }
    public void updateProduct(Product product){
        Optional<ProductDTO> productDTO = productDTORepository.findById(product.getProductNumber());
        if(productDTO.isPresent()){
            productDTO.get().setName(product.getName());
            productDTO.get().setPrice(product.getPrice());
        }
        productDTORepository.save(productDTO.get());
    }

    public void updateQuantity(Stock stock){
        Optional<ProductDTO> productDTO = productDTORepository.findById(stock.getProductNumber());
        productDTO.ifPresent(dto -> dto.setQuantity(dto.getQuantity() + stock.getStockNum()));
        productDTORepository.save(productDTO.get());
    }

    public void setQuantity(Stock stock){
        Optional<ProductDTO> productDTO = productDTORepository.findById(stock.getProductNumber());
        productDTO.ifPresent(dto -> dto.setQuantity(stock.getStockNum()));
        productDTORepository.save(productDTO.get());
    }

    public void deleteQuantity(String  productNumber){
        Optional<ProductDTO> productDTO = productDTORepository.findById(productNumber);
        productDTO.ifPresent(dto -> dto.setQuantity(0));
        productDTORepository.save(productDTO.get());

    }
}

