package com.lixuan.corejava2.ch9.server;

import javax.xml.ws.Endpoint;

public class WarehouseServer
{
	public static void main(String[] args)
	{
		Endpoint.publish("http://localhost:8080/WebService/warehouse", new Warehouse());
	}
}
