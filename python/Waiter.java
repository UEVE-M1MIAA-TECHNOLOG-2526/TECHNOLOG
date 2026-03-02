package ex1;

public class Waiter
{
	private MenuBonReveil menuBonReveil;
	private MenuRapidSandwich menuRapidSandwich;

	public Waiter(MenuBonReveil menuBonReveil, MenuRapidSandwich menuRapidSandwich)
	{
		this.menuBonReveil = menuBonReveil;
		this.menuRapidSandwich = menuRapidSandwich;
	}

	public String displayMenuBonReveil()
	{
		return menuBonReveil.toString();
	}

	public String displayMenuRapidSandwich()
	{
		return menuRapidSandwich.toString();
	}

	public String displayMenuItem(String itemName)
	{
		MenuItem item = findMenuItemFrom(itemName);
		if (item == null)
			return "";
		else
			return item.toString();
	}

	public String displayPrice(String itemName)
	{
		MenuItem item = findMenuItemFrom(itemName);
		if (item == null)
			return "0.0";
		else
			return String.valueOf(item.getPrice());
	}

	public String displayComposition(String itemName)
	{
		MenuItem item = findMenuItemFrom(itemName);
		if (item == null)
			return "";
		else
			return item.getComposition();
	}

	private MenuItem findMenuItemFrom(String itemName)
	{
		// on peut itérer sur les items de plusieurs manières...
		if (itemName != null)
		{
			// parcours avec un indice
			MenuItem[] items = menuBonReveil.getMenuItems();
			for (int i=0 ; i<items.length ; ++i)
				if (items[i].getName() == itemName)
					return items[i];

			// parcours avec un foreach  
			for (MenuItem item : menuRapidSandwich.getMenuItems())
				if (item.getName() == itemName)
					return item;
		}
		
		return null;
	}
}
