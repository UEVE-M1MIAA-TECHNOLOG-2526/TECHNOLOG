package ex1;

public class Exo
{
	public static void main(String[] args)
	{
		System.out.println(Exo.class.getPackage().getName() + "\n");
		
		// Remplissage de la carte Rapid Sandwich
		MenuRapidSandwich mrs = new MenuRapidSandwich();
		mrs.addMenuItem(new MenuItem("Le vegetarien", "laitue, tomate, oeufs, gruyere", 2.5));
		mrs.addMenuItem(new MenuItem("Le parisien", "jambon, emmental, cornichon, beurre", 3.0));
		mrs.addMenuItem(new MenuItem("L'italien", "jambon de Parme, mozzarella, tomate", 3.0));
		mrs.addMenuItem(new MenuItem("L'americain", "steak hache, frites", 4.5));
		mrs.addMenuItem(new MenuItem("Le chaud", "saucisse, bechamel, gruyere", 4.5));

		// Remplissage de la carte Bon Reveil
		MenuBonReveil mbr = new MenuBonReveil();
		mbr.addMenuItem(new MenuItem("Reveil 1", "1 Cafe ou 1 Chocolat + 1 croissant", 2.0));
		mbr.addMenuItem(new MenuItem("Reveil 2", "1 Cafe ou 1 Chocolat + 1 pain au chocolat", 2.5));
		mbr.addMenuItem(new MenuItem("Reveil 3", "1 Cafe ou 1 Chocolat + 1 croissant + 1 tartine", 3.0));
		mbr.addMenuItem(new MenuItem("Reveil 4", "1 Cafe ou 1 Chocolat + 1 pain au chocolat + 1 tartine", 3.5));

		// Le serveur
		Waiter w = new Waiter(mbr, mrs);
		System.out.println("+++ Rapid Sandwich");
		System.out.println(w.displayMenuRapidSandwich());
		System.out.println("+++ Bon Reveil");
		System.out.println(w.displayMenuBonReveil());
		System.out.println("+++ Recuperation du sandwich americain");
		System.out.println(w.displayMenuItem("L'americain"));
		System.out.println("+++ Recuperation du reveil 3");
		System.out.println(w.displayMenuItem("Reveil 3"));
		System.out.println("+++ Recuperation du prix du reveil 2");
		System.out.println(w.displayPrice("Reveil 2"));
		System.out.println("+++ Recuperation de la composition du sandwich chaud");
		System.out.println(w.displayComposition("Le chaud"));
	}
}
