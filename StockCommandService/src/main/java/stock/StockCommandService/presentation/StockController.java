package stock.StockCommandService.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stock.StockCommandService.domain.Stock;
import stock.StockCommandService.service.StockService;

@RestController
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping("/addStock")
    public ResponseEntity<?> addStock(Stock newStock){
        Stock stock =stockService.addStock(newStock);
        return new ResponseEntity<Stock>(stock, HttpStatus.OK);
    }
    @PutMapping("/updateStock")
    public ResponseEntity<Stock> updateStock(Stock newStock){
        Stock stock =stockService.updateStock(newStock);
        return new ResponseEntity<Stock>(stock, HttpStatus.OK);
    }

    @DeleteMapping("/deleteStock/{productNumber}")
    public void deleteStock(@PathVariable String  productNumber){
        stockService.deleteStock(productNumber);
    }


}
