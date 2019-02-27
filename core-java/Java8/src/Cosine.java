
public class Cosine {

	public static void main(String[] args) {
		System.out.println(cosineSimilarity(new int[] {1,1,0},new int[] {1,0,0}));
		System.out.println(cosineSimilarity(new int[] {1,1,0},new int[] {1,1,1}));
	}
	private static double cosineSimilarity(int[] currentBook, int[] book) {
		double product = 0;
		double normCurrentBook = 0;
		double normBook = 0;
		for (int i = 0; i < currentBook.length; i++) {
			product += currentBook[i] * book[i];
			normCurrentBook += Math.pow(currentBook[i], 2);
			normBook += Math.pow(book[i], 2);
		}
		return product / (Math.sqrt(normCurrentBook) * Math.sqrt(normBook));
	}
}
