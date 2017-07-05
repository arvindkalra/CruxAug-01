package Lecture18;

import java.util.Comparator;
import java.util.*;

public class Client {

	public static void main(String[] args) {
		Car[] cars = new Car[5];
		cars[0] = new Car(100, 20);
		cars[1] = new Car(80, 40);
		cars[2] = new Car(20, 30);
		cars[3] = new Car(10, 200);
		cars[4] = new Car(75, 50);
		BubbleSort(cars);
		for (int i = 0; i < cars.length; i++) {
			System.out.println(cars[i]);
		}
		System.out.println("***********************************");
		CarSpeedComparator obj = new CarSpeedComparator();
		BubbleSort(cars, obj);
		for (int i = 0; i < cars.length; i++) {
			System.out.println(cars[i]);
		}
	}

	public static <T extends Comparable<T>> void BubbleSort(T[] xyz) {
		int i = 1;
		while (i < xyz.length) {
			for (int j = 0; j < xyz.length - i; j++) {
				if (xyz[j + 1].compareTo(xyz[j]) < 0) {
					T temp = xyz[j];
					xyz[j] = xyz[j + 1];
					xyz[j + 1] = temp;
				}
			}
			i = i + 1;
		}
	}

	public static <T> void BubbleSort(T[] xyz, Comparator<T> comparator) {
		int i = 1;
		while (i < xyz.length) {
			for (int j = 0; j < xyz.length - i; j++) {
				if (comparator.compare(xyz[j + 1], xyz[j]) < 0) {
					T temp = xyz[j];
					xyz[j] = xyz[j + 1];
					xyz[j + 1] = temp;
				}
			}
			i = i + 1;
		}
	}
}
