package in.ineuron.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.entity.StockPrice;
import in.ineuron.exception.StockNotFoundException;
import in.ineuron.repository.StockRepository;

@Service
public class StockPriceServiceImpl implements IStockPriceService {

	@Autowired
	private StockRepository repo;
	
	@Override
	public Double findByCompanyName(String companyName) {
		StockPrice stockprice=repo.findByCompanyName(companyName);
		if(stockprice==null) {
			throw new StockNotFoundException("Stock not found");
		}
		return stockprice.getCompanyPrice();
	}

}
