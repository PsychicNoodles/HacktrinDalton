public class FoodItem {
	private String name;
	private double price;
	private int quantity;
	public FoodItem(String name,double price,int quantity)
	{
		this.name=name;
		this.price=price;
		this.quantity=quantity;
	}
	public String getName()
	{
		return name;
	}
	public int getQuantity()
	{
		return quantity;
	}
	public double getPrice()
	{
		return price;
	}
	public void setName(String newname)
	{
		name=newname;
	}
	public void setPrice(double newprice)
	{
		price=newprice;
	}
	public void setQuantity(int newquantity)
	{
		quantity=newquantity;
	}
	public void increaseQuantity(int incr)
	{
		quantity=Math.max(quantity+incr,0);
	}
	public String toFancyString()
	{
		return name+"for $"+Double.toString(price);
	}
	public static FoodItem parseItem(String item)
	{
		String[] temp=item.split("~!#!@lol");
		if (temp.length!=3)
			return new FoodItem("Food could not be parsed",0,0);
		return new FoodItem(temp[0],Double.parseDouble(temp[1]),Integer.parseInt(temp[2]));
	}
	public boolean equalsOther(FoodItem other)
	{
		return name.equals(other.getName())&&price==other.getPrice();
	}
	public String toString()
	{
		return name+"~!#!@lol"+Double.toString(price)+"~!#!@lol"+Integer.toString(quantity);
	}
}
