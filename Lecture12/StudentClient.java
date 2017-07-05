package Lecture12;

public class StudentClient {

	public static void main(String[] args) throws Exception {
		Student[] students = new Student[1000];
		
		for(int i = 0; i < 1000; i++){
			students[i] = new Student(i + "th pupil");
			System.out.println("Number of students = " + Student.GetNumStudents());
		}
		
		System.out.println(Student.GetNumStudents() + " exist.");
		
//		Student st = new Student("Test");
		Student.SleepyGoodMorning();
//		Student.NonSleepyGoodMorning(); non-static not allowed on class.
		
		students[0].SleepyGoodMorning();
		students[0].NonSleepyGoodMorning();
		
		System.out.println("Hello World");
	}

}
