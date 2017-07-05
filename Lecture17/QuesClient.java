package Lecture17;

public class QuesClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		QueueUsingLinkedList q = new QueueUsingLinkedList();

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

	public static void PrintQueInfo(QueueUsingLinkedList q) throws Exception {
		System.out.println(q.isEmpty());
		System.out.println(q.size());
		System.out.println(q.front());
		q.display();
		System.out.println("**************************************");
	}

}