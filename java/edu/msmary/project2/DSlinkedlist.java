package edu.msmary.project2;

import java.util.Map;

import java.util.AbstractMap;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class DSlinkedlist {

	private class Node {
		public int data;// info stored in this node 
		public Node next;// what is the node following?


		public Node(int _data, Node _next) {
			data = _data;
			next = _next;
		}
	}


	private Node front; // pointer to the first node on the list
	private int numElements; // how many elements the list has

	public DSlinkedlist() {
		front = null;
		numElements = 0;
	}
	/*
	public String getMode () {// Runtime O(n^2)
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		Node ptr = front;
		List <String> it = new ArrayList <String> ();
		while (ptr.next != null) {
			if (map.containsKey(ptr.data)) {
			map.put(ptr.data, map.get(ptr.data)+1);
			}
			else {
				map.put(ptr.data, 1);	
			}
			if (!it.contains(ptr.data)) {
				it.add(ptr.data);
			}
			ptr = ptr.next;
		}
		if (map.containsKey(ptr.data)) {
			map.put(ptr.data, map.get(ptr.data)+1);
		}
		else {
			map.put(ptr.data, 1);
			it.add(ptr.data);
		}
		for (int i = 0; i < it.size(); i++) {
			for (int j = i + 1; j < it.size(); j++) {
				if (map.get(it.get(i)) < map.get(it.get(j))) {
					String temp = it.get(i);
					it.set(i, it.get(j));
					it.set(j, temp);
					
				}
			}
		}
		return it.get(0);

	}
	*/

	public void add(int element) {
		Node newBox = new Node(element, null);
		if (front == null) {
			front = newBox;
		} else {
			Node ptr = front;
			while (ptr.next != null) {
				ptr = ptr.next;


			}
			ptr.next = newBox;


		}
		numElements++;


		// TODO Auto-generated method stub

	}

	public void addToFront(int element) {
		Node newBox = new Node(element, null);
		newBox.next = front;
		front = newBox;
		numElements++;

	}





	public int length() {
		// TODO Auto-generated method stub
		return numElements;
	}


	public void clear() {// Runtime is O(1)
		numElements = 0;// clear all nodes in the list (sets the number of nodes in the list to zero
	}


	public void combine(DSlinkedlist list2) {// Runtime O(n)

		Node ptr = front;

		while (ptr.next != null) {// gets last node in linked list
			ptr = ptr.next;

		}


		for (int i = 0; i < list2.numElements; i++) {// increases numElments by the number of nodes in the second linked list
			numElements++;

		}

		ptr.next = list2.front;// connects the last node in list1 to the 1st node in list2 which is connected with all its other nodes thus adding the together


	}







	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return front == null;
	}

	public String toString() {
		String answer = "["; // put in starting bracket

		if (numElements == 0) {

			return "[]";
		} else {


			Node ptr = front;
			for (int i = 0; i < numElements - 1; i++) // loop thru all but last
			{
				answer = answer + ptr.data + ", "; // put in element with comma
				ptr = ptr.next;
			}
			answer = answer + ptr.data + "]"; // deal with the end
			return answer;
		}
	}


	public int get2(int pos) {
		if (pos > numElements - 1) {
			while (pos > numElements - 1) {
				pos = pos - numElements;
			}
			Node ptr = front;
			for (int i = 0; i < pos; i++) {
				ptr = ptr.next;
			}
			return ptr.data;

		} else {
			Node ptr = front;
			for (int i = 0; i < pos; i++) {
				ptr = ptr.next;


			}
			return ptr.data;

		}

	}
}