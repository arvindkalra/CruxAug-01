package Lecture12_StacksAndQues;

public class QuesClient {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		int N = 5;
		QuesUsingArrays q = new QuesUsingArrays(N);
		
		q.enque(55);
		PrintQueInfo(q);
		
		q.enque(63);
		PrintQueInfo(q);
		
		q.enque(82);
		PrintQueInfo(q);
		
		q.enque(97);
		PrintQueInfo(q);
		
		q.deque();
		PrintQueInfo(q);

		q.deque();
		PrintQueInfo(q);
	
		q.enque(-1);
		PrintQueInfo(q);
		
		q.enque(2);
		PrintQueInfo(q);
	
		
	}

	public static void PrintQueInfo(QuesUsingArrays q) throws Exception {
		System.out.println(q.IsEmpty());
		System.out.println(q.size());
		System.out.println(q.front());
		q.display();
		System.out.println("**************************************");
	}
	
	public static void reverse(QuesUsingArrays q){
		
	QuesUsingArrays q1 = new QuesUsingArrays(q.getSize()-1);
	
	
	}
}
