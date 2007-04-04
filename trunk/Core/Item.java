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

	protected ItemType type;

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
