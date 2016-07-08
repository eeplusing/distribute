package com.lixuan.corejava2.ch9.server;

import java.util.HashMap;
import java.util.Map;
import javax.jws.WebParam;
import javax.jws.WebService;
/**
 * wsgen -keep -cp ./bin -r ./wsdl -s ./src -d ./bin -wsdl com.lixuan.corejava2.ch9.Warehouse
 * 
 * 
 * */
@WebService
public class Warehouse
{
	private Map<String, Double> prices;
	public Warehouse()
	{
		prices = new HashMap<String, Double>();
		prices.put("Blackwell Toaster", 24.95);
		prices.put("Oaven", 34.5);
		prices.put("shoes", 10000000d);
	}
	public double getPrice(@WebParam(name = "description")String description)
	{
		Double price = prices.get(description);
		return price == null ? 0 : price;
	}
	
	
}
