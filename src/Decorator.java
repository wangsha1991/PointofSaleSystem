public class Decorator implements IceCream {
	private String name;
	private int price;

	public Decorator() {
		this.name = null;
		this.price = 0;
	}

	public Decorator(String name, int price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub

		return this.name;
	}

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub

		return this.price;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

	@Override
	public void setPrice(int price) {
		// TODO Auto-generated method stub
		this.price = price;
	}

}
