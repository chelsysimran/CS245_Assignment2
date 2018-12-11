//Chelsy Simran 
//CS 245: Assignment 2

import java.lang.Math;

public class Hashtable 

{
	class Node 
	{
		private String key;
		private String value;
		private Node next;
		
		public Node(String key, String value) 
		{
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}
	
	private Node[] arr;
	
	public Hashtable() 
	{
		this.arr = new Node[10000];
	}

	public void put(String key, String val) 
	{
		int position = Math.abs(key.hashCode()) % arr.length;
		Node head = arr[position];
		Node start = new Node(key, val);
		start.next = head;
		arr[position] = start;
	}

	public String get(String key) 
	{
		int position = Math.abs(key.hashCode()) % arr.length;
		Node head = arr[position];
		if(head == null) 
			return null;
		while(head != null) 
		{
			if(head.key.equals(key))
				return head.value;
			head = head.next;
		}
		return null;
	}

	public String remove(String key) 
	{
		int position = Math.abs(key.hashCode()) % arr.length;
		Node head = arr[position];
		
		if(head == null) 
			return null;
		
		if(head.key.equals(key)) 
		{
			arr[position] = head.next;
			return head.value;
		}
		
		Node prev = head;
		while(head != null) 
		{
			if(head.key.equals(key)) 
			{
				prev.next = head.next;
				return head.value;
			}
			prev = head;
			head = head.next;
		}
		return null;
		
	}

	public boolean containsKey(String key) 
	{
		return arr[Math.abs(key.hashCode()) % arr.length] != null;
	}
}