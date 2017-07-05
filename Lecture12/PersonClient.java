package Lecture12;

public class PersonClient {

	public static void main(String[] args) {
		Person p1 = new Person(3, "Aryan");
		System.out.println(p1.name);
//		Person p2 = new Person(32, "Bhaiya");
//		int age = 28;
//		String name = "Sumeet";
		
//		Test1(p1, age, name, p2.age, p2.name);
//		
//		System.out.println("**********************************");
//		System.out.println(p1.age);
//		System.out.println(p1.name);
//		System.out.println(age);
//		System.out.println(name);
//		System.out.println(p2.age);
//		System.out.println(p2.name);
		
//		Test2(p1, p2);
//		System.out.println("**********************************");
//		System.out.println(p1.age);
//		System.out.println(p1.name);
//		System.out.println(p2.age);
//		System.out.println(p2.name);
		
//		Test3(p1, p2);
//		System.out.println(p1.age);
//		System.out.println(p1.name);
//		System.out.println(p2.age);
//		System.out.println(p2.name);
	}

	public static void Test1(Person p, int age1, String name1, int age2, String name2){
		System.out.println("**********************************");
		System.out.println(p.age);
		System.out.println(p.name);
		System.out.println(age1);
		System.out.println(name1);
		System.out.println(age2);
		System.out.println(name2);
		
		p.age = 0;
		p.name = "";
		age1 = 0;
		name1 = "";
		age2 = 0;
		name2 = "";
		
		System.out.println("**********************************");
		System.out.println(p.age);
		System.out.println(p.name);
		System.out.println(age1);
		System.out.println(name1);
		System.out.println(age2);
		System.out.println(name2);
	}
	
	public static void Test2(Person p1, Person p2){
		Person temp = p1;
		p1 = p2;
		p2 = temp;
	}

	public static void Test3(Person p1, Person p2){
		int temp1 = p1.age;
		p1.age = p2.age;
		p2.age = temp1;
		
		String temp2 = p1.name;
		p1.name = p2.name;
		p2.name = temp2;
	}
}
