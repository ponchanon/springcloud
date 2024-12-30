package stock.StockCommandService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import stock.StockCommandService.data.StockRepository;
import stock.StockCommandService.domain.Stock;

@Service
public class StockService {
    private StockRepository stockRepository;
    //@Autowired
    private StockQueryFeignClient StockQueryFeignClient;

    public Stock addStock(Stock stock){
        StockQueryFeignClient.addSto(stock);
        return stockRepository.save(stock);
    }

    public void deleteStock(String productNumber ){
        StockQueryFeignClient.deleteSto(productNumber);
        stockRepository.deleteById(productNumber);
    }

    public Stock updateStock(Stock stock){
        StockQueryFeignClient.updateSto(stock);
        return stockRepository.save(stock);
    }

    @FeignClient(name = "ProductQueryService", url = "http://localhost:8902")
    interface StockQueryFeignClient {
        @PostMapping("/addStock")
        void addSto(Stock product);

        @PutMapping("/updateStock")
        void updateSto(Stock product);

        @DeleteMapping("/deleteStock/{productNumber}")
        void deleteSto(@PathVariable String productNumber);


    }

}
