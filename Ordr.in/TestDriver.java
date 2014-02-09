public class TestDriver {
	public static void main(String[] args)
	{
		Site s=new Site();
		s.addOwner("Teddy");
		s.readSale(0,0,"10128");
		s.addStaff(0,0,"Meet");
		s.addItem(0,0,new FoodItem("Cookie",3.75,2));
		s.readSale(0,1,"10028");
		s.addItem(0,1,new FoodItem("Cake",3.77,2));
		s.addOwner("Nate");
		s.readSale(1,0,"12345");
		s.addItem(1,0,new FoodItem("Cheese",4.01,4));
	}
}
