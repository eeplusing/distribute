package com.lixuan.corejava.ch13;

import java.util.SortedSet;
import java.util.TreeSet;
public abstract class TreeSetTest
{
	public static void main(String[] args)
	{
		SortedSet<Item> parts = new TreeSet<Item>();
		parts.add(new Item("Toster", 12345));
		parts.add(new Item("HOster", 88888));
		parts.add(new Item("Jhggg", 3444));
		System.out.println(parts);
		
		SortedSet<Item> sortedByDes = new TreeSet<Item>(
			
		);
		
		/*SortedSet<Item> sortedByDes = new TreeSet<Item>
		(
				new Comparator<Item>()
				{
					public int compare(Item a, Item b)
					{
						String aDes = a.getDescription();
						String bDes = b.getDescription();
						return aDes.compareTo(bDes);
					}
				}
		);*/
		
		sortedByDes.addAll(parts);
		System.out.println(sortedByDes);
	}

}

class Item implements Comparable<Item>
{
	private String description;
	private int partNumber;
	public Item(String aDescription, int aPartNumber)
	{
		this.description = aDescription;
		this.partNumber = aPartNumber;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	
	@Override
	public String toString()
	{
		return "Item [description=" + description + ", partNumber="
				+ partNumber + "]";
	}

	public boolean equals(Object o)
	{
		if(this == o)
			return true;
		if(null == o)
			return false;
		if(getClass() != o.getClass())
			return false;
		Item other = (Item)o;
		return description.equals(other.getDescription()) && partNumber == other.partNumber;
		
	}
	
	
	@Override
	public int compareTo(Item o)
	{
		
		return getDescription().compareTo(o.getDescription());
	}
	
	public int hashCode()
	{
		return 13 * description.hashCode() + 17 * partNumber;
	}
	
	
}
