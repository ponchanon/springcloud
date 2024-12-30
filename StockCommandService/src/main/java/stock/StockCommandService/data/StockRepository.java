package stock.StockCommandService.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import stock.StockCommandService.domain.Stock;

@Repository
public interface StockRepository extends MongoRepository<Stock,String> {

}
