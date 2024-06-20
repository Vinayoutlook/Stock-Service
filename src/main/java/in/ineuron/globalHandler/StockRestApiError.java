package in.ineuron.globalHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.ineuron.exception.StockNotFoundException;

@RestControllerAdvice
public class StockRestApiError {

	@ExceptionHandler(StockNotFoundException.class)
	public ResponseEntity<String> handleStockNotFoundException(StockNotFoundException se){
		return new ResponseEntity<String>("Stock not found",HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e){
		return new ResponseEntity<String>("Other exception",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
