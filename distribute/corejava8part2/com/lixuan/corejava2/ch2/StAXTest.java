package com.lixuan.corejava2.ch2;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

public class StAXTest
{
	public static void main(String[] args)
	{
		String urlString;
		if(args.length == 0)
		{
			urlString = "http://www.w3c.org";
			System.out.println("Uising " + urlString);
		}
		else
			urlString = args[0];
		try
		{
			URL url = new URL(urlString);
			InputStream in = url.openStream();
			XMLInputFactory factory = XMLInputFactory.newInstance();
			XMLStreamReader parser = factory.createXMLStreamReader(in);
			while(parser.hasNext())
			{
				int event = parser.next();
				if(event == XMLStreamConstants.START_ELEMENT)
				{
					if(parser.getLocalName().equals("a"))
					{
						String href = parser.getAttributeValue(null, "href");
						if(href != null)
							System.out.println(href);
					}
				}
			}
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
