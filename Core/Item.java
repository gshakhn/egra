/**
 * A generic object.
 * 
 * @author George Shakhnazaryan
 * 
 */
public abstract class Item
{

	/**
	 * The ID of this <code>Item</code>. Each <code>Item</code> has an ID,
	 * but a specific instance of an <code>Item</code> has its own uniqueID.
	 */
	public String id;

	/**
	 * The unique ID of a specific instance of an <code>Item</code>. Defaults
	 * to null when an <code>Item</code> is created.
	 */
	public String uniqueID;

	/**
	 * The name of this <code>Item</code> for the end user.
	 */
	public String name;

	/**
	 * The cost of this <code>Item</code> in monetary units.
	 */
	public int cost;

	/**
	 * The type of Item. The types can be: 0 - Miscellenous Item 1 - Amulet 2 -
	 * Boots 3 - Bracers 4 - Chest 5 - Gloves 6 - Goggles 7 - Hat 8 - Melee
	 * Weapon 9 - Pants 10 - Ring 11 - Shield 12 - Shoulder 13 - Socks 14 - Belt
	 * 15 - Earring
	 */
	public enum ItemType {MISC, AMULET, BOOTS, BRACERS, CHEST, GLOVES, GOGGLES,
	        HAT, MELEE_WEAPON, PANTS, RING, SHIELD, SHOULDER, SOCKS,
	        BELT, EARRING;}
	
	private ItemType type;

	public String toString()
	{
		return id + " " + name;
	}

	/**
	 * Creates a specific instance of the <code>Item</code>.
	 * 
	 * @return A specific instance of this <code>Item</code>.
	 */
	public Item createItem()
	{
		Item i = cloneItem();
		i.uniqueID = String.valueOf(type) + "-" + String.valueOf(id) + "-"
				+ String.valueOf(Database.nextID());
		return i;
	}

	public abstract Item cloneItem();
}
