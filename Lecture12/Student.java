package Lecture12;

public class Student {
	// private means can't be accessed outside
	private String name;
	
	// public getter
	public String getName(){
		return this.name;
	}
	
	// public setter with business rules
	public void setName(String name) throws Exception {
		if(name.equals("") || name == null){
			// A way of telling the using developer that he/she might be making a mistake.
			throw new Exception("Names can't be null or empty");
		}
		
		this.name = name;
	}
	
	// final's can't be changed and hence can be public.
	public final int rollNo;
	
	// static means, it belongs to the whole class. memory saved. Change once for all objects.
	private static int NumOfStudents = 0;
	
	public static int GetNumStudents(){
		return Student.NumOfStudents;
	}
	
	// nothing more than both static and final
	public static final int MAX_STUDENTS = 1000;
	
	// Constructor - no return type
	// If no constructor, java provides default constructor
	// But if you write a constructor, java removes its own constructor
	// Private constructors are allowed - will discuss more in singleton.
	public Student(String name) throws Exception {
		// static is preferrably used by class name
		if(Student.NumOfStudents == Student.MAX_STUDENTS){
			throw new Exception("Max limit reached");
		}
		
		this.setName(name);
		Student.NumOfStudents++;
		this.rollNo = Student.NumOfStudents;
	}
	
	public static void SleepyGoodMorning(){
//		System.out.println(this); this not available 
//		System.out.println(rollNo); not-static not available
// 		Can be called directly via the class name as it belongs to the class and not the object.
		System.out.println(Student.NumOfStudents + " out of " + Student.MAX_STUDENTS + 
						   " wish me a sleepy good morning");
	}
	
	public void NonSleepyGoodMorning(){
		// but static can be accessed in non-static functions
		System.out.println("But " + this.name + " wishes me a fresh morning.");
		System.out.println(Student.NumOfStudents + " out of " + Student.MAX_STUDENTS + 
				   " wish me a sleepy good morning");
	}
}
