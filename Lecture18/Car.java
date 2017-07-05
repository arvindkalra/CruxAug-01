package Lecture18;

import java.util.Comparator;

public class Car implements Comparable<Car> {

	int speed;
	int price;

	public Car(int speed, int price) {
		this.speed = speed;
		this.price = price;

	}

	@Override
	public int compareTo(Car sp) {
		return this.price - sp.price;
	}

	@Override
	public String toString() {
		return "[ Speed = " + this.speed + " & Price = " + this.price + " ]";
	}
}

class CarSpeedComparator implements Comparator<Car> {

	@Override
	public int compare(Car o1, Car o2) {
		return o1.speed - o2.speed;
	}
}

class CarPriceComparator implements Comparator<Car> {

	@Override
	public int compare(Car o1, Car o2) {
		return o1.price - o2.price;
	}

}