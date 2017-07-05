package Lecture18;

import Lecture18.LinkedList;

public class GLLClient {

	public static void main(String[] args) throws Exception{
		LinkedList<Car> list = new LinkedList<>();
//		 Client for add functions
		list.AddFirst(new Car(10, 20));
		list.Display();

		list.AddLast(new Car(30, 200));
		list.Display();

		list.AddFirst(new Car(25, 150));
		list.Display();

		list.AddLast(new Car(40, 250));
		list.Display();

		list.AddAt(new Car(60, 30), 0);
		list.Display();

		list.AddAt(new Car(-10, 20), 5);
		list.Display();

		list.AddAt(new Car(50, 210), 3);
		list.Display();
		list.AddFirst(new Car(35, 150));
		// client for reverse functions
		list.Reverse_List_Iterative();
		list.Display();
		System.out.println("*******************");
		list.Reverse_Pointer_Iterative();
		list.Display();
		System.out.println("*******************");
		list.Reverse_Pointer_Recurssive();
		list.Display();
		System.out.println("*******************");
		list.Reverse_Data_Recurssive();
		list.Display();
		System.out.println("*******************");
		// client for mid function
		System.out.println(list.mid());
		// client for kth from last
		System.out.println(list.KthFromLast(2));
		System.out.println("*******************");
		// client for merge sort
		list.mergeSort();
		list.Display();
	}

}
