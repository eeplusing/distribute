package com.lixuan.corejava2.ch9.client;
import java.rmi.RemoteException;

import javax.naming.NamingException;

public class WarehouseClient
{
	public static void main(String[] args) throws NamingException, RemoteException
	{
		WarehouseService service = new WarehouseService();
		Warehouse port = service.getPort(Warehouse.class);
		String descr = "shoes";
		double price = port.getPrice(descr);
		System.out.println(descr + ":" + price);
	}
}
