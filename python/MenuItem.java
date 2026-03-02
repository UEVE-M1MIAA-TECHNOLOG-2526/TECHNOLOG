package ex1;

public class MenuItem
{
	private String name;
	private String composition;
	private double price;

	public String getName()
	{
		return name;
	}

	public String getComposition()
	{
		return composition;
	}

	public String toString()
	{
		return name + "\t" + composition + "\t" + price;
	}

	public double getPrice()
	{
		return price;
	}

	public MenuItem(String name, String composition, double price)
	{
		if (name == null || composition == null || price <= 0.0)
			throw new IllegalArgumentException("Arguments invalides");

		this.name = name;
		this.composition = composition;
		this.price = price;
	}
}
