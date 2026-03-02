package ex1;

public class MenuBonReveil
{
	private String name = "Carte du Bon Reveil";
	private MenuItem[] items;

	public MenuBonReveil()
	{
		items = new MenuItem[0];
	}

	public String getName()
	{
		return name;
	}

	public MenuItem[] getMenuItems()
	{
		return items;
	}

	public void addMenuItem(MenuItem item)
	{
		if (item == null)
			throw new IllegalArgumentException("Arguments invalides");

		MenuItem[] tmp = new MenuItem[items.length + 1];
		for (int i = 0; i < items.length; ++i)
			tmp[i] = items[i];
		items = tmp;
		items[items.length - 1] = item;
	}

	public String toString()
	{
		String ret = name + "\n";
		for (MenuItem item : items)
			ret += item.toString() + "\n";
		return ret;
	}
}
