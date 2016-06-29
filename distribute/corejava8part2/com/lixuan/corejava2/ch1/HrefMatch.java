package com.lixuan.corejava2.ch1;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HrefMatch
{
	public static void main(String[] args) throws MalformedURLException, IOException
	{
		String urlString;
		if(args.length > 0)
		{
			urlString = args[0];
		}
		else
		{
			urlString = "http://java.sun.com";
		}
		InputStreamReader in = new InputStreamReader(new URL(urlString).openStream());
		
		StringBuilder input = new StringBuilder();
		int ch;
		while((ch = in.read()) != -1)
		{
			input.append((char)ch);
		}
		String patternString = "<a\\s+href\\s*=\\s*(\"[^\"]*\"|[^\\s>]*)\\s*>";
		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(input);
		
		while(matcher.find())
		{
			int start = matcher.start();
			int end = matcher.end();
			System.out.println(input.substring(start, end));
		}
		
	}

}
