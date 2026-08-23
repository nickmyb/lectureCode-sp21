public class IntNList {
	public int first;
	public IntNList rest;

	public static void main(String[] args) {
		IntNList L = new IntNList();
		L.first = 5;

		L.rest = new IntNList();
		L.rest.first = 10;

		L.rest.rest = new IntNList();
		L.rest.rest.first = 15;
	}
} 