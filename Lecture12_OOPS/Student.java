package Lecture12_OOPS;

public class Student {

	private String name;

	public String getName() {
		return this.name;
	}

	public void SetName(String name) throws Exception {
		if (name.equals("") || name == null) {
			throw new Exception("Name Can't Be Empty...");
		}
		this.name = name;
	}

	public final int RollNo;

	public int getRollNo() {
		return this.RollNo;
	}

	private	static int NoOfStudents = 0;

	public static final int MAX_STUDENTS = 1000;
	
	public Student(String name)throws Exception {
		if(Student.NoOfStudents==Student.MAX_STUDENTS){
			throw new Exception("Max Limit Reached..");
		}
		this.SetName(name);
		Student.NoOfStudents++;
		this.RollNo = Student.NoOfStudents;
	}
}