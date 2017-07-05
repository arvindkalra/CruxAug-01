
public class printAllArmstrong {

	public static void main(String[] args) {
		int count = 100;
		while (count < 1000) {
			int gcount = count;
			int sum = 0;
			while (count > 0) {
				int j = count % 10;
				count = count / 10;
				int j3 = j * j * j;
				sum += j3;
			}
			if (sum == gcount) {
				System.out.println(sum);
			}
			count = gcount++;
		}
	}

}
