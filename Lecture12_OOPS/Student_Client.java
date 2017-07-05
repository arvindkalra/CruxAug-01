package Lecture12_OOPS;

public class Student_Client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Student[] students = new Student[1000];
		System.out.println("Roll No.\t Name");
		for (int i = 0; i < 1000; i++) {
			students[i] = new Student(i + "th Student");
			}
		for(int i = 0; i<1000; i+=10){
			System.out.println(students[i].getRollNo() + "\t \t" + students[i].getName());
		}
	}

}
